package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ConcreteCulturaCreator;
import modelo.Cultura;
import modelo.Folha;
import modelo.Fruto;
import modelo.Grao;

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
            return dados;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public Object ler(int id) {
        ResultSet resultado = super.getConecta().executaSQL("select * from cultura where id_cultura='" + id + "'");
        try {
            resultado.first();
            Cultura cultura = new ConcreteCulturaCreator().factoryMethod(resultado.getString("tipo"));
            cultura.setNome(resultado.getString("nome"));
            cultura.setDescricao(resultado.getString("nome"));
            if (cultura instanceof Fruto) {
                Fruto fruto = (Fruto) cultura;
                fruto.setCor(resultado.getString("cor"));
                return fruto;
            } else if (cultura instanceof Grao) {
                Grao grao = (Grao) cultura;
                grao.setCor(resultado.getString("cor"));
                return grao;
            }
            return cultura;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public boolean inserir(Object obj) {
        Cultura cultura = (Cultura) obj;
        PreparedStatement pst;
        try {
            pst = super.getConecta().getConnection().prepareStatement("insert into cultura(nome, tipo, cor, descricao) values(?,?,?,?)");
            pst.setString(1, cultura.getNome());
            if (cultura instanceof Folha) {
                pst.setString(2, "Folha");
                pst.setString(3, "");
            } else if (cultura instanceof Fruto) {
                Fruto fruto = (Fruto) cultura;
                pst.setString(2, "Fruto");
                pst.setString(3, fruto.getCor());
            } else {
                Grao grao = (Grao) cultura;
                pst.setString(2, "Grão");
                pst.setString(3, grao.getCor());
            }
            pst.setString(4, cultura.getDescricao());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean alterar(Object obj) {
        return false;
    }

    @Override
    public boolean apagar(Object obj) {
        return false;
    }

}
