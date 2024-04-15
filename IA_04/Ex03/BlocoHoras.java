package Ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BlocoHoras
{
    private int id;
    private double horaInicio;
    private double horaFim;


    public BlocoHoras(int id, double horaInicio, double horaFim) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public static List<BlocoHoras> obterBlocosDisponiveis()
    {
        List<BlocoHoras> blocosDisponiveis = new ArrayList<>();
        List<BlocoHoras> todosBlocos = obterTodosBlocosDisponiveis();

        for (BlocoHoras bloco : todosBlocos)
        {
            if (blocoEstaDisponivel(bloco))
            {
                blocosDisponiveis.add(bloco);
            }
        }

        return blocosDisponiveis;
    }

    public static boolean blocoEstaDisponivel(BlocoHoras bloco)
    {
        // Obtenha todas as aulas agendadas
        List<Aula> todasAulasAgendadas = Aula.obterTodasAulasAgendadas(); // Suponha que você tenha uma maneira de obter todas as aulas agendadas

        // Verifique se há alguma aula agendada para o bloco de horas fornecido
        for (Aula aula : todasAulasAgendadas)
        {
            if (aula.getBlocoHoras().equals(bloco))
            {
                // Se houver uma aula agendada para este bloco, o bloco não está disponível
                return false;
            }
        }

        // Se nenhum conflito for encontrado, o bloco está disponível
        return true;
    }

    public static List<BlocoHoras> obterTodosBlocosDisponiveis()
    {
        List<BlocoHoras> todosBlocos = new ArrayList<>();

        todosBlocos.add(new BlocoHoras(1, 08.00,10.00));
        todosBlocos.add(new BlocoHoras(2, 10.00,12.00));
        todosBlocos.add(new BlocoHoras(3, 10.00,12.00));
        todosBlocos.add(new BlocoHoras(4, 12.00,14.00));
        todosBlocos.add(new BlocoHoras(5, 14.00,16.00));
        todosBlocos.add(new BlocoHoras(6, 16.00,18.00));

        return todosBlocos;
    }

    public static BlocoHoras obterBlocoHorasAleatorio(List<BlocoHoras> blocosDisponiveis)
    {
        Random random = new Random();
        int index = random.nextInt(blocosDisponiveis.size());

        return blocosDisponiveis.get(index);
    }

    //#region GETTERS E SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(double horaInicio) {
        this.horaInicio = horaInicio;
    }

    public double getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(double horaFim) {
        this.horaFim = horaFim;
    }

    //endregion


    @Override
    public String toString() {
        return "BlocoHoras{" +
                "id=" + id +
                ", horaInicio=" + horaInicio +
                ", horaFim=" + horaFim +
                '}';
    }
}