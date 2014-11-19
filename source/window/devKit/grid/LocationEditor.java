package devKit.grid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import panel.grid.GridPanelListener;
import world.actors.Actor;
import world.grid.Grid;
import world.grid.Location;
import world.grid.MapLayer;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class LocationEditor extends JPanel implements GridPanelListener {
    private Location loc;
    private JButton actorButton;
    private JButton objectButton;
    private JButton floorButton;
    private Grid grid;
    private JButton btnNewButton;
    private JLabel lblLocation;
    private JLabel lblNewLabel;
    private JLabel locLable;
    private JLabel lblActorlevel;
    private JLabel lblFloorLevel;
    private JLabel lblNewLabel_1;
    private final JPopupMenu popupMenu = new JPopupMenu();

    public LocationEditor(Grid grid) {
        this.grid = grid;
        this.loc = new Location(1, 1);
        setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("default:grow"), FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] { FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));
        this.createButtons();

        this.actorButton = new JButton("New button");// Actor button code
        actorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Actor act = new Actor(loc);
                grid.putInGrid(act);
            }
        });

        lblLocation = new JLabel("Location:");
        lblLocation.setHorizontalAlignment(SwingConstants.TRAILING);
        add(lblLocation, "1, 2");

        this.locLable = new JLabel(this.loc.toString());
        add(this.locLable, "5, 2");
        
        lblActorlevel = new JLabel("Actor Level");
        add(lblActorlevel, "1, 4, center, center");
        add(actorButton, "5, 4");

        this.floorButton = new JButton("None");// Floor button code
        this.floorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

            }
        });
        
        lblFloorLevel = new JLabel("Object Level");
        add(lblFloorLevel, "1, 6, center, default");
        add(this.floorButton, "5, 6");
        
        lblNewLabel_1 = new JLabel("Floor Level");
        add(lblNewLabel_1, "1, 8, center, default");

        btnNewButton = new JButton("New button");
        add(btnNewButton, "5, 8");

    }

    public void createButtons() {
        this.objectButton = new JButton("None");// Object button code
    }

    public void changeLoc(Location loc) {
        this.loc = loc;
        if (this.grid.cheekLocation(this.loc, MapLayer.ActorLevel) != null) {
            this.actorButton.setText(this.grid.cheekLocation(this.loc, MapLayer.ActorLevel).getName());
        } else {
            this.actorButton.setText("None");
        }
        if (this.grid.cheekLocation(this.loc, MapLayer.FloorLevel) != null) {
            this.floorButton.setText(this.grid.cheekLocation(this.loc, MapLayer.FloorLevel).getName());
        } else {
            this.floorButton.setText("None");
        }
        if (this.grid.cheekLocation(this.loc, MapLayer.ObjectLevel) != null) {
            this.objectButton.setText(this.grid.cheekLocation(this.loc, MapLayer.ObjectLevel).getName());
        } else {
            this.objectButton.setText("None");
        }
        this.locLable.setText(loc.toString());
        this.repaint();
    }

    @Override
    public void locationChangeEvent(Location loc) {
        this.changeLoc(loc);
    }

    private void actorDialog() {
        String[] choices = { "Actor" };
        String s = (String) JOptionPane.showInputDialog(this, "Select Actor/n", "Actor Selection", JOptionPane.PLAIN_MESSAGE, null, choices, "Actor");
        if (s == "Actor") {
            Location loc = new Location(this.loc.getRow(), this.loc.getCol(), MapLayer.ActorLevel);
            Actor actor = new Actor(loc);
            this.grid.putInGrid(actor);
        }
    }
}
