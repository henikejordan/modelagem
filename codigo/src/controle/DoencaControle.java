package controle;

import dao.ConcreteCreatorDAO;
import dao.DAO;
import modelo.Doenca;
import modelo.iterator.Lista;
import util.tabela.ModeloTabela;
import util.tabela.ModeloTabelaDoenca;

/**
 *
 * @author henike
 */
public class DoencaControle extends Controle {

    private final DAO daoDoenca, daoCultura;

    public DoencaControle() {
        daoDoenca = new ConcreteCreatorDAO().factoryMethod("Doença");
        daoCultura = new ConcreteCreatorDAO().factoryMethod("Cultura");
    }

    @Override
    public ModeloTabela getModeloTabela() {
        return new ModeloTabelaDoenca(daoDoenca.lerTodos(), new String[]{null, "Nome", "Descrição"});
    }

    public Doenca getDoenca(int id) {
        return (Doenca) daoDoenca.ler(id);
    }

    public Lista getCulturas() {
        return daoCultura.lerTodos();
    }

    @Override
    public boolean criar(Object obj) {
        return daoDoenca.inserir(obj);
    }

    @Override
    public boolean atualizar(Object obj) {
        return daoDoenca.alterar(obj);
    }

    @Override
    public boolean deletar(int id) {
        return daoDoenca.excluir(id);
    }

}
