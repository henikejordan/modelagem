package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cultura;

public class CulturaDAO extends DAO {

    @Override
    public ArrayList lerTodos() {
        ArrayList dados = new ArrayList();
        ResultSet resultado = super.getConecta().executaSQL("select * from cultura");
        try {
            resultado.first();
            do {
                dados.add(new Object[]{resultado.getInt("id_cultura"), resultado.getString("nome"), resultado.getString("descricao")});
            } while (resultado.next());
        } catch (SQLException ex) {
            //
        }
        return dados;
    }

    @Override
    public Object ler(int id) {
        Cultura cultura = new Cultura();
        ResultSet resultado = super.getConecta().executaSQL("select * from cultura where id_cultura='" + id + "'");
        try {
            resultado.first();
            cultura.setNome(resultado.getString("nome"));
            cultura.setTipo(resultado.getString("tipo"));
            cultura.setCor(resultado.getString("cor"));
            cultura.setDescricao(resultado.getString("descricao"));

        } catch (SQLException ex) {
            //
        }
        return cultura;
    }

    @Override
    public boolean inserir(Object obj) {
        Cultura cultura = (Cultura) obj;
        PreparedStatement pst;
        try {
            pst = super.getConecta().getConnection().prepareStatement("insert into cultura(nome, tipo, cor, descricao) values(?,?,?,?)");
            pst.setString(1, cultura.getNome());
            pst.setString(2, cultura.getTipo());
            pst.setString(3, cultura.getCor());
            pst.setString(4, cultura.getDescricao());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean alterar(Object obj) {
        Cultura cultura = (Cultura) obj;
        PreparedStatement pst;
        try {
            pst = super.getConecta().getConnection().prepareStatement("update cultura set nome=?, tipo=?, cor=?, descricao=? where id_cultura=?");
            pst.setString(1, cultura.getNome());
            pst.setString(2, cultura.getTipo());
            pst.setString(3, cultura.getCor());
            pst.setString(4, cultura.getDescricao());
            pst.setInt(5, cultura.getIdCultura());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean apagar(int id) {
        PreparedStatement pst;
        try {
            pst = super.getConecta().getConnection().prepareStatement("delete from cultura where id_cultura=?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

}
