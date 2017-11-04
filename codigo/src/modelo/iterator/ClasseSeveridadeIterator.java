package modelo.iterator;

import modelo.ClasseSeveridade;

/**
 *
 * @author henik
 */
public interface ClasseSeveridadeIterator {

    void primeiro();

    void proximo();

    boolean isFinalizado();

    ClasseSeveridade getAtual();

}
