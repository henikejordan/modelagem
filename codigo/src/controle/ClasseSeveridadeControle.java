package controle;

import dao.CreatorDAO;
import dao.DAO;
import modelo.ClasseSeveridade;
import modelo.iterator.DoencaLista;
import util.tabela.ModeloTabela;
import util.tabela.ModeloTabelaClasseSeveridade;

/**
 *
 * @author henike
 */
public class ClasseSeveridadeControle extends Controle {

    private final DAO daoClasse, daoDoenca;
    private final DoencaLista doencas;

    public ClasseSeveridadeControle() {
        daoClasse = new CreatorDAO().factoryMethod("Classe Severidade");
        daoDoenca = new CreatorDAO().factoryMethod("Doença");
        doencas = (DoencaLista) daoDoenca.lerTodos();
    }

    @Override
    public ModeloTabela getModeloTabela() {
        return new ModeloTabelaClasseSeveridade(daoClasse.lerTodos(), new String[]{null, "Inferior", "Superior"});
    }

    public ClasseSeveridade getClasseSeveridade(int id) {
        return (ClasseSeveridade) daoClasse.ler(id);
    }

    public DoencaLista getDoencas() {
        return doencas;
    }

    @Override
    public boolean inserir(Object obj) {
        return daoClasse.inserir(obj);
    }

    @Override
    public boolean alterar(Object obj) {
        return daoClasse.alterar(obj);
    }

    @Override
    public boolean excluir(int id) {
        return daoClasse.excluir(id);
    }

}
