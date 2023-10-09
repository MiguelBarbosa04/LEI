/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miguel
 */
public class ParDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Par<Integer, String> funcionario = new Par<>(2, "Miguel");
        Par<String, Double> aluno = new Par<>("Miguel", 10.0);
        Par<Float, Float> coordenadas = new Par<>(3.0f, 2.0f);

    }

}
