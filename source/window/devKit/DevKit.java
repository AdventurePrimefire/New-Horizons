package devKit;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import panel.grid.GridPanel;
import world.grid.FactoryGrid;
import devKit.grid.GridDevPanel;
import frame.GameFrame;

public class DevKit extends JFrame {
    private GameFrame gameFrame = null;
    private JTabbedPane tabbedPane;
    
    public DevKit(GameFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setSize(200, 200);
        this.gameFrame = parent;
        setTitle("Dungeon Hero DevKit");
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);
        
        JMenu mnNew = new JMenu("New");
        mnFile.add(mnNew);
        
        JMenuItem mntmGrid = new JMenuItem("Grid");
        mntmGrid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int rows;// rows input
                while (true) {
                    Scanner scanner = new Scanner(JOptionPane.showInputDialog("Enter numder of rows"));
                    if (scanner.hasNextInt()) {
                        rows = scanner.nextInt();
                        break;
                    }
                }
                int cols;// cols input
                while (true) {
                    Scanner scanner = new Scanner(JOptionPane.showInputDialog("Enter numder of colums"));
                    if (scanner.hasNextInt()) {
                        cols = scanner.nextInt();
                        break;
                    }
                }
                GridPanel gridPanel = new GridPanel(new FactoryGrid(rows, cols));
                gameFrame.getTabbedPane().addTab("Grid", gridPanel);
                GridDevPanel gridDev = new GridDevPanel(gridPanel);
                tabbedPane.addTab("GridDev", gridDev);
            }
        });
        mnNew.add(mntmGrid);
        
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
        
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        
    }
    
    public JTabbedPane getTabbedPane() {
        return this.tabbedPane;
    }
    
    private DevKit getThis() {
        return this;
    }
}
