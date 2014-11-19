package frame;

import javax.swing.JOptionPane;

import character.CharacterFactory;
import character.CharacterSheet;

public class WindowUtil {
    public static CharacterSheet createSheet() {
        String name = JOptionPane.showInputDialog("What is your name?", null);
        CharacterFactory cf = new CharacterFactory();
        return cf.newInstance(name);
    }
}
