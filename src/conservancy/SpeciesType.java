package conservancy;

import java.util.Objects;

/**
 * Species Type, whether its a reptile or amphibian.
 */
public final class SpeciesType {
  private final String speciesType;

  /**
   * Constructs a Species Type in terms whether its a reptile or amphibian.
   *
   * @param speciesType It is a species Type
   *
   */
  public SpeciesType(String speciesType) {
    Objects.requireNonNull(speciesType);
    this.speciesType = speciesType;
  }

  /**
   * It retrieves Species type.
   * 
   * @return Species type.
   */
  public String getSpeciesType() {
    return this.speciesType;
  }

  @Override
  public boolean equals(Object o) {
    // Fast path for pointer equality:
    if (this == o) { // backward compatibility with default equals
      return true;
    }

    // If o isn't the right class then it can't be equal:
    if (!(o instanceof SpeciesType)) {
      return false;
    }

    // The successful instanceof check means our cast will succeed:
    SpeciesType that = (SpeciesType) o;

    boolean b = this.speciesType == that.speciesType;

    return b;
  }

  @Override
  public int hashCode() {
    return hashCode();
  }

}
