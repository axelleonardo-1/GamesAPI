package Game;

import javax.swing.*;
import java.awt.*;

/**
 * La clase Pipe representa un tubo en el juego. Hereda de la clase Objects.
 * Esta clase se utiliza para crear tubos en diferentes alturas y de diferentes tipos.
 */
public class Pipe extends Objects{

    /** Imágenes para los tubos */
    public Image pipe1 = new ImageIcon("src/Files/pipe.png").getImage();
    public Image pipe2 = new ImageIcon("src/Files/pipe2.png").getImage();

    /** Velocidad predeterminada para los tubos */
    final int PIPEVELOCITY = 5;

    /** Imagen para el tubo */
    private Image pipe;

    /**
     * Crea un nuevo objeto Pipe con las coordenadas y dimensiones especificadas.
     * @param x posición x del tubo
     * @param y posición y del tubo
     * @param width ancho del tubo
     * @param height alto del tubo
     * @param pipe tipo de tubo (1 o 2)
     */
    public Pipe(int x, int y, int width, int height, int pipe) {
        super(x, y, width, height);
        if (pipe == 1)
            this.pipe = pipe1;
        else
            this.pipe = pipe2;
    }

    /**
     * Dibuja la imagen del tubo en el lienzo.
     * @param g objeto Graphics para dibujar la imagen del tubo
     */
    public void draw(Graphics g){
        g.drawImage(this.pipe, this.x, this.y, this.width, this.height, null);
    }

    /**
     * Mueve el tubo en el eje x con una velocidad y aceleración dadas.
     * @param velocityX velocidad en el eje x del tubo
     * @param acceleration aceleración en el eje x del tubo
     * @return la nueva velocidad en el eje x después del movimiento
     */
    public int move(int velocityX, int acceleration){
        velocityX -= acceleration;
        return velocityX;
    }
}

