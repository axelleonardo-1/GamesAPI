package Game;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class FPanel extends GameLogic implements KeyListener, ActionListener {
    private final int WIDTH = 525, HEIGHT = 550;
    private final int XWALLWIDTH = 50;

    // Variables enteras que representan la altura, velocidad y aceleración del pájaro.
    private int birdHeight = HEIGHT / 4, birdVelocity = 0, characterAcceleration = 5;
    // Arrays de enteros que representan las posiciones de los muros y las brechas entre ellos.
    private final int[] wallx = {WIDTH, WIDTH + WIDTH / 2};
    private final int[] gap = {(int) (Math.random() * (HEIGHT - 150)), (int) (Math.random() * (HEIGHT - 100))};
    // Variable booleana que indica si el juego ha terminado o no.
    public boolean gameover;

    // Variable entera que almacena la puntuación del jugador.
    // Temporizador que llama al método actionPerformed() cada 20 milisegundos.
    private final Timer time = new Timer( 25,this);

    private final Image background;

    private static int keyPress;
    private static Bird bird;
    private static Pipe wall1;
    private static Pipe wall2;




    /**
     * Constructor que establece el tamaño de la ventana y agrega un KeyListener a la misma.
     * Además, establece el color de fondo de la ventana.
     */
    public FPanel(){
        this.gameover = false;
        setFocusable(true);
        addKeyListener(this);

        ImageIcon background = new ImageIcon("src/Files/backgroundFlappy.jpg");
        this.background = background.getImage();

    }

    /**
     * Método que dibuja la imagen del pájaro en la pantalla.
     *
     * @param g Objeto Graphics que se utiliza para dibujar en la pantalla.
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        Font myFont = new Font ("Bernard MT Condensed", Font.BOLD, 24);


        if(!gameover){
            audio.play();
            drawWalls(g);
            g.setColor(Color.decode("#0A0000"));
            g.setFont(myFont);
            g.drawString("SCORE: " + score/14    , WIDTH/2 -60, 40);
            logic();
            drawflappy(g);
            drawPause(g);
            if (!startB){
                drawStartInstruction(g);
            }
            if (startPauseB){
                drawStartInstruction(g);
                startPauseB = false;
            }


        }else {
            // pondremos un boton para reinciar un boton con simbolo de restart que haga que gameover sea falso
            g.setColor(Color.decode("#0A0000"));
            g.setFont(myFont);
            g.drawString("SCORE: " + score/14 , WIDTH/2-70, 40);

            Restart restart = new Restart(175, 200, 100, 100);
            restart.draw(g);
            startB = false;

            try {
                audio.stop();
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Método que dibuja un rectángulo negro en la posición actual del pájaro.
     *
     * @param g Objeto Graphics que se utiliza para dibujar en la pantalla.
     */
    private void drawflappy(Graphics g){
        this.bird = new Bird(55, birdHeight + birdVelocity, 35, 25);
        bird.draw(g);
    }

    /**
     * Método que dibuja los muros en la pantalla.
     *
     * @param g Objeto Graphics que se utiliza para dibujar en la pantalla.
     */
    private void drawWalls(Graphics g){

        for (int i = 0; i < 2; i++) {
            wall1 = new Pipe(wallx[i], 0, XWALLWIDTH, HEIGHT,1);
            wall1.draw(g);

            wall2 = new Pipe(wallx[i]-45, gap[i], XWALLWIDTH+90, 100, 2);
            wall2.draw(g);
        }
    }

    /*
    Se utiliza para detectar si el pájaro ha colisionado con las paredes o si ha tocado el borde
    superior o inferior de la pantalla. También se encarga de aumentar la puntuación del jugador
    y de reposicionar las paredes una vez que han salido de la pantalla.
     */
    private void logic(){
        for (int i = 0; i < 2; i++) {
            if (wallx[i] <= 100 && wallx[i] + XWALLWIDTH >= 100 || wallx[i] <= 75 && wallx[i] + XWALLWIDTH >= 75) {
                if ((birdHeight + birdVelocity) >= 0 && (birdHeight + birdVelocity) <= gap[i]
                        || (birdHeight + birdVelocity + 25) >= gap[i] + 100 && (birdHeight + birdVelocity + 25) <= HEIGHT) {
                    gameover = true;
                }
            }

            if(birdHeight + birdVelocity <=0 || birdHeight + birdVelocity + 25 >= HEIGHT){
                gameover = true;
            }

            if(75 > wallx[i] + XWALLWIDTH){
                score ++;
            }

            if(wallx[i] + XWALLWIDTH <= 0){
                wallx[i] = WIDTH;
                gap[i] = (int)(Math.random() * (HEIGHT-150));
            }
        }
    }

    /*
    El método "actionPerformed(ActionEvent e)" se llama cada vez que se produce un evento de acción, como
    presionar una tecla o hacer clic en un botón. Este método se utiliza para actualizar la aceleración
    y la velocidad del pájaro y para mover las paredes en la pantalla.
     */
    public void actionPerformed(ActionEvent e) {
        characterAcceleration += 1;
        birdVelocity = bird.move(birdVelocity,characterAcceleration);
        wallx[0] = wall1.move(wallx[0],5);
        wallx[1] = wall1.move(wallx[1],5);
        repaint();
    }

    public void keyTyped(KeyEvent e){

    }

    /*
    El método se utiliza para manejar los eventos de teclado. En particular, se
    utiliza para establecer la aceleración del pájaro en un valor negativo cuando se presiona la tecla
    de espacio, lo que hace que el pájaro salte en la pantalla. También se puede utilizar para detener
    el juego si se presiona la tecla "Escape" o para reiniciar el juego si se presiona la tecla "R".
     */

    private void drawStartInstruction(Graphics g) {
        Instruction instruction = new Instruction(150, 250, 200, 100);
        instruction.draw(g);
    }

    private void drawPause(Graphics g) {
        Pause pause = new Pause(10, 10, 50, 40);
        pause.draw(g);
    }

    public void keyPressed(KeyEvent e){
        keyPress = e.getKeyCode();
        if (keyPress == e.VK_SPACE){
            time.start();
            characterAcceleration = -10;
            super.start();
        }
        if(keyPress == e.VK_ESCAPE){
            time.stop();
            super.pause();
        }

        if(keyPress == e.VK_R){
            time.stop();
            birdHeight = HEIGHT/4;
            birdVelocity = 0;
            characterAcceleration = 4;
            score = 0;
            wallx[0] = WIDTH;
            wallx[1] = (WIDTH +WIDTH/2);
            gap[0] = (int)(Math.random() * (HEIGHT-150));
            gap[1] = (int)(Math.random() * (HEIGHT-100));
            gameover = false;
            try {
                audio.restart();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            } catch (UnsupportedAudioFileException ex) {
                throw new RuntimeException(ex);
            }
            repaint();
        }
    }

    public void keyReleased(KeyEvent e){

    }
}
