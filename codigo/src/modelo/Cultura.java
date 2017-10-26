package modelo;

public abstract class Cultura {

    private int idCultura;
    private String nome;
    private String descricao;

    public int getIdCultura() {
        return idCultura;
    }

    public void setIdCultura(int idCultura) {
        this.idCultura = idCultura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
