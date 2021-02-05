package conservancy;

/**
 * Natural Features Report, indicates which natural feature is there in which
 * habitat and how much size is available in each habitat.
 */

public class NaturalFeaturesReport {
  private NaturalFeature naturalFeature;
  private NaturalFeaturesDetails naturalFeaturesDetailsList;

  /**
   * Constructs a Natural Features Report, specifying which natural feature is
   * there in which habitat and how much size is available in each habitat.
   *
   * @param naturalFeature             It is an preferred Natural Feature
   * @param naturalFeaturesDetailsList It has the details about which habitat has
   *                                   a particular natural feature and how much
   *                                   size is available in each habitat.
   * 
   */
  public NaturalFeaturesReport(NaturalFeature naturalFeature,
      NaturalFeaturesDetails naturalFeaturesDetailsList) {
    this.naturalFeature = naturalFeature;
    this.naturalFeaturesDetailsList = naturalFeaturesDetailsList;
  }

  /**
   * It retrieves a preferred Natural Feature.
   *
   */
  public NaturalFeature getNaturalFeature() {
    return this.naturalFeature;
  }

  /**
   * It retrieves the details about which habitat has a particular natural feature
   * and how much size is available in each habitat.
   *
   */
  public NaturalFeaturesDetails getNaturalFeaturesDetailsList() {
    return this.naturalFeaturesDetailsList;
  }
}