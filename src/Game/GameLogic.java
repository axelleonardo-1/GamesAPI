package Game;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

/**

 The GameLogic class represents the game logic of any    game.

 It extends the JPanel class to draw and display game elements on a GUI.
 */
public class GameLogic extends JPanel {
    /**

     A boolean flag to check if the game is started or paused.
     */
    protected static boolean startPauseB = false;
    /**

     A boolean flag to check if the game is started.
     */
    protected static boolean startB = false;
    /**

     A boolean flag to check if the game is over.
     */
    public boolean gameover;
    /**

     An instance of AudioBackground class to handle background audio.
     */
    public static AudioBackground audio;
    /**

     The acceleration of the character in the game.
     */
    public int characterAcceleration = 5;
    /**

     The score of the game.
     */
    public int score = 0;
    /**

     Constructs a new GameLogic object with default values.
     */
    public GameLogic(){
        this.gameover = false;
        setSize(WIDTH,HEIGHT);
        setFocusable(true);

        try {
            audio = new AudioBackground();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    /**

     Starts the game.
     */
    public void start(){
        startB = true;
    }
    /**

     Pauses the game.
     */
    public void pause(){
        startPauseB = true;
        audio.pause();
        repaint();
    }
}