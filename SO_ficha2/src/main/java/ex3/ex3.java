package ex3;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;


public class ex3 {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        if (args.length == 0) {
            System.out.println("Modo de uso: java Ex1 <ficheiro>");
            System.exit(0);
        }
        Charset ENCODING = StandardCharsets.UTF_8;
        Path path = Paths.get(args[0]);
        try {

            List<String> linhas = Files.readAllLines(path, ENCODING);

            List<Thread> threads = new ArrayList<>();

            for (int i = 0; i < linhas.size(); i++) {
                String arg = linhas.get(i);
                Thread thread = new Thread(() -> {
                    try {
                        ProcessBuilder pb = new ProcessBuilder(arg);
                        Process process = pb.start();
                        System.out.println("Inicio do comando \"" + arg + "\".\n");

                        try (InputStream is = process.getInputStream();
                             InputStreamReader isr = new InputStreamReader(is);
                             BufferedReader br = new BufferedReader(isr)) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            System.err.println("Erro ao ler o output do comando: " + e.getMessage());
                        }

                        int exitCode = process.waitFor();
                        System.out.println("Comando \"" + arg + "\" acabou com código: " + exitCode);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                thread.start();
                threads.add(thread);
            }

            // Aguarda todas as threads terminarem
            for (Thread thread : threads) {
                thread.join();
            }

        } catch (IOException err) {
            System.out.println("Erro no acesso ao ficheiro");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.err.println("Execução do comando interrompida: " + e.getMessage());
        }
    }
}
