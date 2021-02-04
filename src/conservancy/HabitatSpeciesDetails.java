package conservancy;

public class HabitatSpeciesDetails {
  private int speciesSize;
  private SpeciesType speciesType;
  private TemperatureRange tempRangeInCelsius;
  private NaturalFeature speciesNaturalFeature;
  private Boolean speciesCompatibality;

  public HabitatSpeciesDetails(int speciesSize, SpeciesType speciesType,
      TemperatureRange tempRangeInCelsius, NaturalFeature speciesNaturalFeature, Boolean speciesCompatibality) {
    this.speciesSize = speciesSize;
    this.speciesType = speciesType;
    this.tempRangeInCelsius = tempRangeInCelsius;
    this.speciesNaturalFeature = speciesNaturalFeature;
    this.speciesCompatibality = speciesCompatibality;
  }

  public int getSpeciesSize() {
    return this.speciesSize;
  }

  public void setSpeciesSize(int speciesSize) {
    this.speciesSize = speciesSize;
  }

  public SpeciesType getSpeciesType() {
    return this.speciesType;
  }

  public void setSpeciesType(SpeciesType speciesType) {
    this.speciesType = speciesType;
  }

  public TemperatureRange getTempRangeInCelsius() {
    return this.tempRangeInCelsius;
  }

  public void setTempRangeInCelsius(TemperatureRange tempRangeInCelsius) {
    this.tempRangeInCelsius = tempRangeInCelsius;
  }

  public NaturalFeature getSpeciesNaturalFeature() {
    return this.speciesNaturalFeature;
  }

  public void setSpeciesNaturalFeature(NaturalFeature speciesNaturalFeature) {
    this.speciesNaturalFeature = speciesNaturalFeature;
  }
  
  public Boolean getSpeciesCompatibality() {
    return this.speciesCompatibality;
  }

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

    boolean b = this.speciesSize == that.speciesSize && 
        this.speciesType.equals(that.speciesType)
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
