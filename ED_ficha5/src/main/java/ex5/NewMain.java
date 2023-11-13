/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

/**
 *
 * @author Miguel
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoubleLinkedUnorderedList<Integer> list = new DoubleLinkedUnorderedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("List: ");
        list.display();

        System.out.println("Contains 3? " + list.contains(3));
        System.out.println("Contains 5? " + list.contains(5));

        list.remove(2);
        System.out.println("After removing 2: ");
        list.display();
    }

}
/*ex1 Parte 2 Porquê que não existe uma método add(Element) na interface ListADT? -> A interface ListADT não possui um método add(Element) porque a nomenclatura exata de métodos pode variar entre diferentes linguagens de programação e estruturas de dados. 
Em Java, a interface List (parte do pacote java.util) é uma das interfaces mais comuns para representar listas e possui um método add para adicionar elementos a uma lista.

No entanto, em outras linguagens de programação ou em estruturas de dados personalizadas, a nomenclatura dos métodos pode variar. Por exemplo, em algumas implementações de estruturas de dados de lista, você pode encontrar métodos com nomes diferentes, como append, insert, push, etc. 
O nome do método é uma decisão de design da API e pode variar de acordo com a preferência dos desenvolvedores ou as convenções adotadas em uma linguagem ou estrutura específica.

Portanto, a ausência de um método add(Element) na interface ListADT pode ser uma escolha específica do design dessa interface e não impede que você crie uma implementação que inclua um método add com a funcionalidade desejada.
A nomenclatura dos métodos em uma interface é flexível e pode ser adaptada às necessidades de uma implementação específica.


ex2 Parte 2 Dada a versatilidade de uma lista porquê que não é sempre a escolhida em vez de uma Stack ou de uma Queue? -> Listas, stacks (pilhas) e queues (filas) são todas estruturas de dados úteis, mas são projetadas para diferentes finalidades e têm vantagens e desvantagens específicas.
A escolha entre elas depende das necessidades do problema que você está resolvendo. 
Aqui estão algumas considerações sobre quando usar cada uma:

Listas:

Versatilidade: Listas são estruturas de dados versáteis que podem ser usadas para várias finalidades, como armazenar uma coleção de elementos.
Acesso arbitrário: Listas permitem o acesso arbitrário a elementos por meio de índices.
Inserções e remoções: Listas podem ser usadas para inserir e remover elementos em qualquer posição.
Usadas quando a ordem dos elementos e o acesso arbitrário são importantes.
Stacks (Pilhas):

LIFO (Last-In-First-Out): Stacks seguem o princípio "último a entrar, primeiro a sair", o que as torna úteis para rastrear o histórico de ações, como em um mecanismo de desfazer (undo).
Operações limitadas: As operações principais em uma pilha são "push" (inserir) e "pop" (remover o elemento mais recente).
Usadas quando a ordem inversa dos elementos é importante e quando você precisa realizar operações de desempilhamento.
Queues (Filas):

FIFO (First-In-First-Out): Filas seguem o princípio "primeiro a entrar, primeiro a sair", o que as torna úteis para situações em que a ordem de chegada dos elementos é importante.
Operações limitadas: As operações principais em uma fila são "enqueue" (inserir) e "dequeue" (remover o elemento mais antigo).
Usadas quando você precisa tratar elementos na ordem em que foram inseridos, como em filas de tarefas ou pedidos.
A escolha entre lista, stack e queue depende do contexto e das necessidades do problema que você está resolvendo. 
Em muitos casos, a versatilidade de uma lista a torna uma escolha sólida, especialmente quando você precisa de acesso arbitrário aos elementos e a ordem dos elementos não segue estritamente o modelo LIFO ou FIFO. No entanto, se a ordem de chegada ou a ordem inversa for fundamental para sua aplicação, uma stack ou uma queue podem ser mais apropriadas.
*/
