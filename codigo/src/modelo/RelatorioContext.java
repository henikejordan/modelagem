package modelo;

/**
 *
 * @author henik
 */
public class RelatorioContext {

    private final Relatorio strategy;

    public RelatorioContext(Relatorio s) {
        this.strategy = s;
    }

    public void gerarRelatorio() {
        strategy.gerarRelatorio();
    }

}
