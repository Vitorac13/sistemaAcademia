Academia academia = new Academia();

void main() {

    dadosTeste();

    int opcao;

    do {

        IO.println("\n=== SISTEMA DA ACADEMIA ===");
        IO.println("1 - Cadastrar aluno");
        IO.println("2 - Cadastrar professor");
        IO.println("3 - Cadastrar exercício");
        IO.println("4 - Listar alunos");
        IO.println("5 - Listar professores");
        IO.println("6 - Listar exercícios");
        IO.println("7 - Listar fichas de treino");
        IO.println("8 - Criar fichas de treino");
        IO.println("9 - Ativar/Desativar ficha de treino");
        IO.println("0 - Sair");

        opcao = Integer.parseInt(
            IO.readln("Escolha uma opção: ")
        );

        switch (opcao) {

            case 1:
                academia.cadastrarAluno();
                break;

            case 2:
                academia.cadastrarProfessor();
                break;

            case 3:
                academia.cadastrarExercicio();
                break;

            case 4:
                listarAlunos();
                break;

            case 5:
                listarProfessores();
                break;

            case 6:
                listarExercicios();
                break;

            case 7:
                acessarFichasTreino();
                break;

            case 8:
                academia.criarFichaTreino();
                break;

            case 9:
                alterarStatusFicha();
                break;

            case 0:
                IO.println("Programa encerrado.");
                break;

            default:
                IO.println("Opção inválida.");
        }

    } while (opcao != 0);

}

void listarAlunos() {

    IO.println("\n--- ALUNOS CADASTRADOS ---");

    if (academia.getQuantidadeAlunos() == 0) {
        IO.println("Nenhum aluno cadastrado.");
        return;
    }

    for (int i = 0; i < academia.getQuantidadeAlunos(); i++) {

        Aluno aluno = academia.getAlunos()[i];

        IO.println("Nome: " + aluno.getNome() + " | CPF: " + aluno.getCpf());
    }

}

void listarProfessores() {

    IO.println("\n--- PROFESSORES CADASTRADOS ---");

    if (academia.getQuantidadeProfessores() == 0) {
        IO.println("Nenhum professor cadastrado.");
        return;
    }

    for (int i = 0; i < academia.getQuantidadeProfessores(); i++) {

        Professor professor = academia.getProfessores()[i];

        IO.println("Nome: " + professor.getNome() + " | CPF: " + professor.getCpf());
    }
}

void listarExercicios() {

    IO.println("\n--- EXERCÍCIOS CADASTRADOS ---");

    if (academia.getQuantidadeExercicios() == 0) {
        IO.println("Nenhum exercício cadastrado.");
        return;
    }

    for (int i = 0; i < academia.getQuantidadeExercicios(); i++) {

        Exercicio exercicio = academia.getExercicios()[i];

        IO.println("Nome: " + exercicio.getNome() + " | Descrição: " + exercicio.getDescricao());
    }
}

void acessarFichasTreino() {

    IO.println("\n===== FICHAS DE TREINO =====");

    if (academia.getQuantidadeAlunos() == 0) {          // Verifica se tem aluno cadastrado
        IO.println("Nenhum aluno cadastrado.");
        return;
    }

    IO.println("Alunos:");

    for (int i = 0; i < academia.getQuantidadeAlunos(); i++) {

        Aluno aluno = academia.getAlunos()[i];

        IO.println((i + 1) + " - " + aluno.getNome());
    }

    int opcaoAluno = Integer.parseInt(IO.readln("\nEscolha o aluno: "));

    if (opcaoAluno < 1 || opcaoAluno > academia.getQuantidadeAlunos()){
        IO.println("Aluno inválido.");
        return;
    }

    Aluno alunoSelecionado = academia.getAlunos()[opcaoAluno - 1];

    IO.println("\n===== FICHAS DE " + alunoSelecionado.getNome().toUpperCase() + " =====");

    if (alunoSelecionado.getQuantidadeFichas() == 0) {
        IO.println("Este aluno não possui fichas de treino.");
        return;
    }

    for (int i = 0; i < alunoSelecionado.getQuantidadeFichas(); i++){

        FichaTreino ficha = alunoSelecionado.getFichasTreino()[i];

        IO.println("\n------------------------------");
        IO.println("Dia: " + ficha.getDia());
        IO.println("Professor: " + ficha.getProfessor().getNome());
        IO.println("Status: " + (ficha.isAtiva() ? "Ativa" : "Inativa"));
        IO.println("\nExercícios:");

        for (int j = 0; j < ficha.getQuantidadeExercicios(); j++){

            ExercicioTreino exercicioTreino = ficha.getExercicios()[j];     // Contem series e repeticoes
            Exercicio exercicio = exercicioTreino.getExercicio();           // Contem o nome do Exercicio

            IO.println("- " + exercicio.getNome() + " | " + exercicioTreino.getSeries() + " séries x " + exercicioTreino.getRepeticoes() + " repetições");
        }
    }
    IO.println("\n------------------------------");
}

void alterarStatusFicha() {

    IO.println("\n===== ATIVAR/DESATIVAR FICHA =====");

    if (academia.getQuantidadeAlunos() == 0) {
        IO.println("Nenhum aluno cadastrado.");
        return;
    }

    IO.println("\nAlunos:");

    for (int i = 0; i < academia.getQuantidadeAlunos(); i++) {

        Aluno aluno = academia.getAlunos()[i];

        IO.println((i + 1) + " - " + aluno.getNome());
    }

    int opcaoAluno = Integer.parseInt(IO.readln("Escolha o aluno: "));

    if (opcaoAluno < 1 || opcaoAluno > academia.getQuantidadeAlunos()){
        IO.println("Aluno inválido.");
        return;
    }

    Aluno aluno = academia.getAlunos()[opcaoAluno - 1];

    if (aluno.getQuantidadeFichas() == 0) {
        IO.println("Este aluno não possui fichas de treino.");
        return;
    }

    IO.println("\nFichas de " + aluno.getNome() + ":");

    for (int i = 0; i < aluno.getQuantidadeFichas(); i++){

        FichaTreino ficha = aluno.getFichasTreino()[i];

        IO.println((i + 1)  + " - " + ficha.getDia() + " | " + (ficha.isAtiva() ? "Ativa" : "Inativa"));
    }

    int opcaoFicha = Integer.parseInt(IO.readln("Escolha a ficha: "));

    if (opcaoFicha < 1 || opcaoFicha > aluno.getQuantidadeFichas()){
        IO.println("Ficha inválida.");
        return;
    }

    FichaTreino fichaSelecionada = aluno.getFichasTreino()[opcaoFicha - 1];

    if (fichaSelecionada.isAtiva()) {           // Se a ficha selecionada tiver ativa, ela será desativada

        fichaSelecionada.desativar();
        IO.println("Ficha desativada com sucesso.");

    } else {
        aluno.ativarFichaTreino(fichaSelecionada);
        IO.println("Ficha ativada com sucesso.");
    }
}

void dadosTeste() {

    Professor professor1 = new Professor("Carlos Mendes", "11111111111");
    Professor professor2 = new Professor("Ana Paula", "22222222222");
    academia.adicionarProfessor(professor1);
    academia.adicionarProfessor(professor2);


    Aluno aluno1 = new Aluno("João Silva", "33333333333");
    Aluno aluno2 =  new Aluno("Maria Santos", "44444444444");
    Aluno aluno3 = new Aluno("Pedro Oliveira", "55555555555");
    Aluno aluno4 = new Aluno("Lucca Costa", "66666666666");

    academia.adicionarAluno(aluno1);
    academia.adicionarAluno(aluno2);
    academia.adicionarAluno(aluno3);
    academia.adicionarAluno(aluno4);

    professor1.adicionarAluno(aluno1);
    professor1.adicionarAluno(aluno2);
    professor2.adicionarAluno(aluno3);
    professor2.adicionarAluno(aluno4);


    Exercicio exercicio1 = new Exercicio("Supino reto", "Exercício para peitoral realizado com barra");
    Exercicio exercicio2 = new Exercicio("Agachamento livre", "Exercício para pernas realizado com barra");
    Exercicio exercicio3 =new Exercicio("Rosca direta", "Exercício para bíceps realizado com barra");
    Exercicio exercicio4 =new Exercicio("Puxada frontal", "Exercício para costas realizado na polia");
    Exercicio exercicio5 =new Exercicio("Desenvolvimento", "Exercício para ombros realizado com pesos");

    academia.adicionarExercicio(exercicio1);
    academia.adicionarExercicio(exercicio2);
    academia.adicionarExercicio(exercicio3);
    academia.adicionarExercicio(exercicio4);
    academia.adicionarExercicio(exercicio5);


    ExercicioTreino treino1 = new ExercicioTreino(exercicio1, 4, 10);
    ExercicioTreino treino2 = new ExercicioTreino(exercicio2, 4, 12);
    ExercicioTreino treino3 = new ExercicioTreino(exercicio3, 3, 10);

    FichaTreino fichaJoaoSegunda = new FichaTreino(aluno1, professor1, "Ficha_Segunda");

    fichaJoaoSegunda.adicionarExercicio(treino1);
    fichaJoaoSegunda.adicionarExercicio(treino2);
    fichaJoaoSegunda.adicionarExercicio(treino3);

    aluno1.adicionarFichaTreino(fichaJoaoSegunda);

    aluno1.ativarFichaTreino(fichaJoaoSegunda);

}
