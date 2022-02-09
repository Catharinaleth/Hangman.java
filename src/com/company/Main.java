//Micro Assignment 5 - Hangman
package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Velkommen til Hangman");
        Scanner tastaturinput = new Scanner(System.in); // Opretter scanner, så det er muligt for brugeren at komme med input/gæt
        String b = brugteBogstaver(); // kalder metode samt opretter String variabel, så den kan bruge andre steder i programmet
        String hemmeligtOrd = "fisk"; //Definere det hemmelige ord som skal gættes
        System.out.println("Ordet har " + hemmeligtOrd.length() + " bogstaver");

        char[] bogstaver = new char[hemmeligtOrd.length()]; //opretter en liste, som indeholder længden på det hemmelige ord
        for (int i = 0; i < bogstaver.length; i++) { //opretter loop, som gør at der kommer fire prikker ved siden af hinanden, for at indikere det ord, som skal findes
            bogstaver[i] = '.';
        }
        int forsøg = 8; //spillet skal stoppe efter 8 forsøg/gæt, derfor en int variabel på 8.

        while (forsøg > 0) { //opretter while loop, som indeholder betingelser der skal ske så længe at brugeren stadig har liv tilbage
            System.out.print("Forsøg tilbage: ");
            for (int i = 0; i < forsøg; i++) { //en for løkke, som at der kommer 8xI ved siden af hinanden for at indikere liv
                System.out.print("I");
            }
            System.out.println();


            System.out.println("Gæt et bogstav: "); //for at brugeren kan komme med input oprettes en String, hvor input fra tastatur indgår

            String gæt = tastaturinput.nextLine(); //Input/gæt fra bruger

            char bogstav = gæt.charAt(0); //finder index af det gættede bogstav

            boolean RigtigtGæt = false; //Opretter en boolean, hvor hvis intet andet gør sig gælden er værdien false

            for (int i = 0; i < hemmeligtOrd.length(); i++) { //for loop for alle input fra bruger, som tjekker om bogstavet er korrekt
                char rigtigtBogstav = hemmeligtOrd.charAt(i); // Gør det muligt at dele ordet i index
                if(rigtigtBogstav == bogstav) { //dermed hvis bogstav input fra bruger er en del af det hemmelige ord er boolean værdien fra før true
                    bogstaver[i] = rigtigtBogstav; //skal ændre prikkerne fra før med det rigtige bogstav
                    RigtigtGæt = true; //hvis overstående gør sig gælden er boolean true ellers falder den tilbage på false
                }
            }
            if(!RigtigtGæt) { //hvis gæt ikke er rigtigt skal vi reducere antal forsøg:
                forsøg = forsøg - 1;
            }

            boolean ordetErGættet = true;

            System.out.print("Ord: ");

            for (int i = 0; i < bogstaver.length; i++) {
                if(bogstaver[i] == '.' ) {
                    ordetErGættet = false;
                }
                System.out.print(bogstaver[i]); //printer liste med de fire prikker
            }
            System.out.println();


            b = b.replace(bogstav, ' '); //opretter et kald, som viser de bogstaver der endnu ikke er valgt:
            System.out.println("Ikke brugte bogstaver: " + b + "\n");

            if (ordetErGættet) { //gør sig gælden, hvis ordet er gætte, hvorefter programmet hopper ud af while løkken
                System.out.println("Tillykke! Du har fundet ordet!");
                break;
            }
        }
        if(forsøg == 0) { //Hvis bruger ikke længere har flere forsøg, har personen tabt og spillet er slut
            System.out.println("Øv du tabte! \nDet rigtige ord er: " + hemmeligtOrd);
        }
    }
    public static String brugteBogstaver() {
        String ikkeBrugteBogstaver = "abcdefghijklmnopqrstuvxyzæøå";
        return ikkeBrugteBogstaver;
    }
}
