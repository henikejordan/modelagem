package controle;

import javax.swing.JOptionPane;
import modelo.ClasseSeveridade;
import modelo.Doenca;
import visao.inicio.TelaClasseSeveridade;

/**
 *
 * @author william
 */
public class ManterClasseSeveridade {

    public static void salvarSeveridade(int id, float inferior, float superior, int index, String areaDesc, ClasseSeveridadeControle classeSeveridadeControle) {
        ClasseSeveridade classeSeveridade = new ClasseSeveridade();
        classeSeveridade.setIdClasseSeveridade(id);
        classeSeveridade.setInferior(inferior);
        classeSeveridade.setSuperior(superior);
        classeSeveridade.setDoenca((Doenca) classeSeveridadeControle.getDoencas().get(index - 1));
        classeSeveridade.setDescricao(areaDesc);
        if (id == 0) {
            if (classeSeveridadeControle.criar(classeSeveridade)) {
                JOptionPane.showMessageDialog(null, "Classe criada com sucesso!");
            }
        } else if (classeSeveridadeControle.atualizar(classeSeveridade)) {
            JOptionPane.showMessageDialog(null, "Classe alterada com sucesso!");
        }
        TelaClasseSeveridade.getInstance().preencherTabela();
    }

}
