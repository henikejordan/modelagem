package util.tabela;

import java.util.ArrayList;
import modelo.Doenca;

/**
 *
 * @author henike
 */
public class ModeloTabelaDoenca extends ModeloTabela {

    public ModeloTabelaDoenca(ArrayList lin, String[] col) {
        super(lin, col);
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Doenca doenca = (Doenca) getLinhas().get(numLin);
        switch (numCol) {
            case 0:
                return doenca.getIdDoenca();
            case 1:
                return doenca.getNome();
            case 2:
                return doenca.getDescricao();
            default:
                return null;
        }
    }

}
