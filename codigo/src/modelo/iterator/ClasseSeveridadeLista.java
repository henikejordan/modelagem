package modelo.iterator;

import java.util.ArrayList;
import modelo.ClasseSeveridade;

/**
 *
 * @author henik
 */
public class ClasseSeveridadeLista extends ArrayList<ClasseSeveridade> implements ClasseSeveridadeAggregator {

    @Override
    public ClasseSeveridadeIterator getClasseSeveridadeIterator() {
        return new ClasseSeveridadeIteratorImpl(this);
    }

}
