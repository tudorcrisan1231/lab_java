package ex1;
//Se cere să se definească o clasă Parabola ai cărei membri vor fi:
//• 3 variabile de tip int care reprezintă coeficienţii a, b şi c
//• un constructor cu 3 parametrii de tip int
//• o metodă care calculează și returnează vârful parabolei
//• se va redefini metoda toString() din clasa Object, astfel încât să returneze un String de
//forma f(x) = a x^2 + b x + c. Caracteristicile a, b și c ale parabolei se vor înlocui cu
//valorile efective. Metoda va fi utilizată pentru afișarea parabolei sub forma unei funcții
//• o metodă care primește ca și parametru de intrare o parabolă și returneză coordonatele
//mijlocului segmentului de dreptă care uneşte vârful parabolei curente cu varful
//parabolei transmisă ca și parametru de intrare
//• o metodă statică ce primeşte ca parametri de intrare două parabole şi calculează
//coordonatele mijlocului segmentului de dreptă care uneşte vârfurile celor două parabole.
//• o metodă care primește ca și parametru de intrare o parabolă și returneză lungimea
//segmentului de dreptă care unește vârful parabolei curente cu varful parabolei transmisă
//ca și parametru de intrare. Se va utiliza metoda statică Math.hypot
//• o metodă statică care primește ca și parametri de intrare două parabole și calculează
//lungimea segmentului de dreapta ce unește vârfurile celor două parabole. Se va utiliza
//metoda statică Math.hypot

import java.util.*;
public class Parabola {
    private int a;
    private int b;
    private int c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }

    public double[] varf() {
        double x = -b / (2 * a);
        double y = (-b * b + 4 * a * c) / (4 * a);
        return new double[] {x, y};
    }

    public double[] middle(Parabola p) {
        double[] v1 = varf();
        double[] v2 = p.varf();
        return new double[] {(v1[0] + v2[0]) / 2, (v1[1] + v2[1]) / 2};
    }

    public static double[] middle(Parabola p1, Parabola p2) {
        double[] v1 = p1.varf();
        double[] v2 = p2.varf();
        return new double[] {(v1[0] + v2[0]) / 2, (v1[1] + v2[1]) / 2};
    }

    public double length(Parabola p) {
        double[] v1 = varf();
        double[] v2 = p.varf();
        return Math.hypot(v1[0] - v2[0], v1[1] - v2[1]);
    }

    public static double length(Parabola p1, Parabola p2) {
        double[] v1 = p1.varf();
        double[] v2 = p2.varf();
        return Math.hypot(v1[0] - v2[0], v1[1] - v2[1]);
    }
}
