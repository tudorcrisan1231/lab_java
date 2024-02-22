package ex2;

import java.util.Scanner;

public class Main {
//    Se cere să se scrie un program Java care să calculeze şi să afişeze perimetru şi aria unui
//dreptunghi. Valorile pentru lungime şi lățime se citesc de la tastatura. Sa se adauge un break
//point pe prima linie care citește valoarea unei laturi si din acel punct să se ruleze programul
//linie cu linie urmărind valorile variabilelor în memorie.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lungime: ");
        int lungime = scanner.nextInt();
        System.out.print("Latime: ");
        int latime = scanner.nextInt();

        int perimetru = 2 * (lungime + latime);
        int aria = lungime * latime;
        System.out.println("Perimetru: " + perimetru);
        System.out.println("Aria: " + aria);
    }
}
