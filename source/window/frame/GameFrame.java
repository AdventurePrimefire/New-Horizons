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
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import panel.characterPanel.CharacterPanel;
import character.CharacterSheet;
import devKit.DevKit;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private DevKit devKit = new DevKit(this);
    
    public GameFrame() {
        super();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
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
                CharacterSheet c = WindowUtil.createSheet();
                tabbedPane.addTab(c.getName(), null, new CharacterPanel(c), null);
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
        
        JMenuItem mntmRepack = new JMenuItem("Repack");
        mntmRepack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                pack();
            }
        });
        mnSettings.add(mntmRepack);
        
        JMenu mnDev = new JMenu("Dev");
        menuBar.add(mnDev);
        
        JMenuItem chckbxmntmEnabled = new JMenuItem("Toggle");
        chckbxmntmEnabled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (devKit.isVisible() == true) {
                    devKit.setVisible(false);
                    return;
                }
                devKit.setVisible(true);
            }
        });
        mnDev.add(chckbxmntmEnabled);
        
        JSeparator separator = new JSeparator();
        menuBar.add(separator);
        
        JButton btnCloseCurrentTab = new JButton("Close Current Tab");
        menuBar.add(btnCloseCurrentTab);
        btnCloseCurrentTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int i = tabbedPane.getSelectedIndex();
                tabbedPane.removeTabAt(i);
            }
        });
        
        this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        getContentPane().add(this.tabbedPane, BorderLayout.CENTER);
        
        JPanel Welcome = new JPanel();
        this.tabbedPane.addTab("Welcome", null, Welcome, null);
        
        JTextPane welcomeText = new JTextPane();
        welcomeText.setText("This is the welcome screen for Dungeon Hero.  Later more will be added.");
        Welcome.add(welcomeText);
        
        this.repaint();
    }
    
    public JTabbedPane getTabbedPane() {
        return this.tabbedPane;
    }
    
    @Override
    public void dispose() {
        super.dispose();
        this.devKit.dispose();
        System.exit(0);
    }
}
