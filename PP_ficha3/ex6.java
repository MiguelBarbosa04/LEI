package PP_ficha3;

public class ex6 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Insira um valor em cêntimos de euro como argumento.");
            return;
        }

        int valor = 0;

        try {
            valor = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("O valor inserido não é um número válido.");
            return;
        }

        int euros = valor / 100;
        int centimos = valor % 100;

        if (euros == 1) {
            System.out.print(euros + " euro");
        } else if (euros > 1) {
            System.out.print(euros + " euros");
        }

        if (euros != 0 && centimos != 0) {
            System.out.print(" e ");
        }

        if (centimos == 1) {
            System.out.println(centimos + " cêntimo");
        } else if (centimos > 1) {
            System.out.println(centimos + " cêntimos");
        }
    }
}
