package Ex03;

import java.util.ArrayList;
import java.util.List;

public class Turma
{
    private int id;
    private int tamanho;


    public Turma(int id, int tamanho)
    {
        this.id = id;
        this.tamanho = tamanho;
    }


    // Método para obter uma lista de turmas disponíveis (exemplo)
    public static List<Turma> obterTurmasDisponiveis()
    {
        List<Turma> turmas = new ArrayList<>();

        // Adicione as turmas disponíveis à lista
        turmas.add(new Turma(1, 20));
        turmas.add(new Turma(2, 100));
        turmas.add(new Turma(3, 50));

        return turmas;
    }


    //region GETTERS E SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    //endregion


    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", tamanho=" + tamanho +
                '}';
    }
}