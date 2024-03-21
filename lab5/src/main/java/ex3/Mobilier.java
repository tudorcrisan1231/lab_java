package ex3;
import java.util.*;
import ex3.Placa;

public class Mobilier {
//    Clasa Mobilier, cu variabilele membre
//o nume (String)
//o lista plăcilor care o compun List<Placa> placi;
    public Mobilier(){};
    private String nume;
    private List<Placa> placi;

    public Mobilier(String nume, List<Placa> placi) {
        this.nume = nume;
        this.placi = placi;
    }

    public String getNume() {
        return nume;
    }

    public List<Placa> getPlaci() {
        return placi;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPlaci(List<Placa> placi) {
        this.placi = placi;
    }

    @Override
    public String toString() {
        return "Mobilier{" +
                "nume='" + this.nume + '\'' +
                ", placi=" + this.placi +
                '}';
    }
}
