package modelo.iterator;

import java.util.ArrayList;
import modelo.Amostragem;

/**
 *
 * @author henik
 */
public class AmostragemLista extends ArrayList<Amostragem> implements AmostragemAggregator {

    @Override
    public AmostragemIterator getAmostragemIterator() {
        return new AmostragemIteratorImpl(this);
    }

}
