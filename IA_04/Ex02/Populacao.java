package Ex02;

import java.util.ArrayList;
import java.util.List;

public class Populacao
{
    private List<Individuo> individuos;

    public Populacao(int tamanhoPopulacao, int tamanhoCromossomo)
    {
        this.individuos = new ArrayList<>();

        for (int i = 0; i < tamanhoPopulacao; i++)
        {
            this.individuos.add(new Individuo(tamanhoCromossomo));
        }
    }

    public List<Individuo> getIndividuos()
    {
        return individuos;
    }
}