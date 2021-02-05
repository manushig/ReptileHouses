package conservancy;

/**
 * IReptileHouses, implement a tracking system for their many Reptile Houses
 * which house reptiles and amphibians in a number of different habitats.
 *
 * <ul>
 * <li>New animals should be able to be brought into a Reptile House by adding
 * them to an appropriate habitat satisfying few criteria
 * <li>Report the natural features that are currently being used in alphabetical
 * order.
 * <li>Look up which habitat(s) that house a particular species.
 * <li>Print a sign for any given habitat that lists the species that it houses
 * along with a description of the species and an indicator of how many of that
 * species is housed in that habitat.
 * <li>Print a “map” that lists all the habitats by location and the natural
 * features in the habitat and species they house.
 * <li>Print an index that lists all species in the Reptile House in
 * alphabetical order and their location(s).
 * </ul>
 */
public interface IReptileHouses {
  /**
   * HabitatSize as 30 square meters.
   *
   */
  public final int habitatSize = 30;

  /**
   * It creates the species data for the Reptile House to track the species.
   *
   * @return a IReptileHouses object with result property as true, if its
   *         compatible otherwise false
   */
  public IReptileHouses createSpecies(String speciesName, String speciesType, SpeciesSize size,
      String characteristic, int minTemp, int maxTemp, NaturalFeature speciesNaturalFeature,
      Boolean isPoisonous, Boolean isExtinct, Boolean isCompatible, Boolean isEndangered);

  /**
   * It add the species into the habitat to inhabitate.
   *
   * @return a IReptileHouses object with result property as true, if its
   *         compatible otherwise false
   */
  public IReptileHouses addSpeciesToReptileHouse(String speciesName);

  /**
   * It retrieves the result field value, this field value holds all operations
   * status.
   *
   * @return a result field.
   */
  public Boolean getStatus();

  /**
   * Report the natural features that are currently being used in alphabetical
   * order.
   *
   * @return a String Objects which has the details of the report.
   */
  public String reportNaturalFeatures();

  /**
   * Look up which habitat(s) that house a particular species.
   *
   * @return a String Objects which has the details of the species and its
   *         habitat.
   */
  public String speciesLookUp(String speciesToLookUp);

  /**
   * Print a sign for any given habitat that lists the species that it houses
   * along with a description of the species and an indicator of how many of that
   * species is housed in that habitat.
   *
   * @return a String Objects which has the details of the habitat and list of
   *         species residing along with species count
   */
  public String printHabitatIndex(String habitatName);

  /**
   * Print a “map” that lists all the habitats by location and the natural
   * features in the habitat and species they house.
   *
   * @return a String Objects which has the required map details
   */
  public String printSpeciesIndex();

  /**
   * Print an index that lists all species in the Reptile House in alphabetical
   * order and their location(s).
   *
   * @return a String Objects which has sorted list of species and its location
   */
  public String allHabitatsMap();
  
  public static IReptileHouses getInstance() {
    return ReptileHouses.getInstance();
  }

}
