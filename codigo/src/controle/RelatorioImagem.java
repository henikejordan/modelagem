/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.ConectaBanco;

/**
 *
 * @author User
 */
public class RelatorioImagem implements Relatorio{
  private static ConectaBanco instance;
    private Statement stm; //responsável por preparar e realizar pesquisas no BD
    private Connection conn; //responsável por realizar a conexão com o BD
    private final String driver = "org.postgresql.Driver";
    private final String caminho = "jdbc:postgresql://localhost:5432/";
    private final String usuario = "postgres";
    private final String senha = "12345";

    public RelatorioImagem() {
        try {
            System.setProperty("jdbc.Drivers", driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
        } catch (SQLException ex) {
            //
        }
    }
    
    
    @Override
    public ArrayList gerarRelatorio() {
       ArrayList<String[]> pesquisa = new ArrayList<>();
        ResultSet culturaPesquisa;
        String linha[] = new String[8];
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultado = stm.executeQuery("SELECT * FROM imagem");

            while (resultado.next()) {
                linha[0] = resultado.getString(2);
                linha[1] = resultado.getString(3);
                linha[2] = resultado.getString(4);
                linha[3] = resultado.getString(5);
                linha[4] = resultado.getString(6);
                linha[5] = resultado.getString(7);
                linha[6] = resultado.getString(8);
                linha[7] = resultado.getString(9);

                culturaPesquisa = stm.executeQuery("SELECT nome FROM cultura WHERE id_cultura = " + resultado.getString(6));
                culturaPesquisa.next();

                linha[4] = culturaPesquisa.getString(1);
                
                pesquisa.add(linha);

            }
        } catch (SQLException ex) {
            //
        }
        return pesquisa;
    }
    
}
