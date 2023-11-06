/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import ex1.*;

/**
 *
 * @author Miguel
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CircularArrayQueue<String> queue = new CircularArrayQueue<>(5);

        queue.enqueue("Cliente 1");
        queue.enqueue("Cliente 2");
        queue.enqueue("Cliente 3");

        System.out.println("Tamanho da fila: " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println("Atendendo " + queue.dequeue());
        }

        queue.enqueue("Cliente 4");
        queue.enqueue("Cliente 5");

        System.out.println("Tamanho da fila: " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println("Atendendo " + queue.dequeue());
        }
    }

}
/**
 * Porquê que usamos uma implementação em array circular? Porque não um array
 * normal como numa stack?
 *
 * Uma implementação de fila baseada em array circular é uma escolha eficiente
 * em situações em que a fila precisa ser tratada como uma estrutura de dados
 * circular e onde você deseja evitar o redimensionamento frequente do array.
 * Existem algumas razões para escolher uma implementação de fila circular em
 * vez de um array linear (como uma pilha) em determinados cenários:
 *
 * Uso eficiente de espaço: Em uma fila circular, o espaço é reutilizado de
 * forma eficiente. Quando a fila atinge sua capacidade máxima e você remove
 * elementos do início, o espaço anteriormente ocupado por esses elementos pode
 * ser reutilizado para armazenar novos elementos no final da fila. Isso evita o
 * desperdício de espaço.
 *
 * Evita realocação de memória: Em implementações de fila baseadas em arrays
 * lineares, quando o array atinge sua capacidade máxima, pode ser necessário
 * alocar um novo array maior e copiar os elementos antigos para o novo array.
 * Isso pode ser custoso em termos de tempo e recursos. Em uma fila circular,
 * essa realocação não é necessária.
 *
 * Melhor desempenho para algumas operações: Para operações como enfileirar e
 * desenfileirar, uma fila circular pode ter melhor desempenho em comparação com
 * uma pilha baseada em array linear, que envolve deslocar todos os elementos
 * para preencher o espaço deixado pela remoção de elementos.
 *
 * Modelagem de estruturas cíclicas: Em alguns casos, as filas precisam modelar
 * comportamento cíclico, como em sistemas de agendamento ou simulações. Nesses
 * casos, uma fila circular é mais adequada.
 *
 * No entanto, a escolha entre uma fila circular e uma pilha (ou array linear)
 * depende das necessidades específicas do seu projeto. Se a ordem de chegada e
 * saída for estritamente linear e você não precisar reutilizar espaço, uma
 * pilha ou uma fila baseada em array linear podem ser mais apropriadas. A
 * escolha deve ser baseada no contexto e nos requisitos do problema que você
 * está resolvendo.
 *
 *
 *
 * Qual o Big O para a operação dequeue nas diferentes implementações de uma
 * Queue: array, array circular e lista ligada?
 *
 *
 * A complexidade de tempo (Big O) para a operação dequeue em diferentes
 * implementações de uma fila (Queue) varia dependendo da estrutura de dados
 * utilizada. Aqui estão as complexidades de tempo típicas para dequeue em
 * diferentes implementações:
 *
 * Array-Based Queue (Fila baseada em array):
 *
 * Complexidade de tempo para dequeue: O(1) Em uma fila baseada em array, a
 * operação dequeue tem uma complexidade de tempo constante, desde que a
 * implementação use um ponteiro (ou índice) para rastrear o elemento da frente
 * da fila. Isso ocorre porque a remoção de um elemento na frente envolve
 * simplesmente mover o ponteiro para o próximo elemento na fila. Circular
 * Array-Based Queue (Fila baseada em array circular):
 *
 * Complexidade de tempo para dequeue: O(1) Assim como na fila baseada em array,
 * a operação dequeue em uma fila circular tem uma complexidade de tempo
 * constante, desde que o ponteiro da frente e os cálculos de índice sejam
 * usados para rastrear a posição do elemento da frente. Não há necessidade de
 * realocação de elementos. Linked Queue (Fila encadeada):
 *
 * Complexidade de tempo para dequeue: O(1) Em uma fila encadeada, a operação
 * dequeue também tem uma complexidade de tempo constante. A remoção do elemento
 * da frente envolve simplesmente atualizar o ponteiro da frente para apontar
 * para o próximo elemento na fila. Como não há realocação de elementos, a
 * operação dequeue é eficiente. Em resumo, a operação dequeue nas
 * implementações de fila mencionadas (fila baseada em array, fila baseada em
 * array circular e fila encadeada) geralmente tem uma complexidade de tempo
 * constante O(1), tornando-as eficientes para a remoção do elemento da frente
 * da fila. A escolha entre essas implementações depende das necessidades
 * específicas do seu projeto e das características do problema que você está
 * resolvendo.
 */
