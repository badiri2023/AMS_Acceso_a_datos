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
        // designamos una uta origen y otra destino
        Path origen = Paths.get(rutaOrigen);
        Path desti = Paths.get(rutaDesti);
        // primero ahremos varias comprobaciones para asegurar el correcto funcionamiento de mover eldocuemnto
        // comprobamos que el archivo exista en si para poder moverlo y de que sea un documento valido
        if (!Files.exists(origen) || !Files.isRegularFile(origen)) {
            System.out.println("Archvio inexistente o archivo no valido!!");
            return;
        }
        // en caso de que exita, este avisara de que sera sobreescrito
        if (Files.exists(desti)) {
            System.out.println("Avís: L'arxiu de destí ja existeix i serà sobreescrit.");}

        try {
            // guardamos los datos del arhivo para luego escribirlo en uno nuevo con los mismos datos
            List<String> linies = Files.readAllLines(origen, StandardCharsets.UTF_8);

            Files.write(desti, linies, StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Copiado exitosamente");
        } catch (IOException e) {
            System.out.println("Error de duplicado" + e.getMessage());
        }
        }
            
}
