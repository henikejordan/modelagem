/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.swing.JOptionPane;
import modelo.Doenca;
import visao.inicio.TelaDoenca;

/**
 *
 * @author william
 */
public class ManterDoenca {
 
    public static void SalvarDoenca(int id, String nome, String tipo, String caracteristica, int  cultura, String areaDesc, DoencaControle doencaControle){
        Doenca doenca = new Doenca();
        doenca.setIdDoenca(id);
        doenca.setNome(nome);
        doenca.setTipo(tipo);
        doenca.setCaracteristica(caracteristica);
        doenca.setCultura(doencaControle.getCulturas().get(cultura));
        doenca.setDescricao(areaDesc);
        if (id == 0) {
            if (doencaControle.inserir(doenca)) {
                TelaDoenca.getInstance().preencherTabela();
                JOptionPane.showMessageDialog(null, "Doença criada com sucesso!");
            }
        } else if (doencaControle.alterar(doenca)) {
            TelaDoenca.getInstance().preencherTabela();
            JOptionPane.showMessageDialog(null, "Doença alterada com sucesso!");
        }
    }
    
}
