package conservancy;

public class NaturalFeaturesDetails {
  private String habitatName;
  private int habitSizeAvailable;

  public NaturalFeaturesDetails(String habitatName, int habitSizeAvailable) {
    this.habitatName = habitatName;
    this.habitSizeAvailable = habitSizeAvailable;
  }

  public String getHabitatName() {
    return this.habitatName;
  }

  public void setHabitatName(String habitatName) {
    this.habitatName = habitatName;
  }

  public int getHabitSizeAvailable() {
    return this.habitSizeAvailable;
  }

  public void setHabitSizeAvailable(int habitSizeAvailable) {
    this.habitSizeAvailable = habitSizeAvailable;
  }
  
  /*
  @Override
  public boolean equals(Object o) {
    // Fast path for pointer equality:
    if (this == o) { // backward compatibility with default equals
      return true;
    }

    // If o isn't the right class then it can't be equal:
    if (!(o instanceof NaturalFeaturesDetails)) {
      return false;
    }

    // The successful instanceof check means our cast will succeed:
    NaturalFeaturesDetails that = (NaturalFeaturesDetails) o;

    return this.habitatName == that.habitatName && this.habitSizeAvailable == that.habitSizeAvailable;
  }

  @Override
  public int hashCode() {
    return hashCode();
  }
  */
  
  
}

