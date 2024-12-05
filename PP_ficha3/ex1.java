package PP_ficha3;

public class ex1 {
    public static void main(String[] args) {
        int N = 3; 
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; 
        int[][] B = new int[N][N]; 

 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                B[i][j] = A[j][i];
            }
        }

      
        System.out.println("Matriz transposta: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
    }
}
}
