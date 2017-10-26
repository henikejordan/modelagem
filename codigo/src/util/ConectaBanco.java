package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author henike
 */
public final class ConectaBanco {

    private static ConectaBanco instance;
    private Statement stm; //responsável por preparar e realizar pesquisas no BD
    private Connection conn; //responsável por realizar a conexão com o BD
    private final String driver = "org.postgresql.Driver";
    private final String caminho = "jdbc:postgresql://localhost:5432/";
    private final String usuario = "postgres";
    private final String senha = "12345";

    private ConectaBanco() {
        try {
            System.setProperty("jdbc.Drivers", driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão!\n Erro:" + ex.getMessage());
        }
    }

    public static ConectaBanco getInstance() {
        if (instance == null) {
            instance = new ConectaBanco();
        }
        return instance;
    }

    public ResultSet executaSQL(String sql) {
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no executaSQL!\n Erro:" + ex.getMessage());
        }
        return null;
    }

    public void desconecta() {
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\n Erro:" + ex.getMessage());
        }
    }
}
