package Ex02;


public class Objeto
{
    private double peso;
    private double valor;
    private String nome;

    public Objeto( String nome, double peso, double valor)
    {
        this.peso = peso;
        this.valor = valor;
        this.nome = nome;
    }

    public double getPeso()
    {
        return peso;
    }

    public double getValor()
    {
        return valor;
    }

    public void setPeso(double peso)
    {
        this.peso = peso;
    }

    public void setValor(double valor)
    {
        this.valor = valor;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
}