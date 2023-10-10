
package ex1;
import java.io.*;

public class ex1 {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Modo de uso: java Ex1 <comando>");
            System.exit(0);
        }

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            ProcessBuilder pb = new ProcessBuilder(arg); // Use the 'arg' variable here
            Process process = pb.start();
            System.out.println("Inicio do comando \"" + arg + "\".");
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) { // Use 'readLine' instead of 'readline'
                System.out.println(line);
            }
            br.close();
            try {
                process.waitFor();
                System.out.println("Fim do comando \"" + arg + "\".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
