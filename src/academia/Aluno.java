package academia

public class Aluno {

    private String nome;
    private String cpf;
    private Professor professorResponsavel;
    private List<FichaTreino> fichasTreino;

    public Aluno(String nome, String cpf) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do aluno é obrigatório.");
        }

        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("O CPF do aluno é obrigatório.");
        }

        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public List<FichaTreino> getFichasTreino() {
        return fichasTreino;
    }

    public void adicionarFichaTreino(FichaTreino ficha) {
        if (ficha != null && !fichasTreino.contains(ficha)) {
            fichasTreino.add(ficha);
        }
    }
}