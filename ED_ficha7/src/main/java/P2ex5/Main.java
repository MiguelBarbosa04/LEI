package P2ex5;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    // Método para adicionar um nó ao final da lista ligada
    public void append(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    // Método recursivo para imprimir os elementos da lista ligada
    public void printList() {
        printListRecursive(head);
    }

    private void printListRecursive(Node<T> node) {
        if (node == null) {
            return;
        }

        // Imprimir o elemento atual
        System.out.print(node.data + " ");

        // Chamar recursivamente para o próximo nó
        printListRecursive(node.next);
    }

    // Método recursivo para inverter a ordem dos elementos na lista
    public void reverse() {
        head = reverseRecursive(head);
    }

    private Node<T> reverseRecursive(Node<T> current) {
        // Caso base: a lista está vazia ou contém apenas um nó
        if (current == null || current.next == null) {
            return current;
        }

        // Chamar recursivamente para inverter o restante da lista
        Node<T> restReversed = reverseRecursive(current.next);

        // Ajustar os ponteiros para inverter a ordem
        current.next.next = current;
        current.next = null;

        return restReversed;
    }
}

public class Main {
    public static void main(String[] args) {
        // Exemplo de uso
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        System.out.println("Lista original:");
        list.printList();

        // Inverter a ordem dos elementos
        list.reverse();

        System.out.println("\nLista invertida:");
        list.printList();
    }
}
