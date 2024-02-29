package ex1;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        //        Fișierul judete_in.txt, conține lista neordonată a județelor din țară. Să se încarce
        //datele din fișier într-un tablou de String-uri și să se ordoneze acest tablou cu ajutorul metodei
        //sort() din clasa Arrays. Să se returneze pe ce poziție se află în vectorul ordonat un județ
        //introdus de la tastatură. Se va utiliza metoda de căutare binară din clasa Arrays

        //read from keyboard the judet
        Scanner scanner = new Scanner(System.in);
        System.out.println("judet: ");
        String judet = scanner.nextLine();


        ArrayList<String> judete = new ArrayList<>();
        //read from file in.txt
        try {
            File myObj = new File("C:\\Users\\Tudor\\JavaProjects\\lab1\\lab2\\src\\main\\java\\ex1\\in.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                judete.add(data);

            }
            myReader.close();

            judete.sort(null);

            System.out.println(judete);

            int index = Arrays.binarySearch(judete.toArray(), judet);
            System.out.println("Pozitie: " + index);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
