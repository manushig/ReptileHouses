package conservancy;

import java.util.ArrayList;

/**
 * The habitats of reptile house has some characteristics like that it can only
 * have maximum of 3 natural features, Temperature Range and Size.
 */
public final class Habitat implements IHabitat {

  private final String habitatName;
  private int habitatAvailableSize;
  private SpeciesType habitatSpeciesType;
  private TemperatureRange habitatTempRangeInCelsius;
  private ArrayList<NaturalFeature> habitatNaturalFeatureList;
  private ArrayList<ISpecies> speciesList;
  public Boolean result;
  public Boolean speciesCompatibality;

  /**
   * Constructs a habitat in terms of its name and size.
   *
   * @param habitatName It is the name of the habitat
   * @param habitatSize It is the size of the habitat
   * 
   * 
   */
  public Habitat(int habitatSize, String habitatName) {
    this.habitatName = habitatName;
    this.habitatAvailableSize = habitatSize;
    this.habitatSpeciesType = new SpeciesType("");
    this.habitatTempRangeInCelsius = null;
    this.habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    this.speciesList = new ArrayList<ISpecies>();
    this.speciesCompatibality = true;
  }

  @Override
  public IHabitat isSpeciesCompatibleWithHabitat(ISpecies species) {
    Boolean doCompatibilityCheck = true;

    if (this.speciesCompatibality) {
      this.result = checkSpeciesCompatibilty(species, doCompatibilityCheck);
    } else {
      if (speciesList.contains(species)) {
        for (ISpecies spec : speciesList) {
          if (spec.getSpeciesName().equals(species.getSpeciesName())) {
            doCompatibilityCheck = false;
            this.result = checkSpeciesCompatibilty(species, doCompatibilityCheck);
          }
        }
      } else {
        this.result = false;
      }
    }
    return this;
  }

  /**
   * Private helper method to check with the species of its compatibility with the
   * habitat.
   * 
   *
   * @return the Boolean object which indicate the compatibility status
   */
  private Boolean checkSpeciesCompatibilty(ISpecies species, Boolean doCompatibilityCheck) {
    Boolean isSpeciesCompatible = false;
    species.isSpeciesCompatibleWithHabitat(this.habitatSpeciesType, this.habitatTempRangeInCelsius,
        this.habitatNaturalFeatureList, this.habitatAvailableSize, doCompatibilityCheck);
    isSpeciesCompatible = species.getStatus();
    return isSpeciesCompatible;
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

  @Override
  public String getHabitatName() {
    return this.habitatName;
  }

  @Override
  public String retriveDetailsToPrintHabitatSign() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Habitat Name: " + this.getHabitatName());
    int speciesCtr = 0;

    for (ISpecies species : speciesList) {
      speciesCtr++;
      stringBuilder.append("\n\n" + speciesCtr + ". ");
      stringBuilder.append(species.retriveDetailsToPrintHabitatSign(this.getHabitatName()));

    }
    return stringBuilder.toString();
  }

  @Override
  public String habitatsMap() {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(this.habitatName);
    stringBuilder.append("\nNatural Features:");
    int ctr = 1;
    int naturalFeatureListCtr = this.habitatNaturalFeatureList.size();
    for (NaturalFeature naturalFeature : this.habitatNaturalFeatureList) {

      stringBuilder.append(" " + naturalFeature);
      if (ctr != naturalFeatureListCtr) {
        stringBuilder.append(",");
      }
      ctr++;
    }
    stringBuilder.append("\nSpecies:");
    ctr = 1;
    int speciesListCtr = this.habitatNaturalFeatureList.size();
    for (ISpecies species : speciesList) {
      stringBuilder.append(" " + species.getSpeciesName());
      if (ctr != speciesListCtr) {
        stringBuilder.append(",");
      }
      ctr++;
    }
    return stringBuilder.toString();
  }
}
