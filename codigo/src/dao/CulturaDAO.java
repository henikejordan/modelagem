package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConectaBanco;

public class CulturaDAO implements DAO {

    @Override
    public ArrayList ler() {
        ArrayList dados = new ArrayList();
        ConectaBanco conecta = ConectaBanco.getInstance();
        ResultSet resultado = conecta.executaSQL("select * from cultura");
        try {
            resultado.first();
            do {
                dados.add(new Object[]{resultado.getString("nome"), resultado.getString("descricao")});
            } while (resultado.next());
        } catch (SQLException ex) {

        }
        return dados;
    }

    @Override
    public boolean inserir() {
        return false;
    }

    @Override
    public boolean alterar() {
        return false;
    }

    @Override
    public boolean apagar() {
        return false;
    }

}
