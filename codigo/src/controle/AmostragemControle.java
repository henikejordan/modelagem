package controle;

import dao.ConcreteCreatorDAO;
import dao.DAO;
import javax.swing.JOptionPane;
import modelo.Amostragem;
import modelo.Camera;
import modelo.iterator.Lista;
import util.tabela.ModeloTabela;
import util.tabela.ModeloTabelaAmostragem;
import visao.inicio.TelaAmostragem;

/**
 *
 * @author henike
 */
public class AmostragemControle {

    private final DAO daoAmostragem, daoCamera;

    public AmostragemControle() {
        daoAmostragem = new ConcreteCreatorDAO().factoryMethod("Amostragem");
        daoCamera = new ConcreteCreatorDAO().factoryMethod("Câmera");
    }

    public void salvarAmostragem(int id, String tipo, int tamanho, String local, String epoca, String objetivo, int index) {
        Amostragem amostragem = new Amostragem();
        amostragem.setIdAmostragem(id);
        amostragem.setTipo(tipo);
        amostragem.setTamanho(tamanho);
        amostragem.setLocal(local);
        amostragem.setEpoca(epoca);
        amostragem.setObjetivo(objetivo);
        amostragem.setCamera((Camera) getCameras().get(index - 1));
        if (id == 0) {
            if (criar(amostragem)) {
                JOptionPane.showMessageDialog(null, "Amostragem cadastrada com sucesso!");
            }
        } else if (atualizar(amostragem)) {
            JOptionPane.showMessageDialog(null, "Amostragem alterada com sucesso!");
        }
        TelaAmostragem.getInstance().preencherTabela();
    }

    public ModeloTabela getModeloTabela(String str) {
        return new ModeloTabelaAmostragem(daoAmostragem.pesquisar(str), new String[]{null, "Tipo", "Objetivo"});
    }

    public Amostragem getAmostragem(int id) {
        return (Amostragem) daoAmostragem.ler(id);
    }

    public Lista getCameras() {
        return daoCamera.pesquisar("");
    }

    public boolean criar(Amostragem amostragem) {
        return daoAmostragem.inserir(amostragem);
    }

    public boolean atualizar(Amostragem amostragem) {
        return daoAmostragem.alterar(amostragem);
    }

    public boolean deletar(int id) {
        return daoAmostragem.excluir(id);
    }

}
