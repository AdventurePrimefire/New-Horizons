package world.grid;

import org.w3c.dom.Element;

import file.RecordableFactory;

public class GridFactory extends RecordableFactory<Grid> {

    public static final String HEADER = "Grid";
    
    @Override
    public Grid newInstance() {
        return new FactoryGrid();
    }

    @Override
    public Grid fromElement(Element e) throws Exception {
        return null;
    }

    @Override
    public String getHeader() {
        return HEADER;
    }
    
}
