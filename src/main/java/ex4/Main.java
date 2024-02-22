package ex4;

import java.util.Scanner;

public class Main {
//    . Să se scrie un program care citește un număr n natural de la tastatură și afișează toți
//divizorii acestuia pe ecran. Dacă numărul este prim se va afișa un mesaj corespunzător.
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("n=");
        int n = scanner.nextInt();


        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
                System.out.println(i);
            }
        }
        if (count == 2) {
            System.out.println("Numarul este prim");
        }
    }
}
