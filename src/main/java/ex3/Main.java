package ex3;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.io.FileWriter;   // Import the FileWriter class

public class Main {
    public static void main(String[] args) {
//     Să se scrie un program care citește un set de numerele din fișierul de intrare in.txt, care
//conține câte un număr pe un rând, având valorile din figura 18. Programul va determină suma
//lor, media aritmetică, valoarea minimă, valoarea maximă, va afișa aceste valori pe ecran și le
//va scrie în fișierul de ieșire out.txt. Media aritmetică va fi afișată ca un număr real.
        ArrayList<Integer> numbers = new ArrayList<>();
        //read from file in.txt
        try {
            File myObj = new File("C:\\Users\\Tudor\\JavaProjects\\lab1\\src\\main\\java\\ex3\\in.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                int number = Integer.parseInt(data);
                numbers.add(number);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

//        System.out.println(numbers);
        int sum = 0;
        int min = numbers.get(0);
        int max = numbers.get(0);
        for (int number : numbers) {
            sum += number;
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }
        double average = (double) sum / numbers.size();
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

        //add the values to out.txt
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\Tudor\\JavaProjects\\lab1\\src\\main\\java\\ex3\\out.txt");

            myWriter.write("Sum: " + sum + "\n");
            myWriter.write("Average: " + average + "\n");
            myWriter.write("Min: " + min + "\n");
            myWriter.write("Max: " + max + "\n");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
