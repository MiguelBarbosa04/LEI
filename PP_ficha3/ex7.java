package PP_ficha3;

public class ex7 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("É necessário passar dois argumentos inteiros na linha de comando.");
            return;
        }
        int dividendo = Integer.parseInt(args[0]);
        int divisor = Integer.parseInt(args[1]);
        int resultado = 0;
        while (dividendo >= divisor) {
            dividendo -= divisor;
            resultado++;
        }
        System.out.println("Resultado da divisão: " + resultado);
        System.out.println("Resto da divisão: " + dividendo);
    }
}
