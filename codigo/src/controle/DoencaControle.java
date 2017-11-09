package controle;

import dao.CreatorDAO;
import dao.DAO;
import modelo.Doenca;
import modelo.iterator.CulturaLista;
import util.tabela.ModeloTabela;
import util.tabela.ModeloTabelaDoenca;

/**
 *
 * @author henike
 */
public class DoencaControle extends Controle {

    private final DAO daoDoenca, daoCultura;
    private final CulturaLista culturas;

    public DoencaControle() {
        daoDoenca = new CreatorDAO().factoryMethod("Doença");
        daoCultura = new CreatorDAO().factoryMethod("Cultura");
        culturas = (CulturaLista) daoCultura.lerTodos();
    }

    @Override
    public ModeloTabela getModeloTabela() {
        return new ModeloTabelaDoenca(daoDoenca.lerTodos(), new String[]{null, "Nome", "Descrição"});
    }

    public Doenca getDoenca(int id) {
        return (Doenca) daoDoenca.ler(id);
    }

    public CulturaLista getCulturas() {
        return culturas;
    }

    @Override
    public boolean inserir(Object obj) {
        return daoDoenca.inserir(obj);
    }

    @Override
    public boolean alterar(Object obj) {
        return daoDoenca.alterar(obj);
    }

    @Override
    public boolean excluir(int id) {
        return daoDoenca.excluir(id);
    }

}
