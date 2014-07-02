package character;

import java.io.File;

import org.w3c.dom.Element;

import file.RecordableFactory;

public class CharacterFactory extends RecordableFactory<CharacterSheet> {
    static final String HEADER = "CharacterSheet";

    @Override
    public CharacterSheet newInstance() {
        return new FactorySheet(null);
    }

    public CharacterSheet newInstance(String name) {
        CharacterSheet out = new FactorySheet(null);
        out.setName(name);
        return out;
    }

    public CharacterSheet newInstance(File file) throws Exception {
        CharacterSheet out = fromElement(CharacterReader.read(file));
        out.setFile(file);
        return out;
    }

    @Override
    public CharacterSheet fromElement(Element e) throws Exception {// Needs Work
        FactorySheet out = new FactorySheet();
        out.setName(e.getAttribute("name"));
        for (String i : this.subElements.keySet()) {
            if (this.subElements.containsKey(i)) {
                Element element = (Element) e.getElementsByTagName(this.subElements.get(i).getHeader()).item(0);
                out.addChild(this.subElements.get(i).fromElement(element));
            } else {
                throw new Exception() {
                    private static final long serialVersionUID = -5023844226691376669L;

                    @Override
                    public String getMessage() {
                        return "Not Valid SubElement";
                    }
                };
            }
        }
        return out;
    }

    @Override
    public String getHeader() {// Done
        return HEADER;
    }
}
