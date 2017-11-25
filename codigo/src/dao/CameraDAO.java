package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Camera;
import modelo.iterator.Lista;

public class CameraDAO extends DAO {

    @Override
    public Lista pesquisar(String str) {
        Lista cameras = new Lista();
        ResultSet resultado = super.getConecta().executaSQL("select * from camera where modelo ~* '" + str + "' order by modelo");
        try {
            resultado.first();
            do {
                cameras.add((Camera) ler(resultado.getInt("id_camera")));
            } while (resultado.next());
        } catch (SQLException ex) {
            //
        }
        return cameras;
    }

    @Override
    public Object ler(int id) {
        Camera camera = new Camera();
        try {
            ResultSet resultado = super.getConecta().executaSQL("select * from camera where id_camera='" + id + "'");
            resultado.first();
            camera.setIdCamera(resultado.getInt("id_camera"));
            camera.setMarca(resultado.getString("marca"));
            camera.setModelo(resultado.getString("modelo"));
            camera.setDistanciaFocal(resultado.getFloat("distancia_focal"));
            camera.setLarguraResolucao(resultado.getInt("largura_resolucao"));
            camera.setAlturaResolucao(resultado.getInt("altura_resolucao"));
            camera.setTipoLente(resultado.getString("tipo_lente"));
        } catch (SQLException ex) {
            //
        }
        return camera;
    }

    @Override
    public boolean inserir(Object obj) {
        Camera camera = (Camera) obj;
        try {
            PreparedStatement pst = super.getConecta().getConnection().prepareStatement("insert into camera(marca, modelo, distancia_focal,"
                    + " largura_resolucao, altura_resolucao, tipo_lente) values(?,?,?,?,?,?)");
            pst.setString(1, camera.getMarca());
            pst.setString(2, camera.getModelo());
            pst.setFloat(3, camera.getDistanciaFocal());
            pst.setInt(4, camera.getLarguraResolucao());
            pst.setInt(5, camera.getAlturaResolucao());
            pst.setString(6, camera.getTipoLente());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean alterar(Object obj) {
        Camera camera = (Camera) obj;
        try {
            PreparedStatement pst = super.getConecta().getConnection().prepareStatement("update camera set marca=?, modelo=?, distancia_focal=?,"
                    + " largura_resolucao=?, altura_resolucao=?, tipo_lente=? where id_camera=?");
            pst.setString(1, camera.getMarca());
            pst.setString(2, camera.getModelo());
            pst.setFloat(3, camera.getDistanciaFocal());
            pst.setInt(4, camera.getLarguraResolucao());
            pst.setInt(5, camera.getAlturaResolucao());
            pst.setString(6, camera.getTipoLente());
            pst.setInt(7, camera.getIdCamera());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean excluir(int id) {
        try {
            PreparedStatement pst = super.getConecta().getConnection().prepareStatement("delete from camera where id_camera=?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

}
