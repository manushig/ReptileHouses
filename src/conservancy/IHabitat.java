package conservancy;

import java.util.List;

/**
 * IHabitat, it is a place where species inhabit.
 *
 * Note: Habitat acquires the below characteristic from species:
 * <ul>
 * <li>The Temperature Range of the Habitat is 0-50 Celsius.
 * <li>The Minimum Temperature cannot be greater than Maximum Temperature and
 * vice versa.
 * </ul>
 */
public interface IHabitat {
  /**
   * Checks whether given habitat is compatible with the species.
   * @param species: Species object whose compatibility needs to be checked with current habitat
   * @return a IHabitat object with result property as true, if its compatible
   *         otherwise false
   */
  IHabitat isSpeciesCompatibleWithHabitat(ISpecies species);

  /**
   * Add species to the Habitat if they satisfy the conditions of the habitat.
   * @param species: Species object need to be added to the habitat
   * @return a IHabitat object with result property as true, if it add the species
   *         otherwise false
   */
  IHabitat addSpeciesToHabitat(ISpecies species);

  /**
   * It retrieves the result field value, this field value holds all operations
   * status.
   *
   * @return a result field.
   */
  public Boolean getStatus();

  /**
   * It retrieves the natural features details that are currently being used and
   * how much size is available in square meters.
   *
   * @return List of NaturalFeaturesReport object which has the natural features
   *         details that are currently being used and how much size is available
   *         in square meters.
   */
  public List<NaturalFeaturesReport> reportNaturalFeatures();

  /**
   * It retrieves habitat name.
   *
   * @return String object having habitat name
   */
  public String getHabitatName();

  /**
   * It retrieves information that lists the species that it houses along with a
   * description of the species and an indicator of how many of that species is
   * housed in that habitat.
   * 
   * 
   * @return String object having information that lists the species that it
   *         houses along with a description of the species and an indicator of
   *         how many of that species is housed in that habitat.
   */
  public String retriveDetailsToPrintHabitatSign();

  /**
   * It retrieves the details like habitat name and the natural features in the
   * habitat and species they house.
   *
   * @return String object having details like habitat name and the natural
   *         features in the habitat and species they house.
   */
  public String habitatsMap();
}
