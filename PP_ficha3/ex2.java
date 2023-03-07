package PP_ficha3;

public class ex2 {
    public static void main(String[] args) {

        int vetor[] = { 1, 2, 3, 4, 5, 6 };
        int i, soma = 0;


        for (i = 1; i < vetor.length; i++) { // a variável i deve ser inicializada com 1, em vez de zero para não dar
                                             // erro
            if (vetor[i] % i == 0) {
                System.out.println(i + " é primo");
            }
        }

        for(int j = 1; j < i; j++){
            if(i % j == 0){
                soma += j;
            }
        }
        if(soma == i){
            System.out.println(i + " é perfeito");
        }

    }
}
