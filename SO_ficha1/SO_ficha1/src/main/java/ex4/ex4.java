/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

/**
 *
 * @author migue
 */
public class ex4 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        
        if (args.length == 0) {
            System.out.println(
                    "Argumento não incluido" + "\n" + "Deverá inserir o nome do ficheiro onde pretende imprimir" + "\n"
                    + "Por exemplo: java (Ficha1Ex4.java) (Nome do ficheiro)");

            System.exit(0);
        }

        try {
            Charset ENCODING = StandardCharsets.UTF_8;
            Path path = Paths.get(args[0]);
            List<String> linhas = Files.readAllLines(path, ENCODING);

            for (int i = 0; i < linhas.size(); i++) {
                System.err.println("Linha_n." + i + ":" + linhas.get(i));

            }

        } catch (IOException err) {
            System.out.println("Erro no acesso ao ficheiro");
        }

    }

}
