package conservancy;

public enum SpeciesSize {
  SMALL(1), MEDIUM(5), LARGE(10);
  
  private int value;

  public int getSizeRequiredInHabitat() {
      return value;
  }

  SpeciesSize(int value){
      this.value = value;
  }
}