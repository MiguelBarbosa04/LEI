/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2_ex3;

/**
 *
 * @author Miguel
 * @param <T>
 * @param <U>
 */
public class ProdutoG2<T, U> {

    private Codigo<T, U> codigo;
    private String descricao;
    private ValorM preco;

    public ProdutoG2(Codigo<T, U> codigo, String descricao, ValorM preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Codigo<T, U> getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public ValorM getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "ProdutoG2 {" + "codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + "}";
    }

}
