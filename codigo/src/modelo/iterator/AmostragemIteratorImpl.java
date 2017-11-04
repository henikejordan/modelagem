package modelo.iterator;

import java.util.ArrayList;
import modelo.Amostragem;

/**
 *
 * @author henik
 */
public class AmostragemIteratorImpl implements AmostragemIterator {

    private final ArrayList<Amostragem> amostragens;
    private int contador = -1;

    public AmostragemIteratorImpl(AmostragemLista amostragens) {
        this.amostragens = new ArrayList<>();
        for (Amostragem a : amostragens) {
            this.amostragens.add(a);
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
        return contador == amostragens.size();
    }

    @Override
    public Amostragem getAtual() {
        if (contador == -1) {
            throw new IllegalStateException("Iterador não inicializado!");
        }

        try {
            return amostragens.get(contador);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("Iterador não possui mais elementos!");
        }
    }

}
