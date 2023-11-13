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
public class Piloto {

    private String nome;
    private int pontos;

    public Piloto(String nome) {
        this.nome = nome;
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }
}
