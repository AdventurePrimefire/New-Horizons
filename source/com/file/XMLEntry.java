package file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLEntry {
private final Recordable parent;
private String nodeText;
private HashMap<String, String> atributes;
private ArrayList<XMLEntry> children;

/**
 * Constructs a new XMLEntry that will make the nodes to write to the file.
 * 
 * @param parent
 *            the object that will be recorded
 */
public XMLEntry(Recordable parent) {
    this.parent = parent;
    this.atributes = new HashMap<String, String>();
    this.children = new ArrayList<XMLEntry>();
}

/**
 * Makes the node from the Document.
 * 
 * @param xmlDoc
 *            to write to.
 * @return an updated node.
 */
public Node makeNode(Document xmlDoc) {
    Element out = xmlDoc.createElement(this.parent.getHeader());
    this.parent.updateSave();
    if (this.nodeText != null) {
        out.setTextContent(nodeText);
    }
    this.makeAtributes(out);
    for (int i = 0; i < this.children.size(); i++) {
        out.appendChild(this.children.get(i).makeNode(xmlDoc));
    }
    return out;
}

private void makeAtributes(Element out) {
    Set<String> keys = this.atributes.keySet();
    for (String key : keys) {
        out.setAttribute(key, this.atributes.get(key));
    }
}

public void setText(String text) {
    this.nodeText = text;
}

public void addAtribute(String attribute, String value) {
    this.atributes.put(attribute, value);
}

public void removeAtribute(String attribute) {
    this.atributes.remove(attribute);
}

public String getAtribute(String atribute) {
    if (this.atributes.containsKey(atribute)) {
        return this.atributes.get(atribute);
    }
    return null;
}

public void addChild(XMLEntry child) {
    if (child != null && !this.children.contains(child)) {
        this.children.add(child);
    }
}

public Recordable getChild(String header) throws Exception {
    for (int i = 0; i < this.children.size(); i++) {
        if (this.children.get(i).parent.getHeader() == header) {
            return this.children.get(i).parent;
        }
    }
    throw new Exception();
}

public Recordable[] getAllChildren() {
    Recordable[] children = new Recordable[this.children.size()];
    for (int i = 0; i < this.children.size(); i++) {
        children[i] = this.children.get(i).parent;
    }
    return children;
}

public void removeChild(XMLEntry child) {
    if (this.children.contains(child)) {
        this.children.remove(child);
    }
}
}