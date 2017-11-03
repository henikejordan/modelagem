package modelo.iterator;

import java.util.ArrayList;
import modelo.Cultura;

/**
 *
 * @author henik
 */
public class CulturaIteratorImpl implements CulturaIterator {

    private final ArrayList<Cultura> culturas;
    private int contador = -1;

    public CulturaIteratorImpl(CulturaLista culturas) {
        this.culturas = new ArrayList<>();
        for (Cultura c : culturas) {
            this.culturas.add(c);
        }
    }

    @Override
    public void primeiro() {
        this.contador = 0;
    }

    @Override
    public void proximo() {
        this.contador++;
    }

    @Override
    public boolean isFinalizado() {
        return contador == culturas.size();
    }

    @Override
    public Cultura getAtual() {
        if (contador == -1) {
            throw new IllegalStateException("Iterador não inicializado!");
        }

        try {
            return culturas.get(contador);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("Iterador não possui mais elementos!");
        }
    }
}
