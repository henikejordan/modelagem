package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Camera;
import modelo.Amostragem;

public class AmostragemDAO extends DAO {

    @Override
    public ArrayList lerTodos() {
        ArrayList<Amostragem> amostragens = new ArrayList();
        ResultSet resultado = super.getConecta().executaSQL("select * from amostragem");
        try {
            resultado.first();
            do {
                amostragens.add((Amostragem) ler(resultado.getInt("id_amostragem")));
            } while (resultado.next());
        } catch (SQLException ex) {
            //
        }
        return amostragens;
    }

    @Override
    public Object ler(int id) {
        Amostragem amostragem = new Amostragem();
        Camera camera = new Camera();
        ResultSet resultAmostragem = super.getConecta().executaSQL("select * from amostragem where id_amostragem='" + id + "'");
        try {
            resultAmostragem.first();
            amostragem.setIdAmostragem(resultAmostragem.getInt("id_amostragem"));
            amostragem.setTipo(resultAmostragem.getString("tipo"));
            amostragem.setTamanho(resultAmostragem.getInt("tamanho"));
            amostragem.setLocal(resultAmostragem.getString("local"));
            amostragem.setEpoca(resultAmostragem.getString("epoca"));
            amostragem.setObjetivo(resultAmostragem.getString("objetivo"));
            ResultSet resultCamera = super.getConecta().executaSQL("select * from camera where id_camera='" + resultAmostragem.getInt("id_camera") + "'");
            resultCamera.first();
            camera.setIdCamera(resultCamera.getInt("id_camera"));
            camera.setMarca(resultCamera.getString("marca"));
            camera.setModelo(resultCamera.getString("modelo"));
            camera.setDistanciaFocal(resultCamera.getFloat("distancia_focal"));
            camera.setLarguraResolucao(resultCamera.getInt("largura_resolucao"));
            camera.setAlturaResolucao(resultCamera.getInt("altura_resolucao"));
            camera.setTipoLente(resultCamera.getString("tipo_lente"));
            amostragem.setCamera(camera);
        } catch (SQLException ex) {
            //
        }
        return amostragem;
    }

    @Override
    public boolean inserir(Object obj) {
        Amostragem amostragem = (Amostragem) obj;
        try {
            PreparedStatement pst = super.getConecta().getConnection().prepareStatement("insert into amostragem(tipo, tamanho, local, epoca, objetivo, id_camera) values(?,?,?,?,?,?)");
            pst.setString(1, amostragem.getTipo());
            pst.setInt(2, amostragem.getTamanho());
            pst.setString(3, amostragem.getLocal());
            pst.setString(4, amostragem.getEpoca());
            pst.setString(5, amostragem.getObjetivo());
            pst.setInt(6, amostragem.getCamera().getIdCamera());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean alterar(Object obj) {
        Amostragem amostragem = (Amostragem) obj;
        try {
            PreparedStatement pst = super.getConecta().getConnection().prepareStatement("update amostragem set tipo=?, tamanho=?, local=?, epoca=?, objetivo=?, id_camera=? where id_amostragem=?");
            pst.setString(1, amostragem.getTipo());
            pst.setInt(2, amostragem.getTamanho());
            pst.setString(3, amostragem.getLocal());
            pst.setString(4, amostragem.getEpoca());
            pst.setString(5, amostragem.getObjetivo());
            pst.setInt(6, amostragem.getCamera().getIdCamera());
            pst.setInt(7, amostragem.getIdAmostragem());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean excluir(int id) {
        try {
            PreparedStatement pst = super.getConecta().getConnection().prepareStatement("delete from amostragem where id_amostragem=?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

}
