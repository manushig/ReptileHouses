import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import conservancy.IHabitat;
import conservancy.ISpecies;
import conservancy.NaturalFeature;
import conservancy.SpeciesSize;
import conservancy.NaturalFeaturesReport;
import conservancy.Habitat;
import conservancy.Species;

/**
 * A JUnit test class for the Habitat class.
 */
public class HabitatTest {

  private IHabitat habitat1;
  private ISpecies grayTreeFrogSpecies;
  private ISpecies greenSeaTurtleSpecies;
  private ISpecies rattleSnakeSpecies;
  private ISpecies hellbenderSalamanderSpecies;
  private ISpecies desertTortoise;
  private ISpecies fenceLizard;

  @Before
  public void setUp() {
    String habitatName = "Habitat1";
    // String habitatLocation = "North-Zone";
    int habitatSize = 30;
    habitat1 = createHabitat(habitatSize, habitatName);

    String amphibianSpeciesName = "Gray TreeFrog";
    String amphibianSpeciesType = "AMPHIBIAN";
    SpeciesSize amphibianSize = SpeciesSize.SMALL;
    String amphibianCharacteristic = "Gray treefrogs have a white spot beneath "
        + "each eye and a dark stripe from the rear of the eyes to the front of the legs.";
    int amphibianMinTemp = 10;
    int amphibianMaxTemp = 32;
    NaturalFeature amphibianSpeciesNaturalFeature = NaturalFeature.TREE_BRANCHES;
    Boolean amphibianIsPoisonous = true;
    Boolean amphibianIsExtinct = false;
    Boolean amphibianIsEndangered = false;
    Boolean amphibianIsCompatible = false;

    grayTreeFrogSpecies = createSpecies(amphibianSpeciesName, amphibianSpeciesType, amphibianSize,
        amphibianCharacteristic, amphibianMinTemp, amphibianMaxTemp, amphibianSpeciesNaturalFeature,
        amphibianIsPoisonous, amphibianIsExtinct, amphibianIsCompatible, amphibianIsEndangered);

    String amphibianSpeciesName2 = "Hellbender Salamander";
    String amphibianSpeciesType2 = "AMPHIBIAN";
    SpeciesSize amphibianSize2 = SpeciesSize.MEDIUM;
    String amphibianCharacteristic2 = "Hellbender Salamander is easily distinguished "
        + "from most other endemic salamander species simply by their size, hellbenders "
        + "average up to about 2 ft in length, making them the largest amphibian in "
        + "North America.";
    int amphibianMinTemp2 = 10;
    int amphibianMaxTemp2 = 26;
    NaturalFeature amphibianSpeciesNaturalFeature2 = NaturalFeature.FLOWING_WATER;
    Boolean amphibianIsPoisonous2 = false;
    Boolean amphibianIsExtinct2 = false;
    Boolean amphibianIsEndangered2 = true;
    Boolean amphibianIsCompatible2 = true;

    hellbenderSalamanderSpecies = createSpecies(amphibianSpeciesName2, amphibianSpeciesType2,
        amphibianSize2, amphibianCharacteristic2, amphibianMinTemp2, amphibianMaxTemp2,
        amphibianSpeciesNaturalFeature2, amphibianIsPoisonous2, amphibianIsExtinct2,
        amphibianIsCompatible2, amphibianIsEndangered2);

    String reptileSpeciesName = "Green Sea Turtle";
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

    greenSeaTurtleSpecies = createSpecies(reptileSpeciesName, reptileSpeciesType, reptileSize,
        reptileCharacteristic, reptileMinTemp, reptileMaxTemp, reptileSpeciesNaturalFeature,
        reptileIsPoisonous, reptileIsExtinct, reptileIsCompatible, reptileIsEndangered);

    String reptileSpeciesName2 = "Rattlesnake";
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

    rattleSnakeSpecies = createSpecies(reptileSpeciesName2, reptileSpeciesType2, reptileSize2,
        reptileCharacteristic2, reptileMinTemp2, reptileMaxTemp2, reptileSpeciesNaturalFeature2,
        reptileIsPoisonous2, reptileIsExtinct2, reptileIsCompatible2, reptileIsEndangered2);

    String reptileSpeciesName4 = "Desert Tortoise";
    String reptileSpeciesType4 = "REPTILE";
    SpeciesSize reptileSize4 = SpeciesSize.MEDIUM;
    String reptileCharacteristic4 = "Desert tortoises dig underground burrows in order to hide "
        + "from the sun in the deep desert.";
    int reptileMinTemp4 = 8;
    int reptileMaxTemp4 = 26;
    NaturalFeature reptileSpeciesNaturalFeature4 = NaturalFeature.FLOWING_WATER;
    Boolean reptileIsPoisonous4 = false;
    Boolean reptileIsExtinct4 = false;
    Boolean reptileIsCompatible4 = true;
    Boolean reptileIsEndangered4 = true;

    desertTortoise = createSpecies(reptileSpeciesName4, reptileSpeciesType4, reptileSize4,
        reptileCharacteristic4, reptileMinTemp4, reptileMaxTemp4, reptileSpeciesNaturalFeature4,
        reptileIsPoisonous4, reptileIsExtinct4, reptileIsCompatible4, reptileIsEndangered4);

    String reptileSpeciesName5 = "Fence Lizard";
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

    fenceLizard = createSpecies(reptileSpeciesName5, reptileSpeciesType5, reptileSize5,
        reptileCharacteristic5, reptileMinTemp5, reptileMaxTemp5, reptileSpeciesNaturalFeature5,
        reptileIsPoisonous5, reptileIsExtinct5, reptileIsCompatible5, reptileIsEndangered5);
  }

  @Test
  public void testReptileSpeciesCompatibleToEmptyHabitat() {
    Boolean expectedResult = true;

    habitat1.isSpeciesCompatibleWithHabitat(grayTreeFrogSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(grayTreeFrogSpecies);

    assertEquals(expectedResult, habitat1.getStatus());
  }

  @Test
  public void testReptileSpeciesNotCompatibleOtherSpeciesInHabitat() {
    Boolean expectedResult = true;

    habitat1.isSpeciesCompatibleWithHabitat(grayTreeFrogSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(grayTreeFrogSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(hellbenderSalamanderSpecies);

    assertNotEquals(expectedResult, habitat1.getStatus());
  }

  @Test
  public void testSameSpeciesNotCompatibleAddedInHabitat() {
    Boolean expectedResult = true;

    habitat1.isSpeciesCompatibleWithHabitat(grayTreeFrogSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(grayTreeFrogSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(grayTreeFrogSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(grayTreeFrogSpecies);
  }

  @Test
  public void testAmphibianSpeciesCompatibleOtherSpeciesInHabitat() {
    Boolean expectedResult = true;

    habitat1.isSpeciesCompatibleWithHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(rattleSnakeSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(rattleSnakeSpecies);

    assertEquals(expectedResult, habitat1.getStatus());
  }

  @Test
  public void testMultipleSameSpeciesAddedToHabitatUnitilHabitatFull() {
    Boolean expectedResult = true;
    habitat1.isSpeciesCompatibleWithHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(greenSeaTurtleSpecies);

    assertNotEquals(expectedResult, habitat1.getStatus());

  }

  @Test
  public void testMultipleSpeciesAddedToHabitatUnitilNaturalFeatureReaches3() {
    Boolean expectedResult = true;
    habitat1.isSpeciesCompatibleWithHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(desertTortoise);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(desertTortoise);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(fenceLizard);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(fenceLizard);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(rattleSnakeSpecies);

    assertNotEquals(expectedResult, habitat1.getStatus());

  }

  @Test
  public void testNaturalFeaturesLookup() {
    Boolean expectedResult = true;
    habitat1.isSpeciesCompatibleWithHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(desertTortoise);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(desertTortoise);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(fenceLizard);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(fenceLizard);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(rattleSnakeSpecies);

    assertNotEquals(expectedResult, habitat1.getStatus());

    ArrayList<NaturalFeaturesReport> habitatNaturalFtrList = habitat1.reportNaturalFeatures();

    assertNotEquals(true, Objects.isNull(habitatNaturalFtrList));

  }

  @Test
  public void testRetriveDetailsToPrintHabitatSign() {
    Boolean expectedResult = true;
    habitat1.isSpeciesCompatibleWithHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(desertTortoise);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(desertTortoise);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(fenceLizard);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(fenceLizard);

    assertEquals(expectedResult, habitat1.getStatus());

    String actual = habitat1.retriveDetailsToPrintHabitatSign();

    String expectedresult = "\n\n" + "1. Species Name: Green Sea Turtle\n"
        + "   Total Species Housed: 1\n"
        + "   Species Characteristics: Green Sea Turtle has heart-shaped shell\n"
        + "   Species Size: LARGE\n" + "   Interesting Features: \n" + "\n"
        + "2. Species Name: Desert Tortoise\n" + "   Total Species Housed: 1\n"
        + "   Species Characteristics: Desert "
        + "tortoises dig underground burrows in order to hide from the sun in the deep "
        + "desert.\n   Species Size: MEDIUM\n" + "   Interesting Features: Endangered     " + "\n"
        + "\n" + "3. Species Name: Fence Lizard\n" + "   Total Species Housed: 1\n"
        + "   Species Characteristics: Fence Lizard is a member of the spiny"
        + " lizard family, also known as a blue belly.\n" + "   Species Size: MEDIUM\n"
        + "   Interesting Features: ";
    assertEquals(expectedresult, actual);

  }

  @Test
  public void testEmptyHabitatsMap() {
    String expected = "Habitat1\n" + "Natural Features:\n" + "Species:";
    String actual = habitat1.habitatsMap();

    assertEquals(expected, actual);
  }

  @Test
  public void testHabitatsMap() {
    Boolean expectedResult = true;
    habitat1.isSpeciesCompatibleWithHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(greenSeaTurtleSpecies);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(desertTortoise);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(desertTortoise);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.isSpeciesCompatibleWithHabitat(fenceLizard);

    assertEquals(expectedResult, habitat1.getStatus());

    habitat1.addSpeciesToHabitat(fenceLizard);

    assertEquals(expectedResult, habitat1.getStatus());

    String actual = habitat1.habitatsMap();

    String expectedresult = "Habitat1\n" + "Natural Features: SALT_WATER, FLOWING_WATER, ROCKS\n"
        + "Species: Green Sea Turtle, Desert Tortoise, Fence Lizard";
    assertEquals(expectedresult, actual);

  }

  protected IHabitat createHabitat(int habitatSize, String habitatName) {
    return new Habitat(habitatSize, habitatName);
  }

  protected ISpecies createSpecies(String speciesName, String speciesType, SpeciesSize size,
      String characteristic, int minTemp, int maxTemp, NaturalFeature speciesNaturalFeature,
      Boolean isPoisonous, Boolean isExtinct, Boolean isCompatible, Boolean isEndangered) {

    return new Species(speciesName, speciesType, size, characteristic, minTemp, maxTemp,
        speciesNaturalFeature, isPoisonous, isExtinct, isCompatible, isEndangered);
  }

}
