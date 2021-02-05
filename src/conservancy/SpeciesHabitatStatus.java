package conservancy;

/**
 * Species Habitat Status, indicates species is in which habitat and what is the
 * count of the species in that habitat.
 */
public class SpeciesHabitatStatus {

  private String speciesHabitatLocation;

  private int sameSpeciesCount;

  /**
   * Constructs a Species Habitat Status, specifying species is in which habitat
   * and what is the count of the species in that habitat.
   *
   * @param speciesHabitatLocation It is an indicator to specify species is in
   *                               which habitat
   * @param sameSpeciesCount       It is a count of the species in that habitat
   * 
   */
  public SpeciesHabitatStatus(String speciesHabitatLocation, int sameSpeciesCount) {
    this.speciesHabitatLocation = speciesHabitatLocation;
    this.sameSpeciesCount = sameSpeciesCount;
  }

  /**
   * It retrieves a habitat Name in which species is there.
   *
   */
  public String getSpeciesHabitatLocation() {
    return this.speciesHabitatLocation;
  }

  /**
   * It sets the habitat name in which species is residing.
   *
   */
  public void setSpeciesHabitatLocation(String speciesHabitatLocation) {
    this.speciesHabitatLocation = speciesHabitatLocation;
  }

  /**
   * It retrieves a count of same species in a particular habitat.
   *
   */

  public int getSameSpeciesCount() {
    return this.sameSpeciesCount;
  }

  /**
   * It increment the count of species if same species added to the habitat.
   *
   */
  public void incrementSameSpeciesCount() {
    this.sameSpeciesCount = this.sameSpeciesCount + 1;
  }
}
