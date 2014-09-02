package display;

import java.util.HashMap;
import java.util.Map;

import world.actors.Actor;

public class GlobalDisplay {
    private static Map<Class<Actor>, Display> displays = new HashMap<Class<Actor>, Display>();

    public static void createDisplay(Displayable actor) {
        if (displays.containsKey(actor.getClass())) {
            return;
        }
    }

    public static Display getDisplay(Displayable actor) {
        return null;
    }
}
