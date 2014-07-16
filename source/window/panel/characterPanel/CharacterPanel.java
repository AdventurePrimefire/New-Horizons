package panel.characterPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import character.CharacterFactory;
import character.CharacterSheet;

public class CharacterPanel extends JPanel {
    private final CharacterSheet character;
    private final ButtonGroup cardButtons = new ButtonGroup();
    private JPanel cardPanel;

    public CharacterPanel() {
        this.character = new CharacterFactory().newInstance();
        initUI();
    }

    public CharacterPanel(File file) throws Exception {
        this.character = new CharacterFactory().newInstance(file);
        initUI();
    }

    public CharacterPanel(CharacterSheet sheet) {
        super();
        this.character = sheet;
        initUI();
    }

    private void initUI() {
        
        setLayout(new BorderLayout(0, 0));

        this.cardPanel = new JPanel();
        add(cardPanel, BorderLayout.CENTER);
        cardPanel.setLayout(new CardLayout(0, 0));

        JPanel Stats = new StatsPanel();
        cardPanel.add(Stats, "Stats");

        JPanel Inventory = new JPanel();
        cardPanel.add(Inventory, "Inventory");

        JLabel lblInventory = new JLabel("Inventory");
        Inventory.add(lblInventory);

        JMenuBar menuBar = new JMenuBar();
        add(menuBar, BorderLayout.NORTH);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenuItem mntmSave = new JMenuItem("Save");
        mntmSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                
            }
        });
        mnFile.add(mntmSave);

        JMenuItem mntmReload = new JMenuItem("ReLoad");
        mnFile.add(mntmReload);

        JSeparator separator = new JSeparator();
        mnFile.add(separator);

        JMenuItem mntmRename = new JMenuItem("Rename");
        mnFile.add(mntmRename);

        JButton btnStats = new JButton("Stats");
        btnStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                showCard("Stats");
            }
        });

        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        menuBar.add(separator_1);
        cardButtons.add(btnStats);
        menuBar.add(btnStats);

        JButton btnInventory = new JButton("Inventory");
        btnInventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                showCard("Inventory");
            }
        });
        cardButtons.add(btnInventory);
        menuBar.add(btnInventory);
    }

    public void showCard(String name) {
        ((CardLayout) this.cardPanel.getLayout()).show(this.cardPanel, name);
        this.repaint();
    }

}
