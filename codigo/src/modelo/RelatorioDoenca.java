package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConectaBanco;

/**
 *
 * @author User
 */
public class RelatorioDoenca implements Relatorio {

    private final ConectaBanco conecta = ConectaBanco.getInstance();

    public ConectaBanco getConecta() {
        return conecta;
    }

    @Override
    public ArrayList gerarRelatorio() {
        ArrayList<String[]> pesquisa = new ArrayList<>();
        try {
            ResultSet resultado = getConecta().executaSQL("SELECT * FROM doenca");

            while (resultado.next()) {
                String linha[] = new String[5];
                linha[0] = resultado.getString(2);
                linha[1] = resultado.getString(3);
                linha[2] = resultado.getString(4);
                linha[3] = resultado.getString(5);
                ResultSet culturaPesquisa = getConecta().executaSQL("SELECT nome FROM cultura WHERE id_cultura = " + resultado.getString(6));
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
