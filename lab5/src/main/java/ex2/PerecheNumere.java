package ex2;

public class PerecheNumere {
//    Să implementeze clasa PerecheNumere care are variabile membre private doi întregi.
//Clasa PerecheNumere va avea un constructor cu parametri şi unul fără parametri, gettere şi
//setttere pentru accesarea variabilelor membre şi va redefini metoda toString din clasa Object.
    private int a;
    private int b;

    public PerecheNumere() {
    }

    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "PerecheNumere{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

//    În clasa PerecheNumere se vor dezvolta următoarele metode:
//• o metodă care va returna o valoare booleana care indică dacă cele două numere care
//formează perechea sunt numere consecutive în șirul lui Fibonaci
//• o metodă care returnează cel mic multiplu comun al celor două numere
//• o metodă care va returna boolean daca cele doua numere au suma cifrelor egală
//• o metodă care va returna boolean dacă cele doua numere au același număr de cifre pare.
    public boolean isFibonacci() {
        int c = a + b;
        int n1 = 0, n2 = 1;
        while (n1 <= c) {
            if (n1 == c) {
                return true;
            }
            int sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return false;
    }

    public int cmmdc() {
        int x = a;
        int y = b;
        while (x != y) {
            if (x > y) {
                x = x - y;
            } else {
                y = y - x;
            }
        }
        return x;
    }

    public boolean isSumOfDigitsEqual() {
        int sum1 = 0;
        int sum2 = 0;
        while (a != 0) {
            sum1 += a % 10;
            a /= 10;
        }
        while (b != 0) {
            sum2 += b % 10;
            b /= 10;
        }
        return sum1 == sum2;
    }

    public boolean hasEqualNumberOfEvenDigits() {
        int count1 = 0;
        int count2 = 0;
        while (a != 0) {
            if ((a % 10) % 2 == 0) {
                count1++;
            }
            a /= 10;
        }
        while (b != 0) {
            if ((b % 10) % 2 == 0) {
                count2++;
            }
            b /= 10;
        }
        return count1 == count2;
    }
}
