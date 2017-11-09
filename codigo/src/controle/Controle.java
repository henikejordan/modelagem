package controle;

import util.tabela.ModeloTabela;

/**
 *
 * @author henike
 */
public abstract class Controle {

    public abstract ModeloTabela getModeloTabela();

    public abstract boolean inserir(Object obj);

    public abstract boolean alterar(Object obj);

    public abstract boolean excluir(int id);

}
