package modelo.iterator;

import java.util.ArrayList;

/**
 *
 * @author henik
 */
public class ConcreteIterator implements Iterator {

    private final ArrayList objetos;
    private int contador = -1;

    public ConcreteIterator(Lista objetos) {
        this.objetos = new ArrayList();
        for (Object obj : objetos) {
            this.objetos.add(obj);
        }
    }

    @Override
    public void primeiro() {
        contador = 0;
    }

    @Override
    public void proximo() {
        contador++;
    }

    @Override
    public boolean isFinalizado() {
        return contador == objetos.size();
    }

    @Override
    public Object getAtual() {
        if (contador == -1) {
            throw new IllegalStateException("Iterador não inicializado!");
        }

        try {
            return objetos.get(contador);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("Iterador não possui mais elementos!");
        }
    }

}
