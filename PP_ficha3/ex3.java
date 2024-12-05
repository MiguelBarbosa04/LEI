package PP_ficha3;

public class ex3 {
    public static void main(String[] args) {

        int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 11, 12 } };
        int numMaisFrequente = 0;
        int frequencia = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int contador = 0;
                for (int k = 0; k < matriz.length; k++) {
                    for (int l = 0; l < matriz[k].length; l++) {
                        if (matriz[i][j] == matriz[k][l]) {
                            contador++;
                        }
                    }
                }
                if (contador > frequencia) {
                    numMaisFrequente = matriz[i][j];
                    frequencia = contador;
                }
            }
        }

        System.out
                .println("O número mais frequente é o " + numMaisFrequente + ", que aparece " + frequencia + " vezes.");

        for (int i = 0; i < matriz.length; i++) {
            int max = matriz[i][0];
            int min = matriz[i][0];
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > max) {
                    max = matriz[i][j];
                }
                if (matriz[i][j] < min) {
                    min = matriz[i][j];
                }
            }
            System.out.println("O número mais pequeno da linha " + (i + 1) + " é " + min);
            System.out.println("O número maior da linha " + (i + 1) + " é " + max);
        }
    }
}
