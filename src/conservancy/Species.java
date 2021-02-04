package conservancy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Species implements ISpecies {

  private final String speciesName;

  private final SpeciesType speciesType;

  private final SpeciesDescription speciesDescription;

  private final TemperatureRange preferredTempRangeInCelsius;

  private final NaturalFeature speciesNaturalFeature;

  private final SpeciesIndicators speciesIndicator;

  private ArrayList<SpeciesHabitatStatus> speciesHabitatStatusList;

  public Boolean result;
  
  public Boolean isSpeciesExtinct;

  public Species(String speciesName, String speciesType, SpeciesSize size, String characteristic,
      int minTemp, int maxTemp, NaturalFeature speciesNaturalFeature, Boolean isPoisonous,
      Boolean isExtinct, Boolean isCompatible, Boolean isEndangered) {
    this.speciesName = speciesName;
    this.speciesType = new SpeciesType(speciesType);
    this.speciesDescription = new SpeciesDescription(size, characteristic);
    this.preferredTempRangeInCelsius = new TemperatureRange(minTemp, maxTemp);
    this.speciesNaturalFeature = speciesNaturalFeature;
    this.speciesIndicator = new SpeciesIndicators(isPoisonous, isCompatible,
        isEndangered);
    this.isSpeciesExtinct = isExtinct;
    this.result = false;
    this.speciesHabitatStatusList = new ArrayList<SpeciesHabitatStatus>();
  }

  @Override
  public ISpecies isSpeciesCompatibleWithHabitat(SpeciesType speciesType,
      TemperatureRange habitatTempRange, ArrayList<NaturalFeature> habitatNaturalFeatureList,
      int habitatAvailableSize) {
    this.result = false;
    Boolean isTypesCompatible = preferredSpeciesType(speciesType);
    Boolean isSpeciesCanFit = (this.speciesDescription.getSize()
        .getSizeRequiredInHabitat() <= habitatAvailableSize);
    Boolean isSpeciesWithinHabitatTemperatureRange = withinHabitatTemperatureRange(
        habitatTempRange);
    Boolean isPreferredNaturalFeaturesAvailable = preferredNaturalFeature(
        habitatNaturalFeatureList);

    Boolean isSpeciesCompatible = isSpeciesCompatiblewithOtherSpiciesInHabitat(habitatTempRange);

    if (isTypesCompatible && isSpeciesCanFit && isSpeciesWithinHabitatTemperatureRange
        && isPreferredNaturalFeaturesAvailable && isSpeciesCompatible) {
      this.result = true;
    } else {
      this.result = false;
    }
    return this;

  }

  private Boolean isSpeciesCompatiblewithOtherSpiciesInHabitat(TemperatureRange habitatTempRange) {
    if (Objects.isNull(habitatTempRange)) {
      // Empty Habitat
      return true;
    } else {
      return this.speciesIndicator.getIsCompatible();
    }
  }

  private Boolean withinHabitatTemperatureRange(TemperatureRange habitatTempRange) {
    if (Objects.isNull(habitatTempRange)) {
      return true;
    } else {
      int habitatMinTemp = habitatTempRange.getMinTemp();
      int habitatMaxTemp = habitatTempRange.getMaxTemp();
      int speciesMinTemp = this.preferredTempRangeInCelsius.getMinTemp();
      int speciesMaxTemp = this.preferredTempRangeInCelsius.getMaxTemp();
      if (speciesMinTemp >= habitatMinTemp && speciesMaxTemp <= habitatMaxTemp) {
        return true;
      } else {
        return false;
      }
    }
  }

  private Boolean preferredSpeciesType(SpeciesType speciesType) {
    if (speciesType.getSpeciesType().isEmpty() || (this.speciesType.equals(speciesType))) {
      return true;
    } else {
      return false;
    }
  }

  private Boolean preferredNaturalFeature(ArrayList<NaturalFeature> habitatNaturalFeatureList) {
    if (habitatNaturalFeatureList.size() > 3) {
      return false;
    } else if (habitatNaturalFeatureList.size() == 0) {
      return true;
    } else if (habitatNaturalFeatureList.contains(this.speciesNaturalFeature)) {
      return true;
    } else if (habitatNaturalFeatureList.size() < 3) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public ISpecies setSpeciesHabitatStatus(String speciesHabitatLocation) {
    this.result = false;

    for (SpeciesHabitatStatus speciesHabitatStatus : this.speciesHabitatStatusList) {
      if (speciesHabitatStatus.getSpeciesHabitatLocation().contains(speciesHabitatLocation)) {
        speciesHabitatStatus.incrementSameSpeciesCount();
        this.result = true;

        return this;
      }
    }

    SpeciesHabitatStatus speciesHabitatStaus = new SpeciesHabitatStatus(speciesHabitatLocation, 1);
    this.speciesHabitatStatusList.add(speciesHabitatStaus);
    this.result = true;

    return this;
  }

  @Override
  public Boolean getStatus() {
    return this.result;
  }
  
  @Override
  public Boolean getIsSpeciesExtinct() {
    return this.isSpeciesExtinct;
  }
  

  @Override
  public String toString() {
    return String.format(
        "Species:%n Name: %s %n (Description: %n Size: %s %n Characteristic: %s %n Indicator: %n Poisonous: %b %n Extinct: %b %n Compatible: %b %n Endangered: %b",
        this.speciesName, this.speciesDescription.getSize(),
        this.speciesDescription.getCharacteristic(), this.speciesIndicator.getIsPoisonous(),
        this.isSpeciesExtinct, this.speciesIndicator.getIsCompatible(),
        this.speciesIndicator.getIsEndangered());
  }

  @Override
  public HabitatSpeciesDetails retrieveSpeciesDetails() {
    int habitatAvailableSize = this.speciesDescription.getSize().getSizeRequiredInHabitat();
    SpeciesType habitatSpeciesType = this.speciesType;
    TemperatureRange habitatTempRange = this.preferredTempRangeInCelsius;
    NaturalFeature habitatNaturalFeature = this.speciesNaturalFeature;
    Boolean speciesCompatibality = this.speciesIndicator.getIsCompatible();
    HabitatSpeciesDetails habitatSpeciesDetails = new HabitatSpeciesDetails(habitatAvailableSize,
        habitatSpeciesType, habitatTempRange, habitatNaturalFeature, speciesCompatibality);
    return habitatSpeciesDetails;

  }
  
  @Override
  public Map<String, Collection<SpeciesHabitatStatus>> speciesLookUp(){
    
    Map<String, Collection<SpeciesHabitatStatus>> speciesHabitatList = new HashMap<String, Collection<SpeciesHabitatStatus>>();

    speciesHabitatList.put(this.speciesName, this.speciesHabitatStatusList);
    
    
    return speciesHabitatList;
  }

  public String getSpeciesName() { return this.speciesName; }
  /*
   * public String getAnimalSpecies() { return this.animalSpecies; }
   * 
   * public SpeciesType getSpeciesType() { return this.speciesType; }
   * 
   * public SpeciesDescription getSpeciesDescription() { return
   * this.speciesDescription; }
   * 
   * public TemperatureRange getPreferredTempRangeInCelsius() { return
   * this.preferredTempRangeInCelsius; }
   * 
   * public NaturalFeature getSpeciesNaturalFeature() { return
   * this.speciesNaturalFeature; }
   * 
   * public SpeciesIndicators getSpeciesIndicator() {
   * 
   * return speciesIndicator; }
   * 
   * public ArrayList<String> getSpeciesLocation() { return
   * this.speciesHabitatLocation; }
   */
}
