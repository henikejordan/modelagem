package modelo.iterator;

import modelo.Doenca;

/**
 *
 * @author henik
 */
public interface DoencaIterator {

    void primeiro();

    void proximo();

    boolean isFinalizado();

    Doenca getAtual();
}
