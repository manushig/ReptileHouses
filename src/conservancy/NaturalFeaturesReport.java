package conservancy;


public class NaturalFeaturesReport {
  private NaturalFeature naturalFeature;
  private NaturalFeaturesDetails naturalFeaturesDetailsList;

  public NaturalFeaturesReport(NaturalFeature naturalFeature,
      NaturalFeaturesDetails naturalFeaturesDetailsList) {
    this.naturalFeature = naturalFeature;
    this.naturalFeaturesDetailsList = naturalFeaturesDetailsList;
  }

  public NaturalFeature getNaturalFeature() {
    return this.naturalFeature;
  }

  public NaturalFeaturesDetails getNaturalFeaturesDetailsList() {
    return this.naturalFeaturesDetailsList;
  }

  public void addNauralFeatureDetailsToList(NaturalFeaturesDetails naturalFeaturesDetails) {
    //this.naturalFeaturesDetailsList.add(naturalFeaturesDetails);
  }
}