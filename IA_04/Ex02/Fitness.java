package Ex02;

import java.util.List;

public class Fitness
{

    /**
     *
     * @param populacao objetos na mochila
     * @param objetos da gruta
     * @param capacidadeMaxima mochila
     */
    public static void calcularFitness(List<Individuo> populacao, List<Objeto> objetos, double capacidadeMaxima)
    {
        double valorMaximoFitness = 0.0;
        double porcentagemFitness = 0.0;

        // Calcular o valor máximo de fitness somando os valores dos itens disponíveis na gruta
        for (Objeto objeto : objetos)
        {
            valorMaximoFitness += objeto.getValor();
        }

        // Para cada indivíduo na população
        for(Individuo individuo : populacao)
        {
            double valorTotal = 0.0;
            double pesoTotal = 0.0;

            List<Boolean> cromossomo = individuo.getCromossomo();

            // Iterar sobre o cromossomo do indivíduo (representando os itens)
            for (int i = 0; i < cromossomo.size(); i++)
            {
                if (cromossomo.get(i)) // Se o item está presente no cromossomo, calcular o peso e valor total
                {
                    Objeto objeto = objetos.get(i);
                    valorTotal += objeto.getValor();
                    pesoTotal += objeto.getPeso();
                }
            }

            // Se o peso total exceder o limite de 37 kg, o fitness é definido como 0
            if (pesoTotal > capacidadeMaxima)
            {
                individuo.setFitness(0); // Penalizar se o peso total exceder 37 kg
            }
            else
            {
                individuo.setFitness(valorTotal); // Caso contrário, o fitness é definido como o valor total dos itens
            }

            porcentagemFitness = (individuo.getFitness() / valorMaximoFitness) * 100;
            individuo.setFitnessPorcentage(porcentagemFitness);
        }
    }
}