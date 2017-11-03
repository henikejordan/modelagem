package modelo.iterator;

import java.util.ArrayList;
import modelo.Cultura;

/**
 *
 * @author henik
 */
public class CulturaLista extends ArrayList<Cultura> implements CulturaAggregator {

    @Override
    public CulturaIterator getCulturaIterator() {
        return new CulturaIteratorImpl(this);
    }

}
