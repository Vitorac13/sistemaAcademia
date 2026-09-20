public class Aluno {

    private String nome;
    private String cpf;
    private Professor professorResponsavel;
    private FichaTreino[] fichasTreino;
    private int quantidadeFichas;

    public Aluno(String nome, String cpf) {

        this.nome = nome;
        this.cpf = cpf;
        this.fichasTreino = new FichaTreino[5];             // O aluno pode ter até 5 fichas de treino
        this.quantidadeFichas = 0;              // O vetor tem 5 espaços para ficha, mas precisa saber quantas fichas cada aluno tem para ativar e desativar
        
        IO.println("Aluno cadastrado com sucesso!");
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

    public FichaTreino[] getFichasTreino() {
        return fichasTreino;
    }

    public int getQuantidadeFichas() {
        return quantidadeFichas;
    }

    public void adicionarFichaTreino(FichaTreino ficha) {

        if (ficha == null) {
            return;
        }

        if (quantidadeFichas >= fichasTreino.length) {
            IO.println("Limite de fichas de treino atingido.");
            return;
        }

        fichasTreino[quantidadeFichas] = ficha;
        quantidadeFichas++;
    }

    public void ativarFichaTreino(FichaTreino ficha) {

        if (ficha == null) {
            return;
        }

        boolean encontrada = false;

        for (int i = 0; i < quantidadeFichas; i++) {

            if (fichasTreino[i] == ficha) {
                encontrada = true;
            }
        }

        if (!encontrada) {
            IO.println("A ficha não pertence ao aluno.");
            return;
        }

        for (int i = 0; i < quantidadeFichas; i++) {        // Desativa todas as fichas de treino, para ativar a ficha selecionada
            fichasTreino[i].desativar();
        }

        ficha.ativar();
    }
}