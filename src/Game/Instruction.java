package Game;

import javax.swing.*;
import java.awt.*;

/**
 * The Instruction class represents an image of the start button in the game.
 * It is a subclass of Objects.
 */
public class Instruction extends Objects{

    /**
     * The image of the start button.
     */
    public Image instruction = new ImageIcon("src/Files/start.png").getImage();

    /**
     * Creates an Instruction object with the specified location and size.
     *
     * @param x      the x-coordinate of the top left corner of the image
     * @param y      the y-coordinate of the top left corner of the image
     * @param width  the width of the image
     * @param height the height of the image
     */
    public Instruction(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    /**
     * Draws the image of the start button on the screen.
     *
     * @param g the Graphics object to draw the image
     */
    public void draw(Graphics g){
        g.drawImage(instruction, this.x, this.y, this.width, this.height, null);
    }

    /**
     * This method returns 0, since the Instruction object does not move.
     *
     * @param velocity the initial velocity of the object
     * @param acceleration the acceleration of the object
     * @return 0
     */
    public int move(int velocity, int acceleration){
        return 0;
    }

}

