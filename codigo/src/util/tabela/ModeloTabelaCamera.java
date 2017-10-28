package util.tabela;

import java.util.ArrayList;
import modelo.Camera;

/**
 *
 * @author henike
 */
public class ModeloTabelaCamera extends ModeloTabela {

    public ModeloTabelaCamera(ArrayList lin, String[] col) {
        super(lin, col);
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Camera camera = (Camera) getLinhas().get(numLin);
        switch (numCol) {
            case 0:
                return camera.getIdCamera();
            case 1:
                return camera.getMarca();
            case 2:
                return camera.getModelo();
            default:
                return null;
        }
    }

}
