package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PR115cp {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Has d'indicar dues rutes d'arxiu.");
            System.out.println("Ús: PR115cp <origen> <destinació>");
            return;
        }

        // Ruta de l'arxiu origen
        String rutaOrigen = args[0];
        // Ruta de l'arxiu destinació
        String rutaDesti = args[1];

        // Crida al mètode per copiar l'arxiu
        copiarArxiu(rutaOrigen, rutaDesti);
    }

    // Mètode per copiar un arxiu de text de l'origen al destí
    public static void copiarArxiu(String rutaOrigen, String rutaDesti) {
        Path origen = Paths.get(rutaOrigen);
        Path desti = Paths.get(rutaDesti);

        if (!Files.exists(origen) || !Files.isRegularFile(origen)) {
            System.out.println("Error: L'arxiu origen no existeix o no és un fitxer vàlid.");
            return;
        }
        if (Files.exists(desti)) {
        System.out.println("Avís: L'arxiu de destí ja existeix i serà sobreescrit.");}

        try {
            List<String> linies = Files.readAllLines(origen, StandardCharsets.UTF_8);

            Files.write(desti, linies, StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Còpia realitzada correctament.");
        } catch (IOException e) {
            System.out.println("Error en copiar l'arxiu: " + e.getMessage());
        }
        }
            
}
