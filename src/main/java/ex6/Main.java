package ex6;

public class Main {
//     Să se scrie un program care generează aleatoriu un număr întreg cuprins între 0 și 20.
//Programul va determina dacă numărul aparține șirului lui Fobonacci. u
    public static void main(String[] args) {
        int n = (int) (Math.random() * 20);
        System.out.println(n);
        int f0 = 0;
        int f1 = 1;
        int f = 0;
        while (f < n) {
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        if (f == n) {
            System.out.println("Numarul apartine sirului lui Fibonacci.");
        } else {
            System.out.println("Numarul nu apartine sirului lui Fibonacci");
        }
    }
}
