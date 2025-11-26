package com.ust.formacion.functional;

import java.util.ArrayList;
import java.util.List;


public class Fp09JavaEasier {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(List.of(
            "Ana", "Berta", "Carlos", "Daniel", "Eva", "Francisco", "Gabriela", "Hector", "Irene", "Javier"
        ));



        //Arraylist has methods that receive lambdas to perform operations directly on the collection without the need of streams
        System.out.println(names);
        names.replaceAll(n-> n.toUpperCase());
        System.out.println(names);
        names.removeIf(n->n.equals("JAVIER"));
        System.out.println(names);
    }
}
