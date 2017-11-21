package controle;

import javax.swing.JOptionPane;
import modelo.Cultura;
import visao.inicio.TelaCultura;
import visao.manter.TelaManterDoenca;

/**
 *
 * @author william
 */
public class ManterCultura {

    public static void SalvarCultura(int id, String nome, String tipo, String cor, String areaDesc, CulturaControle culturaControle) {
        Cultura cultura = new Cultura();
        cultura.setIdCultura(id);
        cultura.setNome(nome);
        cultura.setTipo(tipo);
        cultura.setCor(cor);
        cultura.setDescricao(areaDesc);
        if (id == 0) {
            if (culturaControle.criar(cultura)) {
                JOptionPane.showMessageDialog(null, "Cultura criada com sucesso!");
            }
        } else if (culturaControle.atualizar(cultura)) {
            JOptionPane.showMessageDialog(null, "Cultura alterada com sucesso!");
        }
        TelaCultura.getInstance().preencherTabela();
        TelaManterDoenca.getInstance().preencherComboBox();
    }

}
