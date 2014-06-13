package character;

import java.io.File;

import file.Property;
import file.Recordable;
import file.RecordableFactory;

/**
 * A class that hold the data of a character and saves the data.
 */
public interface CharacterSheet extends Recordable {

/**
 * Saves the character to the file.
 */
public void save();

public default String getHeader() {
    return CharacterFactory.HEADER;
}

public void setName(String name);

public String getName();

@Override
default public RecordableFactory<?> getFactory() {
    return new CharacterFactory();
}

void setFile(File file);

public Property getProperty(String header);
}
