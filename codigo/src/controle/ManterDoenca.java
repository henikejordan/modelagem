package controle;

import javax.swing.JOptionPane;
import modelo.Cultura;
import modelo.Doenca;
import visao.inicio.TelaDoenca;
import visao.manter.TelaManterClasseSeveridade;

/**
 *
 * @author william
 */
public class ManterDoenca {

    public static void SalvarDoenca(int id, String nome, String tipo, String caracteristica, int index, String areaDesc, DoencaControle doencaControle) {
        Doenca doenca = new Doenca();
        doenca.setIdDoenca(id);
        doenca.setNome(nome);
        doenca.setTipo(tipo);
        doenca.setCaracteristica(caracteristica);
        doenca.setCultura((Cultura) doencaControle.getCulturas().get(index - 1));
        doenca.setDescricao(areaDesc);
        if (id == 0) {
            if (doencaControle.criar(doenca)) {
                JOptionPane.showMessageDialog(null, "Doença criada com sucesso!");
            }
        } else if (doencaControle.atualizar(doenca)) {
            JOptionPane.showMessageDialog(null, "Doença alterada com sucesso!");
        }
        TelaDoenca.getInstance().preencherTabela();
        TelaManterClasseSeveridade.getInstance().preencherComboBox();
    }

}
