package modelo.iterator;

import modelo.Cultura;

/**
 *
 * @author henik
 */
public interface CulturaIterator {

    void primeiro();

    void proximo();

    boolean isFinalizado();

    Cultura getAtual();

}
