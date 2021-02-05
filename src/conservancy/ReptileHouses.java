package conservancy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * The reptile house has habitats for reptiles and amphibians and The
 * Cold-Blooded Conservancy wants to track the species.
 */
public final class ReptileHouses implements IReptileHouses {
  private ArrayList<IHabitat> habitatList;
  private ArrayList<ISpecies> speciesList;
  private Boolean result;

  /**
   * Constructs a reptile house in terms of its 5 name and size.
   * 
   * @param args Not used.
   */
  public ReptileHouses() {
    this.habitatList = new ArrayList<IHabitat>();
    this.speciesList = new ArrayList<ISpecies>();
    this.result = true;
  }

  @Override
  public IReptileHouses createSpecies(String speciesName, String speciesType, SpeciesSize size,
      String characteristic, int minTemp, int maxTemp, NaturalFeature speciesNaturalFeature,
      Boolean isPoisonous, Boolean isExtinct, Boolean isCompatible, Boolean isEndangered) {

    ISpecies speciesToAdd = new Species(speciesName, speciesType, size, characteristic, minTemp,
        maxTemp, speciesNaturalFeature, isPoisonous, isExtinct, isCompatible, isEndangered);

    Boolean addSpecies = true;
    for (ISpecies species : this.speciesList) {
      if (species.getSpeciesName().equals(speciesToAdd.getSpeciesName())) {
        addSpecies = false;
      }
    }

    if (addSpecies) {
      this.speciesList.add(speciesToAdd);
    }

    this.result = addSpecies;

    return this;
  }

  @Override
  public IReptileHouses addSpeciesToReptileHouse(String speciesName) {
    this.result = false;

    ISpecies speciesToAdd = null;
    for (ISpecies speciesToLookUp : this.speciesList) {
      if (speciesToLookUp.getSpeciesName().equals(speciesName)) {
        speciesToAdd = speciesToLookUp;
        break;
      }
    }
    if (!Objects.isNull(speciesToAdd)) {
      if (speciesToAdd.getIsSpeciesExtinct()) {
        speciesToAdd.setSpeciesHabitatStatus("Extinct Species - Not inhabiting a Habitat");

        this.speciesList.add(speciesToAdd);

        this.result = true;
      } else {
        if (habitatList.size() == 0) {

          createNewHabitatAndSpecies(speciesToAdd);
          this.result = true;
        } else {
          Boolean isSpeciesHoused = false;

          for (IHabitat habitatInReptileHouse : habitatList) {
            habitatInReptileHouse.isSpeciesCompatibleWithHabitat(speciesToAdd);

            Boolean isSpeciesCompatibleInReptileHouseHabitat = habitatInReptileHouse.getStatus();

            if (isSpeciesCompatibleInReptileHouseHabitat) {
              habitatInReptileHouse.addSpeciesToHabitat(speciesToAdd);

              this.speciesList.add(speciesToAdd);

              isSpeciesHoused = true;
              this.result = true;
              break;
            }
          }
          if (!isSpeciesHoused) {
            createNewHabitatAndSpecies(speciesToAdd);
            this.result = true;
          }
        }
      }
    } else {
      this.result = false;
    }
    return this;
  }

  /**
   * Private helper method to create new habitat and add species to that habitat.
   * 
   *
   * @return the IReptileHouses object
   */
  private IReptileHouses createNewHabitatAndSpecies(ISpecies species) {
    int noOfHabitats = this.habitatList.size();
    String habitatName = String.format("Habitat%d", (noOfHabitats + 1));

    IHabitat habitat = new Habitat(habitatSize, habitatName);

    habitat.isSpeciesCompatibleWithHabitat(species);

    Boolean isspeciesCompatibleInHabitat = habitat.getStatus();

    if (isspeciesCompatibleInHabitat) {
      habitat.addSpeciesToHabitat(species);
      if (!this.habitatList.contains(habitat)) {
        this.habitatList.add(habitat);
      }
      this.speciesList.add(species);
    }
    return this;
  }

  @Override
  public Boolean getStatus() {
    return this.result;
  }

  @Override
  public String reportNaturalFeatures() {

    Map<String, Collection<NaturalFeaturesDetails>> naturalFeatureCollections = 
        new HashMap<String, Collection<NaturalFeaturesDetails>>();

    for (IHabitat habitatInReptileHouse : this.habitatList) {
      ArrayList<NaturalFeaturesReport> habitatNaturalFeatures = habitatInReptileHouse
          .reportNaturalFeatures();

      for (NaturalFeaturesReport naturalFeaturesReport : habitatNaturalFeatures) {
        Collection<NaturalFeaturesDetails> naturalFeaturesDetails = 
            new ArrayList<NaturalFeaturesDetails>();

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

    Map<String, Collection<NaturalFeaturesDetails>> sortedNaturalFeatureCollections = 
        new TreeMap<String, Collection<NaturalFeaturesDetails>>(
        naturalFeatureCollections);

    String displayReport = displayReport(sortedNaturalFeatureCollections).toString();
    return displayReport;

  }

  /**
   * Private helper method to display the natural features details.
   * 
   *
   * @return the StringBuilder object which holds the data to display natural
   *         features
   */
  private StringBuilder displayReport(
      Map<String, Collection<NaturalFeaturesDetails>> naturalFeaturesLookUp) {

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\n**************Natural Features Report**************\n");
    if (naturalFeaturesLookUp.isEmpty()) {
      stringBuilder.append("No Natural Features are available to report.");
    } else {
      for (Map.Entry<String, Collection<NaturalFeaturesDetails>> naturalFeatureLookupList : naturalFeaturesLookUp
          .entrySet()) {
        stringBuilder.append("\nNatural Feature: " + naturalFeatureLookupList.getKey());

        Collection<NaturalFeaturesDetails> naturalFeatureDetailsList = naturalFeatureLookupList
            .getValue();
        for (NaturalFeaturesDetails naturalFeaturesDetails : naturalFeatureDetailsList) {
          stringBuilder.append(
              "\nHabitat Name: " + naturalFeaturesDetails.getHabitatName() + ", Available Size: "
                  + naturalFeaturesDetails.getHabitSizeAvailable() + " square meters\n");
        }
      }
    }
    return stringBuilder;
  }

  @Override
  public String speciesLookUp(String speciesName) {
    ArrayList<String> lookUpResult = new ArrayList<String>();
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("\n**************" + speciesName + " Lookup**************\n");
    ISpecies speciesToLookUp = null;
    for (ISpecies speciesInList : this.speciesList) {
      if (speciesInList.getSpeciesName().toLowerCase().equals(speciesName.toLowerCase())) {
        speciesToLookUp = speciesInList;
        break;
      }
    }

    if (!Objects.isNull(speciesToLookUp)) {

      Map<String, Collection<SpeciesHabitatStatus>> speciesDetails = speciesToLookUp
          .speciesLookUp();

      for (Map.Entry<String, Collection<SpeciesHabitatStatus>> en : speciesDetails.entrySet()) {
        Collection<SpeciesHabitatStatus> speciesHabitatList = en.getValue();
        for (SpeciesHabitatStatus speciesLocation : speciesHabitatList) {
          lookUpResult.add(speciesLocation.getSpeciesHabitatLocation());
        }
      }
      if (lookUpResult.size() > 0) {
        stringBuilder.append(speciesName + " species is Found in: ");

        int habitaNameListCtr = lookUpResult.size();
        int ctr = 1;
        for (String habitat : lookUpResult) {
          stringBuilder.append(habitat);
          if (!(ctr == habitaNameListCtr)) {
            stringBuilder.append(", ");
            ctr++;
          }
        }
        stringBuilder.append("\n");
      } else {
        stringBuilder.append(speciesName + " species is not found in Reptile House\n");
      }

    } else {
      stringBuilder.append(speciesName + " species is unknown to Reptile House");
    }

    return stringBuilder.toString();

  }

  @Override
  public String printSpeciesIndex() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\n**************Print All Species Index**************\n");
    Map<String, Collection<SpeciesHabitatStatus>> speciesDetailsCollection = 
        new HashMap<String, Collection<SpeciesHabitatStatus>>();

    for (ISpecies species : speciesList) {
      Map<String, Collection<SpeciesHabitatStatus>> speciesDetails = species.speciesLookUp();

      speciesDetailsCollection.putAll(speciesDetails);

    }
    if (!speciesDetailsCollection.isEmpty()) {
      Map<String, Collection<SpeciesHabitatStatus>> sortedSpeciesDetailsCollection = 
          new TreeMap<String, Collection<SpeciesHabitatStatus>>(
          speciesDetailsCollection);

      stringBuilder.append(printSpeciesIndexDetails(sortedSpeciesDetailsCollection));

    } else {
      stringBuilder.append("No species in the Reptile House");
    }
    return stringBuilder.toString();
  }

  /**
   * Private helper method to print species index details.
   * 
   *
   * @return the StringBuilder object which holds print species index details
   */
  private StringBuilder printSpeciesIndexDetails(
      Map<String, Collection<SpeciesHabitatStatus>> speciesDetailsCollection) {
    StringBuilder stringBuilder = new StringBuilder();

    int i = 0;
    for (Map.Entry<String, Collection<SpeciesHabitatStatus>> speciesDetailsList : speciesDetailsCollection
        .entrySet()) {
      i++;
      stringBuilder.append(i + ". " + speciesDetailsList.getKey() + " inhabiting in: ");
      Collection<SpeciesHabitatStatus> SpeciesHabitatStatusList = speciesDetailsList.getValue();
      int speciesResidedCounter = SpeciesHabitatStatusList.size();
      int ctr = 1;
      for (SpeciesHabitatStatus speciesHabitatStatus : SpeciesHabitatStatusList) {
        stringBuilder.append(speciesHabitatStatus.getSpeciesHabitatLocation());
        if (speciesResidedCounter != ctr) {
          stringBuilder.append(", ");
          ctr++;
        }
      }
      stringBuilder.append("\n");
    }

    return stringBuilder;
  }

  @Override
  public String printHabitatIndex(String habitatName) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\n**************Print Habitat Map**************\n");
    IHabitat habitatToLookUp = null;
    for (IHabitat habitatsInList : this.habitatList) {
      if (habitatsInList.getHabitatName().equals(habitatName)) {
        habitatToLookUp = habitatsInList;
        break;
      }
    }

    if (!Objects.isNull(habitatToLookUp)) {
      stringBuilder.append(habitatToLookUp.retriveDetailsToPrintHabitatSign());
    } else {
      stringBuilder.append(habitatName + " is not found");
    }

    return stringBuilder.toString();
  }

  @Override
  public String allHabitatsMap() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\n**************Print All Habitats Details**************\n");
    int habitatCtr = 1;
    for (IHabitat habitat : habitatList) {
      stringBuilder.append("\n\n" + habitatCtr + ". ");
      stringBuilder.append(habitat.habitatsMap());
      habitatCtr++;
    }
    return stringBuilder.toString();
  }

}
