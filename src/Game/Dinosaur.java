package Game;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa al dinosaurio protagonista del juego.
 */
public class Dinosaur extends Objects{
    /**
     * Imagen del dinosaurio.
     */
    private static Image dinosaur;

    /**
     * Constructor de la clase Dinosaur.
     * @param x posición en el eje x del dinosaurio.
     * @param y posición en el eje y del dinosaurio.
     * @param width ancho del dinosaurio.
     * @param height alto del dinosaurio.
     */
    public Dinosaur(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.dinosaur = new ImageIcon("src/Files/dinosaur.png").getImage();
    }

    /**
     * Dibuja el dinosaurio en el canvas.
     * @param g objeto Graphics del canvas donde se dibujará el dinosaurio.
     */
    public void draw(Graphics g){
        g.drawImage(dinosaur, this.x, this.y, this.width, this.height,null);
    }

    /**
     * Mueve al dinosaurio en el eje Y.
     * @param velocityY velocidad actual del dinosaurio en el eje Y.
     * @param acceleration aceleración del movimiento en el eje Y.
     * @return la nueva velocidad en el eje Y después del movimiento.
     */
    public int move(int velocityY, int acceleration){
        velocityY -= acceleration;
        return velocityY;
    }
}

