package world.grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import world.actors.Actor;
import file.Property;
import file.RecordableFactory;
import file.XMLEntry;

public class FactoryGrid implements Grid {
    int rows;
    int cols;
    TreeMap<Location, Actor> locations;
    
    public FactoryGrid() {
        this.rows = 9;
        this.cols = 9;
        Location loc = new Location(0, 0);
        this.locations = new TreeMap<Location, Actor>(loc.newLocComp());
    }
    
    public FactoryGrid(int rows, int cols) {
        this.rows = rows - 1;
        this.cols = cols - 1;
        Location loc = new Location(0, 0);
        this.locations = new TreeMap<Location, Actor>(loc.newLocComp());
    }
    
    @Override
    public Actor putInGrid(Actor actor) {
        Location loc = actor.getLocation();
        if (loc.getRow() < 0 || loc.getCol() < 0) {
            return null;
        }
        Actor oldAct = null;
        if (this.locations.containsKey(loc)) {// if location allready exists
            oldAct = this.locations.get(loc);
            this.locations.replace(loc, actor);
            return oldAct;
        } else if (loc.getRow() <= this.rows) {
            if (loc.getCol() <= this.cols) {
                this.locations.put(loc, actor);
            }
        }
        return oldAct;
    }
    
    @Override
    public Actor removeFromGrid(Location loc) {
        if (this.locations.containsKey(loc)) {
            return this.locations.remove(loc);
        }
        return null;
    }
    
    @Override
    public Actor cheekLocation(Location loc) {
        if (this.locations.containsKey(loc)) {
            return this.locations.get(loc);
        }
        return null;
    }
    
    @Override
    public String toString() {
        String out = "Grid{";
        Iterator<Location> keys = this.locations.keySet().iterator();
        while (keys.hasNext()) {
            Location loc = keys.next();
            out += this.locations.get(loc).toString();
        }
        return out + "}";
    }
    
    @Override
    public int getRows() {
        return this.rows + 1;
    }
    
    @Override
    public int getCols() {
        return this.cols + 1;
    }
    
    @Override
    public Iterator<Location> getOccupiedLocations() {
        return this.locations.keySet().iterator();
    }
    
    @Override
    public Iterator<Location> getOccupiedLocations(MapLayer layer) {
        ArrayList<Location> locs = new ArrayList<Location>();
        for (Location loc : this.locations.keySet()) {
            if (loc.getLayer() == layer) {
                locs.add(loc);
            }
        }
        return locs.iterator();
    }
    
    @Override
    public void updateSave() {}
    
    @Override
    public XMLEntry getEntry() {
        return null;
    }
    
    @Override
    public RecordableFactory<?> getFactory() {
        return null;
    }
    
    @Override
    public String getHeader() {
        return null;
    }
    
    @Override
    public void addProperty(Property property) {}
    
    @Override
    public Property getProperty(String property) {
        return null;
    }
    
    @Override
    public Actor cheekLocation(Location loc, MapLayer layer) {
        if (loc != null) {
            Location loc2 = new Location(loc.getRow(), loc.getCol(), layer);
            return this.cheekLocation(loc2);
        }
        return null;
        
    }
}
