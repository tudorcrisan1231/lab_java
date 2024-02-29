package ex2;

//Se va defini o clasă Vers, care are o variabilă membră privată un șir de caractere
//reprezentând versul și se va dezvolta câte un operator pentru fiecare cerință de mai sus (o
//metodă care returnează numărul de cuvinte, o metodă care returnează numărul de vocale, etc).
//Se va crea un vector de obiecte de tip Vers care va conține informația preluată din fișierul de
//intrare
public class Vers {
    private String vers;

    public Vers(String vers) {
        this.vers = vers;
    }

    public int getNrCuvinte() {
        String[] words = vers.split(" ");
        return words.length;
    }

    public int getNrVocale() {
        int nrVocale = 0;
        for (char c : vers.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                nrVocale++;
            }
        }
        return nrVocale;
    }

    public String getVers() {
        return vers;
    }

    public void setVers(String vers) {
        this.vers = vers;
    }
}
