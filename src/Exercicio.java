public class Exercicio {

    private String nome;
    private String descricao;

    public Exercicio(String nome, String descricao) {

        this.nome = nome;
        this.descricao = descricao;

        IO.println("Exercício cadastrado com sucesso!");
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}