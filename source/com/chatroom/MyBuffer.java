package chatroom;

/**
 * First in first out storage unit.
 * 
 * @param <T>
 *            Type to store.
 */
public class MyBuffer<T> {
private Unit topUnit;

public MyBuffer() {
    
}

/**
 * Adds a unit to the top of the stack
 * 
 * @param i
 *            data to store
 */
public void add(T i) {
    if (this.topUnit == null) {
        this.topUnit = new Unit(i);
    } else {
        Unit u = new Unit(i);
        u.next = this.topUnit;
        this.topUnit = u;
    }
}

/**
 * gets data a index 0.
 * 
 * @return data at index 0.
 */
public T get() {
    if (this.topUnit == null) {
        throw new IndexOutOfBoundsException();
    } else {
        return this.topUnit.data;
    }
}

/**
 * A indexed get method
 * 
 * @param index
 *            to return.
 * @return data at that index.
 */
public T get(int index) {
    if (index > 0) {
        return this.topUnit.get(index).data;
    } else {
        throw new IndexOutOfBoundsException();
    }
}

public T remove(int index) {
    if (index == 1) {
        Unit u = this.topUnit.get(index - 1);
        if (u.next.next == null) {
            u.next = null;
        } else {
            u.next = u.next.next;
        }
        return u.data;
    } else {
        throw new IndexOutOfBoundsException();
    }
}

private class Unit {
T data;
Unit next;

public Unit(T unit) {
    this.data = unit;
}

public Unit get(int index) {
    if (index == 0) {
        return this;
    } else {
        return this.next.get(index - 1);
    }
}

}
}
