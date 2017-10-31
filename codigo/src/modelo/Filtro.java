package modelo;

public abstract class Filtro {

    private final String input = "img/image.jpg";

    public String getInput() {
        return input;
    }

    public abstract void aplicarFiltro();

}
