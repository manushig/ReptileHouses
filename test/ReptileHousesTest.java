import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

import conservancy.*;

public class ReptileHousesTest {

  private IHabitat habitat1;
  private ISpecies grayTreeFrogSpecies;
  private ISpecies greenSeaTurtleSpecies;
  private ISpecies rattleSnakeSpecies;
  private ISpecies hellbenderSalamanderSpecies;
  private ISpecies americanAlligator;
  private ISpecies desertTortoise;
  private ISpecies fenceLizard;
  private ISpecies capeVerdeGiantSkink;
  private IReptileHouses reptileHouse1;

  @Before
  public void setUp() {
    reptileHouse1 = new ReptileHouses();

    String amphibianSpeciesName = "Gray TreeFrog";
    String amphibianSpeciesType = "AMPHIBIAN";
    SpeciesSize amphibianSize = SpeciesSize.SMALL;
    String amphibianCharacteristic = "Gray treefrogs have a white spot beneath each eye and a dark stripe from the rear of the eyes to the front of the legs.";
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
    String amphibianCharacteristic2 = "Hellbender Salamander is easily distinguished from most other endemic salamander species simply by their size, hellbenders average up to about 2 ft in length, making them the largest amphibian in North America.";
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
    String reptileCharacteristic2 = "Rattlesnake has heavy-bodied snakes with large, broad heads with two light lines on the face";
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

    String reptileSpeciesName3 = "American Alligator";
    String reptileSpeciesType3 = "REPTILE";
    SpeciesSize reptileSize3 = SpeciesSize.LARGE;
    String reptileCharacteristic3 = "American alligator is capable of biting through a turtle's shell or a moderately sized mammal bone.";
    int reptileMinTemp3 = 28;
    int reptileMaxTemp3 = 33;
    NaturalFeature reptileSpeciesNaturalFeature3 = NaturalFeature.POND;
    Boolean reptileIsPoisonous3 = false;
    Boolean reptileIsExtinct3 = false;
    Boolean reptileIsCompatible3 = false;
    Boolean reptileIsEndangered3 = false;

    americanAlligator = createSpecies(reptileSpeciesName3, reptileSpeciesType3, reptileSize3,
        reptileCharacteristic3, reptileMinTemp3, reptileMaxTemp3, reptileSpeciesNaturalFeature3,
        reptileIsPoisonous3, reptileIsExtinct3, reptileIsCompatible3, reptileIsEndangered3);

    String reptileSpeciesName4 = "Desert Tortoise";
    String reptileSpeciesType4 = "REPTILE";
    SpeciesSize reptileSize4 = SpeciesSize.MEDIUM;
    String reptileCharacteristic4 = "Desert tortoises dig underground burrows in order to hide from the sun in the deep desert.";
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
    String reptileCharacteristic5 = "Fence Lizard is a member of the spiny lizard family, also known as a blue belly.";
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

    String reptileSpeciesName6 = "Cape Verde Giant Skink";
    String reptileSpeciesType6 = "REPTILE";
    SpeciesSize reptileSize6 = SpeciesSize.LARGE;
    String reptileCharacteristic6 = "Cape Verde Giant Skink has the cylindrical tail was as long as the head and body.";
    int reptileMinTemp6 = 20;
    int reptileMaxTemp6 = 37;
    NaturalFeature reptileSpeciesNaturalFeature6 = NaturalFeature.ROCKS;
    Boolean reptileIsPoisonous6 = false;
    Boolean reptileIsExtinct6 = true;
    Boolean reptileIsCompatible6 = false;
    Boolean reptileIsEndangered6 = false;

    capeVerdeGiantSkink = createSpecies(reptileSpeciesName6, reptileSpeciesType6, reptileSize6,
        reptileCharacteristic6, reptileMinTemp6, reptileMaxTemp6, reptileSpeciesNaturalFeature6,
        reptileIsPoisonous6, reptileIsExtinct6, reptileIsCompatible6, reptileIsEndangered6);
  }

  @Test
  public void testaddNewExtinctSpeciesIntheReptileHouses() {
    Boolean expectedResult = true;

    reptileHouse1.addSpeciesToReptileHouse(capeVerdeGiantSkink);

    assertEquals(expectedResult, reptileHouse1.getStatus());

  }

  @Test
  public void testaddSameSpeciesNotCompatibleIntheReptileHouses() {
    Boolean expectedResult = true;

    reptileHouse1.addSpeciesToReptileHouse(grayTreeFrogSpecies);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(grayTreeFrogSpecies);

    assertEquals(expectedResult, reptileHouse1.getStatus());

  }

  @Test
  public void testaddNewDifferentSpeciesTypeIntheReptileHouses() {
    Boolean expectedResult = true;

    reptileHouse1.addSpeciesToReptileHouse(capeVerdeGiantSkink);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(grayTreeFrogSpecies);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(fenceLizard);

    assertEquals(expectedResult, reptileHouse1.getStatus());

  }

  @Test
  public void testaddDifferentSpeciesTypeIntheReptileHouses() {
    Boolean expectedResult = true;

    reptileHouse1.addSpeciesToReptileHouse(capeVerdeGiantSkink);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(grayTreeFrogSpecies);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(greenSeaTurtleSpecies);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(rattleSnakeSpecies);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(hellbenderSalamanderSpecies);

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
  public void naturalFeaturesLookUp() {
    Boolean expectedResult = true;

    reptileHouse1.addSpeciesToReptileHouse(capeVerdeGiantSkink);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(grayTreeFrogSpecies);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(greenSeaTurtleSpecies);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(rattleSnakeSpecies);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(hellbenderSalamanderSpecies);

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

    Map<String, Collection<NaturalFeaturesDetails>> naturalFeatureCollection = reptileHouse1
        .reportNaturalFeatures();

    assertNotEquals(true, naturalFeatureCollection.isEmpty());
  }

  @Test
  public void NaturalFeaturesLookUpWhenThereIsNoSpecies() {
    Map<String, Collection<NaturalFeaturesDetails>> naturalFeatureCollection = reptileHouse1
        .reportNaturalFeatures();

    assertEquals(true, naturalFeatureCollection.isEmpty());
  }

  @Test
  public void speciesLookUp() {
    Boolean expectedResult = true;

    String expectedValue = "";

    ArrayList<String> capeVerdeGiantSkinkSpeciesLookUp = reptileHouse1
        .speciesLookUp(capeVerdeGiantSkink);

    expectedValue = "This species is not there in Reptile House";

    assertEquals(expectedValue, capeVerdeGiantSkinkSpeciesLookUp.get(0));

    reptileHouse1.addSpeciesToReptileHouse(capeVerdeGiantSkink);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(grayTreeFrogSpecies);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(greenSeaTurtleSpecies);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(rattleSnakeSpecies);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(hellbenderSalamanderSpecies);

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

    ArrayList<String> americanAlligatorSpeciesLookUp = reptileHouse1
        .speciesLookUp(americanAlligator);

    expectedValue = "Habitat4";

    assertEquals(expectedValue, americanAlligatorSpeciesLookUp.get(0));

    ArrayList<String> desertTortoiseSpeciesLookUp = reptileHouse1.speciesLookUp(desertTortoise);

    int expectedCount = 2;

    assertEquals(expectedCount, desertTortoiseSpeciesLookUp.size());

    ArrayList<String> capeVerdeGiantSkinkSpeciesLookUp1 = reptileHouse1
        .speciesLookUp(capeVerdeGiantSkink);

    expectedValue = "Extinct Species - Not inhabiting a Habitat";

    assertEquals(expectedValue, capeVerdeGiantSkinkSpeciesLookUp1.get(0));
  }

  @Test
  public void printSpeciesIndex() throws Exception {
    Boolean expectedResult = true;

    reptileHouse1.addSpeciesToReptileHouse(capeVerdeGiantSkink);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(grayTreeFrogSpecies);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(greenSeaTurtleSpecies);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(rattleSnakeSpecies);

    assertEquals(expectedResult, reptileHouse1.getStatus());

    reptileHouse1.addSpeciesToReptileHouse(hellbenderSalamanderSpecies);

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

    String expected = "Print_Species_Index.txtFile is available for printing";

    assertEquals(expected, reptileHouse1.printSpeciesIndex());
  }

  @Test
  public void printSpeciesIndexWhenNoSpeciesInReptileHouse() throws Exception {

    String expected = "Species Index is not printed - No species in the Reptile House";

    assertEquals(expected, reptileHouse1.printSpeciesIndex());
  }

  protected ISpecies createSpecies(String speciesName, String speciesType, SpeciesSize size,
      String characteristic, int minTemp, int maxTemp, NaturalFeature speciesNaturalFeature,
      Boolean isPoisonous, Boolean isExtinct, Boolean isCompatible, Boolean isEndangered) {

    return new Species(speciesName, speciesType, size, characteristic, minTemp, maxTemp,
        speciesNaturalFeature, isPoisonous, isExtinct, isCompatible, isEndangered);
  }

}
