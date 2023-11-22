package src.main.mvc.controller;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioController {
    File soundFileGame;
    File soundFileGameOver;
    File soundFilePacman;
    File soundGhostVulnerable;
    Clip clip;
    AudioInputStream audioInputStream;

    public AudioController(){
        soundFileGame = new File("src/main/resources/audio/pacman_song.wav");
        soundFileGameOver = new File("src/main/resources/audio/pacman_dead.wav");
        soundFilePacman = new File("src/main/resources/audio/pacman_waka-waka-cut.wav");
        soundGhostVulnerable = new File("src/main/resources/audio/ghost_vulnerable.wav");
    }

    public void setSoundGame() {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFileGame);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setSoundDead() {
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFileGameOver)) {
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setSoundPacman(){
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFilePacman);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setSoundGhostVulnerable(){
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundGhostVulnerable);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void play(){
        clip.start();
    }
    
    public void stop() throws IOException{
        clip.stop();
        clip.close();
        audioInputStream.close();
    }

}
