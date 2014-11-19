package world.grid;

import java.util.Iterator;

import world.actors.Actor;
import file.Recordable;
import file.RecordableFactory;

public interface Grid extends Recordable {
    @Override
    public default String getHeader() {
        return GridFactory.HEADER;
    }
    
    @Override
    public default RecordableFactory<?> getFactory() {
        return new GridFactory();
    }

    public Actor putInGrid(Actor actor);
    
    public Actor removeFromGrid(Location loc);

    public Actor cheekLocation(Location loc);

    public int getRows();

    public int getCols();

    public Iterator<Location> getOccupiedLocations();
    
    public Iterator<Location> getOccupiedLocations(MapLayer actorlevel);
    
    public Actor cheekLocation(Location loc, MapLayer actorlevel);
}
