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

    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public void adicionarProfessor(Professor professor){
        professores.add(professor);
    }

    public void adicionarExercicio(Exercicio exercicio){
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

    public void cadastrarAluno() {

        IO.println("\n--- CADASTRO DE ALUNO ---");

        String nome = IO.readln("Nome: ");
        String cpf = IO.readln("CPF: ");

        Aluno aluno = new Aluno(nome, cpf);

        alunos.add(aluno);

        IO.println("Aluno cadastrado com sucesso!");
    }


    public void cadastrarProfessor() {

        IO.println("\n--- CADASTRO DE PROFESSOR ---");

        String nome = IO.readln("Nome: ");
        String cpf = IO.readln("CPF: ");

        Professor professor = new Professor(nome, cpf);

        professores.add(professor);

        IO.println("Professor cadastrado com sucesso!");
    }


    public void cadastrarExercicio() {

        IO.println("\n--- CADASTRO DE EXERCÍCIO ---");

        String nome = IO.readln("Nome: ");
        String descricao = IO.readln("Descrição: ");

        Exercicio exercicio = new Exercicio(nome, descricao);

        exercicios.add(exercicio);

        IO.println("Exercício cadastrado com sucesso!");
    }


    String continuar;
    public void criarFichaTreino() {

        IO.println("\n===== CRIAR FICHA DE TREINO =====");

        if (getAlunos().isEmpty()) {
            IO.println("Nenhum aluno cadastrado.");
            return;
        }

        IO.println("\nAlunos:");

        for (int i = 0; i < getAlunos().size(); i++) {
            Aluno aluno = getAlunos().get(i);
            IO.println((i + 1) + " - " + aluno.getNome());
        }

        int opcaoAluno = Integer.parseInt(IO.readln("\nEscolha o aluno: "));

        if (opcaoAluno < 1 || opcaoAluno > getAlunos().size()) {
            IO.println("Aluno inválido.");
            return;
        }

        Aluno alunoSelecionado = getAlunos().get(opcaoAluno - 1);

        Professor professor = alunoSelecionado.getProfessorResponsavel();

        if (professor == null) {
            IO.println("Este aluno não possui professor responsável.");
            return;
        }

        IO.println("Professor responsável: " + professor.getNome());

        String diaFicha = IO.readln("\nDigite o dia da semana: ");

        FichaTreino ficha = new FichaTreino(alunoSelecionado, professor, diaFicha);

        if (getExercicios().isEmpty()) {
            IO.println("Nenhum exercício cadastrado.");
            return;
        }

        do {
            IO.println("\n===== EXERCÍCIOS =====");

            for (int i = 0; i < getExercicios().size(); i++) {
                Exercicio exercicio = getExercicios().get(i);
                IO.println((i + 1) + " - " + exercicio.getNome());
            }

            int opcaoExercicio = Integer.parseInt(IO.readln("\nEscolha o exercício: "));

            if (opcaoExercicio < 1 || opcaoExercicio > getExercicios().size()) {
                IO.println("Exercício inválido.");
                continue;
            }

            Exercicio exercicioSelecionado = getExercicios().get(opcaoExercicio - 1);

            int series = Integer.parseInt(IO.readln("Quantidade de séries: "));

            int repeticoes = Integer.parseInt(IO.readln("Quantidade de repetições: "));

            ExercicioTreino exercicioTreino = new ExercicioTreino(exercicioSelecionado, series, repeticoes);

            ficha.adicionarExercicio(exercicioTreino);

            IO.println("Exercício adicionado à ficha.");

            continuar = IO.readln("\nAdicionar outro exercício? (s/n): ");

        } while(continuar.equalsIgnoreCase("s"));

        alunoSelecionado.adicionarFichaTreino(ficha);

        IO.println("\nFicha de treino criada com sucesso!");
        IO.println("Aluno: " + alunoSelecionado.getNome());
        IO.println("Professor: " + professor.getNome());
        IO.println("Dia: " + diaFicha);
        IO.println("Quantidade de exercícios: " + ficha.getExercicios().size());
    }

}