package Ex03;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UC
{
    private int id;
    private String nome;


    public UC(int id, String nome)
    {
        this.id = id;
        this.nome = nome;
    }


    public static List<UC> obterUnidadesCurricularesDisponiveis()
    {
        List<UC> unidadesCurriculares = new ArrayList<>();
        // Adicione as unidades curriculares disponíveis à lista
        unidadesCurriculares.add(new UC(1, "IA"));
        unidadesCurriculares.add(new UC(2, "ESII"));
        unidadesCurriculares.add(new UC(3, "ED"));
        unidadesCurriculares.add(new UC(4, "FP"));
        unidadesCurriculares.add(new UC(5, "PAW"));

        return unidadesCurriculares;
    }

    public static UC obterUnidadeCurricularAleatoria()
    {
        List<UC> unidadesCurriculares = obterUnidadesCurricularesDisponiveis();

        Random random = new Random();
        int index = random.nextInt(unidadesCurriculares.size());

        return unidadesCurriculares.get(index);
    }


    //region GETTERS E SETTERS

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
        return "UC{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}