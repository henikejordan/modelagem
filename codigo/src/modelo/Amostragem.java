package modelo;

public class Amostragem {

    private int idAmostragem;
    private String tipo;
    private int tamanho;
    private String local;
    private String epoca;
    private String objetivo;
    private Camera camera;

    public int getIdAmostragem() {
        return idAmostragem;
    }

    public void setIdAmostragem(int idAmostragem) {
        this.idAmostragem = idAmostragem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

}
