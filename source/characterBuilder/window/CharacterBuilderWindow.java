package window;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

import java.awt.CardLayout;

import javax.swing.JInternalFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JSeparator;

import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class CharacterBuilderWindow extends JFrame implements ActionListener {
private final JTabbedPane tabbedPane;
private ArrayList<CharacterPanel> tabs = new ArrayList<CharacterPanel>();

public CharacterBuilderWindow() {
    setTitle("Character Builder");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
    
    this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    getContentPane().add(tabbedPane);
    
    JPanel panel = new CharacterPanel();
    this.tabs.add((CharacterPanel) panel);
    tabbedPane.addTab("Character", null, panel, null);
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu mnFile = new JMenu("File");
    menuBar.add(mnFile);
    
    JMenuItem mntmOpen = new JMenuItem("Open");
    mntmOpen.setActionCommand("Open");
    mntmOpen.addActionListener(this);
    mnFile.add(mntmOpen);
    
    JMenuItem mntmSave = new JMenuItem("Save");
    mntmSave.setActionCommand("Save");
    mnFile.add(mntmSave);
    
    JMenuItem mntmExit = new JMenuItem("Exit");
    mntmExit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            System.exit(0);
        }
    });
    
    JSeparator separator = new JSeparator();
    mnFile.add(separator);
    mnFile.add(mntmExit);
    
    addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent arg0) {
            exit();
        }
    });
    
    this.revalidate();
}

protected void exit() {
    
}

@Override
public void actionPerformed(ActionEvent event) {
    System.out.println(event.getActionCommand());
    switch (event.getActionCommand()) {
        case "Open":
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.removeChoosableFileFilter(fileChooser.getAcceptAllFileFilter());
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Character Sheet", "sheet");
            fileChooser.addChoosableFileFilter(filter);
            fileChooser.setCurrentDirectory(new File("saves/characters"));
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                this.tabbedPane.addTab("New Character", new CharacterPanel(selectedFile));
            } else {
                this.tabbedPane.addTab("New Character", new CharacterPanel());
            }
    }
}
}
