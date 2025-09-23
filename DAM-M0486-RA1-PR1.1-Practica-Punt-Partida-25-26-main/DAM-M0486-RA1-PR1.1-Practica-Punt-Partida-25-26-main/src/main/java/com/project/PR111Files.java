package com.project;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PR111Files {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/pr111";
        gestionarArxius(camiFitxer);
    }

    public static void gestionarArxius(String camiFitxer) {
        try {
            // creamos la carpeta
            Path carpeta = Paths.get(camiFitxer,"myFiles");
            Files.createDirectories(carpeta);
            System.out.println("Carpeta creada: " + carpeta);
            //-------------------------------------------------------
            //Creamos los dos documentos 1 y 2
            Path file1 = carpeta.resolve("file1.txt");
            Files.createFile(file1);
            System.out.println("Fitxer creat: " + file1.getFileName());

            Path file2 = carpeta.resolve("file2.txt");
            Files.createFile(file2);
            System.out.println("Fitxer creat: " + file2.getFileName());
            //-------------------------------------------------------
            // cambiamos el nombre del documento, apra ello cpiamos y lo substituimos con e mismo pero difernete nombre
            Path renamedFile = carpeta.resolve("renamedFile.txt");
            // comprobamos que este no existe primero, si no existe, movemos el viejo fihero y lo substitumos por el primero
            if (!Files.exists(renamedFile)) {
                Files.move(file2, renamedFile);
                System.out.println("Fitxer renombrat: " + renamedFile.getFileName());
            } else {
                // sino, simplemente devolvemos que este ya existe
                System.out.println("No s'ha pogut renombrar: ja existeix un fitxer amb aquest nom.");
            }
            //-------------------------------------------------------
            //Parte 4

            for (Path p : (Iterable<Path>) Files.list(carpeta)::iterator) {
                System.out.println(p.getFileName());
            }

            //-------------------------------------------------------
            // Parte 5
            Files.deleteIfExists(file1);
            System.out.println("Fitxer esborrat: " + file1.getFileName());

            // Parte 6
            System.out.println("Els arxius de la carpeta són:");
            for (Path p : (Iterable<Path>) Files.list(carpeta)::iterator) {
                System.out.println(p.getFileName());
            }


        } catch (Exception e) {
            // Aquesta excepció salta si el fitxer ja existeix
            System.out.println("El fitxer ja existeix.");

            }
}}
