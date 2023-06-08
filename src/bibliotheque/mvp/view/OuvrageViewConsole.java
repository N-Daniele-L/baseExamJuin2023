package bibliotheque.mvp.view;

import bibliotheque.metier.*;
import bibliotheque.mvp.presenter.OuvragePresenter;
import bibliotheque.mvp.presenter.SpecialOuvragePresenter;
import bibliotheque.utilitaires.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bibliotheque.utilitaires.Utilitaire.*;

public class OuvrageViewConsole extends AbstractViewConsole<Ouvrage> implements SpecialOuvrageViewConsole {
    @Override
    protected void rechercher() throws Exception {
        int i = 0;
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        System.out.println("choix du type d'ouvrage : ");
        for (TypeOuvrage to: lto) {
            i++;
            System.out.println(i + ") " + to);
        }
        int ito = lireInt();
        switch (ito - 1){
            case 0 :
                System.out.println("ISBN : ");
                String isbn = sc.nextLine();
                Ouvrage rec = null;
                rec = new Livre("A",0,null,0,"A","A",isbn,0,null,"A");
                presenter.search(rec);
                break;
            case 1 :
                System.out.println("CODE : ");
                long code_c = lireLong();
                Ouvrage rech = null;
                rech = new CD("A",0, (LocalDate) null, (double) 0,"A","A",code_c, (byte) 0,null);
                presenter.search(rech);
                break;
            case 2 :
                System.out.println("MATRICULE : ");
                long code_d = lireLong();
                Ouvrage rech2 = null;
                rech2 = new DVD("A",0, (LocalDate) null, (double) 0,"A","A",code_d, (LocalTime) null, (byte) 0);
                presenter.search(rech2);
                break;
        }
    }

    @Override
    protected void modifier() {
        int choix = choixElt(ldatas);
        Ouvrage o = ldatas.get(choix-1);
         do {
            try {
                double ploc =Double.parseDouble(modifyIfNotBlank("prix location",""+o.getPrixLocation()));
                o.setPrixLocation(ploc);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        presenter.update(o);
        ldatas=presenter.getAll();//rafraichissement
        affListe(ldatas);

    }

    @Override
    protected void ajouter() {
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = Utilitaire.choixListe(lto);
        Ouvrage o = null;
        List<OuvrageFactory> lof = new ArrayList<>(Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        o = lof.get(choix-1).create();
        presenter.add(o);
        Auteur a = ((OuvragePresenter)presenter).choixAuteur();
        o.addAuteur(a);
    }

    @Override
    protected void special() {
        int choix =  choixElt(ldatas);
        Ouvrage o = ldatas.get(choix-1);

        List options = new ArrayList<>(Arrays.asList("lister exemplaires", "lister exemplaires en location", "lister exemplaires libres","fin"));
        do {
            int ch = choixListe(options);

            switch (ch) {

                case 1:
                    exemplaires(o);
                    break;
                case 2:
                    enLocation(o, true);
                    break;
                case 3:
                    enLocation(o, false);
                    break;

                case 4 :return;
            }
        } while (true);




    }

    @Override
    public void enLocation(Ouvrage o, boolean enLocation) {
        ((SpecialOuvragePresenter) presenter).listerExemplaire(o, enLocation);
    }

    @Override
    public void exemplaires(Ouvrage o) {
        ((SpecialOuvragePresenter)presenter).listerExemplaire(o);
    }
}
