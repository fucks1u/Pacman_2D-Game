package src.main.mvc.controller;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;

/**
 * Class AudioController.
 * This class is used to control the audio of the game.
 * It has the methods to set the audio and play it.
 * It also has the method to stop the audio.
 * Each sound has its own method.
 */
public class AudioController {
    File soundFileGame;
    File soundFileGameOver;
    File soundFilePacman;
    File soundGhostVulnerable;
    Clip clip;
    AudioInputStream audioInputStream;

    /**
     * Constructor of the class AudioController
     */
    public AudioController(){
        soundFileGame = new File("src/main/resources/audio/pacman_song.wav");
        soundFileGameOver = new File("src/main/resources/audio/pacman_dead.wav");
        soundFilePacman = new File("src/main/resources/audio/pacman_waka-waka-cut.wav");
        soundGhostVulnerable = new File("src/main/resources/audio/ghost_vulnerable.wav");
    }

    /**
     * Method to set the sound in the menu panel.
     */
    public void setSoundGame() {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFileGame);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to set the sound when the game is over.
     */
    public void setSoundDead() {
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFileGameOver)) {
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to set the sound when the pacman is moving.
     */
    public void setSoundPacman(){
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFilePacman);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to set the sound when the ghost is vulnerable.
     */
    public void setSoundGhostVulnerable(){
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundGhostVulnerable);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to play the sound.
     */
    public void play(){
        clip.start();
    }

    /**
     * Method to stop the sound.
     * @throws IOException
     */
    public void stop() throws IOException{
        clip.stop();
        clip.close();
        audioInputStream.close();
    }
}
