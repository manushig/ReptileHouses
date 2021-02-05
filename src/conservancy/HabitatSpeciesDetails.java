package conservancy;

/**
 * Habitat Species Details, indicates details like Temperature Range, Species
 * Size, Species Type and preferred Natural Feature.
 */
public class HabitatSpeciesDetails {
  private int speciesSize;
  private SpeciesType speciesType;
  private TemperatureRange tempRangeInCelsius;
  private NaturalFeature speciesNaturalFeature;
  private Boolean speciesCompatibality;

  /**
   * Constructs a Habitat Species Details, specifying details like Temperature
   * Range, Species Size, Species Type and preferred Natural Feature.
   *
   * 
   * @param speciesSize      It is the size of the animal(small, medium, large)
   * @param speciesType      It is the type of the species whether its reptile or
   *                         Amphibian
   * @param TemperatureRange It is temperature range in Celsius
   * @param NaturalFeature   It is a particular natural feature that species
   *                         prefer to hang out in
   * 
   */
  public HabitatSpeciesDetails(int speciesSize, SpeciesType speciesType,
      TemperatureRange tempRangeInCelsius, NaturalFeature speciesNaturalFeature,
      Boolean speciesCompatibality) {
    this.speciesSize = speciesSize;
    this.speciesType = speciesType;
    this.tempRangeInCelsius = tempRangeInCelsius;
    this.speciesNaturalFeature = speciesNaturalFeature;
    this.speciesCompatibality = speciesCompatibality;
  }

  /**
   * It retrieves a habitat size.
   *
   */
  public int getSpeciesSize() {
    return this.speciesSize;
  }

  /**
   * It sets a species available size after adding species to the habitat.
   *
   */
  public void setSpeciesSize(int speciesSize) {
    this.speciesSize = speciesSize;
  }

  /**
   * It retrieves a species type.
   *
   */
  public SpeciesType getSpeciesType() {
    return this.speciesType;
  }

  /**
   * It retrieves a habitat Name in which species is there.
   *
   */
  public TemperatureRange getTempRangeInCelsius() {
    return this.tempRangeInCelsius;
  }

  /**
   * It retrieves a preferred Natural Features.
   *
   */
  public NaturalFeature getSpeciesNaturalFeature() {
    return this.speciesNaturalFeature;
  }

  /**
   * It retrieves a species compatible status.
   *
   */
  public Boolean getSpeciesCompatibality() {
    return this.speciesCompatibality;
  }

  /**
   * It sets a species compatible status
   *
   */
  public void setSpeciesCompatibality(Boolean speciesCompatibality) {
    this.speciesCompatibality = speciesCompatibality;
  }

  @Override
  public boolean equals(Object o) {
    // Fast path for pointer equality:
    if (this == o) { // backward compatibility with default equals
      return true;
    }

    // If o isn't the right class then it can't be equal:
    if (!(o instanceof HabitatSpeciesDetails)) {
      return false;
    }

    // The successful instanceof check means our cast will succeed:
    HabitatSpeciesDetails that = (HabitatSpeciesDetails) o;

    boolean b = this.speciesSize == that.speciesSize && this.speciesType.equals(that.speciesType)
        && this.tempRangeInCelsius.equals(that.tempRangeInCelsius)
        && this.speciesNaturalFeature == that.speciesNaturalFeature
        && this.speciesCompatibality == that.speciesCompatibality;

    return b;
  }

  @Override
  public int hashCode() {
    return hashCode();
  }

}
