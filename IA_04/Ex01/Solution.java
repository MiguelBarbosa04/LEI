package Ex01;

import java.util.Random;

public class Solution implements Comparable<Solution> {

    private final int TAM = 6;
    private StringBuffer sol;
    private StringBuffer palavra;

    public Solution(StringBuffer palavra){
        this.sol = new StringBuffer();
        this.palavra = palavra;
        Random random = new Random();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for (int i = 0; i < TAM; i++) {
            int index = random.nextInt(chars.length());
            char randomChar = chars.charAt(index);
            sol.append(randomChar);
        }
    }

    @Override
    public int compareTo(Solution o) {
        if (this.getFitness() > o.getFitness())
            return 1;
        
        if (this.getFitness() < o.getFitness())
            return -1;
        
        return 0;
    }

    

    @Override
    public String toString() {
        return "Solution =" + sol + ", Fitness =" + getFitness();
    }

    public StringBuffer getSol() {
        return sol;
    }

    public int getFitness(){
        int total = 0;
        for (int i=0;i<this.sol.length(); i++)
            if (sol.charAt(i) == palavra.charAt(i))
                total++;

        return total;
    }
}
