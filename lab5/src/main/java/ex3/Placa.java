package ex3;
import java.util.*;
public class Placa {
//    Clasa Placa
//o descriere (String cu valori precum usa, capac, laterală, raft mobil, raft fix, etc)
//o lungime în milimetri (întreg)
//o laţime în milimetri (întreg)
//o orientare– enumerare cu valorile posibile LUNGIME, LATIME, ORICARE
//o canturi (vector de 4 elemente boolean). Fiecare piesă de pal care face parte dintr-un
//corp de mobilă, are 4 muchii. O anumită valoare booleană indică prezența sau
//absența cantului pe muchia corespunzătoare.
//o nr_bucati (int)
    public Placa(){};
    private String descriere;
    private int lungime;
    private int latime;
    private enum Orientare {
        LUNGIME, LATIME, ORICARE
    };
    private Orientare orientare;
    private boolean[] canturi;
    private int nr_bucati;

    public Placa(String descriere, int lungime, int latime, Orientare orientare, boolean[] canturi, int nr_bucati) {
        this.descriere = descriere;
        this.lungime = lungime;
        this.latime = latime;
        this.orientare = orientare;
        this.canturi = canturi;
        this.nr_bucati = nr_bucati;
    }

    public String getDescriere() {
        return descriere;
    }

    public int getLungime() {
        return lungime;
    }

    public int getLatime() {
        return latime;
    }

    public Orientare getOrientare() {
        return orientare;
    }

    public boolean[] getCanturi() {
        return canturi;
    }



    public int getNr_bucati() {
        return nr_bucati;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setLungime(int lungime) {
        this.lungime = lungime;
    }

    public void setLatime(int latime) {
        this.latime = latime;
    }

    public void setOrientare(Orientare orientare) {
        this.orientare = orientare;
    }

    public void setCanturi(boolean[] canturi) {
        this.canturi = canturi;
    }

    public void setNr_bucati(int nr_bucati) {
        this.nr_bucati = nr_bucati;
    }

    @Override
    public String toString() {
        return "Placa{" +
                "descriere='" + descriere + '\'' +
                ", lungime=" + lungime +
                ", latime=" + latime +
                ", orientare=" + orientare +
                ", canturi=" + Arrays.toString(canturi) +
                ", nr_bucati=" + nr_bucati +
                '}';
    }
}
