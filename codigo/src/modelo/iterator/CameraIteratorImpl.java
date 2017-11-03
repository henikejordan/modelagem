package modelo.iterator;

import java.util.ArrayList;
import modelo.Camera;

/**
 *
 * @author henik
 */
public class CameraIteratorImpl implements CameraIterator {

    private final ArrayList<Camera> cameras;
    private int contador = -1;

    public CameraIteratorImpl(CameraLista cameras) {
        this.cameras = new ArrayList<>();
        for (Camera c : cameras) {
            this.cameras.add(c);
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
        return contador == cameras.size();
    }

    @Override
    public Camera getAtual() {
        if (contador == -1) {
            throw new IllegalStateException("Iterador não inicializado!");
        }

        try {
            return cameras.get(contador);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("Iterador não possui mais elementos!");
        }
    }
}
