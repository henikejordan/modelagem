package modelo.iterator;

import java.util.ArrayList;

/**
 *
 * @author henik
 */
public class Lista extends ArrayList implements Aggregator {

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(this);
    }

}
