/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2_ex3;

/**
 *
 * @author Miguel
 */
public class ValorM {

    public double valor;

    public ValorM(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Custa: " + valor;
    }

}
