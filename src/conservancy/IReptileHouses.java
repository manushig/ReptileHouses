package conservancy;

/**
 * IReptileHouses, implement a tracking system for many Reptile Houses
 * which house the reptiles and amphibians in a number of different habitats.
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
 * <li>Print a �map� that lists all the habitats by location and the natural
 * features in the habitat and species they house.
 * <li>Print an index that lists all species in the Reptile House in
 * alphabetical order and their location(s).
 * </ul>
 */
public interface IReptileHouses {
  /**
   * HabitatSize as 30 square meters.
   * Note: Max Habitat size for any habitat will be 30 
   *
   */
  public final int habitatSize = 30;

  /**
   * It creates the species data in the Reptile House to track the different species.
   * @param speciesName:          Name of the species to be added to the reptile house
   * @param speciesType           It is the type of the species whether its
   *                              reptile or Amphibian
   * @param size                  It is the size of the animal(small, medium,
   *                              large)
   * @param characteristic        Characteristic/description of species
   * @param minTemp               It is minimum temperature required in Celsius
   * @param maxTemp               It is maximum temperature required in Celsius
   * @param speciesNaturalFeature It is a particular natural feature that species
   *                              prefer to hang out in.
   * @param isPoisonous           It is an indicator which shows whether species
   *                              is poisonous or not.
   * @param isExtinct             It is an indicator which shows whether species
   *                              is extinct or not.
   * @param isCompatible          It is an indicator which shows whether species
   *                              can live with other species.
   * @param isEndangered          It is an indicator which shows whether species
   *                              is endangered or not.
   * Note: throws IllegalArgumentException if the input variables are null
   * @return a IReptileHouses object with result property as true, if its
   *         compatible otherwise false.
   */
  public IReptileHouses createSpecies(String speciesName, String speciesType, SpeciesSize size,
      String characteristic, int minTemp, int maxTemp, NaturalFeature speciesNaturalFeature,
      Boolean isPoisonous, Boolean isExtinct, Boolean isCompatible, Boolean isEndangered) throws IllegalArgumentException;

  /**
   * It add the species into the suitable habitat to inhabit.
   * @param speciesName:          Name of the species to be added to the reptile house.
   * Note: throws IllegalArgumentException if the input variables are null
   * @return a IReptileHouses object with result property as true, if its
   *         compatible otherwise false.
   */
  public IReptileHouses addSpeciesToReptileHouse(String speciesName)  throws IllegalArgumentException;

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
   * @param speciesToLookUp:  Name of the species to be looked up in the reptile house habitat(s)
   * Note: throws IllegalArgumentException if the input variables are null
   * @return a String Objects which has the details of the species and its
   *         habitat.
   */
  public String speciesLookUp(String speciesToLookUp) throws IllegalArgumentException;

  /**
   * Print a sign for any given habitat that lists the species that it houses
   * along with a description of the species and an indicator of how many of that
   * species is housed in that habitat.
   * @param habitatName: habitat's name for which sign has to be printed.
   * Note: throws IllegalArgumentException if the input variables are null
   * @return a String Objects which has the details of the habitat and list of
   *         species residing along with species count.
   */
  public String printHabitatIndex(String habitatName) throws IllegalArgumentException;

  /**
   * Print a "map" that lists all the habitats by location and the natural
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
  
  /* Singleton class getInstance method 
   * 
   * @return Returns the resptileHouse single instance object.
   * */
  public static IReptileHouses getInstance() {
    return ReptileHouses.getInstance();
  }

}
