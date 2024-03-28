package org.example;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Setter
@Getter
public class Angajat {
    private String nume;
    private String post;
    private LocalDate dataAngajarii;
    private float salariu;

    public Angajat(String nume, String post, LocalDate dataAngajarii, float salariu) {
        this.nume = nume;
        this.post = post;
        this.dataAngajarii = dataAngajarii;
        this.salariu = salariu;
    }

    public Angajat() {
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", post='" + post + '\'' +
                ", dataAngajarii=" + dataAngajarii +
                ", salariu=" + salariu +
                '}';
    }
}
