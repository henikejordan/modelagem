package modelo.iterator;

import modelo.Amostragem;

/**
 *
 * @author henik
 */
public interface AmostragemIterator {

    void primeiro();

    void proximo();

    boolean isFinalizado();

    Amostragem getAtual();

}
