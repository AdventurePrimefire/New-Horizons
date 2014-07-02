package display;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import javax.imageio.ImageIO;

public class ImageDisplay implements Display<PathedImage> {
    BufferedImage loadedImage;
    private File file;
    private BufferedImage image;
    private boolean isConnected;
    private ConectedImageDisplay conectedTexture;

    public ImageDisplay(Class<PathedImage> cls) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        Field field;
        field = cls.getField("file");
        this.file = (File) field.get(null);
        this.image = ImageIO.read(this.file);
        if (ConectedTexture.class.isAssignableFrom(cls)) {
            this.isConnected = true;
            this.conectedTexture = new ConectedImageDisplay(cls);
        } else {
            this.isConnected = false;
        }
    }

    @Override
    public void draw(PathedImage obj, Component c, Graphics2D g2, DrawPosition pos) {
        this.draw(obj, c, g2, pos);
    }

    void drawImage(Image loadedImage, Graphics2D g2, DrawPosition pos) {
        int width = this.loadedImage.getWidth(null);
        int height = this.loadedImage.getHeight(null);
        int size = Math.max(width, height);
        g2.scale(1.0 / size, 1.0 / size);
        g2.clip(new Rectangle(-width / 2, -height / 2, width, height));
        g2.drawImage(this.loadedImage, -width / 2, -height / 2, null);
    }
}
