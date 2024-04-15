package Ex03;

import java.util.List;
import java.util.ArrayList;

public class Aula {
    private Turma turma;
    private UC UC;
    private Docente docente;
    private BlocoHoras blocoHoras; // 1 blocoHoras = 2h
    private Sala sala;

    public Aula(Turma turma, UC UC, Docente docente, BlocoHoras blocoHoras, Sala sala) {
        this.turma = turma;
        this.UC = UC;
        this.docente = docente;
        this.blocoHoras = blocoHoras;
        this.sala = sala;
    }

    public static List<Aula> obterTodasAulasAgendadas() {
        List<Aula> todasAulasAgendadas = new ArrayList<>();

        List<Horario> horarios = Populacao.getHorarios(); // obter todos os horários

        // Percorre todos os horários para obter as aulas agendadas de cada horário
        for (Horario horario : horarios) {
            todasAulasAgendadas.addAll(horario.getAulas());
        }

        return todasAulasAgendadas;
    }

    private List<Aula> obterAulasAgendadasParaSala(Sala sala) {
        List<Aula> aulasAgendadas = sala.getAulasAgendadas();

        // Suponha que você tenha uma lista de todas as aulas agendadas em seu sistema
        for (Aula aula : aulasAgendadas) {
            if (aula.getSala().equals(sala)) {
                aulasAgendadas.add(aula);
            }
        }

        return aulasAgendadas;
    }

    // region GETTERS E SETTERS

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public UC getUC() {
        return UC;
    }

    public void setUC(UC UC) {
        this.UC = UC;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public BlocoHoras getBlocoHoras() {
        return blocoHoras;
    }

    public void setBlocoHoras(BlocoHoras blocoHoras) {
        this.blocoHoras = blocoHoras;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    // endregion

    @Override
    public String toString() {
        return "Aula{" +
                "turma=" + turma +
                ", UC=" + UC +
                ", docente=" + docente +
                ", blocoHoras=" + blocoHoras +
                ", sala=" + sala +
                '}';
    }
}