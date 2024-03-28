package org.example;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        writeInJSON();

        List<Angajat> angajati = readFromJson();

//        1. Afișarea listei de angajați folosind referințe la metode
        System.out.println("1. Afișarea listei de angajați folosind referințe la metode");
        angajati.forEach( (angajat) -> System.out.println(angajat));

//        2.Afișarea angajaților care au salariul peste 2500 RON. Rezolvarea va utiliza stream-uri.
//Interfața funcțională Predicate, care este parametrul metodei de filtrare va fi
//implementată printr-o expresie Lambda.
        System.out.println("2.Afișarea angajaților care au salariul peste 2500 RON. Rezolvarea va utiliza stream-uri.");
        angajati.stream()
                .filter(angajat -> angajat.getSalariu() > 2500)
                .forEach( (angajat)-> System.out.println(angajat));

//        3. Crearea unei liste cu angajații din luna aprilie, a anului trecut, care au funcție de
//conducere (postul conține unul din cuvintele sef sau director). Pentru crearea unei liste
//dintr-un stream se va utiliza operația terminală collect (Collectors.toList()). Se vor
//utiliza steram-uri şi expresii lambda. Noua listă va fi apoi afișată. Anul curent se va citi
//din sistem
        System.out.println("3. Crearea unei liste cu angajații din luna aprilie, a anului trecut, care au funcție de conducere");
        Calendar calendar = Calendar.getInstance();
        int anCurent = calendar.get(Calendar.YEAR);
        int lunaCurenta = calendar.get(Calendar.MONTH) + 1;
        int anulTrecut = anCurent - 1;
        List<Angajat> angajatiConducere = angajati.stream()
                .filter(angajat -> angajat.getDataAngajarii().getYear() == anulTrecut && angajat.getDataAngajarii().getMonthValue() == 4 && (angajat.getPost().contains("Sef") || angajat.getPost().contains("Director")))
                .collect(Collectors.toList());
        angajatiConducere.forEach( (angajat)-> System.out.println(angajat));

//        4. Afișarea angajaților care nu au funcție de conducere (postul lor nu conține cuvintele
//director sau șef), în ordine descrescătoare a salariilor, folosind stream-uri şi expresii
//lambda.
        System.out.println("4. Afișarea angajaților care nu au funcție de conducere");
        angajati.stream()
                .filter(angajat -> !angajat.getPost().contains("Sef") && !angajat.getPost().contains("Director"))
                .sorted(Comparator.comparing(Angajat::getSalariu).reversed())
                .forEach( (angajat)-> System.out.println(angajat));

//        5. Extragerea din lista de angajați a unei liste de String-uri care conține numele angajaților
//scrise cu majuscule. Rezolvarea va utiliza steram-uri, metoda map() şi operația
//terminală collect(). Lista de String-uri va fi afișată.
        System.out.println("5. Extragerea din lista de angajați a unei liste de String-uri care conține numele angajaților scrise cu majuscule");
        List<String> numeAngajati = angajati.stream()
                .map(angajat -> angajat.getNume().toUpperCase())
                .toList();
        numeAngajati.forEach( (nume)-> System.out.println(nume));

//        6. Afișarea salariilor mai mici de 3000 de RON (doar salariile, fără alte informații)
//folosind stream-uri, expresii lambda, referințe la metode şi metoda map().
        System.out.println("6. Afișarea salariilor mai mici de 3000 de RON");
        angajati.stream()
                .filter(angajat -> angajat.getSalariu() < 3000)
                .map(Angajat::getSalariu)
                .forEach(System.out::println);

//        7. Afișarea datelor primului angajat al firmei. Se va determina minimul din stream
//furnizând comparatorul adecvat printr-o expresie Lambda. Dacă containerul Optional
//returnat de funcția min() conține o valoare, atunci se va afișa acea valoare, altfel se va
//afișa un mesaj corespunzător.
        System.out.println("7. Afișarea datelor primului angajat al firmei");
        Optional<Angajat> angajat = angajati.stream()
                .min(Comparator.comparing(Angajat::getDataAngajarii));
        if (angajat.isPresent()) {
            System.out.println(angajat.get());
        } else {
            System.out.println("Nu exista angajati");
        }

//        8. Afișarea de statistici referitoare la salariul angajaților. Se va afișa salariul mediu,
//salariul minim şi salariul maxim. Rezolvarea va utiliza stream-uri şi operația terminală
//collect(Collectors. summarizingDouble())
        System.out.println("8. Afișarea de statistici referitoare la salariul angajaților");
        DoubleSummaryStatistics stats = angajati.stream()
                .collect(Collectors.summarizingDouble(Angajat::getSalariu));
        System.out.println("Salariul mediu: " + stats.getAverage());
        System.out.println("Salariul minim: " + stats.getMin());
        System.out.println("Salariul maxim: " + stats.getMax());

//        9. Afișarea unor mesaje care indică dacă printre angajați există cel puțin un “Ion”. Se vor
//afișa mesaje precum: „Firma are cel puțin un Ion angajat”, „Firma nu are nici un Ion
//angajat”, în funcție de situație. Rezolvarea va utiliza stream-uri şi metoda findAny()
//care va returna un container Optional care poate să conțină un element sau nu. Metoda
//ifPresentOeElse din clasa Optional se va utiliza pentru afișarea mesajelor
//corespunzătoare.
        System.out.println("9. Afișarea unor mesaje care indică dacă printre angajați există cel puțin un “Ion”");
        angajati.stream()
                .filter(angajat1 -> angajat1.getNume().contains("Ion"))
                .findAny()
                .ifPresentOrElse(
                angajat1 -> System.out.println("Firma are cel puțin un Ion angajat"),
                () -> System.out.println("Firma nu are nici un Ion angajat")
        );

//        10. Afișarea numărului de persoane care s-au angajat în vara anului precedent. Se va
//utiliza metoda count() din interfaţa Stream.
        System.out.println("10. Afișarea numărului de persoane care s-au angajat în vara anului precedent");
        long nrAngajati = angajati.stream()
                .filter(angajat1 -> angajat1.getDataAngajarii().getYear() == anulTrecut && angajat1.getDataAngajarii().getMonthValue() >= 6 && angajat1.getDataAngajarii().getMonthValue() <= 8)
                .count();
        System.out.println("Numarul de angajati: " + nrAngajati);
    }

    public static void writeInJSON() {
        //delete all the content from the file
        try {
            new File("C:\\Users\\Tudor\\JavaProjects\\lab_PJ\\lab6\\src\\main\\resources\\angajati.json").delete();
            new File("C:\\Users\\Tudor\\JavaProjects\\lab_PJ\\lab6\\src\\main\\resources\\angajati.json").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Funcţia de scriere în JSON va scrie obiectele de tip LocalDate sub forma unui vector
//[an,luna,zi]. Scrierea obiectului de tip LocalDate sub forma unui sir de caractere poate fi
//asigurată prin completarea funcției de scriere cu următoarea instrucţiune: mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        List<Angajat> angajati = new ArrayList<>();
        angajati.add(new Angajat("Popescu Ion", "Programator", LocalDate.of(2020, 10, 10), 3000));
        angajati.add(new Angajat("Ionescu Vasile", "Contabil", LocalDate.of(2023, 6, 15), 2500));
        angajati.add(new Angajat("Georgescu Maria", "Secretara", LocalDate.of(2021, 1, 1), 2000));
        angajati.add(new Angajat("Dumitrescu Ionel", "Director", LocalDate.of(2018, 12, 1), 4000));
        angajati.add(new Angajat("Popa Ionescu", "Profesor Sef", LocalDate.of(2023, 4, 10), 3000));

        try{
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            mapper.writeValue(new File("C:\\Users\\Tudor\\JavaProjects\\lab_PJ\\lab6\\src\\main\\resources\\angajati.json"), angajati);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Angajat> readFromJson() {
        try {
            File file = new File("C:\\Users\\Tudor\\JavaProjects\\lab_PJ\\lab6\\src\\main\\resources\\angajati.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> angajati = mapper
                    .readValue(file, new TypeReference<List<Angajat>>() {
                    });
            return angajati;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}