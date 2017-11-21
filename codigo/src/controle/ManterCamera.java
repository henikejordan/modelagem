/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.swing.JOptionPane;
import modelo.Camera;
import visao.inicio.TelaCamera;

/**
 *
 * @author william
 */
public class ManterCamera {
    
    public static void SalvarCamera(int id, String marca, String modelo, float focal, int altura, int largura, String tipoLente, CameraControle cameraControle){
        Camera camera = new Camera();
        camera.setIdCamera(id);
        camera.setMarca(marca);
        camera.setModelo(modelo);
        camera.setDistanciaFocal(focal);
        camera.setAlturaResolucao(altura);
        camera.setLarguraResolucao(largura);
        camera.setTipoLente(tipoLente);
        if (id == 0) {
            if (cameraControle.inserir(camera)) {
                TelaCamera.getInstance().preencherTabela();
                JOptionPane.showMessageDialog(null, "Câmera cadastrada com sucesso!");
            }
        } else if (cameraControle.alterar(camera)) {
            TelaCamera.getInstance().preencherTabela();
            JOptionPane.showMessageDialog(null, "Câmera alterada com sucesso!");
        }
    }
}
