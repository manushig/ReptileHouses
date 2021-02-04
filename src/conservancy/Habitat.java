package conservancy;

import java.util.ArrayList;

public final class Habitat implements IHabitat {

  private final String habitatName;
  private final String habitatLocation;
  private int habitatAvailableSize;
  private SpeciesType habitatSpeciesType;
  private TemperatureRange habitatTempRangeInCelsius;
  private ArrayList<NaturalFeature> habitatNaturalFeatureList;
  private ArrayList<ISpecies> speciesList;
  public Boolean result;
  public Boolean speciesCompatibality;

  public Habitat(int habitatSize, String habitatName, String habitatLocation) {
    this.habitatName = habitatName;
    this.habitatLocation = habitatLocation;
    this.habitatAvailableSize = habitatSize;
    this.habitatSpeciesType = new SpeciesType("");
    this.habitatTempRangeInCelsius = null;
    this.habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    this.speciesList = new ArrayList<ISpecies>();
    this.speciesCompatibality = true;
  }

  @Override
  public IHabitat isSpeciesCompatibleWithHabitat(ISpecies species) {
    Boolean isSpeciesCompatible = false;
    if (this.speciesCompatibality) {
      species.isSpeciesCompatibleWithHabitat(this.habitatSpeciesType,
          this.habitatTempRangeInCelsius, this.habitatNaturalFeatureList,
          this.habitatAvailableSize);
      isSpeciesCompatible = species.getStatus();

      if (isSpeciesCompatible) {
        this.result = true;
      } else {
        this.result = false;
      }
    } else {
      this.result = false;
    }
    return this;
  }

  @Override
  public IHabitat addSpeciesToHabitat(ISpecies species) {
    HabitatSpeciesDetails habtatSpeciesDetails = species.retrieveSpeciesDetails();

    this.habitatAvailableSize = this.habitatAvailableSize - habtatSpeciesDetails.getSpeciesSize();

    if (!this.habitatNaturalFeatureList.contains(habtatSpeciesDetails.getSpeciesNaturalFeature())) {
      this.habitatNaturalFeatureList.add(habtatSpeciesDetails.getSpeciesNaturalFeature());
    }

    if (this.speciesList.size() == 0) {
      this.habitatSpeciesType = habtatSpeciesDetails.getSpeciesType();
      this.habitatTempRangeInCelsius = habtatSpeciesDetails.getTempRangeInCelsius();
      this.speciesCompatibality = habtatSpeciesDetails.getSpeciesCompatibality();
    }

    species.setSpeciesHabitatStatus(this.habitatName);

    if (!this.speciesList.contains(species)) {
      this.speciesList.add(species);
    }

    return this;
  }

  @Override
  public Boolean getStatus() {
    return this.result;
  }

  @Override
  public ArrayList<NaturalFeaturesReport> reportNaturalFeatures() {
    ArrayList<NaturalFeaturesReport> naturalFtrList = new ArrayList<NaturalFeaturesReport>();

    for (NaturalFeature naturalFtr : this.habitatNaturalFeatureList) {

      NaturalFeaturesDetails naturalFeatureDetails = new NaturalFeaturesDetails(this.habitatName,
          this.habitatAvailableSize);

      NaturalFeaturesReport naturalFeatureReportDetails = new NaturalFeaturesReport(naturalFtr,
          naturalFeatureDetails);

      naturalFtrList.add(naturalFeatureReportDetails);

    }
    return naturalFtrList;

  }
}
