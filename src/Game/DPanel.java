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


public class DPanel extends GameLogic implements KeyListener, ActionListener {

    private final Image background;
    private final int WIDTH = 800, acceleration = 80, type = (int)(Math.random()*2+1);
    private static Dinosaur dino;

    private static Cactus cactus;
    private int dinoHeight = 280, dinoVelocity = 0, positionCactus = WIDTH, positionFloor = 0;
    private static int keyPress;
    private final Timer time = new Timer( 15,this);


    public DPanel(){
        this.gameover = false;
        setFocusable(true);
        addKeyListener(this);

        ImageIcon background = new ImageIcon("src/Files/backgroundDino.jpg");
        this.background = background.getImage();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, 800, 400, this);
        Font myFont = new Font ("Bernard MT Condensed", Font.BOLD, 24);

        if(!gameover){
            audio.play();
            drawCactus(g);
            g.setColor(Color.decode("#0A0000"));
            g.setFont(myFont);
            g.drawString("SCORE: " + score/14    , WIDTH/2 -60, 40);
            drawDino(g);
            logic();
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

            Restart restart = new Restart(355, 150, 75, 75);
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

    private void drawPause(Graphics g) {
        Pause pause = new Pause(10, 10, 50, 40);
        pause.draw(g);
    }

    private void drawStartInstruction(Graphics g) {
        Instruction instruction = new Instruction(330, 150, 150, 75);
        instruction.draw(g);
    }

    private void drawDino(Graphics g){
        this.dino = new Dinosaur(55, dinoHeight + dinoVelocity, 55, 65);
        dino.draw(g);
    }

    private void drawCactus(Graphics g){
        cactus = new Cactus(positionCactus, 272, 65, 75, type);
        cactus.draw(g);
    }

    public void actionPerformed(ActionEvent e) {
        positionCactus = cactus.move(positionCactus, 5);
        if (dinoVelocity == -80 ){
            positionFloor += 2;
            if (positionFloor >= cactus.width){
                dinoVelocity = dino.move(dinoVelocity, -acceleration);
                positionFloor = 0;
            }
        }

        repaint();
    }

    private void logic(){
        if (dino.x + dino.width >= cactus.x && dino.x + dino.width <= cactus.x + cactus.width+10 &&
            dino.y + dino.height >= cactus.y && dino.y + dino.height <= cactus.y + cactus.height)
            this.gameover = true;

        if (55 > cactus.x - 20)
            score++;

        if (cactus.x <= 0){
            positionCactus = WIDTH;
        }
    }

    public void keyTyped(KeyEvent e){

    }

    public void keyPressed(KeyEvent e){
        keyPress = e.getKeyCode();
        if (keyPress == e.VK_SPACE){
            if(dinoVelocity !=-80){
                dinoVelocity = dino.move(dinoVelocity, acceleration);
                time.start();
                super.start();
            }

        }
        if(keyPress == e.VK_ESCAPE){
            time.stop();
            super.pause();
            if (dinoVelocity == -80)
                dinoVelocity = dino.move(dinoVelocity, -acceleration);
        }

        if(keyPress == e.VK_R){
            time.stop();
            dinoHeight = 280;
            dinoVelocity = 0;
            score = 0;
            positionCactus = WIDTH;
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
