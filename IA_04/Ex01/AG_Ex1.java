package Ex01;

import java.util.ArrayList;
import java.util.Collections;


public class AG_Ex1 {

    private static StringBuffer palavra = new StringBuffer("CASACO");

    
    public static ArrayList<Solution> inicializa(int n){
        ArrayList<Solution> gen0 = new ArrayList<Solution>(n);
        
        for (int i=0;i<n;i++)
            gen0.add(new Solution(palavra));

        return gen0;
    }

    public static void main(String[] args){

        ArrayList<Solution> gen0 = inicializa(100);

        Collections.sort(gen0, Collections.reverseOrder());

        for(int i=0;i<5;i++)
            System.out.println(gen0.get(i));


    }
        
}
