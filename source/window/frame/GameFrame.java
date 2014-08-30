package frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import panel.characterPanel.CharacterPanel;
import world.grid.GridPanel;
import character.CharacterFactory;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
    private JTabbedPane tabbedPane;

    public GameFrame() {
        super();

        this.setSize(500, 600);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenu mnCharacter = new JMenu("Character");
        mnFile.add(mnCharacter);

        JMenuItem mntmNew = new JMenuItem("New");
        mntmNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name = JOptionPane.showInputDialog(getContentPane(), "What is your name?", null);
                CharacterFactory cf = new CharacterFactory();
                tabbedPane.addTab(name, null, new CharacterPanel(cf.newInstance(name)), null);
            }
        });
        mnCharacter.add(mntmNew);

        JMenuItem mntmLoad = new JMenuItem("Load");
        Component frame = this;
        mntmLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.removeChoosableFileFilter(fileChooser.getAcceptAllFileFilter());
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Character Sheet", "sheet");
                fileChooser.addChoosableFileFilter(filter);
                fileChooser.setCurrentDirectory(new File("saves/characters"));
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        tabbedPane.addTab("New Character", null, new CharacterPanel(selectedFile), null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    tabbedPane.addTab("New Character", null, new CharacterPanel(), null);
                }
            }
        });
        mnCharacter.add(mntmLoad);

        JMenu mnWorld = new JMenu("World");
        mnFile.add(mnWorld);

        JMenuItem mntmNew_1 = new JMenuItem("New");
        mnWorld.add(mntmNew_1);

        JMenuItem mntmLoad_1 = new JMenuItem("Load");
        mnWorld.add(mntmLoad_1);

        JMenu mnSettings = new JMenu("Settings");
        menuBar.add(mnSettings);

        JSeparator separator = new JSeparator();
        menuBar.add(separator);

        JButton btnCloseCurrentTab = new JButton("Close Current Tab");
        menuBar.add(btnCloseCurrentTab);
        btnCloseCurrentTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int i = tabbedPane.getSelectedIndex();
                tabbedPane.remove(i);
            }
        });

        this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        getContentPane().add(this.tabbedPane, BorderLayout.CENTER);

        JPanel Welcome = new JPanel();
        this.tabbedPane.addTab("Welcome", null, Welcome, null);

        JTextPane welcomeText = new JTextPane();
        welcomeText.setText("This is the welcome screen for Dungeon Hero.  Later more will be added.");
        Welcome.add(welcomeText);

        GridPanel gridPanel = new GridPanel();
        this.tabbedPane.addTab("Grid", null, gridPanel, null);

        this.repaint();
    }
}
