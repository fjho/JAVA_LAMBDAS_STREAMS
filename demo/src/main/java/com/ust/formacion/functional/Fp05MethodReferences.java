package com.ust.formacion.functional;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Fp05MethodReferences {
    private List<String> courses = List.of("Java", "Python", "JavaScript", "C++", "Spring", "Ruby", "Kotlin");

    private List<Course> coursesObjects = List.of(new Course("Java"), new Course("Python"), new Course("JavaScript"), new Course("C++"), new Course("Spring"), new Course("Ruby"), new Course("Kotlin"));
    public static void main(String[] args) {
        Fp05MethodReferences fp05 = new Fp05MethodReferences();
        fp05.execute();
    }  

    public void execute() {
         Function<? super String, ? extends String> mapper = String::toUpperCase;
         Function<? super String, ? extends String> mapper2 = str -> str.toUpperCase();
         Function<? super String, ? extends String> mapper3 = new Function<String, String>() {
            @Override
            public String apply(String str) {
                return str.toUpperCase();
            }
         };

         courses.stream()
               .map(String::toUpperCase)           // Instance method reference of a built-in java class: se esta llamando al metodo toUpperCase del objeto String que se está procesando en ese momento
               .forEach(System.out::println);      // Instance method reference of a built-in java class: se esta llamando al metodo println del objeto System.out(instancia de PrintStream) pasandole como parametro el objeto String que se está procesando en ese momento

        System.out.println("-----------------");

         courses.stream()
               .map(mapper)                     // Instance method reference of a built-in java class: se esta llamando al metodo toUpperCase del objeto String que se está procesando en ese momento
               .forEach(System.out::println);   // Instance method reference of a built-in java class: se esta llamando al metodo println del objeto System.out(instancia de PrintStream) pasandole como parametro el objeto String que se está procesando en ese momento

        System.out.println("-----------------");

        courses.stream()
               .map(mapper2)                    // Instance method reference of a built-in java class: se esta llamando al metodo toUpperCase del objeto String que se está procesando en ese momento
               .forEach(System.out::println);   // Instance method reference of a built-in java class: se esta llamando al metodo println del objeto System.out(instancia de PrintStream) pasandole como parametro el objeto String que se está procesando en ese momento

        System.out.println("-----------------");

        courses.stream()
               .map(mapper3)                    // Instance method reference of a built-in java class: se esta llamando al metodo toUpperCase del objeto String que se está procesando en ese momento
               .forEach(System.out::println);   // Instance method reference of a built-in java class: se esta llamando al metodo println del objeto System.out(instancia de PrintStream) pasandole como parametro el objeto String que se está procesando en ese momento

        System.out.println("-----------------");

        coursesObjects.stream()
            .forEach(Course::print);            // Instance method reference of a user-defined class: se esta llamando al metodo print del objeto Course que se está procesando en ese momento

        System.out.println("-----------------");

        coursesObjects.stream()
            .forEach(Course::staticPrintCourse);            // Static method reference of a user-defined class: se esta llamando al metodo estatico printCourse de la clase Course

        System.out.println("-----------------");

        Course printerCourse = new Course("Printer Course");
        coursesObjects.stream()
            .forEach(printerCourse::printCourse);            // Instance method reference of a user-defined class: se esta llamando al metodo printCourse del objeto printerCourse pasandole como parametro el objeto Course que se está procesando en ese momento

        System.out.println("-----------------");

        Supplier<Course> supplier = Course::new; // Method reference of a constructor
        Course course = supplier.get(); 
        course.print();   
        
        System.out.println("-----------------");
    }
}


class Course {
    String name;

    public Course() {
        this.name = "Unknown";
    }  

    public Course(String name) {
        this.name = name;
    }   

    public String getName() {
        return name;
    }

    public void print() {
        System.out.println("Course name: " + name);
    }

    public static void staticPrintCourse(Course course) {
        System.out.println("staticPrintCourse: " + course.getName());
    }

    public void printCourse(Course course) {
        System.out.println("printCourse: " + course.getName());
    }
}