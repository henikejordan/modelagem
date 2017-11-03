package modelo.iterator;

import modelo.Camera;

/**
 *
 * @author henik
 */
public interface CameraIterator {

    void primeiro();

    void proximo();

    boolean isFinalizado();

    Camera getAtual();

}
