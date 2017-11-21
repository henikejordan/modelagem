/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.swing.JOptionPane;
import modelo.ClasseSeveridade;
import visao.inicio.TelaClasseSeveridade;

/**
 *
 * @author william
 */
public class ManterClasseSeveridade {
    
    public static void salvarSeveridade(int id, float inferior, float superior, int Doenca, String areaDesc, ClasseSeveridadeControle  classeSeveridadeControle){
        ClasseSeveridade classeSeveridade = new ClasseSeveridade();
        classeSeveridade.setIdClasseSeveridade(id);
        classeSeveridade.setInferior(inferior);
        classeSeveridade.setSuperior(superior);
        classeSeveridade.setDoenca(classeSeveridadeControle.getDoencas().get(Doenca));
        classeSeveridade.setDescricao(areaDesc);
        if (id == 0) {
            if (classeSeveridadeControle.inserir(classeSeveridade)) {
                TelaClasseSeveridade.getInstance().preencherTabela();
                JOptionPane.showMessageDialog(null, "Classe criada com sucesso!");
            }
        } else if (classeSeveridadeControle.alterar(classeSeveridade)) {
            TelaClasseSeveridade.getInstance().preencherTabela();
            JOptionPane.showMessageDialog(null, "Classe alterada com sucesso!");
        }
    }
    
}
