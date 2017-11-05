package modelo;

public abstract class Filtro {

    private String dirIn, dirOut;

    public String getDirIn() {
        return dirIn;
    }

    public void setDirIn(String dirIn) {
        this.dirIn = dirIn;
    }

    public String getDirOut() {
        return dirOut;
    }

    public void setDirOut(String dirOut) {
        this.dirOut = dirOut;
    }

    public abstract void aplicarFiltro();

}
