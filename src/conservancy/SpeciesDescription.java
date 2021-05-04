package conservancy;

import java.util.Objects;

/**
 * Species Description, A description of the species' defining characteristic
 * and size (small, medium, large).
 */
public final class SpeciesDescription {

  private final SpeciesSize size;

  private final String characteristic;

  /**
   * Constructs a Species Description, in terms of its defining characteristic and
   * size (small, medium, large).
   *
   * @param size           It is a size of the species(small, medium, large)
   * @param characteristic It is a defining characteristic of the species
   * 
   */
  public SpeciesDescription(SpeciesSize size, String characteristic) {
    Objects.requireNonNull(size);
    Objects.requireNonNull(characteristic);
    this.size = size;
    this.characteristic = characteristic;
  }

  /**
   * It retrieves a size of the species(small, medium, large).
   *
   */
  public SpeciesSize getSize() {
    return this.size;
  }

  /**
   * It retrieves a defining characteristic of the species.
   *
   */
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
