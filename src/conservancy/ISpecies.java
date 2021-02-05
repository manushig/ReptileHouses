package conservancy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * ISpecies, its an species which are housed in the Reptile House.
 *
 * <ul>
 * <li>The Temperature Range of the Species is 0-50 Celcius.
 * <li>The Minimum Temperature cannot be greater than Maximum Temperature and
 * vice versa.
 * </ul>
 */
public interface ISpecies {
  /**
   * Checks whether given species is compatile with the Habitat.
   *
   * @return a ISpecies object with result property as true, if its compatible
   *         otherwise false
   */
  public ISpecies isSpeciesCompatibleWithHabitat(SpeciesType speciesType,
      TemperatureRange habitatTempRange, ArrayList<NaturalFeature> habitatNaturalFeatureList,
      int habitatAvailableSize, Boolean doCompatibilityCheck);

  /**
   * Species sets its habitat location where it is residing and its counts in that
   * habitat.
   *
   * @return a ISpecies object with result property as true, if its successful
   *         otherwise false
   */
  public ISpecies setSpeciesHabitatStatus(String speciesHabitatLocation);

  /**
   * It retrieves the result field value, this field value holds all operations
   * status.
   *
   * @return a result field.
   */
  public Boolean getStatus();

  /**
   * It retrieves the details like Temperature Range, Species Size, Species Type
   * and preferred Natural Feature.
   *
   * @return HabitatSpeciesDetails object which has details like Temperature
   *         Range, Species Size, Species Type and preferred Natural Feature
   */
  public HabitatSpeciesDetails retrieveSpeciesDetails();

  /**
   * It retrieves species extinct Indicator.
   *
   * @return Boolean object having species extinct Indicator detail
   */
  public Boolean getIsSpeciesExtinct();

  /**
   * It fetched species lookup details like species name and in which habitat its
   * inhabitating.
   *
   * @return Hashmap object having species lookup details like species name and in
   *         which habitat its inhabitating
   */
  public Map<String, Collection<SpeciesHabitatStatus>> speciesLookUp();

  /**
   * It retrieves species name.
   *
   * @return String object having species name
   */
  public String getSpeciesName();

  /**
   * It fetched species details like species name and its characteristics along
   * with species Indicator to print.
   *
   * @return String object having details like species name and its
   *         characteristics along with species Indicator to print
   */
  public String retriveDetailsToPrintHabitatSign(String habitatName);
}
