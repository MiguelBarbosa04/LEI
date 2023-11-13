/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author Miguel
 */
public class NewMain {
    public static void main(String[] args) {
        DoubleLinkedOrderedList<Integer> orderedList = new DoubleLinkedOrderedList<>();

        orderedList.add(10);
        orderedList.add(5);
        orderedList.add(20);

        System.out.print("Ordered List: ");
        orderedList.displayList();

        int first = orderedList.removeFirst();
        int last = orderedList.removeLast();

        System.out.println("Removed first: " + first);
        System.out.println("Removed last: " + last);

        System.out.print("Ordered List after removal: ");
        orderedList.displayList();
    }
}

//Nas implementações anteriores dos exercícios, as listas eram declaradas com elementos comparáveis, e a comparação de elementos era realizada usando o método compareTo para determinar a ordem dos elementos na lista. 
//Quando elementos não comparáveis eram adicionados, isso poderia resultar em erros em tempo de execução, como uma exceção ClassCastException ao tentar chamar o método compareTo em tipos que não eram comparáveis.
//
//Para lidar com elementos não comparáveis em uma lista ordenada, você precisaria tomar algumas medidas adicionais, como:
//
//Requerer que os elementos implementem uma interface de comparação, como Comparable, ou fornecer um Comparator personalizado para a lista, permitindo que a lista seja capaz de comparar os elementos.
//
//Garantir que os elementos a serem adicionados à lista sejam comparáveis ou usem um Comparator personalizado para inserir os elementos na ordem desejada.
//
//Lidar com elementos não comparáveis de maneira adequada, seja por meio de manipulação de exceções ou outras estratégias de tratamento.
//
//Se você tentar adicionar elementos não comparáveis a uma lista que depende da comparação (como uma lista ordenada), isso pode levar a erros em tempo de execução ou comportamentos inesperados, a menos que você tome medidas para tratar esses casos adequadamente. 
//Certifique-se de que os elementos que você adiciona a uma lista ordenada sejam comparáveis de alguma forma, seja implementando a interface Comparable ou usando um Comparator.
