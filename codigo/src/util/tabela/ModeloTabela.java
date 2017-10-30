package util.tabela;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 *
 * @author Henike
 */
public abstract class ModeloTabela extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = null;

    public ModeloTabela(ArrayList lin, String[] col) {
        this.linhas = lin;
        this.colunas = col;
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public String getColumnName(int numCol) {
        return colunas[numCol];
    }
    
}
