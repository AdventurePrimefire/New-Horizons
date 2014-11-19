package display;

import java.util.HashMap;
import java.util.Map;

public class GlobalDisplay {
    /*
     * Add support for week references so it can keep memory low.
     */
    private static Map<String, Display> displays = new HashMap<String, Display>();
    
    public static void createDisplay(Displayable cls) {
        if (displays.containsKey(cls.getDisplayName())) {
            return;
        }
        Display dis = new Display(cls);
        displays.put(cls.getDisplayName(), dis);
    }
    
    public static Display getDisplay(Displayable actor) {
        if (displays.containsKey(actor.getDisplayName())) {
            return displays.get(actor.getDisplayName());
        }
        createDisplay(actor);
        return getDisplay(actor);
    }
}
