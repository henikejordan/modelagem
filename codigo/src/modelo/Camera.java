package modelo;

public class Camera {

    private int idCamera;
    private String marca;
    private String modelo;
    private float distanciaFocal;
    private int larguraResolucao;
    private int alturaResolucao;
    private String tipoLente;

    public int getIdCamera() {
        return idCamera;
    }

    public void setIdCamera(int idCamera) {
        this.idCamera = idCamera;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getDistanciaFocal() {
        return distanciaFocal;
    }

    public void setDistanciaFocal(float distanciaFocal) {
        this.distanciaFocal = distanciaFocal;
    }

    public int getLarguraResolucao() {
        return larguraResolucao;
    }

    public void setLarguraResolucao(int larguraResolucao) {
        this.larguraResolucao = larguraResolucao;
    }

    public int getAlturaResolucao() {
        return alturaResolucao;
    }

    public void setAlturaResolucao(int alturaResolucao) {
        this.alturaResolucao = alturaResolucao;
    }

    public String getTipoLente() {
        return tipoLente;
    }

    public void setTipoLente(String tipoLente) {
        this.tipoLente = tipoLente;
    }

}
