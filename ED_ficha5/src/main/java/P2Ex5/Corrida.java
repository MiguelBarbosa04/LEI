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
public class Corrida {

    private Piloto[] pilotos;

    public Corrida(Piloto[] pilotos) {
        this.pilotos = pilotos;
    }

    public void simularCorrida() {
        System.out.println("Iniciando a corrida de pole position:");

        for (int volta = 1; volta <= 3; volta++) {
            System.out.println("Volta " + volta);
            for (Piloto piloto : pilotos) {
                int pontos = (int) (Math.random() * 10) + 1;
                piloto.adicionarPontos(pontos);
                System.out.println(piloto.getNome() + " ganhou " + pontos + " pontos nesta volta.");
            }
        }

        System.out.println("Classificação final:");
        ordenarPilotosPorPontos(pilotos);

        for (int i = 0; i < pilotos.length; i++) {
            Piloto piloto = pilotos[i];
            System.out.println((i + 1) + ". " + piloto.getNome() + " - " + piloto.getPontos() + " pontos");
        }
    }

    private void ordenarPilotosPorPontos(Piloto[] pilotos) {
        for (int i = 0; i < pilotos.length - 1; i++) {
            for (int j = 0; j < pilotos.length - 1 - i; j++) {
                if (pilotos[j].getPontos() < pilotos[j + 1].getPontos()) {
                    Piloto temp = pilotos[j];
                    pilotos[j] = pilotos[j + 1];
                    pilotos[j + 1] = temp;
                }
            }
        }
    }
}
