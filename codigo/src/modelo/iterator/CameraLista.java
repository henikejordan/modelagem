package modelo.iterator;

import java.util.ArrayList;
import modelo.Camera;

/**
 *
 * @author henik
 */
public class CameraLista extends ArrayList<Camera> implements CameraAggregator {

    @Override
    public CameraIterator getCameraIterator() {
        return new CameraIteratorImpl(this);
    }

}
