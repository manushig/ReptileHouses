package conservancy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public interface ISpecies {
  public ISpecies isSpeciesCompatibleWithHabitat(SpeciesType speciesType,
      TemperatureRange habitatTempRange, ArrayList<NaturalFeature> habitatNaturalFeatureList,
      int habitatAvailableSize);

  public ISpecies setSpeciesHabitatStatus(String speciesHabitatLocation);

  public Boolean getStatus();

  public HabitatSpeciesDetails retrieveSpeciesDetails();
  
  public Boolean getIsSpeciesExtinct();
  
  public Map<String, Collection<SpeciesHabitatStatus>> speciesLookUp();
}
