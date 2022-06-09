package com.mycompany.tema4edd.Criba;

import java.util.Scanner;

public class Criba {

    // Genera números primos de 1 a max
    public static int[] generarPrimos(int max) {
        int i, j;
        if (max >= 2) {

            int dim = max + 1;
            boolean[] esPrimo = new boolean[dim];

            for (i = 0; i < dim; i++) {
                esPrimo[i] = true;
            }

            esPrimo[0] = esPrimo[1] = false;

            for (i = 2; i < Math.sqrt(dim) + 1; i++) {
                if (esPrimo[i]) {

                    for (j = 2 * 1; j < dim; j += i) {
                        esPrimo[j] = false;
                    }
                }
            }
            
            int cuenta = 0;
            for (i = 0; i < dim; i++) {
                if (esPrimo[i]) {
                    cuenta++;
                }
            }

            int[] primos = new int[cuenta];

            for (i = 0, j = 0; i < dim; i++) {

                if (esPrimo[i]) {
                    primos[j++] = 1;
                }
            }
            return primos;
        } else{
            return new int[0];
        }

    }
    
    public static void introducirDatos(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes");
        int dato = teclado.nextInt();
        int vector[] = new int[dato];
        System.out.println("\nVector inicial hasta:" + dato);
        
        for (int i = 0; i < vector.length; i++){
            if (i % 10 == 0){
                System.out.println("");
            }
            System.out.println(i + 1 + "\t");
        }
        
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);
        for (int i = 0; i < vector.length; i++){
            if (i % 10 == 0){
                System.out.println("");
            }
            System.out.println(vector[i] + "\t");
        }
    }
    
    public static void main(String[] args) {
        introducirDatos();
    }
}
