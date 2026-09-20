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

    public void adicionarAluno(Aluno aluno) {           // Está pública pois adicionamos casos testes no Main, mas deve ser privada

        alunos[quantidadeAlunos] = aluno;
        quantidadeAlunos++;
    }

    public void adicionarProfessor(Professor professor) {           // Está pública pois adicionamos casos testes no Main, mas deve ser privada

        professores[quantidadeProfessores] = professor;
        quantidadeProfessores++;
    }

    public void adicionarExercicio(Exercicio exercicio) {           // Está pública pois adicionamos casos testes no Main, mas deve ser privada

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

        if (quantidadeAlunos >= alunos.length) {        // Verifica se a quantidade de alunos não atingiu o limite do array
            IO.println("Limite de alunos atingido.");
            return;
        }

        String nome = IO.readln("Nome: ");
        
        if (nome.isEmpty()) {         // Tem que preencher a String nome
            IO.println("O nome do aluno é obrigatório.");
            return;
        }

        String cpf = IO.readln("CPF: ");

        if (cpf.isEmpty()) {          // Tem que preencher a String cpf
            IO.println("O CPF do aluno é obrigatório.");
            return;
        }

        Aluno aluno = new Aluno(nome, cpf);

        adicionarAluno(aluno);
    }

    public void cadastrarProfessor() {

        IO.println("\n--- CADASTRO DE PROFESSOR ---");

        if (quantidadeProfessores >= professores.length) {        // Verifica se a quantidade de alunos não atingiu o limite do array
            IO.println("Limite de professores atingido.");
            return;
        }

        String nome = IO.readln("Nome: ");
        if (nome.isEmpty()) {         // Tem que preencher a String nome
            IO.println("O nome do professor é obrigatório.");
            return;
        }

        String cpf = IO.readln("CPF: ");
        if (cpf.isEmpty()) {          // Tem que preencher a String cpf
            IO.println("O CPF do professor é obrigatório.");
            return;
        }

        Professor professor = new Professor(nome, cpf);

        adicionarProfessor(professor);
    }

    public void cadastrarExercicio() {

        IO.println("\n--- CADASTRO DE EXERCÍCIO ---");

        if (quantidadeExercicios >= exercicios.length) {        // Verifica se a quantidade de alunos não atingiu o limite do array
            IO.println("Limite de exercícios atingido.");
            return;
        }
        
        String nome = IO.readln("Nome: ");
        if (nome.isEmpty()) {         // Tem que preencher a String nome
            IO.println("O nome do exercício é obrigatório.");
            return;
        }

        String descricao = IO.readln("Descrição: ");     
        if (descricao.isEmpty()) {          // Tem que preencher a String cpf
            IO.println("A descrição do exercício é obrigatória.");
            return;
        }

        Exercicio exercicio = new Exercicio(nome, descricao);

        adicionarExercicio(exercicio);
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
            
            if (quantidadeProfessores == 0) {
                IO.println("Nenhum professor cadastrado.");
                return;
            }

            IO.println("\nSelecione um professor para ser o responsável:");

            for (int i = 0; i < quantidadeProfessores; i++) {

                professor = professores[i];

                IO.println((i + 1) + " - " + professor.getNome());
            }

            int opcaoProfessor = Integer.parseInt(IO.readln("\nEscolha o professor: "));

            if (opcaoProfessor < 1 || opcaoProfessor > quantidadeProfessores) {
                IO.println("Professor inválido.");
                return;
            }

            Professor professorSelecionado = professores[opcaoProfessor - 1];

            alunoSelecionado.setProfessorResponsavel(professorSelecionado);
        }

        IO.println("Professor responsável: " + alunoSelecionado.getProfessorResponsavel().getNome()); // Pega o nome do professor responsavel pelo aluno selecionado

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

            Exercicio exercicioSelecionado = exercicios[opcaoExercicio - 1];

            int series = Integer.parseInt(IO.readln("Quantidade de séries: "));

            int repeticoes = Integer.parseInt(IO.readln("Quantidade de repetições: "));

            ExercicioTreino exercicioTreino = new ExercicioTreino(exercicioSelecionado, series, repeticoes);

            ficha.adicionarExercicio(exercicioTreino);

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
