package controle;

import dao.ConcreteCreatorDAO;
import dao.DAO;
import modelo.ClasseSeveridade;
import modelo.iterator.Lista;
import util.tabela.ModeloTabela;
import util.tabela.ModeloTabelaClasseSeveridade;

/**
 *
 * @author henike
 */
public class ClasseSeveridadeControle extends Controle {

    private final DAO daoClasse, daoDoenca;

    public ClasseSeveridadeControle() {
        daoClasse = new ConcreteCreatorDAO().factoryMethod("Classe Severidade");
        daoDoenca = new ConcreteCreatorDAO().factoryMethod("Doença");
    }

    @Override
    public ModeloTabela getModeloTabela() {
        return new ModeloTabelaClasseSeveridade(daoClasse.lerTodos(), new String[]{null, "Inferior", "Superior"});
    }

    public ClasseSeveridade getClasseSeveridade(int id) {
        return (ClasseSeveridade) daoClasse.ler(id);
    }

    public Lista getDoencas() {
        return daoDoenca.lerTodos();
    }

    @Override
    public boolean criar(Object obj) {
        return daoClasse.inserir(obj);
    }

    @Override
    public boolean atualizar(Object obj) {
        return daoClasse.alterar(obj);
    }

    @Override
    public boolean deletar(int id) {
        return daoClasse.excluir(id);
    }

}
