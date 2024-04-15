package Ex02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo
{
    static int tamanhoPopulacao = 25;
    static int tamanhoCromossomo = 15; // Número de objetos disponíveis
    static double capacidadeMaxima = 37.0; // Capacidade máxima do saco do lenhador
    static List<Individuo> populacaoList = new ArrayList<>();
    static List<Objeto> objetosList = new ArrayList<>(tamanhoCromossomo);

    public static void inicializa()
    {
        objetosList.add(new Objeto("Espada Mágica", 2.5, 100.0));
        objetosList.add(new Objeto("Poção de Cura", 0.5, 50.0));
        objetosList.add(new Objeto("Pedra Preciosa", 0.2, 200.0));
        objetosList.add(new Objeto("Escudo de Ouro", 3.0, 150.0));
        objetosList.add(new Objeto("Espada de Aço", 2.5, 50.0));
        objetosList.add(new Objeto("Poção de Cura", 0.2, 30.0));
        objetosList.add(new Objeto("Elmo de Ferro", 1.8, 80.0));
        objetosList.add(new Objeto("Pergaminho de Teleporte", 0.1, 500.0));
        objetosList.add(new Objeto("Gema Preciosa", 0.05, 200.0));
        objetosList.add(new Objeto("Adaga Envenenada", 1.0, 80.0));
        objetosList.add(new Objeto("Anel de Poder", 0.3, 300.0));
        objetosList.add(new Objeto("Amuleto da Sorte", 0.1, 150.0));
        objetosList.add(new Objeto("Lanterna Mágica", 0.8, 120.0));
        objetosList.add(new Objeto("Botas Velozes", 0.6, 180.0));
        objetosList.add(new Objeto("Coroa de Diamante", 0.7, 500.0));


        // Criando população inicial
        Populacao populacao = new Populacao(tamanhoPopulacao, tamanhoCromossomo);
        populacaoList = populacao.getIndividuos();

        // Avaliando a fitness de cada indivíduo
        Fitness.calcularFitness(populacaoList, objetosList, capacidadeMaxima);


        // Mostrando cromossomos e fitness da população inicial
        System.out.println("Cromossomos e fitness da população inicial: ");

        Collections.sort(populacaoList, Collections.reverseOrder());

        for (Individuo individuo : populacaoList) {
            System.out.println(individuo);
        }
    }

    public static void main(String[] args)
    {
        inicializa();
    }
}