package com.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PR112cat {

    public static void main(String[] args) {
        // Comprovar que s'ha proporcionat una ruta com a paràmetre
        if (args.length == 0) {
            System.out.println("No s'ha proporcionat cap ruta d'arxiu.");
            return;
        }

        // Obtenir la ruta del fitxer des dels paràmetres
        String rutaArxiu = args[0];
        mostrarContingutArxiu(rutaArxiu);
    }

    // Funció per mostrar el contingut de l'arxiu o el missatge d'error corresponent
    public static void mostrarContingutArxiu(String rutaArxiu) {

        Path path = Paths.get(rutaArxiu);
        // Hacemos comprobacion de que se ha introducido direccion de un documento en vez de fichero
        if(Files.isDirectory(path)){
            System.out.println("El path no correspon a un arxiu, sino a una carpeta.");
            return;
        }else if(Files.isRegularFile(path)){
            System.out.println("Leyendo Datos...");
            try (BufferedReader br = Files.newBufferedReader(path, java.nio.charset.StandardCharsets.UTF_8)) {
                String linia;
                while ((linia = br.readLine()) != null) {
                System.out.println(linia);
            }
            // tiramos el cathc para las excepciones durante la lectura del archivo
            } catch (IOException e) {
                System.out.println("No hauria de fallar amb una excepció: " + e.getMessage());
            }
        }else {
        System.out.println("El fitxer no existeix o no es accessible.");
        }
    }
}
