public class Professor {

    private String nome;
    private String cpf;
    private Aluno[] alunos;
    private int quantidadeAlunos;

    public Professor(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.alunos = new Aluno[10];            // O professor tem um limite de 10 alunos por causa do tamanho do vetor criado      
        this.quantidadeAlunos = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public int getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void adicionarAluno(Aluno aluno) {

        if (aluno == null) {
            return;
        }

        for (int i = 0; i < quantidadeAlunos; i++) {        // Para ver se o aluno já está cadastrado para este professor

            if (alunos[i] == aluno) {
                return;
            }
        }

        if (quantidadeAlunos >= alunos.length) {            // O professor só pode ter 10 alunos cadastrados
            IO.println("Limite de alunos deste professor atingido.");
            return;
        }

        alunos[quantidadeAlunos] = aluno;
        quantidadeAlunos++;

        aluno.setProfessorResponsavel(this);
    }
}
