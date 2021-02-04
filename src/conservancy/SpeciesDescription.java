package conservancy;

public final class SpeciesDescription {

  private final SpeciesSize size;

  private final String characteristic;

  public SpeciesDescription(SpeciesSize size, String characteristic) {
    this.size = size;
    this.characteristic = characteristic;
  }

  public SpeciesSize getSize() {
    return this.size;
  }

  public String getCharacteristic() {
    return this.characteristic;
  }
  
  @Override
  public boolean equals(Object o) {
    // Fast path for pointer equality:
    if (this == o) { // backward compatibility with default equals
      return true;
    }

    // If o isn't the right class then it can't be equal:
    if (!(o instanceof SpeciesDescription)) {
      return false;
    }

    // The successful instanceof check means our cast will succeed:
    SpeciesDescription that = (SpeciesDescription) o;

    return this.getSize() == that.getSize() && this.getCharacteristic() == that.getCharacteristic();
  }

  @Override
  public int hashCode() {
    return hashCode();
  }

}
