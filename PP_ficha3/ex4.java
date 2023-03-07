package PP_ficha3;

public class ex4 {
    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                double graus = Double.parseDouble(args[0]);
                double radianos = graus * Math.PI / 180;
                System.out.println(graus + " graus equivalem a " + radianos + " radianos.");
            } catch (NumberFormatException e) {
                System.out.println("O argumento deve ser um número válido.");
            }
        } else {
            System.out.println("É necessário fornecer um argumento com o valor em graus a ser convertido.");
        }
    }
}
