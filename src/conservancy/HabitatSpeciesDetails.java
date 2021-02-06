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
   * @param speciesSize           It is the size of the animal(small, medium,
   *                              large)
   * @param speciesType           It is the type of the species whether its
   *                              reptile or Amphibian
   * @param tempRangeInCelsius    It is temperature range in Celsius
   * @param speciesNaturalFeature It is a particular natural feature that species
   *                              prefer to hang out in
   * @param speciesCompatibality  If the species in habitat are non compatible, this variable maintains that distinction
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
   * @return returns the size of the species
   */
  public int getSpeciesSize() {
    return this.speciesSize;
  }

  /**
   * It sets a species available size after adding species to the habitat.
   *
   * @param  speciesSize: Sets the particular species count, number of species count, 
   * 
   */
  public void setSpeciesSize(int speciesSize) {
    this.speciesSize = speciesSize;
  }

  /**
   * It retrieves a species type.
   * @return returns the species type, is it reptile or amphibian
   */
  public SpeciesType getSpeciesType() {
    return this.speciesType;
  }

  /**
   * It retrieves a habitat Name in which species is there.
   * @return returns the range of species temperature range
   */
  public TemperatureRange getTempRangeInCelsius() {
    return this.tempRangeInCelsius;
  }

  /**
   * It retrieves a preferred Natural Features.
   * @return returns the species natural feature
   */
  public NaturalFeature getSpeciesNaturalFeature() {
    return this.speciesNaturalFeature;
  }

  /**
   * It retrieves a species compatible status.
   * @return species compatibility, can this species stay with other species or not
   */
  public Boolean getSpeciesCompatibality() {
    return this.speciesCompatibality;
  }

  /**
   * It sets a species compatible status.
   * @param speciesCompatibality: sets the species compatibility 
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
