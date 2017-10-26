package controle;

import java.sql.ResultSet;
import java.sql.SQLException;
import util.ConectaBanco;

/**
 *
 * @author henike
 */
public class Principal {

    public static void main(String[] args) {
        ConectaBanco conecta = ConectaBanco.getInstance();
        ResultSet resultado = conecta.executaSQL("select * from cultura");
        try {
            resultado.first();
            System.out.println(resultado.getString("nome"));
        } catch (SQLException ex) {
            
        }
    }

}
