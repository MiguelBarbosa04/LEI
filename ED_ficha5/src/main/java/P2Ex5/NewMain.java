/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2Ex5;

/**
 *
 * @author Miguel
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Piloto[] pilotos = new Piloto[5];
        pilotos[0] = new Piloto("Lewis Hamilton");
        pilotos[1] = new Piloto("Max Verstappen");
        pilotos[2] = new Piloto("Valtteri Bottas");
        pilotos[3] = new Piloto("Charles Leclerc");
        pilotos[4] = new Piloto("Lando Norris");

        Corrida corrida = new Corrida(pilotos);
        corrida.simularCorrida();
    }

}
