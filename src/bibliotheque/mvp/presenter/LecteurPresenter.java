package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Livre;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.SpecialLecteur;
import bibliotheque.mvp.view.ViewInterface;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class LecteurPresenter extends Presenter<Lecteur> implements SpecialLecteurPresenter {


    public LecteurPresenter(DAO<Lecteur> model, ViewInterface<Lecteur> view, Comparator<Lecteur>cmp) {
        super(model,view,cmp);
    }


    @Override
    public void exemplairesEnLocation(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesEnLocation(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }
    @Override
    public void exemplairesLoues(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesLoues(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }
    @Override
    public void livreLoues(Lecteur l){
        List<Exemplaire> lex =   ((SpecialLecteur)model).livreLoues(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun livre loué par ce lecteur");
        else {
            lex.sort((ex1,ex2) -> ex1.getOuvrage().getTitre().compareTo(ex2.getOuvrage().getTitre()));
            view.affList(lex);
        }
    }

    @Override
    public void lecParMail(String mail) {
        Lecteur l = ((SpecialLecteur)model).lecParMail(mail);
        if(l==null) view.affMsg("aucun lecteur pour ce mail");
        else view.affMsg("lecteur trouvé :" +l);
    }

    @Override
    public void chargementLecteurParFichier() {
        ((SpecialLecteur)model).chargementParFichier();
        view.affMsg("chargement des lecteurs terminé");
    }
}
