package Game;

import javax.swing.*;
import java.awt.*;

/**
 * La clase Bird representa un objeto de pájaro que hereda de la clase Objects y
 * tiene una imagen asociada para su representación gráfica.
 */
public class Bird extends Objects {

    /**
     * La imagen asociada al pájaro.
     */
    private static Image bird;

    /**
     * Constructor de la clase Bird.
     * @param x La posición x del pájaro.
     * @param y La posición y del pájaro.
     * @param width El ancho del pájaro.
     * @param height La altura del pájaro.
     */
    public Bird(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.bird = new ImageIcon("src/Files/bird2.png").getImage();
    }

    /**
     * Dibuja la imagen del pájaro en el objeto Graphics dado.
     * @param g El objeto Graphics en el cual se dibuja la imagen del pájaro.
     */
    public void draw(Graphics g) {
        g.drawImage(bird, this.x, this.y, this.width, this.height, null);
    }

    /**
     * Mueve el pájaro de acuerdo a su velocidad y aceleración vertical.
     * @param velocityY La velocidad vertical del pájaro.
     * @param acceleration La aceleración vertical del pájaro.
     * @return La nueva velocidad vertical del pájaro después de ser actualizada.
     */
    public int move(int velocityY, int acceleration) {
        velocityY += acceleration;
        return velocityY;
    }
}

