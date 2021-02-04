package conservancy;

public class SpeciesHabitatStatus {

  private String speciesHabitatLocation;

  private int sameSpeciesCount;

  public SpeciesHabitatStatus(String speciesHabitatLocation, int sameSpeciesCount) {
    this.speciesHabitatLocation = speciesHabitatLocation;
    this.sameSpeciesCount = sameSpeciesCount;
  }

  public String getSpeciesHabitatLocation() {
    return this.speciesHabitatLocation;
  }

  public void setSpeciesHabitatLocation(String speciesHabitatLocation) {
    this.speciesHabitatLocation = speciesHabitatLocation;
  }

  public int getSameSpeciesCount() {
    return this.sameSpeciesCount;
  }

  public void incrementSameSpeciesCount() {
    this.sameSpeciesCount = this.sameSpeciesCount + 1;
  }

  /*
  @Override
  public boolean equals(Object o) {
    // Fast path for pointer equality:
    if (this == o) { // backward compatibility with default equals
      return true;
    }

    // If o isn't the right class then it can't be equal:
    if (!(o instanceof SpeciesHabitatStatus)) {
      return false;
    }

    // The successful instanceof check means our cast will succeed:
    SpeciesHabitatStatus that = (SpeciesHabitatStatus) o;

    return this.getSpeciesHabitatLocation() == that.getSpeciesHabitatLocation()
        && this.getSameSpeciesCount() == that.getSameSpeciesCount();
  }

  @Override
  public int hashCode() {
    return hashCode();
  }
  */

}
