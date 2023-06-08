package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Mail;

import java.util.List;

public class ExemplaireModel extends AbstractModel<Exemplaire> implements SpecialExemplaire {
    @Override
    public void modifierEtat(Exemplaire ex, String etat) {
         ex.setDescriptionEtat(etat);
    }

    @Override
    public Lecteur lecteurActuel(Exemplaire ex) {
        return ex.lecteurActuel();
    }

    @Override
    public List<Lecteur> lecteurs(Exemplaire ex) {
        return ex.lecteurs();
    }

    @Override
    public void envoiMailLecteurActuel(Exemplaire ex) {
      Mail m = new Mail("demo","message de test");
        ex.envoiMailLecteurActuel(m);

    }

    @Override
    public void envoiMailLecteurs(Exemplaire ex) {
       String msg = "Vous avez loué l'exemplaire suivant : \n"+ex+"\n"+"La Bibliothèque";
       Mail m = new Mail("information",msg);
        ex.envoiMailLecteurs(m);
    }

    @Override
    public boolean enRetard(Exemplaire ex) {
        return ex.enRetard();
    }

    @Override
    public int joursRetard(Exemplaire ex) {
        return ex.joursRetard();
    }

    @Override
    public boolean enLocation(Exemplaire ex) {
        return ex.enLocation();
    }
}
