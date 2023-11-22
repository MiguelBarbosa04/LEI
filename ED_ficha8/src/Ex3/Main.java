package Ex3;
class Carro implements Comparable<Carro> {
    private String marca;
    private String modelo;
    private int ano;

    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Carro{marca='" + marca + "', modelo='" + modelo + "', ano=" + ano + '}';
    }
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public int compareTo(Carro outroCarro) {
        // Comparar carros com base no ano
        return Integer.compare(this.ano, outroCarro.ano);
    }
}

class ListaLigada<T extends Comparable<T>> {
    private Node<T> inicio;

    static class Node<T> {
        T data;
        Node<T> proximo;

        public Node(T data) {
            this.data = data;
            this.proximo = null;
        }
    }

    public void adicionar(T data) {
        Node<T> novoNode = new Node<>(data);
        if (inicio == null) {
            inicio = novoNode;
        } else {
            Node<T> atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNode;
        }
    }

    public void imprimir() {
        Node<T> atual = inicio;
        while (atual != null) {
            System.out.println(atual.data);
            atual = atual.proximo;
        }
    }

    public void ordenar() {
        inicio = mergeSort(inicio);
    }

    private Node<T> mergeSort(Node<T> inicioLista) {
        if (inicioLista == null || inicioLista.proximo == null) {
            return inicioLista;
        }

        Node<T> meio = encontrarMeio(inicioLista);
        Node<T> metadeDireita = meio.proximo;
        meio.proximo = null;

        Node<T> metadeEsquerdaOrdenada = mergeSort(inicioLista);
        Node<T> metadeDireitaOrdenada = mergeSort(metadeDireita);

        return merge(metadeEsquerdaOrdenada, metadeDireitaOrdenada);
    }

    private Node<T> encontrarMeio(Node<T> inicioLista) {
        if (inicioLista == null) {
            return null;
        }

        Node<T> rapido = inicioLista;
        Node<T> lento = inicioLista;

        while (rapido.proximo != null && rapido.proximo.proximo != null) {
            rapido = rapido.proximo.proximo;
            lento = lento.proximo;
        }

        return lento;
    }

    private Node<T> merge(Node<T> listaEsquerda, Node<T> listaDireita) {
        Node<T> resultado = null;

        if (listaEsquerda == null) {
            return listaDireita;
        }
        if (listaDireita == null) {
            return listaEsquerda;
        }

        if (listaEsquerda.data.compareTo(listaDireita.data) <= 0) {
            resultado = listaEsquerda;
            resultado.proximo = merge(listaEsquerda.proximo, listaDireita);
        } else {
            resultado = listaDireita;
            resultado.proximo = merge(listaEsquerda, listaDireita.proximo);
        }

        return resultado;
    }

    public boolean pesquisaLinear(T alvo) {
        Node<T> atual = inicio;
        while (atual != null) {
            if (atual.data.compareTo(alvo) == 0) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public boolean pesquisaBinaria(T alvo) {
        // Garante que a lista esteja ordenada
        ordenar();
        return pesquisaBinariaRecursiva(inicio, alvo);
    }

    private boolean pesquisaBinariaRecursiva(Node<T> inicioLista, T alvo) {
        if (inicioLista == null) {
            return false;
        }

        Node<T> meio = encontrarMeio(inicioLista);

        if (meio.data.compareTo(alvo) == 0) {
            return true;
        } else if (meio.data.compareTo(alvo) > 0) {
            return pesquisaBinariaRecursiva(inicioLista, alvo);
        } else {
            return pesquisaBinariaRecursiva(meio.proximo, alvo);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ListaLigada<Carro> listaCarros = new ListaLigada<>();
        listaCarros.adicionar(new Carro("Toyota", "Corolla", 2020));
        listaCarros.adicionar(new Carro("Honda", "Civic", 2019));
        listaCarros.adicionar(new Carro("Ford", "Focus", 2021));
        listaCarros.adicionar(new Carro("Chevrolet", "Cruze", 2018));

        System.out.println("Lista de Carros:");
        listaCarros.imprimir();

        Carro alvoCarro = new Carro("Ford", "Focus", 2021);

        System.out.println("\nPesquisa Linear:");
        System.out.println(listaCarros.pesquisaLinear(alvoCarro));

        System.out.println("\nPesquisa Binária:");
        System.out.println(listaCarros.pesquisaBinaria(alvoCarro));
    }
}

