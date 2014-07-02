package display;

import java.io.IOException;
import java.util.HashMap;

public class DisplayMap {
    private HashMap<Class<?>, Display<?>> displays;
    
    public DisplayMap() {
        this.displays = new HashMap<Class<?>, Display<?>>();
    }
    
    public void creatDisplay(Class<PathedImage> cls) {
        if (PathedImage.class.isAssignableFrom(cls)) {
            try {
                Display d = new ImageDisplay(cls);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
