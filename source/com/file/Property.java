package file;

public interface Property {
/**
 * Gets the header of the class that is used.
 * 
 * @return the name used for everything.
 */
public abstract String getHeader();

/**
 * 
 * @param property
 */
public void addProperty(Property property);

public Property getProperty(String property);
}
