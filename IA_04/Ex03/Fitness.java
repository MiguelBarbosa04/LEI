package Ex03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Locale;
public class Fitness {
    public static double calcularFitness(Horario horario) {
        // Lógica para calcular o fitness do horário
        int sobreposicoes = contarSobreposicoes(horario);
        double utilizacaoSalas = calcularUtilizacaoSalas(horario);
    
        // Calcular o fitness
        double fitness = 1.00 / (sobreposicoes + 1) * utilizacaoSalas;
    
        // Formatar o fitness para duas casas decimais usando o ponto como separador decimal
        String fitnessString = String.format(Locale.US, "%.2f", fitness);
    
        // Converter a string formatada de volta para um número
        return Double.parseDouble(fitnessString);
    }
    

    private static double calcularUtilizacaoSalas(Horario horario) {
        List<Aula> aulas = horario.getAulas();
        Map<Sala, Integer> utilizacaoPorSala = new HashMap<>();

        // Inicializar o mapa de utilização de salas
        for (Aula aula : aulas) {
            utilizacaoPorSala.put(aula.getSala(), 0);
        }

        // Contar a quantidade de alunos por sala em cada bloco de horário
        for (Aula aula : aulas) {
            Sala sala = aula.getSala();
            int alunos = aula.getTurma().getTamanho();
            utilizacaoPorSala.put(sala, utilizacaoPorSala.get(sala) + alunos);
        }

        // Verificar se alguma sala excede a capacidade máxima
        double penalidade = 0;
        for (Sala sala : utilizacaoPorSala.keySet()) {
            int utilizacao = utilizacaoPorSala.get(sala);
            int capacidade = sala.getCapacidade();
            if (utilizacao > capacidade) {
                // Penalizar horários que excedem a capacidade da sala
                penalidade += (double) (utilizacao - capacidade) / capacidade;
            }
        }

        // Quanto menor a penalidade, melhor o fitness
        return 1.0 / (1 + penalidade);
    }

    private static int contarSobreposicoes(Horario horario) {
        int sobreposicoes = 0;
        List<Aula> aulas = horario.getAulas();

        // Verificar todas as combinações de aulas para detectar sobreposições
        for (int i = 0; i < aulas.size(); i++) {
            for (int j = i + 1; j < aulas.size(); j++) {
                if (sobreposicao(aulas.get(i), aulas.get(j))) {
                    sobreposicoes++;
                }
            }
        }

        return sobreposicoes;
    }

    private static boolean sobreposicao(Aula aula1, Aula aula2) {
        // Verificar se as aulas ocorrem no mesmo bloco de horas e na mesma sala
        return aula1.getBlocoHoras().equals(aula2.getBlocoHoras()) &&
                aula1.getSala().equals(aula2.getSala()); // Retorne true se houver sobreposição, caso contrário false
    }
}