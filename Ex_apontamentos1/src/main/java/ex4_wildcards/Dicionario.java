/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4_wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 * @param <K>
 * @param <V>
 */
public class Dicionario<K, V> {

    private List<K> chaves;
    private List<V> valores;

    public Dicionario() {
        chaves = new ArrayList<>();
        valores = new ArrayList<>();
    }

    public void add(K chave, V valor) {
        chaves.add(chave);
        valores.add(valor);
    }

    public V get(K chave) {
        for (int i = 0; i < chaves.size(); i++) {
            if (chaves.get(i).equals(chave)) {
                return valores.get(i);
            }
        }
        return null; // Chave não encontrada.
    }
}
