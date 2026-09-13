import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
Academia academia = new Academia();

void main(){

    dadosTeste(); // Contem alunos, professores e exercicios já cadastrados para testar

    int opcao;

    do {
        IO.println("\n=== SISTEMA DA ACADEMIA ===");
        IO.println("1 - Cadastrar aluno");
        IO.println("2 - Cadastrar professor");
        IO.println("3 - Cadastrar exercício");
        IO.println("4 - Listar alunos");
        IO.println("5 - Listar professores");
        IO.println("6 - Listar exercícios");
        IO.println("0 - Sair");
        IO.print("Escolha uma opção: ");

        opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {

            case 1:
                cadastrarAluno();
                break;

            case 2:
                cadastrarProfessor();
                break;

            case 3:
                cadastrarExercicio();
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

            case 0:
                IO.println("Programa encerrado.");
                break;

            default:
                IO.println("Opção inválida.");
        }

    } while (opcao != 0);

    scanner.close();
}

void cadastrarAluno() {

    IO.println("\n--- CADASTRO DE ALUNO ---");

    IO.print("Nome: ");
    String nome = scanner.nextLine();

    IO.print("CPF: ");
    String cpf = scanner.nextLine();

    Aluno aluno = new Aluno(nome, cpf);

    academia.adicionarAluno(aluno);

    IO.println("Aluno cadastrado com sucesso!");
}


void cadastrarProfessor() {

    IO.println("\n--- CADASTRO DE PROFESSOR ---");

    IO.print("Nome: ");
    String nome = scanner.nextLine();

    IO.print("CPF: ");
    String cpf = scanner.nextLine();

    Professor professor = new Professor(nome, cpf);

    academia.adicionarProfessor(professor);

    IO.println("Professor cadastrado com sucesso!");
}


void cadastrarExercicio() {

    IO.println("\n--- CADASTRO DE EXERCÍCIO ---");

    IO.print("Nome: ");
    String nome = scanner.nextLine();

    IO.print("Descrição: ");
    String descricao = scanner.nextLine();

    Exercicio exercicio = new Exercicio(nome, descricao);

    academia.adicionarExercicio(exercicio);

    IO.println("Exercício cadastrado com sucesso!");
}


void listarAlunos() {

    IO.println("\n--- ALUNOS CADASTRADOS ---");

    for (Aluno aluno : academia.getAlunos()) {
        IO.println("Nome: " + aluno.getNome() + " | CPF: " + aluno.getCpf());
    }
}


void listarProfessores() {

    IO.println("\n--- PROFESSORES CADASTRADOS ---");

    for (Professor professor : academia.getProfessores()) {
        IO.println("Nome: " + professor.getNome() + " | CPF: " + professor.getCpf());
    }
}


void listarExercicios() {

    IO.println("\n--- EXERCÍCIOS CADASTRADOS ---");

    for (Exercicio exercicio : academia.getExercicios()) {
        IO.println("Nome: " + exercicio.getNome() + " | Descrição: " + exercicio.getDescricao());
    }
}

void dadosTeste(){

    Professor professor1 = new Professor("Carlos Mendes", "11111111111");
    Professor professor2 = new Professor("Ana Paula", "22222222222");

    academia.adicionarProfessor(professor1);
    academia.adicionarProfessor(professor2);

    Aluno aluno1 = new Aluno("João Silva", "33333333333");
    Aluno aluno2 = new Aluno("Maria Santos", "44444444444");
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
    Exercicio exercicio3 = new Exercicio("Rosca direta", "Exercício para bíceps realizado com barra");
    Exercicio exercicio4 = new Exercicio("Puxada frontal", "Exercício para costas realizado na polia");
    Exercicio exercicio5 = new Exercicio("Desenvolvimento", "Exercício para ombros realizado com pesos");

    academia.adicionarExercicio(exercicio1);
    academia.adicionarExercicio(exercicio2);
    academia.adicionarExercicio(exercicio3);
    academia.adicionarExercicio(exercicio4);
    academia.adicionarExercicio(exercicio5);
}