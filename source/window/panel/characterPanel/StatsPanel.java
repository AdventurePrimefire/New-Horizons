package panel.characterPanel;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StatsPanel extends JPanel {
    private JTable table;

    public StatsPanel() {
        FlowLayout flowLayout = (FlowLayout) getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        
        table = new JTable();
        table.setEnabled(false);
        table.setModel(new DefaultTableModel(new Object[][] { { "Strength", null }, { "Dexterity", null }, { "Constitution", null }, { "Intellignce", null }, { "Wisdom", null }, { "Charisma", null }, }, new String[] { "Stat", "Value" }) {
            Class[] columnTypes = new Class[] { Object.class, Integer.class };

            @Override
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            boolean[] columnEditables = new boolean[] { false, false };

            @Override
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(1).setResizable(false);
        add(table);
    }
    
}
