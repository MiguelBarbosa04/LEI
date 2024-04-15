package Ex03;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Docente
{
    private int id;
    private String nome;
    private List<Aula> aulasAgendadas;


    public Docente(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.aulasAgendadas = new ArrayList<>();
    }

    public static List<Docente> obterDocentesDisponiveis(BlocoHoras blocoAtual)
    {
        List<Docente> docentesDisponiveis = new ArrayList<>();
        List<Docente> todosDocentes = obterTodosDocentesDisponiveis();

        for (Docente docente : todosDocentes)
        {
            if (docenteEstaDisponivelParaBloco(docente, blocoAtual))
            {
                docentesDisponiveis.add(docente);
            }
        }

        return docentesDisponiveis;
    }

    public static boolean docenteEstaDisponivelParaBloco(Docente docente, BlocoHoras bloco)
    {
        List<Aula> aulasAgendadas = docente.getAulasAgendadas();

        for (Aula aula : aulasAgendadas)
        {
            if (aula.getBlocoHoras().equals(bloco))
            {
                return false;
            }
        }

        return true;
    }

    public static List<Docente> obterTodosDocentesDisponiveis()
    {
        List<Docente> todosDocentes = new ArrayList<>();

        todosDocentes.add(new Docente(1, "Prof. João"));
        todosDocentes.add(new Docente(2, "Prof. Maria"));
        todosDocentes.add(new Docente(3, "Prof. Pedro"));

        return todosDocentes;
    }

    public static Docente obterDocenteAleatorio(List<Docente> docentesDisponiveis)
    {
        Random random = new Random();
        int index = random.nextInt(docentesDisponiveis.size());

        return docentesDisponiveis.get(index);

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //endregion


    @Override
    public String toString() {
        return "Docente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", aulasAgendadas=" + aulasAgendadas +
                '}';
    }
}