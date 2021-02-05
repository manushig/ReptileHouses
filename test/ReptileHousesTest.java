import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

import conservancy.IReptileHouses;
import conservancy.ReptileHouses;
import conservancy.NaturalFeature;
import conservancy.SpeciesSize;

/**
 * A JUnit test class for the ReptileHouses class.
 */
public class ReptileHousesTest {
  private IReptileHouses reptileHouse1;
  String grayTreeFrog;
  String hellbenderSalamander;
  String greenSeaTurtle;
  String rattlesnake;
  String americanAlligator;
  String desertTortoise;
  String fenceLizard;
  String capeVerdeGiantSkink;

  @Before
  public void setUp() throws SecurityException, NoSuchFieldException, IllegalArgumentException,
      IllegalAccessException {

    Field instance = ReptileHouses.class.getDeclaredField("instance");
    instance.setAccessible(true);
    instance.set(null, null);

    reptileHouse1 = ReptileHouses.getInstance();

    grayTreeFrog = "Gray TreeFrog";
    String amphibianSpeciesType = "AMPHIBIAN";
    SpeciesSize amphibianSize = SpeciesSize.SMALL;
    String amphibianCharacteristic = "Gray treefrogs have a white spot beneath each eye "
        + "and a dark stripe from the rear of the eyes to the front of the legs.";
    int amphibianMinTemp = 10;
    int amphibianMaxTemp = 32;
    NaturalFeature amphibianSpeciesNaturalFeature = NaturalFeature.TREE_BRANCHES;
    Boolean amphibianIsPoisonous = true;
    Boolean amphibianIsExtinct = false;
    Boolean amphibianIsEndangered = false;
    Boolean amphibianIsCompatible = false;

    createSpecies(grayTreeFrog, amphibianSpeciesType, amphibianSize, amphibianCharacteristic,
        amphibianMinTemp, amphibianMaxTemp, amphibianSpeciesNaturalFeature, amphibianIsPoisonous,
        amphibianIsExtinct, amphibianIsCompatible, amphibianIsEndangered);

    hellbenderSalamander = "Hellbender Salamander";
    String amphibianSpeciesType2 = "AMPHIBIAN";
    SpeciesSize amphibianSize2 = SpeciesSize.MEDIUM;
    String amphibianCharacteristic2 = "Hellbender Salamander is easily distinguished "
        + "from most other endemic salamander species simply by their size, hellbenders "
        + "average up to about 2 ft in length, making them the largest amphibian in North America.";
    int amphibianMinTemp2 = 10;
    int amphibianMaxTemp2 = 26;
    NaturalFeature amphibianSpeciesNaturalFeature2 = NaturalFeature.FLOWING_WATER;
    Boolean amphibianIsPoisonous2 = false;
    Boolean amphibianIsExtinct2 = false;
    Boolean amphibianIsEndangered2 = true;
    Boolean amphibianIsCompatible2 = true;

    createSpecies(hellbenderSalamander, amphibianSpeciesType2, amphibianSize2,
        amphibianCharacteristic2, amphibianMinTemp2, amphibianMaxTemp2,
        amphibianSpeciesNaturalFeature2, amphibianIsPoisonous2, amphibianIsExtinct2,
        amphibianIsCompatible2, amphibianIsEndangered2);

    greenSeaTurtle = "Green Sea Turtle";
    String reptileSpeciesType = "REPTILE";
    SpeciesSize reptileSize = SpeciesSize.LARGE;
    String reptileCharacteristic = "Green Sea Turtle has heart-shaped shell";
    int reptileMinTemp = 8;
    int reptileMaxTemp = 38;
    NaturalFeature reptileSpeciesNaturalFeature = NaturalFeature.SALT_WATER;
    Boolean reptileIsPoisonous = false;
    Boolean reptileIsExtinct = false;
    Boolean reptileIsCompatible = true;
    Boolean reptileIsEndangered = false;

    createSpecies(greenSeaTurtle, reptileSpeciesType, reptileSize, reptileCharacteristic,
        reptileMinTemp, reptileMaxTemp, reptileSpeciesNaturalFeature, reptileIsPoisonous,
        reptileIsExtinct, reptileIsCompatible, reptileIsEndangered);

    rattlesnake = "Rattlesnake";
    String reptileSpeciesType2 = "REPTILE";
    SpeciesSize reptileSize2 = SpeciesSize.LARGE;
    String reptileCharacteristic2 = "Rattlesnake has heavy-bodied snakes with large, "
        + "broad heads with two light lines on the face";
    int reptileMinTemp2 = 19;
    int reptileMaxTemp2 = 32;
    NaturalFeature reptileSpeciesNaturalFeature2 = NaturalFeature.FALLEN_LOGS;
    Boolean reptileIsPoisonous2 = true;
    Boolean reptileIsExtinct2 = false;
    Boolean reptileIsCompatible2 = true;
    Boolean reptileIsEndangered2 = false;

    createSpecies(rattlesnake, reptileSpeciesType2, reptileSize2, reptileCharacteristic2,
        reptileMinTemp2, reptileMaxTemp2, reptileSpeciesNaturalFeature2, reptileIsPoisonous2,
        reptileIsExtinct2, reptileIsCompatible2, reptileIsEndangered2);

    americanAlligator = "American Alligator";
    String reptileSpeciesType3 = "REPTILE";
    SpeciesSize reptileSize3 = SpeciesSize.LARGE;
    String reptileCharacteristic3 = "American alligator is capable of biting through a "
        + "turtle's shell or a moderately sized mammal bone.";
    int reptileMinTemp3 = 28;
    int reptileMaxTemp3 = 33;
    NaturalFeature reptileSpeciesNaturalFeature3 = NaturalFeature.POND;
    Boolean reptileIsPoisonous3 = false;
    Boolean reptileIsExtinct3 = false;
    Boolean reptileIsCompatible3 = false;
    Boolean reptileIsEndangered3 = false;

    createSpecies(americanAlligator, reptileSpeciesType3, reptileSize3, reptileCharacteristic3,
        reptileMinTemp3, reptileMaxTemp3, reptileSpeciesNaturalFeature3, reptileIsPoisonous3,
        reptileIsExtinct3, reptileIsCompatible3, reptileIsEndangered3);

    desertTortoise = "Desert Tortoise";
    String reptileSpeciesType4 = "REPTILE";
    SpeciesSize reptileSize4 = SpeciesSize.MEDIUM;
    String reptileCharacteristic4 = "Desert tortoises dig underground burrows in order to "
        + "hide from the sun in the deep desert.";
    int reptileMinTemp4 = 8;
    int reptileMaxTemp4 = 26;
    NaturalFeature reptileSpeciesNaturalFeature4 = NaturalFeature.FLOWING_WATER;
    Boolean reptileIsPoisonous4 = false;
    Boolean reptileIsExtinct4 = false;
    Boolean reptileIsCompatible4 = true;
    Boolean reptileIsEndangered4 = true;

    createSpecies(desertTortoise, reptileSpeciesType4, reptileSize4, reptileCharacteristic4,
        reptileMinTemp4, reptileMaxTemp4, reptileSpeciesNaturalFeature4, reptileIsPoisonous4,
        reptileIsExtinct4, reptileIsCompatible4, reptileIsEndangered4);

    fenceLizard = "Fence Lizard";
    String reptileSpeciesType5 = "REPTILE";
    SpeciesSize reptileSize5 = SpeciesSize.MEDIUM;
    String reptileCharacteristic5 = "Fence Lizard is a member of the spiny lizard family, "
        + "also known as a blue belly.";
    int reptileMinTemp5 = 27;
    int reptileMaxTemp5 = 37;
    NaturalFeature reptileSpeciesNaturalFeature5 = NaturalFeature.ROCKS;
    Boolean reptileIsPoisonous5 = false;
    Boolean reptileIsExtinct5 = false;
    Boolean reptileIsCompatible5 = true;
    Boolean reptileIsEndangered5 = false;

    createSpecies(fenceLizard, reptileSpeciesType5, reptileSize5, reptileCharacteristic5,
        reptileMinTemp5, reptileMaxTemp5, reptileSpeciesNaturalFeature5, reptileIsPoisonous5,
        reptileIsExtinct5, reptileIsCompatible5, reptileIsEndangered5);

    capeVerdeGiantSkink = "Cape Verde Giant Skink";
    String reptileSpeciesType6 = "REPTILE";
    SpeciesSize reptileSize6 = SpeciesSize.LARGE;
    String reptileCharacteristic6 = "Cape Verde Giant Skink has the cylindrical tail was as "
        + "long as the head and body.";
    int reptileMinTemp6 = 20;
    int reptileMaxTemp6 = 37;
    NaturalFeature reptileSpeciesNaturalFeature6 = NaturalFeature.ROCKS;
    Boolean reptileIsPoisonous6 = false;
    Boolean reptileIsExtinct6 = true;
    Boolean reptileIsCompatible6 = false;
    Boolean reptileIsEndangered6 = false;

    createSpecies(capeVerdeGiantSkink, reptileSpeciesType6, reptileSize6, reptileCharacteristic6,
        reptileMinTemp6, reptileMaxTemp6, reptileSpeciesNaturalFeature6, reptileIsPoisonous6,
        reptileIsExtinct6, reptileIsCompatible6, reptileIsEndangered6);

  }

  @Test
  public void testaddSpeciesWhichIsNotCreatedInReptileHouses() {
    Boolean expectedResult = false;

    reptileHouse1.addSpeciesToReptileHouse("T-Rex");

    assertEquals(expectedResult, reptileHouse1.getStatus());

  }

  @Test
  public void testaddNewExtinctSpeciesIntheReptileHouses() {
    Boolean expectedResult = true;

    reptileHouse1.addSpeciesToReptileHouse("Cape Verde Giant Skink");

    assertEquals(expectedResult, reptileHouse1.getStatus());

  }

  @Test
  public void testaddSameSpeciesNotCompatibleIntheReptileHouses() {
    Boolean expectedResult = true;

    reptileHouse1.addSpeciesToReptileHouse("Gray TreeFrog");

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse("Gray TreeFrog");

    assertEquals(expectedResult, reptileHouse1.getStatus());

  }

  @Test
  public void testaddNewDifferentSpeciesTypeIntheReptileHouses() {
    Boolean expectedResult = true;

    reptileHouse1.addSpeciesToReptileHouse("Cape Verde Giant Skink");

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse("Gray TreeFrog");

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse("Fence Lizard");

    assertEquals(expectedResult, reptileHouse1.getStatus());

  }

  @Test
  public void testaddDifferentSpeciesTypeIntheReptileHouses() {
    Boolean expectedResult = true;

    reptileHouse1.addSpeciesToReptileHouse("Cape Verde Giant Skink");

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse("Gray TreeFrog");

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(greenSeaTurtle);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(rattlesnake);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(hellbenderSalamander);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(americanAlligator);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(fenceLizard);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

  }

  @Test
  public void testNaturalFeaturesLookUp() {
    Boolean expectedResult = true;

    reptileHouse1.addSpeciesToReptileHouse(capeVerdeGiantSkink);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(grayTreeFrog);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(greenSeaTurtle);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(rattlesnake);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(hellbenderSalamander);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(americanAlligator);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(fenceLizard);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    String naturalFeatureCollection = reptileHouse1.reportNaturalFeatures();

    assertNotEquals(true, naturalFeatureCollection.isEmpty());
  }

  @Test
  public void testNaturalFeaturesLookUpWhenThereIsNoSpecies() {

    IReptileHouses reptileHouse2 = ReptileHouses.getInstance();

    String expectedOutput = "\n" + "**************Natural Features Report**************\n"
        + "No Natural Features are available to report.";
    String naturalFeatureCollection = reptileHouse2.reportNaturalFeatures();

    assertEquals(expectedOutput, naturalFeatureCollection);
  }

  @Test
  public void testSpeciesLookUp() {
    Boolean expectedResult = true;

    String expectedValue = "";

    String capeVerdeGiantSkinkSpeciesLookUp = reptileHouse1.speciesLookUp(capeVerdeGiantSkink);

    expectedValue = "\n" + "**************Cape Verde Giant Skink Lookup**************\n"
        + "Cape Verde Giant Skink species is not found in Reptile House\n" + "";

    assertEquals(expectedValue, capeVerdeGiantSkinkSpeciesLookUp);

    reptileHouse1.addSpeciesToReptileHouse(capeVerdeGiantSkink);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(grayTreeFrog);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(greenSeaTurtle);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(rattlesnake);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(hellbenderSalamander);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(americanAlligator);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(fenceLizard);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    String americanAlligatorSpeciesLookUp = reptileHouse1.speciesLookUp(americanAlligator);

    expectedValue = "\n" + "**************American Alligator Lookup**************\n"
        + "American Alligator species is Found: Habitat4\n" + "";

    assertEquals(expectedValue, americanAlligatorSpeciesLookUp);

    expectedValue = "\n" + "**************Desert Tortoise Lookup**************\n"
        + "Desert Tortoise species is Found: Habitat2, Habitat6\n" + "";
    String desertTortoiseSpeciesLookUp = reptileHouse1.speciesLookUp(desertTortoise);

    assertEquals(expectedValue, desertTortoiseSpeciesLookUp);

    String capeVerdeGiantSkinkSpeciesLookUp1 = reptileHouse1.speciesLookUp(capeVerdeGiantSkink);

    expectedValue = "\n" + "**************Cape Verde Giant Skink Lookup**************\n"
        + "Cape Verde Giant Skink species is Found: Extinct Species - Not inhabiting a Habitat\n"
        + "";

    assertEquals(expectedValue, capeVerdeGiantSkinkSpeciesLookUp1);
  }

  @Test
  public void testPrintSpeciesIndex() {
    Boolean expectedResult = true;

    reptileHouse1.addSpeciesToReptileHouse(capeVerdeGiantSkink);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(grayTreeFrog);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(greenSeaTurtle);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(rattlesnake);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(hellbenderSalamander);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(americanAlligator);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(fenceLizard);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    String expected = "\n" + "**************Print All Species Index**************\n"
        + "1. American Alligator inhabiting in: Habitat4\n"
        + "2. Cape Verde Giant Skink inhabiting in: Extinct Species - Not inhabiting a Habitat\n"
        + "3. Desert Tortoise inhabiting in: Habitat2, Habitat6\n"
        + "4. Fence Lizard inhabiting in: Habitat5\n" + "5. Gray TreeFrog inhabiting in: Habitat1\n"
        + "6. Green Sea Turtle inhabiting in: Habitat2\n"
        + "7. Hellbender Salamander inhabiting in: Habitat3\n"
        + "8. Rattlesnake inhabiting in: Habitat2\n" + "";

    assertEquals(expected, reptileHouse1.printSpeciesIndex());
  }

  @Test
  public void testPrintHabitatIndex() {
    Boolean expectedResult = true;

    reptileHouse1.addSpeciesToReptileHouse(capeVerdeGiantSkink);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(grayTreeFrog);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(greenSeaTurtle);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(rattlesnake);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(hellbenderSalamander);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(americanAlligator);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(fenceLizard);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    String expected;

    expected = "\n" + "**************Print Habitat1 Sign**************\n" + "\n" + "\n"
        + "1. Species Name: Gray TreeFrog\n" + "   Total Species Housed: 1\n"
        + "   Species Characteristics: Gray treefrogs have a white spot beneath each "
        + "eye and a dark stripe from the rear of the eyes to the front of the legs.\n"
        + "   Species Size: SMALL\n" + "   Interesting Features: Poisonous     ";

    assertEquals(expected, reptileHouse1.printHabitatIndex("Habitat1"));

    expected = "\n" + "**************Print Habitat2 Sign**************\n" + "\n" + "\n"
        + "1. Species Name: Green Sea Turtle\n" + "   Total Species Housed: 1\n"
        + "   Species Characteristics: Green Sea Turtle has heart-shaped shell\n"
        + "   Species Size: LARGE\n" + "   Interesting Features: \n" + "\n"
        + "2. Species Name: Rattlesnake\n" + "   Total Species Housed: 1\n"
        + "   Species Characteristics: Rattlesnake has heavy-bodied snakes "
        + "with large, broad heads with two light lines on the face\n" + "   Species Size: LARGE\n"
        + "   Interesting Features: Poisonous     \n" + "\n" + "3. Species Name: Desert Tortoise\n"
        + "   Total Species Housed: 2\n"
        + "   Species Characteristics: Desert tortoises dig underground burrows "
        + "in order to hide from the sun in the deep desert.\n" + "   Species Size: MEDIUM\n"
        + "   Interesting Features: Endangered     ";

    assertEquals(expected, reptileHouse1.printHabitatIndex("Habitat2"));

    expected = "\n" + "**************Print Habitat7 Sign**************\n" + "Habitat7 is not found";

    assertEquals(expected, reptileHouse1.printHabitatIndex("Habitat7"));
  }

  @Test
  public void testAllHabitatsMap() {
    Boolean expectedResult = true;

    reptileHouse1.addSpeciesToReptileHouse(capeVerdeGiantSkink);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(grayTreeFrog);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(greenSeaTurtle);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(rattlesnake);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(hellbenderSalamander);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(americanAlligator);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(fenceLizard);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(desertTortoise);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    String expected;

    expected = "\n" + "**************Print All Habitats Details**************\n" + "\n" + "\n"
        + "1. Habitat1\n" + "Natural Features: TREE_BRANCHES\n" + "Species: Gray TreeFrog\n" + "\n"
        + "2. Habitat2\n" + "Natural Features: SALT_WATER, FALLEN_LOGS, FLOWING_WATER\n"
        + "Species: Green Sea Turtle, Rattlesnake, Desert Tortoise\n" + "\n" + "3. Habitat3\n"
        + "Natural Features: FLOWING_WATER\n" + "Species: Hellbender Salamander\n" + "\n"
        + "4. Habitat4\n" + "Natural Features: POND\n" + "Species: American Alligator\n" + "\n"
        + "5. Habitat5\n" + "Natural Features: ROCKS\n" + "Species: Fence Lizard\n" + "\n"
        + "6. Habitat6\n" + "Natural Features: FLOWING_WATER\n" + "Species: Desert Tortoise";

    assertEquals(expected, reptileHouse1.allHabitatsMap());
  }

  @Test
  public void testPrintSpeciesIndexWhenNoSpeciesInReptileHouse() {

    String expected = "\n" + "**************Print All Species Index**************\n"
        + "No species in the Reptile House";

    assertEquals(expected, reptileHouse1.printSpeciesIndex());
  }

  @Test
  public void testCreateNewSpecies() {
    String reptileSpeciesName6 = "Cape Verde";
    String reptileSpeciesType6 = "REPTILE";
    SpeciesSize reptileSize6 = SpeciesSize.LARGE;
    String reptileCharacteristic6 = "Cape Verde Giant Skink has the cylindrical tail "
        + "was as long as the head and body.";
    int reptileMinTemp6 = 20;
    int reptileMaxTemp6 = 37;
    NaturalFeature reptileSpeciesNaturalFeature6 = NaturalFeature.ROCKS;
    Boolean reptileIsPoisonous6 = false;
    Boolean reptileIsExtinct6 = true;
    Boolean reptileIsCompatible6 = false;
    Boolean reptileIsEndangered6 = false;

    reptileHouse1.createSpecies(reptileSpeciesName6, reptileSpeciesType6, reptileSize6,
        reptileCharacteristic6, reptileMinTemp6, reptileMaxTemp6, reptileSpeciesNaturalFeature6,
        reptileIsPoisonous6, reptileIsExtinct6, reptileIsCompatible6, reptileIsEndangered6);

    assertEquals(true, reptileHouse1.getStatus());

    // Create Same Species Again
    reptileHouse1.createSpecies(reptileSpeciesName6, reptileSpeciesType6, reptileSize6,
        reptileCharacteristic6, reptileMinTemp6, reptileMaxTemp6, reptileSpeciesNaturalFeature6,
        reptileIsPoisonous6, reptileIsExtinct6, reptileIsCompatible6, reptileIsEndangered6);

    assertEquals(false, reptileHouse1.getStatus());
  }

  protected IReptileHouses createSpecies(String speciesName, String speciesType, SpeciesSize size,
      String characteristic, int minTemp, int maxTemp, NaturalFeature speciesNaturalFeature,
      Boolean isPoisonous, Boolean isExtinct, Boolean isCompatible, Boolean isEndangered) {

    return reptileHouse1.createSpecies(speciesName, speciesType, size, characteristic, minTemp,
        maxTemp, speciesNaturalFeature, isPoisonous, isExtinct, isCompatible, isEndangered);
  }

}
