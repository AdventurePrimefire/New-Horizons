package display;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Display {
    private String name = null;
    private BufferedImage image = null;
    
    public Display(Displayable actor) {
        this.name = actor.getDisplayName();
        try {
            this.image = ImageIO.read(actor.getImageFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return this.image;
    }

}
