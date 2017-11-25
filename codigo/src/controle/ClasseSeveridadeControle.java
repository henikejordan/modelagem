package controle;

import dao.ConcreteCreatorDAO;
import dao.DAO;
import javax.swing.JOptionPane;
import modelo.ClasseSeveridade;
import modelo.Doenca;
import modelo.iterator.Lista;
import util.tabela.ModeloTabela;
import util.tabela.ModeloTabelaClasseSeveridade;
import visao.inicio.TelaClasseSeveridade;

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

    public void salvarClasse(int id, float inferior, float superior, int index, String areaDesc) {
        ClasseSeveridade classeSeveridade = new ClasseSeveridade();
        classeSeveridade.setIdClasseSeveridade(id);
        classeSeveridade.setInferior(inferior);
        classeSeveridade.setSuperior(superior);
        classeSeveridade.setDoenca((Doenca) getDoencas().get(index - 1));
        classeSeveridade.setDescricao(areaDesc);
        if (id == 0) {
            if (criar(classeSeveridade)) {
                JOptionPane.showMessageDialog(null, "Classe criada com sucesso!");
            }
        } else if (atualizar(classeSeveridade)) {
            JOptionPane.showMessageDialog(null, "Classe alterada com sucesso!");
        }
        TelaClasseSeveridade.getInstance().preencherTabela();
    }

    @Override
    public ModeloTabela getModeloTabela(String str) {
        return new ModeloTabelaClasseSeveridade(daoClasse.pesquisar(str), new String[]{null, "Doença", "Inferior", "Superior"});
    }

    public ClasseSeveridade getClasseSeveridade(int id) {
        return (ClasseSeveridade) daoClasse.ler(id);
    }

    public Lista getDoencas() {
        return daoDoenca.pesquisar("");
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
