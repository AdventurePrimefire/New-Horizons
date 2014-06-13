package file;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Element;

public abstract class RecordableFactory<T extends Recordable> {
protected Map<String, RecordableFactory<?>> subElements = new HashMap<String, RecordableFactory<?>>();

/**
 * 
 * @return
 */
public abstract T newInstance();

/**
 * Remakes the object from an element.
 * 
 * @param e
 *            of the element of the factory
 * @return an instance of the object.
 * @throws Exception
 */
public abstract T fromElement(Element e) throws Exception;

/**
 * String that the Recordable goes by.
 * 
 * @return name of the node.
 */
public abstract String getHeader();

/**
 * Genarates an array of all of the added sub elements.
 * 
 * @return array of the possible sub elements.
 */
public RecordableFactory<?>[] getSubElements() {
    Set<String> keys = this.subElements.keySet();
    RecordableFactory<?>[] out = new RecordableFactory<?>[keys.size()];
    Iterator<String> ik = keys.iterator();
    for (int i = 0; (i < keys.size()) && (ik.hasNext()); i++) {
        out[i] = this.subElements.get(ik.next());
    }
    return out;
}

/**
 * Adds the factory to the possible sub element list.
 * 
 * @param factory
 *            to add.
 */
public void addSubElement(RecordableFactory<?> factory) {
    this.subElements.put(factory.getHeader(), factory);
}

/**
 * Remove the factory from the list of possible sub elements.
 * 
 * @param factory
 *            to remove.
 * @return if the sub element was successfully removed.
 */
public void removeSubElement(RecordableFactory<?> factory) {
    this.subElements.remove(factory.getHeader());
}
}
