package ex3;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import ex3.Placa;
import ex3.Mobilier;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
//    Informații privind necesarul de pal al mai multor piese de mobilier sunt păstrate într-un
//fișierul mobilier.json. Palul este un material lemnos sub formă de placă obținut prin presarea de
//lemn în combinație cu diferiți lianți. Pentru fiecare piesă de mobilier se memorează numele
//piesei (birou, dulap, etajeră, etc) și informații privind plăcile de pal care o compun. Fiecare
//placă de pal are o formă dreptunghiulară. Pentru fiecare placă de pal se memorează o descriere
//a plăcii, lungimea şi lățimea exprimate in milimetri, orientarea fibrei, canturile pe care le are şi
//numărul de bucăți din placa respectivă care intră în compoziția mobilierului. Sa se realizeze un
//program care:
//a) Citește datele despre piesele de mobilier din fișierul mobilier.json într-o listă de piese
//de mobilier (List<Mobilier>) și le afișează
//b) Afişează elementele de mobilier din colecție şi plăcile care le compun
//c) Afişează caracteristicile plăcilor care compun o anumită piesă de mobilier

    public static void main(String[] args) {
        List<Mobilier> mobilier = citire();
        System.out.println(mobilier);
        for (Mobilier m : mobilier) {
            System.out.println(m.getNume());
            for (Placa p : m.getPlaci()) {
                System.out.println(p.getDescriere());
            }
            System.out.println("-----------------");
        }
        System.out.println("-----------------");
        for (Mobilier m : mobilier) {
            System.out.println(m.getNume());
            for (Placa p : m.getPlaci()) {
                System.out.println(p.getLungime());
                System.out.println(p.getLatime());
                System.out.println(p.getOrientare());
                System.out.println(p.getNr_bucati());
            }
            System.out.println("-----------------");
        }
        for (Mobilier m : mobilier) {
            System.out.println(m.getNume());
            //d) Afișează estimativ numărul colilor de pal necesare pentru realizarea unui anumit corp
            //de mobile știind că o coală de pal are dimensiunea 2800 x 2070 mm (pentru simplitate
            //se va ţine cont doar de arie, nu şi de posibilitatea de a realiza tăieturile)
            int lungime = 0;
            int latime = 0;
            for (Placa p : m.getPlaci()) {
                lungime += p.getLungime();
                latime += p.getLatime();
            }
            System.out.println("Nr coli: " + (lungime * latime) / (2800 * 2070));
            System.out.println("-----------------");
        }
    }

    public static List<Mobilier> citire() {
        try {
            File file = new File("C:\\Users\\Tudor\\JavaProjects\\lab_PJ\\lab5\\src\\main\\java\\ex3\\mobilier.json");
            ObjectMapper mapper = new ObjectMapper();
            List<Mobilier> mobilier = mapper
                    .readValue(file, new TypeReference<List<Mobilier>>() {
                    });
            return mobilier;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
