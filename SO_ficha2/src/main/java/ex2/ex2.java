package ex2;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

public class ex2 {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        if (args.length == 0) {
            System.out.println("Modo de uso: java Ex1 <ficheiro>");
            System.exit(0);
        }
        Charset ENCODING = StandardCharsets.UTF_8;
        Path path = Paths.get(args[0]);
        try {

            List<String> linhas = Files.readAllLines(path, ENCODING);

            for (int i = 0; i < linhas.size(); i++) {
                String arg = linhas.get(i);
                ProcessBuilder pb = new ProcessBuilder(arg); // Use the 'arg' variable here
                Process process = pb.start();
                System.out.println("Inicio do comando \"" + arg + "\".\n");
                try (
                         InputStream is = process.getInputStream();  InputStreamReader isr = new InputStreamReader(is);  BufferedReader br = new BufferedReader(isr);) {
                    String line;
                    while ((line = br.readLine()) != null) { // Use 'readLine' instead of 'readline'
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.err.println("Error reading command output: " + e.getMessage());
                }

                int exitCode = process.waitFor();
                System.out.println("Command \"" + arg + "\" finished with exit code: " + exitCode);
            }

        } catch (IOException err) {
            System.out.println("Erro no acesso ao ficheiro");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.err.println("Command execution interrupted: " + e.getMessage());
        }
    }
}
