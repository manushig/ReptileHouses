package conservancy;

/**
 * Temperature Range, it has minimum temperature in Celsius and maximum
 * Temperature in Celsius.
 */
public class TemperatureRange {
  private final int minTemp;
  private final int maxTemp;

  /**
   * Constructs a Temperature Range in terms of its minimum Temperature and
   * maximum Temperature.
   *
   * @param minTemp It is minimum temperature required in Celsius
   * @param maxTemp It is maximum temperature required in Celsius
   *
   */
  public TemperatureRange(int minTemp, int maxTemp) {
    this.minTemp = minTemp;
    this.maxTemp = maxTemp;
  }

  /**
   * It retrieves minimum Temperature.
   *
   */
  public int getMinTemp() {
    return this.minTemp;
  }

  /**
   * It retrieves maximum Temperature.
   *
   */
  public int getMaxTemp() {
    return this.maxTemp;
  }

  @Override
  public boolean equals(Object o) {
    // Fast path for pointer equality:
    if (this == o) { // backward compatibility with default equals
      return true;
    }

    // If o isn't the right class then it can't be equal:
    if (!(o instanceof TemperatureRange)) {
      return false;
    }

    // The successful instanceof check means our cast will succeed:
    TemperatureRange that = (TemperatureRange) o;

    return this.getMinTemp() == that.getMinTemp() && this.getMaxTemp() == that.getMaxTemp();
  }

  @Override
  public int hashCode() {
    return hashCode();
  }
}
