/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.swing.JOptionPane;
import modelo.Amostragem;
import visao.inicio.TelaAmostragem;

/**
 *
 * @author william
 */
public class ManterAmostragem {

    public static void  SalvarAmostragem(int id, String tipo, int tamanho, String local, String epoca, String objetivo, AmostragemControle amostragemControle, int index) {
        Amostragem amostragem = new Amostragem();
        amostragem.setIdAmostragem(id);
        amostragem.setTipo(tipo);
        amostragem.setTamanho(tamanho);
        amostragem.setLocal(local);
        amostragem.setEpoca(epoca);
        amostragem.setObjetivo(objetivo);
        amostragem.setCamera(amostragemControle.getCameras().get(index - 1));
        if (id == 0) {
            if (amostragemControle.inserir(amostragem)) {
                TelaAmostragem.getInstance().preencherTabela();
                JOptionPane.showMessageDialog(null, "Amostragem cadastrada com sucesso!");
            }
        } else if (amostragemControle.alterar(amostragem)) {
            TelaAmostragem.getInstance().preencherTabela();
            JOptionPane.showMessageDialog(null, "Amostragem alterada com sucesso!");
        }
    }
}