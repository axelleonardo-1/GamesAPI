package Game;

import javax.swing.*;
import java.awt.*;

/**
 * The Cactus class represents a cactus object that the player must avoid in the game.
 * It extends the Objects class and implements the methods defined in it.
 */
public class Cactus extends Objects{

    /** The first image of the cactus object. */
    public Image cactus1 = new ImageIcon("src/Files/cactus1.png").getImage();

    /** The second image of the cactus object. */
    public Image cactus2 = new ImageIcon("src/Files/cactus2.png").getImage();

    /** The current image of the cactus object. */
    private static Image cactus;

    /**
     * Constructs a cactus object with the given x, y, width, height, and type of cactus.
     * @param x the x-coordinate of the cactus object.
     * @param y the y-coordinate of the cactus object.
     * @param width the width of the cactus object.
     * @param height the height of the cactus object.
     * @param cactus the type of cactus object (1 or 2).
     */
    public Cactus(int x, int y, int width, int height, int cactus) {
        super(x, y, width, height);
        if (cactus == 1)
            this.cactus = cactus1;
        else
            this.cactus = cactus2;
    }

    /**
     * Draws the cactus object on the screen.
     * @param g the graphics object used to draw the cactus.
     */
    public void draw(Graphics g){
        g.drawImage(cactus, this.x, this.y, this.width, this.height, null);
    }

    /**
     * Moves the cactus object to the left with the given velocity and acceleration.
     * @param velocityX the velocity of the cactus object in the x direction.
     * @param acceleration the acceleration of the cactus object in the x direction.
     * @return the new velocity of the cactus object in the x direction.
     */
    public int move(int velocityX, int acceleration){
        velocityX -= acceleration;
        return velocityX;
    }
}
