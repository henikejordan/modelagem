package controle;

import dao.ConcreteCreatorDAO;
import dao.DAO;
import javax.swing.JOptionPane;
import modelo.Cultura;
import modelo.Doenca;
import modelo.iterator.Lista;
import util.tabela.ModeloTabela;
import util.tabela.ModeloTabelaDoenca;
import visao.inicio.TelaDoenca;
import visao.manter.TelaManterClasseSeveridade;

/**
 *
 * @author henike
 */
public class DoencaControle {

    private final DAO daoDoenca, daoCultura;

    public DoencaControle() {
        daoDoenca = new ConcreteCreatorDAO().factoryMethod("Doença");
        daoCultura = new ConcreteCreatorDAO().factoryMethod("Cultura");
    }

    public void salvarDoenca(int id, String nome, String tipo, String caracteristica, int index, String areaDesc) {
        Doenca doenca = new Doenca();
        doenca.setIdDoenca(id);
        doenca.setNome(nome);
        doenca.setTipo(tipo);
        doenca.setCaracteristica(caracteristica);
        doenca.setCultura((Cultura) getCulturas().get(index - 1));
        doenca.setDescricao(areaDesc);
        if (id == 0) {
            if (criar(doenca)) {
                JOptionPane.showMessageDialog(null, "Doença criada com sucesso!");
            }
        } else if (atualizar(doenca)) {
            JOptionPane.showMessageDialog(null, "Doença alterada com sucesso!");
        }
        TelaDoenca.getInstance().preencherTabela();
        TelaManterClasseSeveridade.getInstance().preencherComboBox();
    }

    public ModeloTabela getModeloTabela(String str) {
        return new ModeloTabelaDoenca(daoDoenca.pesquisar(str), new String[]{null, "Nome", "Descrição"});
    }

    public Doenca getDoenca(int id) {
        return (Doenca) daoDoenca.ler(id);
    }

    public Lista getCulturas() {
        return daoCultura.pesquisar("");
    }

    public boolean criar(Doenca doenca) {
        return daoDoenca.inserir(doenca);
    }

    public boolean atualizar(Doenca doenca) {
        return daoDoenca.alterar(doenca);
    }

    public boolean deletar(int id) {
        return daoDoenca.excluir(id);
    }

}
