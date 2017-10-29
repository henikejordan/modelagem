package modelo;

public class ClasseSeveridade extends MedicaoVisual {

    private int idClasseSeveridade;
    private String descricao;
    private float inferior;
    private float superior;

    public int getIdClasseSeveridade() {
        return idClasseSeveridade;
    }

    public void setIdClasseSeveridade(int idClasseSeveridade) {
        this.idClasseSeveridade = idClasseSeveridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getInferior() {
        return inferior;
    }

    public void setInferior(float inferior) {
        this.inferior = inferior;
    }

    public float getSuperior() {
        return superior;
    }

    public void setSuperior(float superior) {
        this.superior = superior;
    }

}
