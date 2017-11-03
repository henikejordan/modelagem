package modelo.iterator;

import java.util.ArrayList;
import modelo.Doenca;

/**
 *
 * @author henik
 */
public class DoencaLista extends ArrayList<Doenca> implements DoencaAggregator {

    @Override
    public DoencaIterator getDoencaIterator() {
        return new DoencaIteratorImpl(this);
    }

}
