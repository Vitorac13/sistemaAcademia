public class FichaTreino {

    private String diaFicha;
    private Aluno aluno;
    private Professor professor;
    private ExercicioTreino[] exercicios;
    private int quantidadeExercicios;
    private boolean ativa;

    public FichaTreino(Aluno aluno, Professor professor, String diaFicha) {
        this.diaFicha = diaFicha;
        this.aluno = aluno;
        this.professor = professor;
        this.exercicios = new ExercicioTreino[10];      // Limite de 10 exercicios por ficha
        this.quantidadeExercicios = 0;
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

    public ExercicioTreino[] getExercicios() {
        return exercicios;
    }

    public int getQuantidadeExercicios() {
        return quantidadeExercicios;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void adicionarExercicio(ExercicioTreino exercicioTreino) {

        if (quantidadeExercicios >= exercicios.length) {
            IO.println("Limite de exercícios da ficha atingido.");
            return;
        }

        for(int i=0; i < quantidadeExercicios; i++){
            if(exercicioTreino.getExercicio().getNome().equals(this.exercicios[i].getExercicio().getNome())){
                IO.println("\nEsta ficha já contém esse exercício!");
                return;
            }
        }

        exercicios[quantidadeExercicios] = exercicioTreino;
        quantidadeExercicios++;
        
        IO.println("Exercício adicionado à ficha.");
    }

    public void ativar() {

        if (quantidadeExercicios == 0) {
            IO.println("A ficha de treino deve possuir pelo menos um exercício.");
            return;
        }

        this.ativa = true;
    }

    public void desativar() {
        this.ativa = false;
    }

}