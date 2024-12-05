package PP_ficha3;

import java.util.*;

public class scanner {
    public static void main(String[] args) {

        /*
         * / COMO DAR SCANF:
         * System.out.print("Número: ");
         * Scanner scn = new Scanner(System.in);
         * int a = Integer.parseInt(scn.nextLine());
         * scn.close();
         * 
         * 
         * System.out.println(a);
         */

        int[] listaA = { 2, 1, -121, 102, -35, -2, 0, -125, 802, -10 };
        int[] listaB = { 6, 99, -1, 12, 1, -2 };

        int[] listaC = new int[16];
        int j = 0;
        int i;

        juntar(listaA, listaB, listaC);

        System.out.println(Arrays.toString(listaC));

        for (i = 0; i < listaA.length; i++) {
            if (!existeNumero(listaB, listaA[i])) {
                listaC[j] = listaA[i];
                j++;
            }
        }

        for (i = 0; i < listaA.length; i++) {
            System.out.print(listaC[i] + " ");
        }
    }

    public static void juntar(int[] lista1, int[] lista2, int[] lista3) {
        System.arraycopy(lista1, 0, lista3, 0, lista1.length);
        System.arraycopy(lista2, 0, lista3, lista1.length, lista2.length);

    }

    public static boolean existeNumero(int[] lista, int numero) {
        for (int i = 0; i < lista.length; i++) {
            if (numero == lista[i]) {
                return true;
            }
        }
        return false;

    }

}
