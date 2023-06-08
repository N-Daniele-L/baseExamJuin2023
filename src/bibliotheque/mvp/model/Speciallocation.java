package bibliotheque.mvp.model;

import bibliotheque.metier.Location;

public interface Speciallocation {
 public double calculerAmende(Location l);
 public void enregistrerRetour(Location l);
}
