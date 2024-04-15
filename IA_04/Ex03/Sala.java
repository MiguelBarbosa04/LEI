package Ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sala
{
    private int id;
    private int capacidade;
    private List<Aula> aulasAgendadas;


    public Sala(int id, int capacidade)
    {
        this.id = id;
        this.capacidade = capacidade;
        this.aulasAgendadas = new ArrayList<>();
    }


    public static List<Sala> obterSalasDisponiveis(BlocoHoras blocoAtual)
    {
        List<Sala> salasDisponiveis = new ArrayList<>();
        List<Sala> todasSalas = obterTodasSalasDisponiveis();

        // Verifique a disponibilidade de cada sala para o bloco de horas atual
        for (Sala sala : todasSalas)
        {
            if (salaEstaDisponivelParaBloco(sala, blocoAtual))
            {
                salasDisponiveis.add(sala);
            }
        }

        return salasDisponiveis;
    }


    public static boolean salaEstaDisponivelParaBloco(Sala sala, BlocoHoras bloco)
    {
        List<Aula> aulasAgendadas = sala.getAulasAgendadas();

        // Verifique se há alguma sobreposição com o bloco de horas atual
        for (Aula aula : aulasAgendadas)
        {
            if (aula.getBlocoHoras().equals(bloco))
            {
                // Se houver uma aula já agendada para o mesmo bloco de horas, a sala não está disponível
                return false;
            }
        }

        return true; // Retorne true se a sala estiver disponível, caso contrário false
    }

    public static List<Sala> obterTodasSalasDisponiveis()
    {
        List<Sala> todasSalas = new ArrayList<>();

        // Adicione as salas disponíveis à lista
        todasSalas.add(new Sala(1, 30)); // Exemplo: Sala com capacidade para 30 alunos
        todasSalas.add(new Sala(2, 25)); // Exemplo: Sala com capacidade para 25 alunos
        todasSalas.add(new Sala(3, 50));
        todasSalas.add(new Sala(4, 10));

        return todasSalas;
    }

    public static Sala obterSalaAleatoria(List<Sala> salasDisponiveis)
    {
        Random random = new Random();
        int index = random.nextInt(salasDisponiveis.size());

        return salasDisponiveis.get(index);
    }


    //region GETTERS E SETTERS


    public List<Aula> getAulasAgendadas() {
        return aulasAgendadas;
    }

    public void setAulasAgendadas(List<Aula> aulasAgendadas) {
        this.aulasAgendadas = aulasAgendadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    //endregion


    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", capacidade=" + capacidade +
                ", aulasAgendadas=" + aulasAgendadas +
                '}';
    }
}