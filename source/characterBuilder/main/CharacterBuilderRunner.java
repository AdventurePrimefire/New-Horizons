package main;

import javax.swing.SwingUtilities;

import window.CharacterBuilderWindow;

public class CharacterBuilderRunner {
public static CharacterBuilderWindow window;

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            window = new CharacterBuilderWindow();
            window.setVisible(true);
        }
    });
}
}
