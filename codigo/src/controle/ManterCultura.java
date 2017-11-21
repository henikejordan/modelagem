/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.Debug.id;
import modelo.Cultura;
import visao.inicio.TelaCultura;

/**
 *
 * @author william
 */
public class ManterCultura {


    public static void SalvarCultura(int id, String nome, String tipo, String cor, String areaDesc, CulturaControle culturaControle) {
       
        Cultura cultura = new Cultura();
        cultura.setIdCultura(id);
        cultura.setNome(nome);
        cultura.setTipo(tipo);
        cultura.setCor(cor);
        cultura.setDescricao(areaDesc);
        if (id == 0) {
            if (culturaControle.inserir(cultura)) {
                TelaCultura.getInstance().preencherTabela();
                JOptionPane.showMessageDialog(null, "Cultura criada com sucesso!");
            }
        } else if (culturaControle.alterar(cultura)) {
            TelaCultura.getInstance().preencherTabela();
            JOptionPane.showMessageDialog(null, "Cultura alterada com sucesso!");
        }
    }

}
