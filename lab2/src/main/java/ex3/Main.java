package ex3;


//3. Să se insereze într-o anumită poziție a unui șir de caractere, un alt șir. Datele vor fi
//preluate de la tastatură sau din fișier. Să se șteargă o porțiune a unui șir de caractere care
//începe dintr-o anumită poziție și are un anumit număr de caractere. Se recomandă utilizarea
//clasei StringBuilder.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("text: ");
        String text = scanner.nextLine();
        System.out.println("pozitie: ");
        int pozitie = scanner.nextInt();
        System.out.println("numar caractere: ");
        int numarCaractere = scanner.nextInt();
        System.out.println("text de inserat: ");
        String textDeInserat = scanner.next();

        StringBuilder sb = new StringBuilder(text);
        StringBuilder sb1 = new StringBuilder(text);

        sb.insert(pozitie, textDeInserat);
        System.out.println(sb);

        sb1.delete(pozitie, pozitie + numarCaractere);
        System.out.println(sb1);
    }
}
