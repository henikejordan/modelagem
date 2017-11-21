package controle;

import dao.ConcreteCreatorDAO;
import dao.DAO;
import modelo.Amostragem;
import modelo.iterator.Lista;
import util.tabela.ModeloTabela;
import util.tabela.ModeloTabelaAmostragem;

/**
 *
 * @author henike
 */
public class AmostragemControle extends Controle {

    private final DAO daoAmostragem, daoCamera;
    private final Lista cameras;

    public AmostragemControle() {
        daoAmostragem = new ConcreteCreatorDAO().factoryMethod("Amostragem");
        daoCamera = new ConcreteCreatorDAO().factoryMethod("Câmera");
        cameras = daoCamera.lerTodos();
    }

    @Override
    public ModeloTabela getModeloTabela() {
        return new ModeloTabelaAmostragem(daoAmostragem.lerTodos(), new String[]{null, "Tipo", "Objetivo"});
    }

    public Amostragem getAmostragem(int id) {
        return (Amostragem) daoAmostragem.ler(id);
    }

    public Lista getCameras() {
        return cameras;
    }

    @Override
    public boolean inserir(Object obj) {
        return daoAmostragem.inserir(obj);
    }

    @Override
    public boolean alterar(Object obj) {
        return daoAmostragem.alterar(obj);
    }

    @Override
    public boolean excluir(int id) {
        return daoAmostragem.excluir(id);
    }

}
