package Game;

import javax.swing.*;
import java.awt.*;

/**
 * La clase Pause representa el objeto que se muestra en pantalla cuando el juego está en pausa.
 * Esta clase extiende la clase abstracta Objects e implementa el método abstracto move.
 */
public class Pause extends Objects{

    /**
     * Imagen que se utiliza para representar el objeto de pausa.
     */
    public Image pause = new ImageIcon("src/Files/pause.png").getImage();

    /**
     * Crea un objeto de la clase Pause con la posición y tamaño especificados.
     * @param x La posición horizontal del objeto.
     * @param y La posición vertical del objeto.
     * @param width El ancho del objeto.
     * @param height La altura del objeto.
     */
    public Pause(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    /**
     * Dibuja la imagen de pausa en la posición especificada.
     * @param g El contexto gráfico en el que se dibuja el objeto.
     */
    public void draw(Graphics g){
        g.drawImage(pause, this.x, this.y, this.width, this.height, null);
    }

    /**
     * El método move de la clase Pause siempre devuelve cero, ya que este objeto no se mueve durante el juego.
     * @param velocity La velocidad actual del objeto.
     * @param acceleration La aceleración del objeto.
     * @return El valor cero, indicando que el objeto no se mueve.
     */
    public int move(int velocity, int acceleration){
        return 0;
    }
}

