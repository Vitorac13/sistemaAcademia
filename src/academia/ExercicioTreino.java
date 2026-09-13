package academia

public class ExercicioTreino {

    private Exercicio exercicio;
    private int series;
    private int repeticoes;

    public ExercicioTreino(Exercicio exercicio, int series, int repeticoes) {
        this.exercicio = exercicio;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public int getSeries() {
        return series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }
}