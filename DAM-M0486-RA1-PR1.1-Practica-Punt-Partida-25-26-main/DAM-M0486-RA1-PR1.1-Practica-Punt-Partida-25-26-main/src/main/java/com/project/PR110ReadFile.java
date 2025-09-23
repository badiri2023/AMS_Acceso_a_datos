package com.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PR110ReadFile {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/GestioTasques.java";
        llegirIMostrarFitxer(camiFitxer);  // Només cridem a la funció amb la ruta del fitxer
    }

    // Funció que llegeix el fitxer i mostra les línies amb numeració
    public static void llegirIMostrarFitxer(String camiFitxer) {
    // iniciamos con un try catch por si salta algun error
    try {
        BufferedReader br = new BufferedReader(new FileReader(camiFitxer));

        String linia;
        int numeroLinia = 1;
        // iteramos de forma que mientras haya una linea siga imprimiendo
        while ((linia = br.readLine()) != null) {
            System.out.println(numeroLinia+": "+linia);
            numeroLinia++;
        }
        // cerramos el documento
        br.close();
            } 
        catch (IOException e) {
            System.out.println("No hauria de fallar amb una excepció: " + e.getMessage());
        }


        
    }
}
