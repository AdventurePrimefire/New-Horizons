package window;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import character.CharacterSheet;

public class CharacterPanel extends JPanel implements ActionListener {

private final ButtonGroup buttonGroup = new ButtonGroup();
private JPanel pCard;
private final CharacterSheet character;

public CharacterPanel() {
    this.character = new CharacterSheet(null);
    initUI();
}
public CharacterPanel(File file){
    this.character= new CharacterSheet(file);
    initUI();
}
private void initUI() {
    super.setLayout(new CardLayout());
    this.setLayout(new BorderLayout(0, 0));
    
    JToolBar toolBar = new JToolBar();// The Toolbar on the west
    toolBar.setOrientation(SwingConstants.VERTICAL);
    this.add(toolBar, BorderLayout.WEST);
    
    JRadioButton rdbtnStats = new JRadioButton("Stats");// The Stats button
    rdbtnStats.setActionCommand("Stats");
    rdbtnStats.addActionListener(this);
    rdbtnStats.setSelected(true);
    buttonGroup.add(rdbtnStats);
    toolBar.add(rdbtnStats);
    
    JRadioButton rdbtnClass = new JRadioButton("Class");// Other button
    rdbtnClass.setActionCommand("Class");
    rdbtnClass.addActionListener(this);
    buttonGroup.add(rdbtnClass);
    toolBar.add(rdbtnClass);
    
    this.pCard = new JPanel();
    this.add(pCard, BorderLayout.CENTER);
    pCard.setLayout(new CardLayout(0, 0));
    
    JPanel pStats = new JPanel();
    pStats.add(new JLabel("Stats"));
    pCard.add(pStats, "Stats");
    
    JPanel pClass = new JPanel();
    pClass.add(new JLabel("Class"));
    pCard.add(pClass, "Class");
}

@Override
public void actionPerformed(ActionEvent event) {
    CardLayout cl = null;
    switch (event.getActionCommand()) {
        case "Stats":
            cl = (CardLayout) (pCard.getLayout());
            cl.show(pCard, "Stats");
            break;
        case "Class":
            cl = (CardLayout) (pCard.getLayout());
            cl.show(pCard, "Class");
            break;
    }
}
}
