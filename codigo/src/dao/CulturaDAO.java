package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cultura;
import modelo.iterator.Lista;

public class CulturaDAO extends DAO {

    @Override
    public Lista lerTodos() {
        Lista culturas = new Lista();
        ResultSet resultado = super.getConecta().executaSQL("select * from cultura");
        try {
            resultado.first();
            do {
                culturas.add((Cultura) ler(resultado.getInt("id_cultura")));
            } while (resultado.next());
        } catch (SQLException ex) {
            //
        }
        return culturas;
    }

    @Override
    public Object ler(int id) {
        Cultura cultura = new Cultura();
        try {
            ResultSet resultado = super.getConecta().executaSQL("select * from cultura where id_cultura='" + id + "'");
            resultado.first();
            cultura.setIdCultura(resultado.getInt("id_cultura"));
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
        try {
            PreparedStatement pst = super.getConecta().getConnection().prepareStatement("insert into cultura(nome, tipo, cor, descricao) values(?,?,?,?)");
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
        try {
            PreparedStatement pst = super.getConecta().getConnection().prepareStatement("update cultura set nome=?, tipo=?, cor=?, descricao=? where id_cultura=?");
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
    public boolean excluir(int id) {
        try {
            PreparedStatement pst = super.getConecta().getConnection().prepareStatement("delete from cultura where id_cultura=?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

}
