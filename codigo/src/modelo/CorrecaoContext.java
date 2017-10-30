package modelo;

/**
 *
 * @author henik
 */
public class CorrecaoContext {

    private final Correcao strategy;

    public CorrecaoContext(Correcao s) {
        this.strategy = s;
    }

    public void corrigirImagem() {
        strategy.corrigirImagem();
    }

}
