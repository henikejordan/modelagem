package modelo;

public abstract class Correcao {

    private final String input = "img/image.jpg";

    public String getInput() {
        return input;
    }

    public abstract void corrigirImagem();

}
