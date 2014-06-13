package character;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

class CharacterReader {

static Element read(File file) throws SAXException, IOException, ParserConfigurationException{
    DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
        Document document = dBuilder.parse(file);
        document.normalize();
        NodeList root = document.getElementsByTagName("CharacterSheet");
        Element loadedCharacter = (Element) document.getFirstChild();
        return loadedCharacter;
}
}
