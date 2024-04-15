package Ex03;


import java.util.List;


public class Horario implements Comparable<Horario>
{
    private List<Aula> aulas;
    private double fitness;


    public Horario()
    {

    }

    public Horario(List<Aula> aulas) {
        this.aulas = aulas;
    }


    //region GETTERS E SETTERS

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }


    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    //endregion

    @Override
    public String toString() {
        return "Horario{" +
                "aulas=" + aulas +
                ", fitness=" + fitness +
                '}';
    }

    @Override
    public int compareTo(Horario o)
    {
        // Comparação para ordenar em ordem decrescente de fitness
        return Double.compare(this.getFitness(), o.getFitness());
    }
}