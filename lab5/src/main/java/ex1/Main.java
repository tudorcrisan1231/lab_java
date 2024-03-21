package ex1;
import java.io.File;
import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static ex1.Mainpp.*;
import static ex1.Persoana.*;

public class Main {
    public static void main(String[] args){
        List<Persoana> persoane = citire();
        System.out.println(persoane);
        for (Persoana p : persoane) {
            System.out.println(p);
        }
        persoane.add(new Persoana("Maria", 33));
        scriere(persoane);
    }
}