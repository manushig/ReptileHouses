package conservancy;

import java.util.stream.Stream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ReptileHouses implements IReptileHouses {
  private ArrayList<IHabitat> habitatList;
  private ArrayList<ISpecies> speciesList;
  private Boolean result;

  public ReptileHouses() {
    this.habitatList = new ArrayList<IHabitat>();
    this.speciesList = new ArrayList<ISpecies>();
    this.result = true;
  }

  @Override
  public IReptileHouses addSpeciesToReptileHouse(ISpecies species) {
    this.result = false;

    if (species.getIsSpeciesExtinct()) {
      species.setSpeciesHabitatStatus("Extinct Species - Not inhabiting a Habitat");
      addSpeciesToReptileHouseSpiecesList(species);

      this.result = true;
    } else {
      if (habitatList.size() == 0) {

        createNewHabitatAndSpecies(species);
        this.result = true;
      } else {
        Boolean isSpeciesHoused = false;

        for (IHabitat habitatInReptileHouse : habitatList) {
          habitatInReptileHouse.isSpeciesCompatibleWithHabitat(species);

          Boolean isSpeciesCompatibleInReptileHouseHabitat = habitatInReptileHouse.getStatus();

          if (isSpeciesCompatibleInReptileHouseHabitat) {
            habitatInReptileHouse.addSpeciesToHabitat(species);

            addSpeciesToReptileHouseSpiecesList(species);

            isSpeciesHoused = true;
            this.result = true;
            break;
          }
        }
        if (!isSpeciesHoused) {
          createNewHabitatAndSpecies(species);
          this.result = true;
        }
      }
    }
    return this;
  }

  private IReptileHouses createNewHabitatAndSpecies(ISpecies species) {
    int noOfHabitats = this.habitatList.size();
    String habitatName = String.format("Habitat%d", (noOfHabitats + 1));

    IHabitat habitat = new Habitat(HabitatSize, habitatName, HabitatLocation);

    habitat.isSpeciesCompatibleWithHabitat(species);

    Boolean isspeciesCompatibleInHabitat = habitat.getStatus();

    if (isspeciesCompatibleInHabitat) {
      habitat.addSpeciesToHabitat(species);
      addNewHabitatToReptileHouse(habitat);
      addSpeciesToReptileHouseSpiecesList(species);
    }
    return this;
  }

  private IReptileHouses addSpeciesToReptileHouseSpiecesList(ISpecies species) {
    if (!this.speciesList.contains(species)) {
      this.speciesList.add(species);
    }
    return this;
  }

  private IReptileHouses addNewHabitatToReptileHouse(IHabitat habitat) {
    if (!this.habitatList.contains(habitat)) {
      this.habitatList.add(habitat);
    }
    return this;
  }

  @Override
  public Boolean getStatus() {
    return this.result;
  }

  @Override
  public Map<String, Collection<NaturalFeaturesDetails>> reportNaturalFeatures() {

    Map<String, Collection<NaturalFeaturesDetails>> naturalFeatureCollections = new HashMap<String, Collection<NaturalFeaturesDetails>>();

    for (IHabitat habitatInReptileHouse : this.habitatList) {
      ArrayList<NaturalFeaturesReport> habitatNaturalFeatures = habitatInReptileHouse
          .reportNaturalFeatures();

      for (NaturalFeaturesReport naturalFeaturesReport : habitatNaturalFeatures) {
        Collection<NaturalFeaturesDetails> naturalFeaturesDetails = new ArrayList<NaturalFeaturesDetails>();

        NaturalFeature naturalFtr = naturalFeaturesReport.getNaturalFeature();

        String naturalFeature = naturalFtr.name();

        Collection<NaturalFeaturesDetails> naturalFeaturesDetails_Temp = naturalFeatureCollections
            .get(naturalFeature);

        if (!Objects.isNull(naturalFeaturesDetails_Temp)) {
          naturalFeaturesDetails_Temp.add(naturalFeaturesReport.getNaturalFeaturesDetailsList());
          naturalFeatureCollections.put(naturalFeature, naturalFeaturesDetails_Temp);

        } else {

          naturalFeaturesDetails.add(naturalFeaturesReport.getNaturalFeaturesDetailsList());
          naturalFeatureCollections.put(naturalFeature, naturalFeaturesDetails);

        }

      }

    }

    Map<String, Collection<NaturalFeaturesDetails>> sortedNaturalFeatureCollections = new TreeMap<String, Collection<NaturalFeaturesDetails>>(
        naturalFeatureCollections);

    return sortedNaturalFeatureCollections;

  }

  @Override
  public ArrayList<String> speciesLookUp(ISpecies speciesToLookUp) {
    ArrayList<String> lookUpResult = new ArrayList<String>();

    if (speciesList.contains(speciesToLookUp)) {
      Map<String, Collection<SpeciesHabitatStatus>> speciesDetails = speciesToLookUp
          .speciesLookUp();
      lookUpResult.add("This species is found - ");
      for (Map.Entry<String, Collection<SpeciesHabitatStatus>> en : speciesDetails.entrySet()) {
        Collection<SpeciesHabitatStatus> speciesHabitatList = en.getValue();
        for (SpeciesHabitatStatus speciesLocation : speciesHabitatList) {
          lookUpResult.add(speciesLocation.getSpeciesHabitatLocation());
        }
      }
    } else {
      lookUpResult.add("This species is not there in Reptile House");
    }

    return lookUpResult;
  }

  @Override
  public String printSpeciesIndex() throws IOException {
    String result = "";
    Map<String, Collection<SpeciesHabitatStatus>> speciesDetailsCollection = new HashMap<String, Collection<SpeciesHabitatStatus>>();

    for (ISpecies species : speciesList) {
      Map<String, Collection<SpeciesHabitatStatus>> speciesDetails = species.speciesLookUp();

      speciesDetailsCollection.putAll(speciesDetails);

    }
    if (!speciesDetailsCollection.isEmpty()) {
      Map<String, Collection<SpeciesHabitatStatus>> sortedSpeciesDetailsCollection = new TreeMap<String, Collection<SpeciesHabitatStatus>>(
          speciesDetailsCollection);

      result = printSpeciesIndexDetailsToFile(sortedSpeciesDetailsCollection);

    } else {
      result = "Species Index is not printed - No species in the Reptile House";
    }
    return result;
  }

  private String printSpeciesIndexDetailsToFile(Map<String, Collection<SpeciesHabitatStatus>> speciesDetailsCollection)
      throws IOException {
    String result = "";

    BufferedWriter br = new BufferedWriter(
        new FileWriter(new File(".//res//Print_Species_Index.txtFile")));
    int i = 0;
    for (Map.Entry<String, Collection<SpeciesHabitatStatus>> speciesDetailsList : speciesDetailsCollection
        .entrySet()) {
      i++;
      br.write(i + ". " + speciesDetailsList.getKey() + " inhabiting in: ");
      Collection<SpeciesHabitatStatus> SpeciesHabitatStatusList = speciesDetailsList.getValue();
      int speciesResidedCounter = SpeciesHabitatStatusList.size();
      int ctr = 1;
      for (SpeciesHabitatStatus speciesHabitatStatus : SpeciesHabitatStatusList) {
        br.write(speciesHabitatStatus.getSpeciesHabitatLocation());
        if (speciesResidedCounter != ctr) {
          br.write(", ");
          ctr++;
        }
      }
      br.newLine();
    }
    br.flush();
    return "Print_Species_Index.txtFile is available for printing";
  }

  // Fixme
  private void t(ArrayList<NaturalFeaturesReport> naturalFeaturesList) {
    Collections.sort(naturalFeaturesList, new Comparator<NaturalFeaturesReport>() {
      public int compare(NaturalFeaturesReport v1, NaturalFeaturesReport v2) {
        return v1.getNaturalFeature().compareTo(v2.getNaturalFeature());
      }
    });
    this.result = false;
  }

  @Override
  public String toString() {
    return String.format(" has been added to Reptile House");
  }

}
