package conservancy;

/**
 * Species Size, size of the species.The number of animals a habitat can host
 * depends on the size of the habitat and the size of the animals in it. Small
 * animals require 1 square meter, medium animals require 5 square meters, and
 * large animals require 10 square meters.
 */
public enum SpeciesSize {

  SMALL(1), MEDIUM(5), LARGE(10);

  private int value;

  /**
   * It retrieves Species size in square meters.
   *
   */
  public int getSizeRequiredInHabitat() {
    return value;
  }

  /**
   * It sets Species size.
   *
   */
  SpeciesSize(int value) {
    this.value = value;
  }
}