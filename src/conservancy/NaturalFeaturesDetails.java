package conservancy;

/**
 * Natural Features Details, indicates habitat name and what is the available
 * size of that habitat.
 */
public class NaturalFeaturesDetails {
  private String habitatName;
  private int habitSizeAvailable;

  /**
   * Constructs a Natural Features Details, specifying habitat name and what is
   * the available size of that habitat.
   *
   * @param habitatName        It is habitat name
   * @param habitSizeAvailable It is the available size of the habitat
   * 
   */
  public NaturalFeaturesDetails(String habitatName, int habitSizeAvailable) {
    this.habitatName = habitatName;
    this.habitSizeAvailable = habitSizeAvailable;
  }

  /**
   * It retrieves a habitat Name.
   *
   */
  public String getHabitatName() {
    return this.habitatName;
  }

  /**
   * It sets a habitat Name in a species.
   *
   */
  public void setHabitatName(String habitatName) {
    this.habitatName = habitatName;
  }

  /**
   * It retrieves the available size of the habitat.
   *
   */
  public int getHabitSizeAvailable() {
    return this.habitSizeAvailable;
  }

  /**
   * It sets the available size of the habitat.
   *
   */
  public void setHabitSizeAvailable(int habitSizeAvailable) {
    this.habitSizeAvailable = habitSizeAvailable;
  }

}
