package org.example;

import java.util.ArrayList;
import java.util.List;

public class EngineManager {
    private final List<Engine> engines;

    public EngineManager() {
        this.engines = new ArrayList<>();
    }

    public void addEngine(Engine e) {
        if (e == null) throw new IllegalArgumentException("Engine cannot be null");
        engines.add(e);
    }

    public void removeEngine(int index) {
        if (index < 0 || index >= engines.size())
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        engines.remove(index);
    }

    public List<Engine> getAll() {
        return new ArrayList<>(engines);
    }

    public boolean compare(int i1, int i2) {
        if (i1 < 0 || i1 >= engines.size() || i2 < 0 || i2 >= engines.size())
            throw new IndexOutOfBoundsException("Invalid indices for comparison");
        return engines.get(i1).equals(engines.get(i2));
    }

    public Engine getByIndex(int index) {
        if (index < 0 || index >= engines.size())
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        return engines.get(index);
    }

    public int size() {
        return engines.size();
    }
}
