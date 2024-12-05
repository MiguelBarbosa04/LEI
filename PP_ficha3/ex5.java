package PP_ficha3;

public class ex5 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java ConverteMoeda <valor> <moeda>");
            System.out.println("<valor> - valor a ser convertido");
            System.out.println("<moeda> - moeda original (euro ou dolar)");
            return;
        }
        double valor = Double.parseDouble(args[0]);
        String moeda = args[1].toLowerCase();
        double taxa = 0.9184;

        try {
            if (moeda.equals("euro")) {
                double valorDolar = valor / taxa;
                System.out.printf("%.2f$\n", valorDolar);
            } else if (moeda.equals("dolar")) {
                double valorEuro = valor * taxa;
                System.out.printf("%.2f€\n", valorEuro);
            } else {
                System.out.println("Moeda inválida. Use euro ou dolar.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Use um número válido.");
        }
    }
}
