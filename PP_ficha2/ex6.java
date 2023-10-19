public class ex6 {
    public static void main(String[] args) {

        int[] listaA = {2, -5, -121, 102, -35, -2, 0, -125, 802, -10};
        int[] listaB = {6, 99, -1, 12, 1, -2};

        int tamanhoA = listaA.length;
        int tamanhoB = listaB.length;
        int tamanhoC = tamanhoA + tamanhoB;
        int[] listaC = new int[tamanhoC];

        for (int i = 0; i < tamanhoA; i++) {
            listaC[i] = listaA[i];
        }

        for (int i = 0; i < tamanhoB; i++) {
            listaC[tamanhoA + i] = listaB[i];
        }

        System.out.println("Vetor resultante: ");
        for (int i = 0; i < tamanhoC; i++) {
            System.out.print(listaC[i] + " ");
        }
       
    }
}
