package conservancy;

/**
 * Driver program for Reptile House Tracking System, to show how it works.
 */
public class ReptileHouseDriver {

  /**
   * Driver program for Reptile House Tracking System to show how it works.
   * 
   * @param args Not used.
   */
  private static IReptileHouses reptileHouse;

  /**
   * Prints all the output for the various functionalities of the Reptile House
   * Tracking System
   * 
   */
  public static void main(String[] args) {
    SpeciesData();
    String displayResult;
    // Add Gray Tree Frog to the Reptile House
    reptileHouse.addSpeciesToReptileHouse("Gray TreeFrog");
    System.out.println("Species has been added to Reptile House");

    // Add Gray Tree Frog to the Reptile House again - Is Not CompatibleType Species
    reptileHouse.addSpeciesToReptileHouse("Gray TreeFrog");
    System.out.println("Species has been added to Reptile House");

    // Add Green Sea Turtle to the Reptile House
    reptileHouse.addSpeciesToReptileHouse("Green Sea Turtle");
    System.out.println("Species has been added to Reptile House");

    // Add Rattlesnake to the Reptile House
    reptileHouse.addSpeciesToReptileHouse("Rattlesnake");
    System.out.println("Species has been added to Reptile House");

    // Add hellbender Salamander to the Reptile House
    reptileHouse.addSpeciesToReptileHouse("Hellbender Salamander");
    System.out.println("Species has been added to Reptile House");

    // Add American Alligator to the Reptile House
    reptileHouse.addSpeciesToReptileHouse("American Alligator");
    System.out.println("Species has been added to Reptile House");

    // Add Desert Tortoise to the Reptile House
    reptileHouse.addSpeciesToReptileHouse("Desert Tortoise");
    System.out.println("Species has been added to Reptile House");

    // Add Extinct species Cape Verde Giant Skink to the Reptile House
    reptileHouse.addSpeciesToReptileHouse("Cape Verde Giant Skink");
    System.out.println("Species has been added to Reptile House");

    // Report the natural features that are currently being used in alphabetical
    // order.
    displayResult = reptileHouse.reportNaturalFeatures();
    System.out.println(displayResult);

    // Look up which habitat(s) that house a particular species - Extinct species
    // Cape Verde Giant Skink

    displayResult = reptileHouse.speciesLookUp("Cape Verde Giant Skink");
    System.out.println(displayResult);

    // Adding another species Gray Tree Frog in Reptile House
    reptileHouse.addSpeciesToReptileHouse("Gray TreeFrog");

    System.out.println("Species has been added to Reptile House\n");

    // Look up again which habitat(s) that house a particular species - Gray Tree
    // Frog
    displayResult = reptileHouse.speciesLookUp("Gray TreeFrog");
    System.out.println(displayResult);

    // Look up which habitat(s) that house a particular species - Fence Lizard -
    // This species has not been added to Reptile House.
    displayResult = reptileHouse.speciesLookUp("Fence Lizard");
    System.out.println(displayResult);

    // Look up which habitat(s) that house a particular species - T-Rex -
    // This species has not not been created.
    displayResult = reptileHouse.speciesLookUp("T-Rex");
    System.out.println(displayResult);

    System.out.println();

    // Print a sign for any given habitat that lists the species that it houses
    // along with a description of the species and an indicator of how many of that
    // species is housed in that habitat.
    displayResult = reptileHouse.printHabitatIndex("Habitat1");
    System.out.println(displayResult);
    System.out.println("\n");

    displayResult = reptileHouse.allHabitatsMap();
    System.out.println(displayResult);
    System.out.println("\n");

    // Print an index that lists all species in the Reptile House in alphabetical
    // order and their location(s).
    displayResult = reptileHouse.printSpeciesIndex();
    System.out.println(displayResult);
  }

  private static void SpeciesData() {
    reptileHouse = new ReptileHouses();
    String amphibianSpeciesName = "Gray TreeFrog";
    String amphibianSpeciesType = "AMPHIBIAN";
    SpeciesSize amphibianSize = SpeciesSize.SMALL;
    String amphibianCharacteristic = "Gray treefrogs have a white spot beneath each eye and "
        + "a dark stripe from the rear of the eyes to the front of the legs.";
    int amphibianMinTemp = 10;
    int amphibianMaxTemp = 32;
    NaturalFeature amphibianSpeciesNaturalFeature = NaturalFeature.TREE_BRANCHES;
    Boolean amphibianIsPoisonous = true;
    Boolean amphibianIsExtinct = false;
    Boolean amphibianIsEndangered = false;
    Boolean amphibianIsCompatible = false;

    reptileHouse.createSpecies(amphibianSpeciesName, amphibianSpeciesType, amphibianSize,
        amphibianCharacteristic, amphibianMinTemp, amphibianMaxTemp, amphibianSpeciesNaturalFeature,
        amphibianIsPoisonous, amphibianIsExtinct, amphibianIsCompatible, amphibianIsEndangered);

    String amphibianSpeciesName2 = "Hellbender Salamander";
    String amphibianSpeciesType2 = "AMPHIBIAN";
    SpeciesSize amphibianSize2 = SpeciesSize.MEDIUM;
    String amphibianCharacteristic2 = "Hellbender Salamander is easily distinguished from most "
        + "other endemic salamander species simply by their size, hellbenders average up to about "
        + "2 ft in length, making them the largest amphibian in North America.";
    int amphibianMinTemp2 = 10;
    int amphibianMaxTemp2 = 26;
    NaturalFeature amphibianSpeciesNaturalFeature2 = NaturalFeature.FLOWING_WATER;
    Boolean amphibianIsPoisonous2 = false;
    Boolean amphibianIsExtinct2 = false;
    Boolean amphibianIsEndangered2 = true;
    Boolean amphibianIsCompatible2 = true;

    reptileHouse.createSpecies(amphibianSpeciesName2, amphibianSpeciesType2, amphibianSize2,
        amphibianCharacteristic2, amphibianMinTemp2, amphibianMaxTemp2,
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

    reptileHouse.createSpecies(reptileSpeciesName, reptileSpeciesType, reptileSize,
        reptileCharacteristic, reptileMinTemp, reptileMaxTemp, reptileSpeciesNaturalFeature,
        reptileIsPoisonous, reptileIsExtinct, reptileIsCompatible, reptileIsEndangered);

    String reptileSpeciesName2 = "Rattlesnake";
    String reptileSpeciesType2 = "REPTILE";
    SpeciesSize reptileSize2 = SpeciesSize.LARGE;
    String reptileCharacteristic2 = "Rattlesnake has heavy-bodied snakes with large, broad heads "
        + "with two light lines on the face";
    int reptileMinTemp2 = 19;
    int reptileMaxTemp2 = 32;
    NaturalFeature reptileSpeciesNaturalFeature2 = NaturalFeature.FALLEN_LOGS;
    Boolean reptileIsPoisonous2 = true;
    Boolean reptileIsExtinct2 = false;
    Boolean reptileIsCompatible2 = true;
    Boolean reptileIsEndangered2 = false;

    reptileHouse.createSpecies(reptileSpeciesName2, reptileSpeciesType2, reptileSize2,
        reptileCharacteristic2, reptileMinTemp2, reptileMaxTemp2, reptileSpeciesNaturalFeature2,
        reptileIsPoisonous2, reptileIsExtinct2, reptileIsCompatible2, reptileIsEndangered2);

    String reptileSpeciesName3 = "American Alligator";
    String reptileSpeciesType3 = "REPTILE";
    SpeciesSize reptileSize3 = SpeciesSize.LARGE;
    String reptileCharacteristic3 = "American alligator is capable of biting through a turtle's shell "
        + "or a moderately sized mammal bone.";
    int reptileMinTemp3 = 28;
    int reptileMaxTemp3 = 33;
    NaturalFeature reptileSpeciesNaturalFeature3 = NaturalFeature.POND;
    Boolean reptileIsPoisonous3 = false;
    Boolean reptileIsExtinct3 = false;
    Boolean reptileIsCompatible3 = false;
    Boolean reptileIsEndangered3 = false;

    reptileHouse.createSpecies(reptileSpeciesName3, reptileSpeciesType3, reptileSize3,
        reptileCharacteristic3, reptileMinTemp3, reptileMaxTemp3, reptileSpeciesNaturalFeature3,
        reptileIsPoisonous3, reptileIsExtinct3, reptileIsCompatible3, reptileIsEndangered3);

    String reptileSpeciesName4 = "Desert Tortoise";
    String reptileSpeciesType4 = "REPTILE";
    SpeciesSize reptileSize4 = SpeciesSize.MEDIUM;
    String reptileCharacteristic4 = "Desert tortoises dig underground burrows in order to hide from "
        + "the sun in the deep desert.";
    int reptileMinTemp4 = 8;
    int reptileMaxTemp4 = 26;
    NaturalFeature reptileSpeciesNaturalFeature4 = NaturalFeature.FLOWING_WATER;
    Boolean reptileIsPoisonous4 = false;
    Boolean reptileIsExtinct4 = false;
    Boolean reptileIsCompatible4 = true;
    Boolean reptileIsEndangered4 = true;

    reptileHouse.createSpecies(reptileSpeciesName4, reptileSpeciesType4, reptileSize4,
        reptileCharacteristic4, reptileMinTemp4, reptileMaxTemp4, reptileSpeciesNaturalFeature4,
        reptileIsPoisonous4, reptileIsExtinct4, reptileIsCompatible4, reptileIsEndangered4);

    String reptileSpeciesName5 = "Fence Lizard";
    String reptileSpeciesType5 = "REPTILE";
    SpeciesSize reptileSize5 = SpeciesSize.MEDIUM;
    String reptileCharacteristic5 = "Fence Lizard is a member of the spiny lizard family, also known "
        + "as a blue belly.";
    int reptileMinTemp5 = 27;
    int reptileMaxTemp5 = 37;
    NaturalFeature reptileSpeciesNaturalFeature5 = NaturalFeature.ROCKS;
    Boolean reptileIsPoisonous5 = false;
    Boolean reptileIsExtinct5 = false;
    Boolean reptileIsCompatible5 = true;
    Boolean reptileIsEndangered5 = false;

    reptileHouse.createSpecies(reptileSpeciesName5, reptileSpeciesType5, reptileSize5,
        reptileCharacteristic5, reptileMinTemp5, reptileMaxTemp5, reptileSpeciesNaturalFeature5,
        reptileIsPoisonous5, reptileIsExtinct5, reptileIsCompatible5, reptileIsEndangered5);

    String reptileSpeciesName6 = "Cape Verde Giant Skink";
    String reptileSpeciesType6 = "REPTILE";
    SpeciesSize reptileSize6 = SpeciesSize.LARGE;
    String reptileCharacteristic6 = "Cape Verde Giant Skink has the cylindrical tail was as long "
        + "as the head and body.";
    int reptileMinTemp6 = 20;
    int reptileMaxTemp6 = 37;
    NaturalFeature reptileSpeciesNaturalFeature6 = NaturalFeature.ROCKS;
    Boolean reptileIsPoisonous6 = false;
    Boolean reptileIsExtinct6 = true;
    Boolean reptileIsCompatible6 = false;
    Boolean reptileIsEndangered6 = false;

    reptileHouse.createSpecies(reptileSpeciesName6, reptileSpeciesType6, reptileSize6,
        reptileCharacteristic6, reptileMinTemp6, reptileMaxTemp6, reptileSpeciesNaturalFeature6,
        reptileIsPoisonous6, reptileIsExtinct6, reptileIsCompatible6, reptileIsEndangered6);

  }
}