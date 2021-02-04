import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import conservancy.*;

public class SpeciesTest {
  private ISpecies amphibianSpecies;
  private ISpecies reptileSpecies;

  @Before
  public void setUp() {
    String amphibianSpeciesName = "Tree Frog";
    String amphibianSpeciesType = "AMPHIBIAN";
    SpeciesSize amphibianSize = SpeciesSize.SMALL;
    String amphibianCharacteristic = "disc-shaped";
    int amphibianMinTemp = 23;
    int amphibianMaxTemp = 29;
    NaturalFeature amphibianSpeciesNaturalFeature = NaturalFeature.TREE_BRANCHES;
    Boolean amphibianIsPoisonous = false;
    Boolean amphibianIsExtinct = false;
    Boolean amphibianIsEndangered = false;
    Boolean amphibianIsCompatible = true;

    amphibianSpecies = createSpecies(amphibianSpeciesName, amphibianSpeciesType, amphibianSize,
        amphibianCharacteristic, amphibianMinTemp, amphibianMaxTemp, amphibianSpeciesNaturalFeature,
        amphibianIsPoisonous, amphibianIsExtinct, amphibianIsCompatible, amphibianIsEndangered);

    String reptileSpeciesName = "Green Sea Turtle";
    String reptileSpeciesType = "REPTILE";
    SpeciesSize reptileSize = SpeciesSize.LARGE;
    String reptileCharacteristic = "heart-shaped shell";
    int reptileMinTemp = 20;
    int reptileMaxTemp = 29;
    NaturalFeature reptileSpeciesNaturalFeature = NaturalFeature.SALT_WATER;
    Boolean reptileIsPoisonous = false;
    Boolean reptileIsExtinct = false;
    Boolean reptileIsCompatible = true;
    Boolean reptileIsEndangered = false;

    reptileSpecies = createSpecies(reptileSpeciesName, reptileSpeciesType, reptileSize,
        reptileCharacteristic, reptileMinTemp, reptileMaxTemp, reptileSpeciesNaturalFeature,
        reptileIsPoisonous, reptileIsExtinct, reptileIsCompatible, reptileIsEndangered);
  }

  @Test
  public void testIsAmphibianSpeciesCompatibleWithHabitat() {
    SpeciesType speciesType = new SpeciesType("");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 5;

    Boolean expectedResult = true;

    amphibianSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, amphibianSpecies.getStatus());
  }

  @Test
  public void testIsAmphibianSpeciesCompatibleWithHabitatIfReptile() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 5;

    Boolean expectedResult = false;

    amphibianSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, amphibianSpecies.getStatus());
  }

  @Test
  public void testIsAmphibianSpeciesCompatibleWithHabitatIfAmphibian() {
    SpeciesType speciesType = new SpeciesType("AMPHIBIAN");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 5;

    Boolean expectedResult = true;

    amphibianSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, amphibianSpecies.getStatus());
  }

  @Test
  public void testIsReptileSpeciesCompatibleWithHabitat() {
    SpeciesType speciesType = new SpeciesType("");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 15;

    Boolean expectedResult = true;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsReptileSpeciesCompatibleWithHabitatIfReptile() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 15;

    Boolean expectedResult = true;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsReptileSpeciesCompatibleWithHabitatIfAmphibian() {
    SpeciesType speciesType = new SpeciesType("AMPHIBIAN");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 15;

    Boolean expectedResult = false;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsSpeciesCompatibleWithLargerHabitatAvailableSize() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 15;

    Boolean expectedResult = true;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsSpeciesCompatibleWithEqualToHabitatAvailableSize() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 10;

    Boolean expectedResult = true;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsSpeciesCompatibleWithSmallerHabitatAvailableSize() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 5;

    Boolean expectedResult = false;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsSpeciesCompatibleWithEmptyHabitatTemperatureRange() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    TemperatureRange habitatTempRange = null;
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 15;

    Boolean expectedResult = true;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsSpeciesCompatibleWithinHabitatTemperatureRange() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 15;

    Boolean expectedResult = true;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsSpeciesCompatibleWithinHabitatTemperatureRange1() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 20;
    int habitatMaxTemp = 29;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 15;

    Boolean expectedResult = true;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsSpeciesCompatibleOutsideHabitatTemperatureRange() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 28;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 15;

    Boolean expectedResult = false;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsSpeciesCompatibleOutsideHabitatTemperatureRange2() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 21;
    int habitatMaxTemp = 29;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 15;

    Boolean expectedResult = false;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsSpeciesCompatiblewithOtherSpecies() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 15;

    Boolean expectedResult = true;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsSpeciesNotCompatiblewithOtherSpecies() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 25;
    int habitatMaxTemp = 33;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 15;

    String reptileSpeciesName = "Rattlesnake";
    String reptileSpeciesType = "REPTILE";
    SpeciesSize reptileSize = SpeciesSize.LARGE;
    String reptileCharacteristic = " heavy-bodied snakes with large, broad heads with two light lines on the face";
    int reptileMinTemp = 26;
    int reptileMaxTemp = 32;
    NaturalFeature reptileSpeciesNaturalFeature = NaturalFeature.FALLEN_LOGS;
    Boolean reptileIsPoisonous = true;
    Boolean reptileIsExtinct = false;
    Boolean reptileIsCompatible = false;
    Boolean reptileIsEndangered = false;

    reptileSpecies = createSpecies(reptileSpeciesName, reptileSpeciesType, reptileSize,
        reptileCharacteristic, reptileMinTemp, reptileMaxTemp, reptileSpeciesNaturalFeature,
        reptileIsPoisonous, reptileIsExtinct, reptileIsCompatible, reptileIsEndangered);

    Boolean expectedResult = false;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsSpeciesCompatiblewithNoNaturalFeatures() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    int habitatSize = 15;

    Boolean expectedResult = true;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsSpeciesCompatiblewithMorethan3NaturalFeatures() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    habitatNaturalFeatureList.add(NaturalFeature.TREE_BRANCHES);
    habitatNaturalFeatureList.add(NaturalFeature.SALT_WATER);
    habitatNaturalFeatureList.add(NaturalFeature.FALLEN_LOGS);
    habitatNaturalFeatureList.add(NaturalFeature.ROCKS);

    int habitatSize = 15;

    Boolean expectedResult = false;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsSpeciesCompatiblewith3NaturalFeatures() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    habitatNaturalFeatureList.add(NaturalFeature.TREE_BRANCHES);
    habitatNaturalFeatureList.add(NaturalFeature.ROCKS);
    habitatNaturalFeatureList.add(NaturalFeature.FALLEN_LOGS);

    int habitatSize = 15;

    Boolean expectedResult = false;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsSpeciesCompatiblewith3NaturalFeaturesButNotSpeciesOne() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    habitatNaturalFeatureList.add(NaturalFeature.TREE_BRANCHES);
    habitatNaturalFeatureList.add(NaturalFeature.SALT_WATER);
    habitatNaturalFeatureList.add(NaturalFeature.FALLEN_LOGS);

    int habitatSize = 15;

    Boolean expectedResult = true;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testIsSpeciesCompatiblewithLessThan3NaturalFeaturesButNotSpeciesOne() {
    SpeciesType speciesType = new SpeciesType("REPTILE");
    int habitatMinTemp = 18;
    int habitatMaxTemp = 30;
    TemperatureRange habitatTempRange = new TemperatureRange(habitatMinTemp, habitatMaxTemp);
    ArrayList<NaturalFeature> habitatNaturalFeatureList = new ArrayList<NaturalFeature>();
    habitatNaturalFeatureList.add(NaturalFeature.TREE_BRANCHES);

    habitatNaturalFeatureList.add(NaturalFeature.FALLEN_LOGS);

    int habitatSize = 15;

    Boolean expectedResult = true;

    reptileSpecies.isSpeciesCompatibleWithHabitat(speciesType, habitatTempRange,
        habitatNaturalFeatureList, habitatSize);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testSetSpeciesNewLocation() {
    String speciesLoaction = "Habitat1";

    Boolean expectedResult = true;

    reptileSpecies.setSpeciesHabitatStatus(speciesLoaction);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testSetSpeciesExistingLocation() {
    String speciesLoaction = "Habitat1";

    Boolean expectedResult = true;

    reptileSpecies.setSpeciesHabitatStatus(speciesLoaction);
    reptileSpecies.setSpeciesHabitatStatus(speciesLoaction);

    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testSetSpeciesExistingAndNewLocation() {
    String speciesLoaction1 = "Habitat1";
    String speciesLoaction2 = "Habitat2";

    Boolean expectedResult = true;

    reptileSpecies.setSpeciesHabitatStatus(speciesLoaction1);
    reptileSpecies.setSpeciesHabitatStatus(speciesLoaction1);
    reptileSpecies.setSpeciesHabitatStatus(speciesLoaction2);
    reptileSpecies.setSpeciesHabitatStatus(speciesLoaction2);
    assertEquals(expectedResult, reptileSpecies.getStatus());
  }

  @Test
  public void testToString() {
    String expectedResult = "Species:\r\n" + " Name: Green Sea Turtle \r\n" + " (Description: \r\n"
        + " Size: LARGE \r\n" + " Characteristic: heart-shaped shell \r\n" + " Indicator: \r\n"
        + " Poisonous: false \r\n" + " Extinct: false \r\n" + " Compatible: true \r\n"
        + " Endangered: false";
    reptileSpecies.toString();
    assertEquals(expectedResult, reptileSpecies.toString());
  }

  @Test
  public void testRetrieveSpeciesDetails() {
    int minTemp = 20;
    int maxTemp = 29;
    TemperatureRange tempRange = new TemperatureRange(minTemp, maxTemp);
    SpeciesType type = new SpeciesType("REPTILE");
    HabitatSpeciesDetails expectedResult = new HabitatSpeciesDetails(10, type, tempRange,
        NaturalFeature.SALT_WATER, true);
    HabitatSpeciesDetails actualResult = reptileSpecies.retrieveSpeciesDetails();
    assertEquals(true, actualResult.equals(expectedResult));
  }

  @Test
  public void equalsWorks() {
    Boolean expectedResult = true;
    String strObj = "test";

    String reptileSpeciesType = "REPTILE";
    SpeciesType speciesType1 = new SpeciesType(reptileSpeciesType);
    SpeciesType speciesType2 = new SpeciesType(reptileSpeciesType);
    assertEquals(expectedResult, speciesType1.equals(speciesType2));
    assertEquals(expectedResult, speciesType1.equals(speciesType1));
    assertNotEquals(expectedResult, speciesType1.equals(strObj));

    SpeciesSize reptileSize = SpeciesSize.LARGE;
    String reptileCharacteristic = "heart-shaped shell";
    SpeciesDescription speciesDes1 = new SpeciesDescription(reptileSize, reptileCharacteristic);
    SpeciesDescription speciesDes2 = new SpeciesDescription(reptileSize, reptileCharacteristic);
    assertEquals(expectedResult, speciesDes1.equals(speciesDes1));
    assertEquals(expectedResult, speciesDes1.equals(speciesDes2));
    assertNotEquals(expectedResult, speciesDes1.equals(strObj));

    int reptileMinTemp = 20;
    int reptileMaxTemp = 29;
    TemperatureRange tempRange1 = new TemperatureRange(reptileMinTemp, reptileMaxTemp);
    TemperatureRange tempRange2 = new TemperatureRange(reptileMinTemp, reptileMaxTemp);
    assertEquals(expectedResult, tempRange1.equals(tempRange1));
    assertEquals(expectedResult, tempRange1.equals(tempRange2));
    assertNotEquals(expectedResult, tempRange1.equals(strObj));

    Boolean reptileIsPoisonous = false;
    Boolean reptileIsCompatible = true;
    Boolean reptileIsEndangered = false;

    SpeciesIndicators speciesIndicator1 = new SpeciesIndicators(reptileIsPoisonous,
        reptileIsCompatible, reptileIsEndangered);
    SpeciesIndicators speciesIndicator2 = new SpeciesIndicators(reptileIsPoisonous,
        reptileIsCompatible, reptileIsEndangered);
    assertEquals(expectedResult, speciesIndicator1.equals(speciesIndicator1));
    assertEquals(expectedResult, speciesIndicator1.equals(speciesIndicator2));
    assertNotEquals(expectedResult, speciesIndicator1.equals(strObj));
  }
  /*
   * @Test public void testHashCodeWorks() { //speciestype - hash,equal
   * //temprange - hash, equal //speciesindiactor - equals, hashcode, getispoinous
   * //speciesdes - equals, getcharacteristic, hashcode Transmission
   * autoTransmissionExpected = autoTransmission(3, 6, 8, 14, 17);
   * assertEquals(autoTransmission.hashCode(),
   * autoTransmissionExpected.hashCode()); }
   */
  
  @Test
  public void getIsSpeciesExtinct() {
    Boolean expectedResult = false;
    assertEquals(expectedResult, reptileSpecies.getIsSpeciesExtinct());
  }
  
  @Test
  public void speciesLookUp() {
    Map<String, Collection<SpeciesHabitatStatus>> speciesLookUp = reptileSpecies.speciesLookUp();
    assertEquals(true, speciesLookUp.size()==1);
  }

  protected ISpecies createSpecies(String speciesName, String speciesType, SpeciesSize size,
      String characteristic, int minTemp, int maxTemp, NaturalFeature speciesNaturalFeature,
      Boolean isPoisonous, Boolean isExtinct, Boolean isCompatible, Boolean isEndangered) {

    return new Species(speciesName, speciesType, size, characteristic, minTemp, maxTemp,
        speciesNaturalFeature, isPoisonous, isExtinct, isCompatible, isEndangered);
  }

}
