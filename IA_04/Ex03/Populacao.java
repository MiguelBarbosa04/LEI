package Ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Populacao
{
    private static List<Horario> horarios;

    public Populacao(int tamanhoPopulacao)
    {
        this.horarios = new ArrayList<>();

        for (int i = 0; i < tamanhoPopulacao; i++)
        {
            Horario horario = gerarHorarioAleatorio(); //gera um horario aleatorio
            this.horarios.add(horario);
        }
    }


    private Horario gerarHorarioAleatorio()
    {
        Horario horario = new Horario();
        List<Aula> aulas = new ArrayList<>(); // Lista de aulas no horário

        // Implemente a lógica para adicionar aulas aleatórias ao horário
        List<BlocoHoras> blocosDisponiveis = BlocoHoras.obterBlocosDisponiveis();
        Random random = new Random();

        for(BlocoHoras blocoAtual : blocosDisponiveis)
        {
            List<Sala> salasDisponiveis = Sala.obterSalasDisponiveis(blocoAtual);
            List<Docente> docentesDisponiveis = Docente.obterDocentesDisponiveis(blocoAtual);


            // Em um loop, gere aulas aleatórias e adicione ao horário
            for (Turma turma : Turma.obterTurmasDisponiveis())
            {
                UC uc = UC.obterUnidadeCurricularAleatoria();
                Docente docente = Docente.obterDocenteAleatorio(docentesDisponiveis);
                BlocoHoras bloco = BlocoHoras.obterBlocoHorasAleatorio(blocosDisponiveis);
                Sala sala = Sala.obterSalaAleatoria(salasDisponiveis);

                Aula aula = new Aula(turma, uc, docente, bloco, sala);
                aulas.add(aula);

                // Remover a sala, docente e bloco utilizados para evitar duplicatas
                salasDisponiveis.remove(sala);
                docentesDisponiveis.remove(docente);
                //blocosDisponiveis.remove(bloco);
            }
        }

        horario.setAulas(aulas);
        return horario;
    }

    //region GETTERS E SETTERS

    public void setHorarios(List<Horario> horarios)
    {
        this.horarios = horarios;
    }

    public static List<Horario> getHorarios()
    {
        return horarios;
    }

//endregion

}