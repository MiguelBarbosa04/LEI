package P2ex4;
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

    // Método recursivo para substituir todas as ocorrências de existingElement por newElement
    public void replace(T existingElement, T newElement) {
        replaceRecursive(head, existingElement, newElement);
    }

    private void replaceRecursive(Node<T> node, T existingElement, T newElement) {
        if (node == null) {
            return;
        }

        // Substituir o existingElement pelo newElement se forem iguais
        if (node.data.equals(existingElement)) {
            node.data = newElement;
        }

        // Chamar recursivamente para o próximo nó
        replaceRecursive(node.next, existingElement, newElement);
    }
}

public class main {
    public static void main(String[] args) {
        // Exemplo de uso
        LinkedList<String> list = new LinkedList<>();
        list.append("apple");
        list.append("banana");
        list.append("orange");
        list.append("apple");

        System.out.println("Lista original:");
        list.printList();

        list.replace("apple", "grape");

        System.out.println("\nLista após a substituição:");
        list.printList();
    }
}
