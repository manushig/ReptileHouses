package conservancy;

import java.util.ArrayList;

public interface IHabitat {

  IHabitat isSpeciesCompatibleWithHabitat(ISpecies species);

  IHabitat addSpeciesToHabitat(ISpecies species);

  public Boolean getStatus();
  
  public ArrayList<NaturalFeaturesReport> reportNaturalFeatures();
  
}
