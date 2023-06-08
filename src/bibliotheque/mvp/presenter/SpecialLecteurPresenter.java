package bibliotheque.mvp.presenter;

import bibliotheque.metier.Lecteur;

public interface SpecialLecteurPresenter {
    void exemplairesEnLocation(Lecteur l);

    void exemplairesLoues(Lecteur l);

    void livreLoues(Lecteur l) throws Exception;

    void lecParMail(String mail);

     void chargementLecteurParFichier();
}
