package ex2_v2;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Ex1 <file>");
            System.exit(1); // Use a non-zero exit code to indicate an error
        }

        Charset ENCODING = StandardCharsets.UTF_8;
        Path path = Paths.get(args[0]);

        try {
            List<String> lines = Files.readAllLines(path, ENCODING);

            for (String line : lines) {
                ProcessBuilder pb = new ProcessBuilder(line);
                Process process = pb.start();
                System.out.println("Starting command: \"" + line + "\".");
                try (
                    InputStream is = process.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr)
                ) {
                    String outputLine;
                    while ((outputLine = br.readLine()) != null) {
                        System.out.println(outputLine);
                    }
                } catch (IOException e) {
                    System.err.println("Error reading command output: " + e.getMessage());
                }

                int exitCode = process.waitFor();
                System.out.println("Command \"" + line + "\" finished with exit code: " + exitCode);
            }
        } catch (IOException e) {
            System.err.println("Error accessing the file: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.err.println("Command execution interrupted: " + e.getMessage());
        }
    }
}
