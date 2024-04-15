package Ex03;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Demo {
    static int tamanhoPopulacao = 100;
    static List<Horario> horariosList = new ArrayList<>();

    public static void main(String[] args) {
        // Criando população inicial
        Populacao populacao = new Populacao(tamanhoPopulacao);
        horariosList = populacao.getHorarios();

        // Calcular o valor de fitness para cada horário na população
        for (Horario horario : horariosList) {
            horario.setFitness(Fitness.calcularFitness(horario));
        }

        Collections.sort(horariosList, Collections.reverseOrder());

        for (Horario horario : horariosList) {
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------");
            System.out.println("|  Turma  |     UC    |     Docente    | Início | Fim | Bloco |  Sala  |");
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------");
            for (Aula aula : horario.getAulas()) {
                System.out.printf("|%-9s|%-11s|%-16s|%-8s|%-5s|%-7s|%-7s|\n", aula.getTurma().getId(),
                        aula.getUC().getNome(), aula.getDocente().getNome(), aula.getBlocoHoras().getHoraInicio(),
                        aula.getBlocoHoras().getHoraFim(), aula.getBlocoHoras().getId(), aula.getSala().getId());
            }
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------");
            System.out.printf("Fitness: %.2f\n", horario.getFitness());
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------");
        }
    }
}