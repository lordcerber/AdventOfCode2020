package adventofcode.day7;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Bag {
    private String ID;
    private HashMap<Bag, Integer> container;


    public Bag(String ID) {
        this.ID = ID;
        container = new HashMap();
    }


    public void add(String id, int count) {
        //assume that in data id != ID and no loops
        container.put(Solution.getInstance().getBag(id), count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bag day7Bag = (Bag) o;
        return ID.equals(day7Bag.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public boolean isColor(String color) {
        return ID.equals(color);
    }

    public boolean containsAnyDepth(String color) {
        if (ID.equals(color)) return true;
        //and here comes crazy recursion
        else if (container.keySet().stream().anyMatch(key -> key.containsAnyDepth(color))) return true;
        return false;

    }

    public int countInnerTree() {
        AtomicInteger summ = new AtomicInteger(1);
        //even more crazy recursion
        container.forEach((bag, val) -> summ.addAndGet(val * bag.countInnerTree()));
        return summ.get();
    }
}
