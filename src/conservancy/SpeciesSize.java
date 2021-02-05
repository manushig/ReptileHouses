package conservancy;

public enum SpeciesSize {
  SMALL(1), MEDIUM(5), LARGE(10);
  
  private int value;
  /**
   * It retrieves Species size in square meters
   *
   */
  public int getSizeRequiredInHabitat() {
      return value;
  }
  /**
   * It sets Species size
   *
   */
  SpeciesSize(int value){
      this.value = value;
  }
}