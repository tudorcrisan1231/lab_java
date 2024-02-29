package ex4;

import java.util.*;
import java.time.LocalDate;
import ex4.Persoana;

//Să se realizeze un program care citește numele si CNP-ul pe care îl au n persoane.
//Valoarea lui n se citește de la tastatură. Programul va afișa informațiile introduse și în plus
//pentru fiecare persoana va afișa vârsta. Cât timp un CNP-ul este introdus greșit programul va
//cere reintroducerea acestuia. Pentru simplitate se consideră că CNP-ul este valid dacă
//îndeplinește următoarele condiții:
//• Are 13 caractere
//• Toate caracterele sunt cifre
//• Prima cifră are una din valorile 1, 2, 5, 6
//• Cifra de control a CNP-ului are o valoare validă.
//Se va crea clasa Persoana cu variabile membre private nume (String) şi cnp (String).
//Clasa va avea constructor cu parametri, gettere si settere în funcție de necesități şi metoda
//getVarsta() care va calcula şi va returna vârsta persoanei extrăgând data nașterii din CNP şi
//citind din sistem data curentă. Se va utiliza clasa LocalDate. Se va crea un vector în care se
//vor adăuga obiectele de tip Persoana. Fiecare element din vectorul va fi afișat pe un rând în
//formatul nume, CNP, varsta.

public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("n: ");
            int n = scanner.nextInt();
            scanner.nextLine();

            ArrayList<Persoana> persoane = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                System.out.println("nume: ");
                String nume = scanner.nextLine();
                System.out.println("cnp: ");
                String cnp = scanner.nextLine();
                while (!cnpValid(cnp)) {
                    System.out.println("cnp: ");
                    cnp = scanner.nextLine();
                }
                persoane.add(new Persoana(nume, cnp));
            }

            for (Persoana persoana : persoane) {
                System.out.println(persoana.getNume() + " " + persoana.getCnp() + " " + persoana.getVarsta() + " ani");
            }
        }

        public static boolean cnpValid(String cnp) {
            if (cnp.length() != 13) {
                return false;
            }
            for (char c : cnp.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            if (cnp.charAt(0) != '1' && cnp.charAt(0) != '2' && cnp.charAt(0) != '5' && cnp.charAt(0) != '6') {
                return false;
            }

            return true;
        }
}
