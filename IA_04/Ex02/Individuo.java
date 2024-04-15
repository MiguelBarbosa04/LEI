package Ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Individuo implements Comparable<Individuo>
{
    private List<Boolean> cromossomo; // Representação binária dos objetos na mochila
    private double fitness;
    private double fitnessPorcentage;

    public Individuo(int tamanhoCromossomo)
    {
        this.cromossomo = new ArrayList<>(tamanhoCromossomo);
        Random rand = new Random();

        for (int i = 0; i < tamanhoCromossomo; i++)
        {
            this.cromossomo.add(rand.nextBoolean());
        }
    }

    public List<Boolean> getCromossomo() {
        return cromossomo;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public void setCromossomo(List<Boolean> cromossomo) {
        this.cromossomo = cromossomo;
    }

    public double getFitnessPorcentage() {
        return fitnessPorcentage;
    }

    public void setFitnessPorcentage(double fitnessPorcentage) {
        this.fitnessPorcentage = fitnessPorcentage;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Individuo o)
    {
        // Comparação para ordenar em ordem decrescente de fitness
        return Double.compare(this.getFitness(), o.getFitness());
    }


    @Override
    public String toString() {
        return "Cromossomo: " + cromossomo + ", Fitness: " + fitness + " ("+String.format("%.2f", fitnessPorcentage)+"%)";
    }
}