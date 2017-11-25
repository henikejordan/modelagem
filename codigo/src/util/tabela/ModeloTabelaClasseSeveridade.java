package util.tabela;

import java.math.BigDecimal;
import java.util.ArrayList;
import modelo.ClasseSeveridade;

/**
 *
 * @author henike
 */
public class ModeloTabelaClasseSeveridade extends ModeloTabela {

    public ModeloTabelaClasseSeveridade(ArrayList lin, String[] col) {
        super(lin, col);
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        ClasseSeveridade classeSeveridade = (ClasseSeveridade) getLinhas().get(numLin);
        switch (numCol) {
            case 0:
                return classeSeveridade.getIdClasseSeveridade();
            case 1:
                return classeSeveridade.getDoenca().getNome();
            case 2:
                return new BigDecimal(classeSeveridade.getInferior()).setScale(2, BigDecimal.ROUND_HALF_UP);
            case 3:
                return new BigDecimal(classeSeveridade.getSuperior()).setScale(2, BigDecimal.ROUND_HALF_UP);
            default:
                return null;
        }
    }

}
