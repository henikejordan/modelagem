package modelo;

/**
 *
 * @author henik
 */
public class FiltroContext {

    private final Filtro strategy;

    public FiltroContext(Filtro s) {
        this.strategy = s;
    }

    public void corrigirImagem() {
        strategy.aplicarFiltro();
    }

}
