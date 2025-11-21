package com.ust.formacion.lambdaexp;

import java.util.List;

public class Example001 {
    public static void main(String[] args) {

        List<Product> products = ExampleProductData.getProducts();

        // print all products
        //products.forEach(System.out::println);

        //hay que implementar la interfaz Comparator con una clase anónima
        //muchas lineas solo para comparar los precios
        //el resto de lineas estan solo pq java las necesita (plumbing code)        
        products.sort(new java.util.Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
            return p1.getPrice().compareTo(p2.getPrice());
            }
        });
        

        //ahora con lambda expressions
        //La implementacion del metodo compare recibe dos parametros (p1 y p2) 
        //y devuelve el resultado de la comparacion (int)
        //como la implementación de la funcion es sólo una linea de codigo, se pueden omitir las llaves y el return 
        products.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));

        //Si tuviese mas de una linea de codigo en la implementacion, habria que usar llaves y return
        products.sort((p1, p2) -> { 
                                    return p1.getPrice().compareTo(p2.getPrice()); 
                                });

        for (Product product : products) {
            System.out.println(product);
        }

        //ejemplo arrow function que implementa FileFilter el metodo accept, como solo tiene un parametro se puede omitir los parentesis
        //FileFilter filter = file -> file.getName().endsWith(".java");
    }
}
