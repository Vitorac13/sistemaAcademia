package academia

import java.util.ArrayList;
import java.util.List;

public class Professor {

    private String nome;
    private String cpf;
    private List<Aluno> alunos;

    public Professor(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.alunos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        if (aluno != null && !alunos.contains(aluno)) {
            alunos.add(aluno);
            aluno.setProfessorResponsavel(this);
        }
    }
}