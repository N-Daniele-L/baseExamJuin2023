package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;

import java.util.List;

public interface SpecialLecteur {
    public List<Exemplaire> exemplairesEnLocation(Lecteur l);
    public List<Exemplaire> exemplairesLoues(Lecteur l);

    public List<Exemplaire> livreLoues(Lecteur l) throws Exception;

    public Lecteur lecParMail(String mail);

    public void chargementParFichier();
}
