package util.tabela;

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
                return classeSeveridade.getInferior();
            case 2:
                return classeSeveridade.getSuperior();
            default:
                return null;
        }
    }

}
