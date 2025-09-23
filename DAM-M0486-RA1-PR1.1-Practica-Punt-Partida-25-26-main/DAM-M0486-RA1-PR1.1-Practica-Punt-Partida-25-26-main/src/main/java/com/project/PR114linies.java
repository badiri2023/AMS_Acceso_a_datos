package com.project;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PR114linies {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/numeros.txt";

        // Crida al mètode que genera i escriu els números aleatoris
        generarNumerosAleatoris(camiFitxer);
    }

    // Mètode per generar 10 números aleatoris i escriure'ls al fitxer
    public static void generarNumerosAleatoris(String camiFitxer) {
        Path path = Paths.get(camiFitxer);
      // Llista on guardarem els números en format String
        List<String> numeros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
                int numero = (int) (Math.random() * 100); // 0..99
                numeros.add(String.valueOf(numero));
            }
         try  {
            Files.write(path, numeros, StandardCharsets.UTF_8,
            StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Fitxer creat amb 10 números aleatoris.");
          
        }catch (Exception e) {
            System.out.println("Error escrivint al fitxer: " + e.getMessage());
        }

    }
}

