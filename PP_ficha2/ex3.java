public class ex3 {
    public static void main(String[] args) {
        int[] lista = { 12,5,-21,10,-345,22,50,-125,80,-1};

        int mult = 1;
       int  count = 0;
        int maior = 0;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] > 0) {
                mult *= lista[i];
            }
        }
        System.out.println(mult);

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] < 0) {
               count++;
            }
        }

        System.out.println(count);

    for (int i = 0; i < lista.length; i++) {
        if ( maior < lista[i]) {
            maior = lista[i]
           ; 
        }
    }
    System.out.println(maior);

}
}