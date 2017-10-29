package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cultura;
import modelo.Doenca;

public class DoencaDAO extends DAO {

    @Override
    public ArrayList lerTodos() {
        ArrayList<Doenca> doencas = new ArrayList();
        ResultSet resultado = super.getConecta().executaSQL("select * from doenca");
        try {
            resultado.first();
            do {
                doencas.add((Doenca) ler(resultado.getInt("id_doenca")));
            } while (resultado.next());
        } catch (SQLException ex) {
            //
        }
        return doencas;
    }

    @Override
    public Object ler(int id) {
        Doenca doenca = new Doenca();
        Cultura cultura = new Cultura();
        ResultSet resultDoenca = super.getConecta().executaSQL("select * from doenca where id_doenca='" + id + "'");
        try {
            resultDoenca.first();
            doenca.setIdDoenca(resultDoenca.getInt("id_doenca"));
            doenca.setNome(resultDoenca.getString("nome"));
            doenca.setTipo(resultDoenca.getString("tipo"));
            doenca.setCaracteristica(resultDoenca.getString("caracteristica"));
            doenca.setDescricao(resultDoenca.getString("descricao"));
            ResultSet resultCultura = super.getConecta().executaSQL("select * from cultura where id_cultura='" + resultDoenca.getInt("id_cultura") + "'");
            resultCultura.first();
            cultura.setIdCultura(resultCultura.getInt("id_cultura"));
            cultura.setNome(resultCultura.getString("nome"));
            cultura.setTipo(resultCultura.getString("tipo"));
            cultura.setCor(resultCultura.getString("cor"));
            cultura.setDescricao(resultCultura.getString("descricao"));
            doenca.setCultura(cultura);
        } catch (SQLException ex) {
            //
        }
        return doenca;
    }

    @Override
    public boolean inserir(Object obj) {
        Doenca doenca = (Doenca) obj;
        try {
            PreparedStatement pst = super.getConecta().getConnection().prepareStatement("insert into doenca(nome, tipo, caracteristica, descricao, id_cultura) values(?,?,?,?,?)");
            pst.setString(1, doenca.getNome());
            pst.setString(2, doenca.getTipo());
            pst.setString(3, doenca.getCaracteristica());
            pst.setString(4, doenca.getDescricao());
            pst.setInt(5, doenca.getCultura().getIdCultura());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean alterar(Object obj) {
        Doenca doenca = (Doenca) obj;
        try {
            PreparedStatement pst = super.getConecta().getConnection().prepareStatement("update doenca set nome=?, tipo=?, caracteristica=?, descricao=?, id_cultura=? where id_doenca=?");
            pst.setString(1, doenca.getNome());
            pst.setString(2, doenca.getTipo());
            pst.setString(3, doenca.getCaracteristica());
            pst.setString(4, doenca.getDescricao());
            pst.setInt(5, doenca.getCultura().getIdCultura());
            pst.setInt(6, doenca.getIdDoenca());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean excluir(int id) {
        try {
            PreparedStatement pst = super.getConecta().getConnection().prepareStatement("delete from doenca where id_doenca=?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

}
