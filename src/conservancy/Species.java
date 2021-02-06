package conservancy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The species of animal has some characteristics like species name, species
 * type, species description, preferred Temperature Range, species Indicator.
 */
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

  /**
   * Constructs a species object with species name, species type, species
   * description, preferred Temperature Range, species Indicator.
   *
   * @param speciesName           It is the name of the species
   * @param speciesType           It is the type of the species whether its
   *                              reptile or Amphibian
   * @param size                  It is the size of the animal(small, medium,
   *                              large)
   * @param characteristic        Characteristic/description of species                           
   * @param minTemp               It is minimum temperature required in Celsius
   * @param maxTemp               It is maximum temperature required in Celsius
   * @param speciesNaturalFeature It is a particular natural feature that species
   *                              prefer to hang out in
   * @param isPoisonous           It is an indicator which shows whether species
   *                              is poisonous or not
   * @param isExtinct             It is an indicator which shows whether species
   *                              is extinct or not
   * @param isCompatible          It is an indicator which shows whether species
   *                              can live with other species
   * @param isEndangered          It is an indicator which shows whether species
   *                              is endangered or not
   * 
   * @throws IllegalArgumentException If the Minimum Temperature greater than
   *                                  Maximum Temperature and vice versa or
   *                                  Minimum Temperature is lesser than 0 Celsius
   *                                  and Maximum Temperature is greater than 50
   *                                  Celsius
   */
  public Species(String speciesName, String speciesType, SpeciesSize size, String characteristic,
      int minTemp, int maxTemp, NaturalFeature speciesNaturalFeature, Boolean isPoisonous,
      Boolean isExtinct, Boolean isCompatible, Boolean isEndangered)
      throws IllegalArgumentException {
    if (minTemp < 0 || maxTemp < 0 || minTemp > 50 || maxTemp > 50) {
      throw new IllegalArgumentException("Temperature Range should be in 0 - 50 Celsius");
    }
    if (minTemp >= maxTemp || maxTemp <= minTemp) {
      throw new IllegalArgumentException(
          "Minimum Temperature cannot be higher than Maximum Temperature and vice versa");
    }
    this.speciesName = speciesName;
    this.speciesType = new SpeciesType(speciesType);
    this.speciesDescription = new SpeciesDescription(size, characteristic);
    this.preferredTempRangeInCelsius = new TemperatureRange(minTemp, maxTemp);
    this.speciesNaturalFeature = speciesNaturalFeature;
    this.speciesIndicator = new SpeciesIndicators(isPoisonous, isCompatible, isEndangered);
    this.isSpeciesExtinct = isExtinct;
    this.result = true;
    this.speciesHabitatStatusList = new ArrayList<SpeciesHabitatStatus>();
  }

  @Override
  public ISpecies isSpeciesCompatibleWithHabitat(SpeciesType speciesType,
      TemperatureRange habitatTempRange, ArrayList<NaturalFeature> habitatNaturalFeatureList,
      int habitatAvailableSize, Boolean doCompatibilityCheck) {
    this.result = false;
    Boolean isTypesCompatible = preferredSpeciesType(speciesType);
    Boolean isSpeciesCanFit = (this.speciesDescription.getSize()
        .getSizeRequiredInHabitat() <= habitatAvailableSize);
    Boolean isSpeciesWithinHabitatTemperatureRange = withinHabitatTemperatureRange(
        habitatTempRange);
    Boolean isPreferredNaturalFeaturesAvailable = preferredNaturalFeature(
        habitatNaturalFeatureList);

    Boolean isSpeciesCompatible = isSpeciesCompatiblewithOtherSpiciesInHabitat(habitatTempRange,
        doCompatibilityCheck);

    if (isTypesCompatible && isSpeciesCanFit && isSpeciesWithinHabitatTemperatureRange
        && isPreferredNaturalFeaturesAvailable && isSpeciesCompatible) {
      this.result = true;
    } else {
      this.result = false;
    }
    return this;

  }

  /**
   * Private helper method to check the compatibility of the species with other
   * species.
   *
   * @return the Boolean object which indicate the compatibility status
   */
  private Boolean isSpeciesCompatiblewithOtherSpiciesInHabitat(TemperatureRange habitatTempRange,
      Boolean doCompatibilityCheck) {
    if (Objects.isNull(habitatTempRange)) {
      // Empty Habitat
      return true;
    } else {
      if (doCompatibilityCheck) {
        return this.speciesIndicator.getIsCompatible();
      } else {
        return true;
      }
    }
  }

  /**
   * Private helper method to check whether habitat Temperature Range is
   * compatible with species.
   *
   * @return the Boolean object which indicate the compatibility status
   */
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

  /**
   * Private helper method to check whether species' type in Habitat is compatible
   * with the species.
   *
   * @return the Boolean object which indicate the compatibility status
   */
  private Boolean preferredSpeciesType(SpeciesType speciesType) {
    if (speciesType.getSpeciesType().isEmpty() || (this.speciesType.equals(speciesType))) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Private helper method to check whether preferred natural feature is available
   * in Habitat.
   *
   * @return the Boolean object which indicate the compatibility status
   */
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
  public Map<String, Collection<SpeciesHabitatStatus>> speciesLookUp() {

    Map<String, Collection<SpeciesHabitatStatus>> speciesHabitatList = 
        new HashMap<String, Collection<SpeciesHabitatStatus>>();
    if (!this.speciesHabitatStatusList.isEmpty()) {
      speciesHabitatList.put(this.speciesName, this.speciesHabitatStatusList);
    }
    return speciesHabitatList;
  }

  @Override
  public String getSpeciesName() {
    return this.speciesName;
  }

  @Override
  public String retriveDetailsToPrintHabitatSign(String habitatName) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Species Name: " + this.speciesName);

    for (SpeciesHabitatStatus speciesHabitatStatus : this.speciesHabitatStatusList) {
      if (speciesHabitatStatus.getSpeciesHabitatLocation().equals(habitatName)) {
        stringBuilder
            .append("\n   Total Species Housed: " + speciesHabitatStatus.getSameSpeciesCount());
      }
    }

    stringBuilder
        .append("\n   Species Characteristics: " + this.speciesDescription.getCharacteristic());
    stringBuilder.append("\n   Species Size: " + this.speciesDescription.getSize());
    stringBuilder.append("\n   Interesting Features: ");

    if (this.speciesIndicator.getIsPoisonous()) {
      stringBuilder.append("Poisonous     ");
    }
    if (this.isSpeciesExtinct) {
      stringBuilder.append("Extinct     ");
    }
    if (this.speciesIndicator.getIsEndangered()) {
      stringBuilder.append("Endangered     ");
    }

    return stringBuilder.toString();
  }
}
