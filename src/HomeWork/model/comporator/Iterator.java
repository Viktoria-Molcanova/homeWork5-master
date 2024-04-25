package HomeWork.model.comporator;

import java.util.List;

import HomeWork.model.Description;

public class Iterator<T extends Description> implements java.util.Iterator<T> {
    private int index;
    private List<T> humans;

    public Iterator(List<T> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size() > index;
    }

    @Override
    public T next() {
        return humans.get(index++);
    }
}
