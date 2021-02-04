package conservancy;

public final class SpeciesIndicators {
  private final Boolean isPoisonous;
  private final Boolean isCompatible;
  private final Boolean isEndangered;

  public SpeciesIndicators(Boolean isPoisonous, Boolean isCompatible, Boolean isEndangered) {
    this.isPoisonous = isPoisonous;
    this.isCompatible = isCompatible;
    this.isEndangered = isEndangered;
  }

  public Boolean getIsPoisonous() {
    return this.isPoisonous;
  }

  public Boolean getIsCompatible() {
    return this.isCompatible;
  }

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
