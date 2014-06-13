package character;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import file.Property;
import file.Recordable;
import file.RecordableFactory;
import file.XMLEntry;

/**
 * A class that hold the data of a character and saves the data.
 */
class FactorySheet implements CharacterSheet {
private File file;
private Map<String, Property> properties;
private String name;
private XMLEntry save;

/**
 * 
 * @param file
 *            File to load.
 */
public FactorySheet(File file) {
    if (file != null) {
        this.file = file;
    } else {
        this.file = new File("saves/characters/NewCharacter.sheet");
    }
    this.save = new XMLEntry(this);
    this.name = "New Character";
    this.properties = new HashMap<String, Property>();
}

public FactorySheet() {
    this.save = new XMLEntry(this);
}

public void addChild(Recordable child) {
    this.save.addChild(child.getEntry());
    this.addProperty(child);
}

/**
 * Saves the character to the
 */
public void save() {
    CharacterWriter cw = new CharacterWriter(this.file);
    cw.save(this.getEntry());
}

@Override
public void updateSave() {
    if (this.save == null) {
        this.save = new XMLEntry(this);
    }
    this.save.addAtribute("name", this.name);
}

@Override
public XMLEntry getEntry() {
    this.updateSave();
    return this.save;
}

public void setName(String name) {
    this.name = name;
}

public String getName() {
    return this.name;
}

@Override
public RecordableFactory<?> getFactory() {
    return null;
}

@Override
public Property getProperty(String header) {
    return this.properties.get(header);
}

@Override
public void setFile(File file) {
    this.file = file;
}

@Override
public String getHeader() {
    return CharacterFactory.HEADER;
}

@Override
public void addProperty(Property property) {
    this.properties.put(property.getHeader(), property);
}
}
