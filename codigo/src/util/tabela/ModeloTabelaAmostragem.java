package util.tabela;

import java.util.ArrayList;
import modelo.Amostragem;

/**
 *
 * @author henike
 */
public class ModeloTabelaAmostragem extends ModeloTabela {

    public ModeloTabelaAmostragem(ArrayList lin, String[] col) {
        super(lin, col);
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Amostragem amostragem = (Amostragem) getLinhas().get(numLin);
        switch (numCol) {
            case 0:
                return amostragem.getIdAmostragem();
            case 1:
                return amostragem.getTipo();
            case 2:
                return amostragem.getObjetivo();
            default:
                return null;
        }
    }

}
