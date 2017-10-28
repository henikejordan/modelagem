package util.tabela;

import java.util.ArrayList;
import modelo.Cultura;

/**
 *
 * @author henike
 */
public class ModeloTabelaCultura extends ModeloTabela {

    public ModeloTabelaCultura(ArrayList lin, String[] col) {
        super(lin, col);
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Cultura cultura = (Cultura) getLinhas().get(numLin);
        switch (numCol) {            
            case 0:
                return cultura.getIdCultura();
            case 1:
                return cultura.getNome();
            case 2:
                return cultura.getDescricao();
            default:
                return null;
        }
    }

}
