package ex1;

import java.util.*;
import java.io.*;

//Fișierul de intrare in.txt conține mai multe linii, pe fiecare linie aflându-se coeficienții
//unei parabole. Să se citească informația din fișierul de intrare și pentru fiecare linie să se creeze
//câte un obiect de tip Parabola care se va adăuga unei colecții de tip List. Colecția va fi apoi
//traversată și pentru fiecare element se va afișa parabola sub forma unei funcții și apoi vârful
//parabolei. Pentru două parabole din colecție se va afișa mijlocul segmentului care le unește
//vârfurile și lungimea segmentului care le unește vârfurile apelând metodele dezvoltate în clasa
//Parabola.
public class Main {
    public static void main(String[] args) {

        ArrayList<Parabola> parabole = new ArrayList<>();
        //read from file in.txt
        try {
            File myObj = new File("C:\\Users\\Tudor\\JavaProjects\\lab_PJ\\lab3\\src\\main\\java\\ex1\\in.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                String[] coef = data.split(" ");
                parabole.add(new Parabola(Integer.parseInt(coef[0]), Integer.parseInt(coef[1]), Integer.parseInt(coef[2])));

            }
            myReader.close();

            for (Parabola p : parabole) {
                System.out.println(p);
                System.out.println(Arrays.toString(p.varf()));
            }

            for (int i = 0; i < parabole.size(); i++) {
                for (int j = i + 1; j < parabole.size(); j++) {
                    System.out.println(Arrays.toString(parabole.get(i).middle(parabole.get(j))));
                    System.out.println(parabole.get(i).length(parabole.get(j)));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}