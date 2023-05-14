package Frame;

import Game.*;
import javax.swing.*;

/**
 * La clase FFrame extiende de JFrame y representa la ventana principal del juego Flappy Bird.
 * Contiene un FPanel que se encarga de mostrar el juego en sí.
 */
public class FFrame extends JFrame {
    /**
     * El panel que se utiliza para mostrar el juego.
     */
    private final FPanel panel = new FPanel();

    /**
     * Constructor por defecto de la clase FFrame.
     * Agrega el FPanel a la ventana, establece el título, el tamaño, la visibilidad y la acción al cerrar.
     */
    public FFrame() {
        add(panel);
        setTitle("Flappy Bird");
        setSize(500, 520);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


