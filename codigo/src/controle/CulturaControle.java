package controle;

import dao.ConcreteCreatorDAO;
import dao.DAO;
import javax.swing.JOptionPane;
import modelo.Cultura;
import util.tabela.ModeloTabela;
import util.tabela.ModeloTabelaCultura;
import visao.inicio.TelaCultura;
import visao.manter.TelaManterDoenca;

/**
 *
 * @author henike
 */
public class CulturaControle extends Controle {

    private final DAO daoCultura;

    public CulturaControle() {
        daoCultura = new ConcreteCreatorDAO().factoryMethod("Cultura");
    }

    public void salvarCultura(int id, String nome, String tipo, String cor, String areaDesc) {
        Cultura cultura = new Cultura();
        cultura.setIdCultura(id);
        cultura.setNome(nome);
        cultura.setTipo(tipo);
        cultura.setCor(cor);
        cultura.setDescricao(areaDesc);
        if (id == 0) {
            if (criar(cultura)) {
                JOptionPane.showMessageDialog(null, "Cultura criada com sucesso!");
            }
        } else if (atualizar(cultura)) {
            JOptionPane.showMessageDialog(null, "Cultura alterada com sucesso!");
        }
        TelaCultura.getInstance().preencherTabela();
        TelaManterDoenca.getInstance().preencherComboBox();
    }

    @Override
    public ModeloTabela getModeloTabela(String str) {
        return new ModeloTabelaCultura(daoCultura.pesquisar(str), new String[]{null, "Nome", "Descrição"});
    }

    public Cultura getCultura(int id) {
        return (Cultura) daoCultura.ler(id);
    }

    @Override
    public boolean criar(Object obj) {
        return daoCultura.inserir(obj);
    }

    @Override
    public boolean atualizar(Object obj) {
        return daoCultura.alterar(obj);
    }

    @Override
    public boolean deletar(int id) {
        return daoCultura.excluir(id);
    }

}
