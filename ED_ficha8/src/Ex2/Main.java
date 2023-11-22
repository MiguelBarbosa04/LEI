package Ex2;

class Carro implements Comparable<Carro> {
    private String modelo;
    private int ano;

    public Carro(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public int compareTo(Carro outroCarro) {
        // Comparar por modelo e ano para ordenação
        int comparacaoModelo = this.modelo.compareTo(outroCarro.modelo);
        if (comparacaoModelo == 0) {
            return Integer.compare(this.ano, outroCarro.ano);
        }
        return comparacaoModelo;
    }
}

class ListaLigada<T extends Comparable<T>> {
    private Nodo<T> primeiro;

    public void adicionar(T elemento) {
        Nodo<T> novoNodo = new Nodo<>(elemento);
        novoNodo.setProximo(primeiro);
        primeiro = novoNodo;
    }

    public void ordenar() {
        // Implemente a ordenação da lista ligada (pode usar algum algoritmo de ordenação)
    }

    public boolean pesquisaLinear(T alvo) {
        Nodo<T> atual = primeiro;
        while (atual != null) {
            if (atual.getElemento().equals(alvo)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }
    public boolean pesquisaBinaria(T alvo) {
        // Antes de usar pesquisa binária, certifique-se de que a lista está ordenada
        ordenar();
        // Agora, aplique pesquisa binária
        return pesquisaBinariaRecursiva(alvo, primeiro, null);
    }

    private boolean pesquisaBinariaRecursiva(T alvo, Nodo<T> inicio, Nodo<T> fim) {
        if (inicio == null || inicio.getElemento().compareTo(alvo) > 0) {
            return false;
        }

        Nodo<T> meio = encontrarMeio(inicio, fim);

        if (meio.getElemento().equals(alvo)) {
            return true;
        } else if (meio.getElemento().compareTo(alvo) > 0) {
            return pesquisaBinariaRecursiva(alvo, inicio, meio.getAnterior());
        } else {
            return pesquisaBinariaRecursiva(alvo, meio.getProximo(), fim);
        }
    }

    private Nodo<T> encontrarMeio(Nodo<T> inicio, Nodo<T> fim) {
        if (inicio == null) {
            return null;
        }

        Nodo<T> rapido = inicio;
        Nodo<T> lento = inicio;
        Nodo<T> anterior = null;

        while (rapido != null && rapido != fim && rapido.getProximo() != fim) {
            rapido = rapido.getProximo().getProximo();
            anterior = lento;
            lento = lento.getProximo();
        }

        return anterior != null ? lento : inicio;
    }


    class Nodo<T> {
        private T elemento;
        private Nodo<T> proximo;
        private Nodo<T> anterior; // Adiciona uma referência para o nodo anterior

        public Nodo(T elemento) {
            this.elemento = elemento;
        }

        public T getElemento() {
            return elemento;
        }

        public Nodo<T> getProximo() {
            return proximo;
        }

        public void setProximo(Nodo<T> proximo) {
            this.proximo = proximo;
        }

        public Nodo<T> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<T> anterior) {
            this.anterior = anterior;
        }
    }

}


class Nodo<T> {
    private T elemento;
    private Nodo<T> proximo;

    public Nodo(T elemento) {
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }
}

public class Main {
    public static void main(String[] args) {
        // Exemplo de uso
        ListaLigada<Carro> listaCarros = new ListaLigada<>();

        listaCarros.adicionar(new Carro("Modelo A", 2020));
        listaCarros.adicionar(new Carro("Modelo B", 2019));
        listaCarros.adicionar(new Carro("Modelo C", 2021));

        // Pesquisa Linear
        System.out.println("Pesquisa Linear: " + listaCarros.pesquisaLinear(new Carro("Modelo B", 2019)));

        // Pesquisa Binária
        System.out.println("Pesquisa Binária: " + listaCarros.pesquisaBinaria(new Carro("Modelo C", 2021)));
    }
}
