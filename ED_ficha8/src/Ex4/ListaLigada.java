package Ex4;

class Node {
    int valor;
    Node proximo;

    public Node(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

public class ListaLigada {
    private Node inicio;

    public ListaLigada() {
        this.inicio = null;
    }

    public void adicionar(int valor) {
        Node novoNode = new Node(valor);
        if (inicio == null) {
            inicio = novoNode;
        } else {
            Node atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNode;
        }
    }

    public void imprimir() {
        Node atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    // Implementação do Selection Sort para Lista Ligada
    public void selectionSort() {
        if (inicio == null) {
            return;
        }

        Node atual = inicio;
        while (atual != null) {
            Node menor = encontrarMenor(atual);
            trocarValores(atual, menor);
            atual = atual.proximo;
        }
    }

    private Node encontrarMenor(Node inicio) {
        Node menor = inicio;
        Node atual = inicio.proximo;

        while (atual != null) {
            if (atual.valor < menor.valor) {
                menor = atual;
            }
            atual = atual.proximo;
        }

        return menor;
    }

    private void trocarValores(Node node1, Node node2) {
        int temp = node1.valor;
        node1.valor = node2.valor;
        node2.valor = temp;
    }

    // Implementação do Insertion Sort para Lista Ligada
    public void insertionSort() {
        if (inicio == null || inicio.proximo == null) {
            return;
        }

        Node ordenado = null;
        Node atual = inicio;

        while (atual != null) {
            Node proximo = atual.proximo;
            ordenado = inserirNaOrdem(ordenado, atual);
            atual = proximo;
        }

        inicio = ordenado;
    }

    private Node inserirNaOrdem(Node inicioOrdenado, Node novoNode) {
        if (inicioOrdenado == null || inicioOrdenado.valor >= novoNode.valor) {
            novoNode.proximo = inicioOrdenado;
            return novoNode;
        }

        Node atual = inicioOrdenado;
        while (atual.proximo != null && atual.proximo.valor < novoNode.valor) {
            atual = atual.proximo;
        }

        novoNode.proximo = atual.proximo;
        atual.proximo = novoNode;

        return inicioOrdenado;
    }

    // Implementação do Bubble Sort para Lista Ligada
    public void bubbleSort() {
        if (inicio == null || inicio.proximo == null) {
            return;
        }

        boolean trocaFeita;
        do {
            trocaFeita = false;
            Node atual = inicio;
            Node anterior = null;

            while (atual.proximo != null) {
                if (atual.valor > atual.proximo.valor) {
                    trocarValores(atual, atual.proximo);
                    trocaFeita = true;
                }

                anterior = atual;
                atual = atual.proximo;
            }
        } while (trocaFeita);
    }

    // Implementação do Quick Sort para Lista Ligada
    public void quickSort() {
        inicio = quickSortRecursivo(inicio);
    }

    private Node quickSortRecursivo(Node inicioLista) {
        if (inicioLista == null || inicioLista.proximo == null) {
            return inicioLista;
        }

        Node pivo = particionar(inicioLista);
        pivo.proximo = quickSortRecursivo(pivo.proximo);

        Node novoInicio = (pivo == inicioLista) ? pivo : inicioLista;
        return novoInicio;
    }

    private Node particionar(Node inicioLista) {
        Node pivo = inicioLista;
        Node atual = inicioLista.proximo;
        Node menorAntesPivo = null;
        Node anterior = null;

        while (atual != null) {
            if (atual.valor < pivo.valor) {
                if (menorAntesPivo == null) {
                    menorAntesPivo = inicioLista;
                } else {
                    menorAntesPivo = menorAntesPivo.proximo;
                }

                trocarValores(atual, menorAntesPivo);
            }

            anterior = atual;
            atual = atual.proximo;
        }

        trocarValores(pivo, menorAntesPivo);
        return (menorAntesPivo == null) ? pivo : menorAntesPivo;
    }

    // Implementação do Merge Sort para Lista Ligada
    public void mergeSort() {
        inicio = mergeSortRecursivo(inicio);
    }

    private Node mergeSortRecursivo(Node inicioLista) {
        if (inicioLista == null || inicioLista.proximo == null) {
            return inicioLista;
        }

        Node meio = encontrarMeio(inicioLista);
        Node metadeDireita = meio.proximo;
        meio.proximo = null;

        Node metadeEsquerdaOrdenada = mergeSortRecursivo(inicioLista);
        Node metadeDireitaOrdenada = mergeSortRecursivo(metadeDireita);

        return merge(metadeEsquerdaOrdenada, metadeDireitaOrdenada);
    }

    private Node encontrarMeio(Node inicioLista) {
        if (inicioLista == null) {
            return null;
        }

        Node rapido = inicioLista;
        Node lento = inicioLista;

        while (rapido.proximo != null && rapido.proximo.proximo != null) {
            rapido = rapido.proximo.proximo;
            lento = lento.proximo;
        }

        return lento;
    }

    private Node merge(Node listaEsquerda, Node listaDireita) {
        Node resultado = null;

        if (listaEsquerda == null) {
            return listaDireita;
        }
        if (listaDireita == null) {
            return listaEsquerda;
        }

        if (listaEsquerda.valor <= listaDireita.valor) {
            resultado = listaEsquerda;
            resultado.proximo = merge(listaEsquerda.proximo, listaDireita);
        } else {
            resultado = listaDireita;
            resultado.proximo = merge(listaEsquerda, listaDireita.proximo);
        }

        return resultado;
    }

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        lista.adicionar(5);
        lista.adicionar(2);
        lista.adicionar(8);
        lista.adicionar(1);
        lista.adicionar(7);

        System.out.println("Lista Original:");
        lista.imprimir();

        // Testar os algoritmos de ordenação para a lista ligada
        ListaLigada listaSelectionSort = new ListaLigada();
        listaSelectionSort.adicionar(5);
        listaSelectionSort.adicionar(2);
        listaSelectionSort.adicionar(8);
        listaSelectionSort.adicionar(1);
        listaSelectionSort.adicionar(7);
        listaSelectionSort.selectionSort();
        System.out.println("Selection Sort:");
        listaSelectionSort.imprimir();

        ListaLigada listaInsertionSort = new ListaLigada();
        listaInsertionSort.adicionar(5);
        listaInsertionSort.adicionar(2);
        listaInsertionSort.adicionar(8);
        listaInsertionSort.adicionar(1);
        listaInsertionSort.adicionar(7);
        listaInsertionSort.insertionSort();
        System.out.println("Insertion Sort:");
        listaInsertionSort.imprimir();

        ListaLigada listaBubbleSort = new ListaLigada();
        listaBubbleSort.adicionar(5);
        listaBubbleSort.adicionar(2);
        listaBubbleSort.adicionar(8);
        listaBubbleSort.adicionar(1);
        listaBubbleSort.adicionar(7);
        listaBubbleSort.bubbleSort();
        System.out.println("Bubble Sort:");
        listaBubbleSort.imprimir();

        ListaLigada listaQuickSort = new ListaLigada();
        listaQuickSort.adicionar(5);
        listaQuickSort.adicionar(2);
        listaQuickSort.adicionar(8);
        listaQuickSort.adicionar(1);
        listaQuickSort.adicionar(7);
        listaQuickSort.quickSort();
        System.out.println("Quick Sort:");
        listaQuickSort.imprimir();

        ListaLigada listaMergeSort = new ListaLigada();
        listaMergeSort.adicionar(5);
        listaMergeSort.adicionar(2);
        listaMergeSort.adicionar(8);
        listaMergeSort.adicionar(1);
        listaMergeSort.adicionar(7);
        listaMergeSort.mergeSort();
        System.out.println("Merge Sort:");
        listaMergeSort.imprimir();
    }
}

  // Parte 2 ex 1 -   Qual é o algoritmo de pesquisa mais eficiente, a pesquisa binária ou a pesquisa linear?
//A eficiência de um algoritmo de pesquisa depende do contexto em que é aplicado. A pesquisa binária e a pesquisa linear são métodos de busca diferentes, e cada um tem suas vantagens e limitações.
//
//Pesquisa Linear:
//
//Complexidade de Tempo: A pesquisa linear percorre os elementos da lista sequencialmente até encontrar o elemento desejado ou alcançar o final da lista. A complexidade de tempo é O(n), onde "n" é o número de elementos na lista.
//Aplicação: É eficaz quando a lista não está ordenada ou quando a posição do item na lista é desconhecida. Funciona bem para listas pequenas.
//Pesquisa Binária:
//
//Complexidade de Tempo: A pesquisa binária é aplicável apenas em listas ordenadas. Ela divide repetidamente a lista ao meio e verifica se o elemento desejado está na metade superior ou inferior. A complexidade de tempo é O(log n), onde "n" é o número de elementos na lista.
//Aplicação: É altamente eficiente para listas ordenadas, especialmente quando a lista é grande. No entanto, requer que a lista esteja ordenada.

// Parte 2 ex 2 - Qual é o algoritmo de ordenação mais eficiente, o QuickSort ou o Merge Sort?
//A eficiência de algoritmos de ordenação pode variar dependendo do contexto específico, do tamanho dos dados e de outras características do problema. Vamos comparar o QuickSort e o Merge Sort em termos gerais:
//
//QuickSort:
//
//Complexidade de Tempo Média: O QuickSort geralmente tem uma boa performance em média. Sua complexidade de tempo média é O(n log n).
//Pior Caso: No entanto, o pior caso do QuickSort pode ser problemático, especialmente se a escolha do pivô não for eficiente. O pior caso é O(n^2), mas escolhas de pivô inteligentes e implementações cuidadosas podem mitigar esse problema.
//Espaço: O QuickSort é in-place, o que significa que geralmente requer menos espaço adicional do que o Merge Sort.
//Merge Sort:
//
//Complexidade de Tempo: O Merge Sort tem uma complexidade de tempo constante O(n log n) em todos os casos, incluindo o pior caso.
//Espaço: No entanto, o Merge Sort requer espaço adicional para armazenar os elementos ordenados temporariamente. Isso pode ser uma desvantagem em termos de uso de memória, especialmente para conjuntos de dados grandes.