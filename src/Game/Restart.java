package Game;

import javax.swing.*;
import java.awt.*;

/**

 Clase que representa el botón de reinicio en el juego.

 Hereda de la clase Objects.
 */
public class Restart extends Objects{
    /**

     Imagen que representa el botón de reinicio.
     */
    public Image restart = new ImageIcon("src/Files/restart.png").getImage();
    /**

     Constructor de la clase Restart.
     @param x posición en x del botón.
     @param y posición en y del botón.
     @param width ancho del botón.
     @param height altura del botón.
     */
    public Restart(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    /**

     Método que dibuja el botón de reinicio en la pantalla.
     @param g objeto Graphics utilizado para dibujar el botón.
     */
    public void draw(Graphics g){
        g.drawImage(restart, this.x, this.y, this.width, this.height, null);
    }

    /**

     Método que actualmente no tiene ninguna funcionalidad.
     @param velocity velocidad del objeto.
     @param acceleration aceleración del objeto.
     @return 0.
     */
    public int move(int velocity, int acceleration){
        return 0;
    }
}
