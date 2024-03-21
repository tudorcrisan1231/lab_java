package ex2;
import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Main {
//    În program se va crea o colecție de obiecte de tip List în care se vor adăuga minim 3
//perechi de numere.
//În programul principal se vor dezvolta metodele:
//static void scriere(List< PerecheNumere > lista);
//static List<Persoana> citire();
//Metoda scriere() va salva lista perechilor de numere într-un fișier JSON, iar metoda
//citire() va încărca lista perechilor de numere din fișierul JSON în program.
//Metoda main() va testa cele două metode.
    public static void main(String[] args) {
        List<PerecheNumere> perechi = List.of(
                new PerecheNumere(1, 2),
                new PerecheNumere(3, 5),
                new PerecheNumere(8, 13)
        );
        scriere(perechi);
        List<PerecheNumere> perechiCitite = citire();
        System.out.println(perechiCitite);
    }

    public static void scriere(List<PerecheNumere> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("C:/Users/Tudor/JavaProjects/lab_PJ/lab5/src/main/java/ex2/scriere.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PerecheNumere> citire() {
        try {
            File file = new File("C:/Users/Tudor/JavaProjects/lab_PJ/lab5/src/main/java/ex2/citire.json");
            ObjectMapper mapper = new ObjectMapper();
            List<PerecheNumere> perechi = mapper
                    .readValue(file, new TypeReference<List<PerecheNumere>>() {
                    });
            return perechi;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
