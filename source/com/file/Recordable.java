package file;

public interface Recordable extends Property {

/**
 * Updates the node.
 */
public void updateSave();

/**
 * Updates and returns the node.
 * 
 * @return the updated node.
 */
public XMLEntry getEntry();

/**
 * 
 * @return
 */
public RecordableFactory<?> getFactory();

/**
 * This method will also add it to the properties.
 * 
 * @param Child
 */
public default void addChild(Recordable child) {
    addProperty(child);
}
}
