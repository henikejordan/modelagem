package modelo.iterator;

import java.util.ArrayList;
import modelo.Doenca;

/**
 *
 * @author henik
 */
public class DoencaIteratorImpl implements DoencaIterator {

    private final ArrayList<Doenca> doencas;
    private int contador = -1;

    public DoencaIteratorImpl(DoencaLista doencas) {
        this.doencas = new ArrayList<>();
        for (Doenca d : doencas) {
            this.doencas.add(d);
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
        return contador == doencas.size();
    }

    @Override
    public Doenca getAtual() {
        if (contador == -1) {
            throw new IllegalStateException("Iterador não inicializado!");
        }

        try {
            return doencas.get(contador);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("Iterador não possui mais elementos!");
        }
    }

}
