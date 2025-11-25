package com.ust.formacion.functional;

import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class Fp08Performance {
    public static void main(String[] args) {
        List<String> names = List.of(
            "Ana", "Berta", "Carlos", "Daniel", "Eva", "Francisco", "Gabriela", "Hector", "Irene", "Javier"
        );
        // ============ LAZY EVALUATION DEMONSTRATION ============
        
        System.out.println("=== 1. SIN OPERACION TERMINAL (LAZY) - NO EJECUTA NADA ===");
        Stream<String> lazyStream = names.stream()
            .peek(name -> System.out.println("  Procesando: " + name))  // ¡NO se ejecuta!
            .filter(name -> {
                System.out.println("  Filtrando: " + name);              // ¡NO se ejecuta!
                return name.length() > 6;
            })
            .map(name -> {
                System.out.println("  Mapeando: " + name);               // ¡NO se ejecuta!
                return name.toUpperCase();
            });
        
        System.out.println("Stream creado, pero NO se ha ejecutado nada aún...");
        System.out.println("¿Has visto algún 'Procesando', 'Filtrando' o 'Mapeando'? ¡NO!");
        
        System.out.println("\n=== 2. AHORA AGREGAMOS OPERACION TERMINAL ===");
        Optional<String> resultado = lazyStream.findFirst();  // ¡AHORA SÍ SE EJECUTA!
        System.out.println("Resultado: " + resultado);
        
        System.out.println("\n=== 3. COMPARACION CON EJECUCION INMEDIATA (FOR LOOP) ===");
        System.out.println("Con bucle for tradicional:");
        for (String name : names) {
            System.out.println("  Procesando inmediatamente: " + name);
            if (name.length() > 6) {
                System.out.println("  Encontrado: " + name.toUpperCase());
                break;  // Simula findFirst()
            }
        }
        
        System.out.println("\n=== 4. EJEMPLO MAS CLARO: STREAM QUE NUNCA SE EJECUTA ===");
        Stream<String> streamInutil = names.stream()
            .peek(name -> System.out.println("  ¡ESTO NUNCA SE VERÁ!: " + name))
            .filter(name -> {
                System.out.println("  ¡ESTO TAMPOCO!: " + name);
                return true;
            });
        
        System.out.println("Stream 'streamInutil' creado... ¿viste algún mensaje? ¡NO!");
        System.out.println("Porque NO tiene operación terminal, ¡es completamente LAZY!");

        System.out.println("\n" + "=".repeat(50));
        
        System.out.println(
        names.stream().peek(System.out::println)
                      .filter(name -> name.length() > 6)
                      .peek(System.out::println)
                      .map(String::toUpperCase)
                      .peek(System.out::println)
                      .findFirst()
                      );

        //El aspecto crucial de este pipeline es la operación terminal findFirst(). 
        //Esta operación implementa 'evaluación de cortocircuito', lo que significa que detiene el procesamiento tan pronto 
        //como encuentra el primer elemento que satisface todas las operaciones intermedias. 
        //Dado que los streams son 'perezosos', todo el pipeline (peek, filter, peek, map, peek) solo se ejecuta 
        //para tantos elementos como sea necesario para producir un resultado. 
        //Si el primer elemento del stream pasa el filtro, los elementos restantes no serán procesados en absoluto. 
        //Este comportamiento hace que las operaciones peek() sean particularmente reveladoras
        //te mostrarán exactamente cuántos elementos fueron realmente procesados antes de que el stream hiciera cortocircuito, 
        //demostrando la eficiencia del procesamiento de streams en tiempo real.

        long time = 0;

        time = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < 1_000_000_000; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println("Time taken in ms: " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        System.out.println(LongStream.rangeClosed(1, 1_000_000_000)
                         .sum()
        );
        System.out.println("Time taken in ms: " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        System.out.println(LongStream.rangeClosed(1, 1_000_000_000)
                         .parallel()
                         .sum()
        );
        System.out.println("Time taken in ms: " + (System.currentTimeMillis() - time));


    }
}
