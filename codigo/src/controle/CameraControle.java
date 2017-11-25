package controle;

import dao.ConcreteCreatorDAO;
import dao.DAO;
import javax.swing.JOptionPane;
import modelo.Camera;
import util.tabela.ModeloTabela;
import util.tabela.ModeloTabelaCamera;
import visao.inicio.TelaCamera;
import visao.manter.TelaManterAmostragem;

/**
 *
 * @author henike
 */
public class CameraControle extends Controle {

    private final DAO daoCamera;

    public CameraControle() {
        daoCamera = new ConcreteCreatorDAO().factoryMethod("Câmera");
    }

    public void salvarCamera(int id, String marca, String modelo, float focal, int altura, int largura, String tipoLente) {
        Camera camera = new Camera();
        camera.setIdCamera(id);
        camera.setMarca(marca);
        camera.setModelo(modelo);
        camera.setDistanciaFocal(focal);
        camera.setAlturaResolucao(altura);
        camera.setLarguraResolucao(largura);
        camera.setTipoLente(tipoLente);
        if (id == 0) {
            if (criar(camera)) {
                JOptionPane.showMessageDialog(null, "Câmera cadastrada com sucesso!");
            }
        } else if (atualizar(camera)) {
            JOptionPane.showMessageDialog(null, "Câmera alterada com sucesso!");
        }
        TelaCamera.getInstance().preencherTabela();
        TelaManterAmostragem.getInstance().preencherComboBox();
    }

    @Override
    public ModeloTabela getModeloTabela(String str) {
        return new ModeloTabelaCamera(daoCamera.pesquisar(str), new String[]{null, "Modelo", "Marca"});
    }

    public Camera getCamera(int id) {
        return (Camera) daoCamera.ler(id);
    }

    @Override
    public boolean criar(Object obj) {
        return daoCamera.inserir(obj);
    }

    @Override
    public boolean atualizar(Object obj) {
        return daoCamera.alterar(obj);
    }

    @Override
    public boolean deletar(int id) {
        return daoCamera.excluir(id);
    }

}
