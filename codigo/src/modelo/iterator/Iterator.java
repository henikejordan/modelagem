package modelo.iterator;

/**
 *
 * @author henik
 */
public interface Iterator {

    void primeiro();

    void proximo();

    boolean isFinalizado();

    Object getAtual();

}
