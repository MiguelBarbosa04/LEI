package Ex1;

public class Carro {
    private String modelo;
    private String marca;
    private int ano;

    // Construtor
    public Carro(String modelo, String marca, int ano) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
    }

    // Getters
    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    public static Carro pesquisaLinear(Carro[] carros, String modelo) {
        for (Carro carro : carros) {
            if (carro.getModelo().equals(modelo)) {
                return carro;
            }
        }
        return null; // Retorna null se o carro não for encontrado
    }

    public static Carro pesquisaBinaria(Carro[] carros, String modelo) {
        // Antes de usar a pesquisa binária, o array deve estar ordenado
        ordenaPorModelo(carros);

        int inicio = 0;
        int fim = carros.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            String modeloNoMeio = carros[meio].getModelo();

            if (modeloNoMeio.equals(modelo)) {
                return carros[meio];
            } else if (modeloNoMeio.compareTo(modelo) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return null; // Retorna null se o carro não for encontrado
    }

    // Método auxiliar para ordenar o array por modelo (necessário para pesquisa binária)
    private static void ordenaPorModelo(Carro[] carros) {
        for (int i = 0; i < carros.length - 1; i++) {
            for (int j = 0; j < carros.length - i - 1; j++) {
                if (carros[j].getModelo().compareTo(carros[j + 1].getModelo()) > 0) {
                    // Troca os carros se estiverem fora de ordem
                    Carro temp = carros[j];
                    carros[j] = carros[j + 1];
                    carros[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso
        Carro[] carros = {
                new Carro("Civic", "Honda", 2022),
                new Carro("Corolla", "Toyota", 2021),
                new Carro("Golf", "Volkswagen", 2023),
                new Carro("Fusion", "Ford", 2022)
        };

        // Pesquisa linear
        Carro carroEncontradoLinear = pesquisaLinear(carros, "Golf");
        System.out.println("Pesquisa Linear: " + (carroEncontradoLinear != null ? carroEncontradoLinear.getMarca() : "Carro não encontrado"));

        // Pesquisa binária
        Carro carroEncontradoBinaria = pesquisaBinaria(carros, "Corolla");
        System.out.println("Pesquisa Binária: " + (carroEncontradoBinaria != null ? carroEncontradoBinaria.getMarca() : "Carro não encontrado"));
    }
}
