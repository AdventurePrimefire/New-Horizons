package display;

import java.awt.Component;
import java.awt.Graphics2D;

public interface Display<T> {
    /**
     * @param obj
     *            to be drawn
     * @param c
     *            to draw to
     * @param g2
     *            to use
     * @param drawPlace
     *            area to draw on
     */
    public void draw(T obj, Component c, Graphics2D g2, DrawPosition drawPlace);
}
