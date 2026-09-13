import java.util.ArrayList;
import java.util.List;

public class Academia {

    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Exercicio> exercicios;

    public Academia() {
        alunos = new ArrayList<>();
        professores = new ArrayList<>();
        exercicios = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public void adicionarExercicio(Exercicio exercicio) {
        exercicios.add(exercicio);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }
}