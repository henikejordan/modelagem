package controle;

import dao.CreatorDAO;
import dao.DAO;
import modelo.Cultura;
import util.tabela.ModeloTabela;
import util.tabela.ModeloTabelaCultura;

/**
 *
 * @author henike
 */
public class CulturaControle extends Controle {

    private final DAO daoCultura;

    public CulturaControle() {
        daoCultura = new CreatorDAO().factoryMethod("Cultura");
    }

    @Override
    public ModeloTabela getModeloTabela() {
        return new ModeloTabelaCultura(daoCultura.lerTodos(), new String[]{null, "Nome", "Descrição"});
    }

    public Cultura getCultura(int id) {
        return (Cultura) daoCultura.ler(id);
    }

    @Override
    public boolean inserir(Object obj) {
        return daoCultura.inserir(obj);
    }

    @Override
    public boolean alterar(Object obj) {
        return daoCultura.alterar(obj);
    }

    @Override
    public boolean excluir(int id) {
        return daoCultura.excluir(id);
    }

}
