package bibliotheque.utilitaires;


import bibliotheque.metier.Ouvrage;

import java.time.LocalDate;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;

public  abstract class OuvrageFactory {
   protected Scanner sc= new Scanner(System.in);
   public Ouvrage create() {

       System.out.println("titre");
       String titre= sc.nextLine();
       System.out.println("age minimum");
       int ageMin= lireInt();
       System.out.println("date de parution");
       LocalDate dp= lecDate();
       System.out.println("prix de location");
       double ploc = lireDouble();
       System.out.println("langue");
       String langue=sc.nextLine();
       System.out.println("genre");
       String genre=sc.nextLine();
       return addDetail(titre, ageMin,dp,ploc, langue,  genre);
    }

    public abstract Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre);
}