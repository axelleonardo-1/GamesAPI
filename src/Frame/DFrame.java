package Frame;

import Game.DPanel;
import Game.FPanel;

import javax.swing.*;

/**

 This class represents the main frame of the Dino Game. It extends the JFrame class.

 It contains a DPanel object that represents the main panel of the game.
 */
public class DFrame extends JFrame {

    private final DPanel panel = new DPanel();

    /**

     Constructor for DFrame. Initializes the frame by adding the main panel and setting the title, size and visibility.
     Also sets the default close operation of the frame.
     */
    public DFrame (){
        add(panel);
        setTitle("Dino Game");
        setSize(800,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}