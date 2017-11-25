package dao;

import modelo.iterator.Lista;
import util.ConectaBanco;

public abstract class DAO {

    private final ConectaBanco conecta = ConectaBanco.getInstance();

    public ConectaBanco getConecta() {
        return conecta;
    }

    public abstract Lista pesquisar(String str);

    public abstract Object ler(int id);

    public abstract boolean inserir(Object obj);

    public abstract boolean alterar(Object obj);

    public abstract boolean excluir(int id);

}
