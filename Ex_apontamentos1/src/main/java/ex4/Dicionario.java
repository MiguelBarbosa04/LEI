/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

import java.util.Arrays;

/*
 *
 * @author Miguel
 */
public class Dicionario<K, V> {

    private K[] chaves;
    private V[] valores;
    private int tamanho;

    public Dicionario(int tamanho) {
        chaves = (K[]) new Object[tamanho];
        valores = (V[]) new Object[tamanho];
        tamanho = 0;
    }

    public void add(K chave, V valor) {
        // Verifica se a chave já existe
        for (int i = 0; i < tamanho; i++) {
            if (chaves[i].equals(chave)) {
                valores[i] = valor; // Atualiza o valor se a chave já existir
                return;
            }
        }

        // Se a chave não existir, adiciona no final dos arrays
        if (tamanho >= chaves.length) {
            aumentarCapacidade();
        }

        chaves[tamanho] = chave;
        valores[tamanho] = valor;
        tamanho++;
    }

    public V get(K chave) {
        for (int i = 0; i < tamanho; i++) {
            if (chaves[i].equals(chave)) {
                return valores[i];
            }
        }
        return null; // Retorna null se a chave não for encontrada
    }

    private void aumentarCapacidade() {
        int novaCapacidade = chaves.length * 2;
        chaves = Arrays.copyOf(chaves, novaCapacidade);
        valores = Arrays.copyOf(valores, novaCapacidade);
    }
}
