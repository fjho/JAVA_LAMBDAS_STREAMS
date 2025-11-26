package com.ust.formacion.functional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Fp10Files {
    public static void main(String[] args) throws IOException {

        // Read lines from a file and process them
        Files.lines(Paths.get("file.txt"))
             .filter(line -> !line.isBlank())
             .map(String::toUpperCase)
             .forEach(System.out::println);
        System.out.println("-------------------------------");
        
        //read lines of a file and find unique words
        Files.lines(Paths.get("file.txt"))
        .map(line->line.split(" "))
        .flatMap(Arrays::stream)
        .distinct()
        .forEach(System.out::println);
        System.out.println("-------------------------------");

        Files.list(Paths.get("."))
                .forEach(System.out::println);
        System.out.println("-------------------------------");

        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);
        System.out.println("-------------------------------");
    }
}
