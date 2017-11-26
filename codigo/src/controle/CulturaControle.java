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
public class CulturaControle {

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

    public ModeloTabela getModeloTabela(String str) {
        return new ModeloTabelaCultura(daoCultura.pesquisar(str), new String[]{null, "Nome", "Descrição"});
    }

    public Cultura getCultura(int id) {
        return (Cultura) daoCultura.ler(id);
    }

    public boolean criar(Cultura cultura) {
        return daoCultura.inserir(cultura);
    }

    public boolean atualizar(Cultura cultura) {
        return daoCultura.alterar(cultura);
    }

    public boolean deletar(int id) {
        return daoCultura.excluir(id);
    }

}
