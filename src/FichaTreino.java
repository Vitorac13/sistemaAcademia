import java.util.ArrayList;
import java.util.List;

public class FichaTreino {

    private String diaFicha;
    private Aluno aluno;
    private Professor professor;
    private List<ExercicioTreino> exercicios;
    private boolean ativa;

    public FichaTreino(Aluno aluno, Professor professor, String diaFicha) {
        this.diaFicha = diaFicha;
        this.aluno = aluno;
        this.professor = professor;
        this.exercicios = new ArrayList<>();
        this.ativa = false;
    }

    public String getDia() {
        return diaFicha;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<ExercicioTreino> getExercicios() {
        return exercicios;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void adicionarExercicio(ExercicioTreino exercicioTreino) {
        if (exercicioTreino != null) {
            exercicios.add(exercicioTreino);
        }
    }

    public void ativar() {
    if (exercicios.isEmpty()) {
        throw new IllegalStateException("A ficha de treino deve possuir pelo menos um exercício.");
    }
    this.ativa = true;
}

    public void desativar() {
        this.ativa = false;
    }
}