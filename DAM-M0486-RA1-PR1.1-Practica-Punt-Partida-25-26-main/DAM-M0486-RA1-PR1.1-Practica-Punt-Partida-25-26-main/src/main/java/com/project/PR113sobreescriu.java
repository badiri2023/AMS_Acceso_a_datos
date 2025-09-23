package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class PR113sobreescriu {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que escriu les frases sobreescrivint el fitxer
        escriureFrases(camiFitxer);
    }

    // Mètode que escriu les frases sobreescrivint el fitxer amb UTF-8 i línia en blanc final
    public static void escriureFrases(String camiFitxer) {

        Path path = Paths.get(camiFitxer);

        // Llista amb les frases de matrix, pero podemos hacer mas igualmente
        List<String> frases = Arrays.asList(
                "I can only show you the door",
                "You're the one that has to walk through it Arriba espanya","");

        try {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }

            Files.write(path, frases, StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Frases escrites sobreescrivint fitxer.");
        } catch (IOException e) {
            System.out.println("Error escrivint al fitxer: " + e.getMessage());
        }
}}
    

