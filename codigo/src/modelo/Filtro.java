package modelo;

public abstract class Filtro {

    private String dir;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public abstract void aplicarFiltro();

}
