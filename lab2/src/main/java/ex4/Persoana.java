package ex4;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.LocalDate;
public class Persoana {
//Se va crea clasa Persoana cu variabile membre private nume (String) şi cnp (String).
//Clasa va avea constructor cu parametri, gettere si settere în funcție de necesități şi metoda
//getVarsta() care va calcula şi va returna vârsta persoanei extrăgând data nașterii din CNP şi
//citind din sistem data curentă. Se va utiliza clasa LocalDate
    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public long getVarsta() {
        int an = Integer.parseInt(cnp.substring(1, 3));
        int luna = Integer.parseInt(cnp.substring(3, 5));
        int zi = Integer.parseInt(cnp.substring(5, 7));

        if(cnp.charAt(0) == '1' || cnp.charAt(0) == '2') {
            an += 1900;
        } else if(cnp.charAt(0) == '5' || cnp.charAt(0) == '6') {
            an += 2000;
        }

        return ChronoUnit.YEARS.between(
                LocalDate.of(an, luna, zi),
                LocalDate.now()
        );
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }
}
