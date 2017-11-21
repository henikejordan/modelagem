package controle;

import dao.ConcreteCreatorDAO;
import dao.DAO;
import modelo.Camera;
import util.tabela.ModeloTabela;
import util.tabela.ModeloTabelaCamera;

/**
 *
 * @author henike
 */
public class CameraControle extends Controle {

    private final DAO daoCamera;

    public CameraControle() {
        daoCamera = new ConcreteCreatorDAO().factoryMethod("Câmera");
    }

    @Override
    public ModeloTabela getModeloTabela() {
        return new ModeloTabelaCamera(daoCamera.lerTodos(), new String[]{null, "Marca", "Modelo"});
    }

    public Camera getCamera(int id) {
        return (Camera) daoCamera.ler(id);
    }

    @Override
    public boolean inserir(Object obj) {
        return daoCamera.inserir(obj);
    }

    @Override
    public boolean alterar(Object obj) {
        return daoCamera.alterar(obj);
    }

    @Override
    public boolean excluir(int id) {
        return daoCamera.excluir(id);
    }

}
