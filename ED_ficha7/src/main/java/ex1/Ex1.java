package ex1;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Método para adicionar um nó ao final da lista ligada
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
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

    private void printListRecursive(Node node) {
        if (node == null) {
            return;
        }

        // Imprimir o elemento atual
        System.out.print(node.data + " ");

        // Chamar recursivamente para o próximo nó
        printListRecursive(node.next);
    }
}

public class Ex1 {
    public static void main(String[] args) {
        // Exemplo de uso
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        System.out.println("Elementos da lista ligada:");
        list.printList();
    }
}
