public class Academia {

    private Aluno[] alunos;
    private Professor[] professores;
    private Exercicio[] exercicios;
    private int quantidadeAlunos;
    private int quantidadeProfessores;
    private int quantidadeExercicios;

    public Academia() {

        alunos = new Aluno[10];                 // A academia comporta 10 alunos
        professores = new Professor[5];         // 5 professores
        exercicios = new Exercicio[30];         // Até 30 exercicios cadastrados
        quantidadeAlunos = 0;
        quantidadeProfessores = 0;
        quantidadeExercicios = 0;
    }

    public void adicionarAluno(Aluno aluno) {

        if (aluno == null) {
            return;
        }

        if (quantidadeAlunos >= alunos.length) {
            IO.println("Limite de alunos atingido.");
            return;
        }

        alunos[quantidadeAlunos] = aluno;
        quantidadeAlunos++;
    }

    public void adicionarProfessor(Professor professor) {

        if (professor == null) {
            return;
        }

        if (quantidadeProfessores >= professores.length) {
            IO.println("Limite de professores atingido.");
            return;
        }

        professores[quantidadeProfessores] = professor;
        quantidadeProfessores++;
    }

    public void adicionarExercicio(Exercicio exercicio) {

        if (exercicio == null) {
            return;
        }

        if (quantidadeExercicios >= exercicios.length) {
            IO.println("Limite de exercícios atingido.");
            return;
        }

        exercicios[quantidadeExercicios] = exercicio;
        quantidadeExercicios++;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public Professor[] getProfessores() {
        return professores;
    }

    public Exercicio[] getExercicios() {
        return exercicios;
    }

    public int getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public int getQuantidadeProfessores() {
        return quantidadeProfessores;
    }

    public int getQuantidadeExercicios() {
        return quantidadeExercicios;
    }

    public void cadastrarAluno() {

        IO.println("\n--- CADASTRO DE ALUNO ---");

        if (quantidadeAlunos >= alunos.length) {
            IO.println("Limite de alunos atingido.");
            return;
        }

        String nome = IO.readln("Nome: ");
        String cpf = IO.readln("CPF: ");

        Aluno aluno = new Aluno(nome, cpf);

        adicionarAluno(aluno);

        IO.println("Aluno cadastrado com sucesso!");
    }

    public void cadastrarProfessor() {

        IO.println("\n--- CADASTRO DE PROFESSOR ---");

        if (quantidadeProfessores >= professores.length) {
            IO.println("Limite de professores atingido.");
            return;
        }

        String nome = IO.readln("Nome: ");
        String cpf = IO.readln("CPF: ");

        Professor professor = new Professor(nome, cpf);

        adicionarProfessor(professor);

        IO.println("Professor cadastrado com sucesso!");
    }

    public void cadastrarExercicio() {

        IO.println("\n--- CADASTRO DE EXERCÍCIO ---");

        if (quantidadeExercicios >= exercicios.length) {
            IO.println("Limite de exercícios atingido.");
            return;
        }

        String nome = IO.readln("Nome: ");
        String descricao = IO.readln("Descrição: ");

        Exercicio exercicio = new Exercicio(nome, descricao);

        adicionarExercicio(exercicio);

        IO.println("Exercício cadastrado com sucesso!");
    }

    String continuar;
    
    public void criarFichaTreino() {

        IO.println("\n===== CRIAR FICHA DE TREINO =====");

        if (quantidadeAlunos == 0) {
            IO.println("Nenhum aluno cadastrado.");
            return;
        }

        IO.println("\nAlunos:");

        for (int i = 0; i < quantidadeAlunos; i++) {

            Aluno aluno = alunos[i];

            IO.println((i + 1) + " - " + aluno.getNome());
        }

        int opcaoAluno = Integer.parseInt(IO.readln("\nEscolha o aluno: "));

        if (opcaoAluno < 1 || opcaoAluno > quantidadeAlunos) {
            IO.println("Aluno inválido.");
            return;
        }

        Aluno alunoSelecionado = alunos[opcaoAluno - 1];

        Professor professor = alunoSelecionado.getProfessorResponsavel();

        if (professor == null) {
            IO.println("Este aluno não possui professor responsável.");
            return;
        }

        IO.println("Professor responsável: " + professor.getNome());

        String diaFicha = IO.readln("\nDigite o dia da semana: ");

        FichaTreino ficha = new FichaTreino(alunoSelecionado, professor, diaFicha);

        if (quantidadeExercicios == 0) {
            IO.println("Nenhum exercício cadastrado.");
            return;
        }

        do {

            IO.println("\n===== EXERCÍCIOS =====");

            for (int i = 0; i < quantidadeExercicios; i++) {

                Exercicio exercicio = exercicios[i];

                IO.println((i + 1) + " - " + exercicio.getNome());
            }

            int opcaoExercicio = Integer.parseInt(IO.readln("\nEscolha o exercício: "));

            if (opcaoExercicio < 1 || opcaoExercicio > quantidadeExercicios) {
                IO.println("Exercício inválido.");
                continue;
            }

            Exercicio exercicioSelecionado =
                exercicios[opcaoExercicio - 1];

            int series = Integer.parseInt(IO.readln("Quantidade de séries: "));

            int repeticoes = Integer.parseInt(IO.readln("Quantidade de repetições: "));

            ExercicioTreino exercicioTreino =
                new ExercicioTreino(exercicioSelecionado, series, repeticoes);

            ficha.adicionarExercicio(exercicioTreino);

            IO.println("Exercício adicionado à ficha.");

            continuar = IO.readln("\nAdicionar outro exercício? (s/n): ");

        } while (continuar.equalsIgnoreCase("s"));

        alunoSelecionado.adicionarFichaTreino(ficha);

        IO.println("\nFicha de treino criada com sucesso!");
        IO.println("Aluno: " + alunoSelecionado.getNome());
        IO.println("Professor: " + professor.getNome());
        IO.println("Dia: " + diaFicha);
        IO.println("Quantidade de exercícios: " + ficha.getQuantidadeExercicios());
    }

}
