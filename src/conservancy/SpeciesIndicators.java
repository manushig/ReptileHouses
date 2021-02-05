package conservancy;

/**
 * Species Indicators, indicators about species are poisonous, which are extinct
 * or endangered, and whether they can live with other species.
 */
public final class SpeciesIndicators {
  private final Boolean isPoisonous;
  private final Boolean isCompatible;
  private final Boolean isEndangered;

  /**
   * Constructs a Species Indicators in terms whether species are poisonous, which
   * are extinct or endangered, and whether they can live with other species.
   *
   * @param isPoisonous  It is an indicator to indicate whether species is
   *                     poisonous or not
   * @param isCompatible It is an indicator to indicate whether species can live
   *                     with other species
   * @param isEndangered It is an indicator to indicate whether species is
   *                     endangered or not
   */
  public SpeciesIndicators(Boolean isPoisonous, Boolean isCompatible, Boolean isEndangered) {
    this.isPoisonous = isPoisonous;
    this.isCompatible = isCompatible;
    this.isEndangered = isEndangered;
  }

  /**
   * It retrieves an indicator to indicate whether species is poisonous or not.
   *
   */
  public Boolean getIsPoisonous() {
    return this.isPoisonous;
  }

  /**
   * It retrieves an indicator to indicate whether species can live with other
   * species.
   *
   */
  public Boolean getIsCompatible() {
    return this.isCompatible;
  }

  /**
   * It retrieves an indicator to indicate whether species is endangered or not.
   *
   */
  public Boolean getIsEndangered() {
    return this.isEndangered;
  }

  @Override
  public boolean equals(Object o) {
    // Fast path for pointer equality:
    if (this == o) { // backward compatibility with default equals
      return true;
    }

    // If o isn't the right class then it can't be equal:
    if (!(o instanceof SpeciesIndicators)) {
      return false;
    }

    // The successful instanceof check means our cast will succeed:
    SpeciesIndicators that = (SpeciesIndicators) o;

    return this.isPoisonous == that.isPoisonous && this.isCompatible == that.isCompatible
        && this.isEndangered == that.isEndangered;
  }

  @Override
  public int hashCode() {
    return hashCode();
  }
}
