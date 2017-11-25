package controle;

import util.tabela.ModeloTabela;

/**
 *
 * @author henike
 */
public abstract class Controle {

    public abstract ModeloTabela getModeloTabela(String str);

    public abstract boolean criar(Object obj);

    public abstract boolean atualizar(Object obj);

    public abstract boolean deletar(int id);

}
