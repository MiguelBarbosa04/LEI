package ex2;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Método para adicionar um nó ao final da lista duplamente ligada
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Método recursivo para imprimir os elementos da lista ligada a partir do início
    public void printListFromHead() {
        printListFromHeadRecursive(head);
    }

    private void printListFromHeadRecursive(Node node) {
        if (node == null) {
            return;
        }

        // Imprimir o elemento atual
        System.out.print(node.data + " ");

        // Chamar recursivamente para o próximo nó
        printListFromHeadRecursive(node.next);
    }

    // Método recursivo para imprimir os elementos da lista ligada a partir do final
    public void printListFromTail() {
        printListFromTailRecursive(tail);
    }

    private void printListFromTailRecursive(Node node) {
        if (node == null) {
            return;
        }

        // Imprimir o elemento atual
        System.out.print(node.data + " ");

        // Chamar recursivamente para o nó anterior
        printListFromTailRecursive(node.prev);
    }
}

public class Ex2 {
    public static void main(String[] args) {
        // Exemplo de uso
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        System.out.println("Elementos da lista duplamente ligada a partir do início:");
        list.printListFromHead();

        System.out.println("\nElementos da lista duplamente ligada a partir do final:");
        list.printListFromTail();
    }
}
