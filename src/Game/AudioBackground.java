package Game;// Java program to play an Audio
// file using Clip Object

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Esta clase se utiliza para reproducir un archivo de audio en bucle continuo utilizando la biblioteca de sonido de Java.
 */
public class AudioBackground
{

    // to store current position
    Long currentFrame;
    Clip clip;

    // current status of clip
    String status;

    AudioInputStream audioInputStream;
    static String filePath = "src/Files/1.wav";

    /**
     * Constructor de la clase AudioBackground.
     *
     * @throws UnsupportedAudioFileException Si el archivo de audio no es compatible.
     * @throws IOException Si ocurre un error de entrada/salida al leer el archivo de audio.
     * @throws LineUnavailableException Si no se puede acceder a la línea de sonido para reproducir el archivo de audio.
     */
    public AudioBackground()
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        // create AudioInputStream object
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }


    // Method to play the audio
    /**
     * Método para reproducir el archivo de audio.
     */
    public void play()
    {
        //start the clip
        clip.start();
        status = "play";
    }

    // Method to pause the audio
    /**
     * Método para pausar la reproducción del archivo de audio.
     */
    public void pause()
    {
        if (status.equals("paused"))
        {
            return;
        }
        this.currentFrame =
                this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    // Method to resume the audio
    /**
     * Método para reanudar la reproducción del archivo de audio después de pausarlo.
     *
     * @throws UnsupportedAudioFileException Si el archivo de audio no es compatible.
     * @throws IOException Si ocurre un error de entrada/salida al leer el archivo de audio.
     * @throws LineUnavailableException Si no se puede acceder a la línea de sonido para reproducir el archivo de audio.
     */
    public void resumeAudio() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        if (status.equals("play"))
        {
            System.out.println("Audio is already "+
                    "being played");
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    // Method to restart the audio
    /**
     * Método para reiniciar la reproducción del archivo de audio desde el principio.
     *
     * @throws IOException Si ocurre un error de entrada/salida al leer el archivo de audio.
     * @throws LineUnavailableException Si no se puede acceder a la línea de sonido para reproducir el archivo de audio.
     * @throws UnsupportedAudioFileException Si el archivo de audio no es compatible.
     */
    public void restart() throws IOException, LineUnavailableException,
            UnsupportedAudioFileException
    {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
    }

    // Method to stop the audio
    /**

     Stops the current audio playback, closing the clip and resetting the current frame to 0.
     @throws UnsupportedAudioFileException if the audio file is not supported.
     @throws IOException if there's an I/O error while trying to stop the playback.
     @throws LineUnavailableException if the audio line is unavailable.
     */
    public void stop() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    // Method to jump over a specific part
    /**

     Jumps to a specific position in the audio playback, closing the clip and resetting the audio stream.
     @param c the specific position in microseconds to jump to.
     @throws UnsupportedAudioFileException if the audio file is not supported.
     @throws IOException if there's an I/O error while trying to jump to the specific position.
     @throws LineUnavailableException if the audio line is unavailable.
     */
    public void jump(long c) throws UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        if (c > 0 && c < clip.getMicrosecondLength())
        {
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame = c;
            clip.setMicrosecondPosition(c);
            this.play();
        }
    }

    // Method to reset audio stream
    /**

     Resets the audio stream, closing the clip and opening it again to loop continuously.
     @throws UnsupportedAudioFileException if the audio file is not supported.
     @throws IOException if there's an I/O error while trying to reset the audio stream.
     @throws LineUnavailableException if the audio line is unavailable.
     */
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        audioInputStream = AudioSystem.getAudioInputStream(
                new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}

