package modelo.iterator;

import java.util.ArrayList;
import modelo.ClasseSeveridade;

/**
 *
 * @author henik
 */
public class ClasseSeveridadeIteratorImpl implements ClasseSeveridadeIterator {

    private final ArrayList<ClasseSeveridade> classes;
    private int contador = -1;

    public ClasseSeveridadeIteratorImpl(ClasseSeveridadeLista classes) {
        this.classes = new ArrayList<>();
        for (ClasseSeveridade c : classes) {
            this.classes.add(c);
        }
    }

    @Override
    public void primeiro() {
        contador = 0;
    }

    @Override
    public void proximo() {
        contador++;
    }

    @Override
    public boolean isFinalizado() {
        return contador == classes.size();
    }

    @Override
    public ClasseSeveridade getAtual() {
        if (contador == -1) {
            throw new IllegalStateException("Iterador não inicializado!");
        }

        try {
            return classes.get(contador);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("Iterador não possui mais elementos!");
        }
    }

}
