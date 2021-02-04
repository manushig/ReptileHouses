package conservancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public interface IReptileHouses{
  public final int HabitatSize = 30;
  
  public final String HabitatLocation = "North-Zone";
  
  public IReptileHouses addSpeciesToReptileHouse(ISpecies species);
  
  public Boolean getStatus();
  
  public Map<String, Collection<NaturalFeaturesDetails>> reportNaturalFeatures();
  
  public ArrayList<String> speciesLookUp(ISpecies speciesToLookUp);
  
  public String printSpeciesIndex() throws IOException;
}
