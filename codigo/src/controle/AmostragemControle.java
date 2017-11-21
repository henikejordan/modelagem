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

    public AmostragemControle() {
        daoAmostragem = new ConcreteCreatorDAO().factoryMethod("Amostragem");
        daoCamera = new ConcreteCreatorDAO().factoryMethod("Câmera");
    }

    @Override
    public ModeloTabela getModeloTabela() {
        return new ModeloTabelaAmostragem(daoAmostragem.lerTodos(), new String[]{null, "Tipo", "Objetivo"});
    }

    public Amostragem getAmostragem(int id) {
        return (Amostragem) daoAmostragem.ler(id);
    }

    public Lista getCameras() {
        return daoCamera.lerTodos();
    }

    @Override
    public boolean criar(Object obj) {
        return daoAmostragem.inserir(obj);
    }

    @Override
    public boolean atualizar(Object obj) {
        return daoAmostragem.alterar(obj);
    }

    @Override
    public boolean deletar(int id) {
        return daoAmostragem.excluir(id);
    }

}
