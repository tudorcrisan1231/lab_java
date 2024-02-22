package ex5;

import java.util.Scanner;

public class Main {
//    Să se determine cmmdc a două numere naturale, a căror valoare maximă este 30. Numerele
//vor fi generate aleatoriu cu ajutorul unui obiect de tip Random și metodei nextInt();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("a=");
        int a = scanner.nextInt();
        System.out.print("b=");
        int b = scanner.nextInt();

        int cmmdc = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                cmmdc = i;
            }
        }
        System.out.println("Cmmdc: " + cmmdc);
    }
}
