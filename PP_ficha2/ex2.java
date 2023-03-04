public class ex2 {
    public static void main(String[] args) {
        int a[][] = { { 11, 7, 333 }, { -20, -23, 63 }, { -22, 501, 1000 } };
        
float soma = 0;

        for (int i = 0; i <  a.length; i++) {
            for (int j = 0; j <  a.length; j++) {
                soma += a[i][j];
            }  
        }
        System.out.println( soma );
    }
}
