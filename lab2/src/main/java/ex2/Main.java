package ex2;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import ex2.Vers;

//Fișierul cantec_in.txt conține versurile unui cântec la alegere. Să se scrie un
//program care creează fișierul cantec_out.txt, care conține versurile cântecului original dar în
//plus în dreptul fiecărui rând sunt afișate numărul de cuvinte de pe rând şi numărul de vocale
//de pe fiecare rând. În dreptul rândurilor care se încheie cu o grupare de litere aleasă se va
//pune o steluță (*). Rândurile pentru care un număr generat aleator este mai mic decât 0.1 vor
//fi scrise cu majuscule (se vor genera aleator numere între 0 şi 1).
//Se va defini o clasă Vers, care are o variabilă membră privată un șir de caractere
//reprezentând versul și se va dezvolta câte un operator pentru fiecare cerință de mai sus (o
//metodă care returnează numărul de cuvinte, o metodă care returnează numărul de vocale, etc).
//Se va crea un vector de obiecte de tip Vers care va conține informația preluată din fișierul de
//intrare

public class Main {

    public static void main(String[] args) {
        //read from keyboard the judet
        Scanner scanner = new Scanner(System.in);
        System.out.println("grupare litere: ");
        String grupare_litere = scanner.nextLine();


        ArrayList<String> versuri = new ArrayList<>();
        //read from file in.txt
        try {
            File myObj = new File("C:\\Users\\Tudor\\JavaProjects\\lab1\\lab2\\src\\main\\java\\ex2\\cantec.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                String vers = new Vers(data).getVers();

                // random number between 0 and 1
                Integer random = new Random().nextInt(2);
                if (random < 0.1) {
                    vers = vers.toUpperCase();
                }

                Integer grupare_litere_length = grupare_litere.length();
                if (vers.length() >= grupare_litere_length) {
                    if (vers.substring(vers.length() - grupare_litere_length).equals(grupare_litere)) {
                        vers += "*";
                    }
                }

                System.out.println(vers + " - " + new Vers(data).getNrCuvinte() + " - " + new Vers(data).getNrVocale());
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
