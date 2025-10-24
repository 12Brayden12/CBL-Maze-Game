import java.io.File;
import javax.sound.sampled.*;

/**
 * SoundManager handles playing sound effects and background music in the game.
 */
public class SoundManager {
    private static final String SOUND_FOLDER = "sounds";
    private Clip bgmClip;

    /**
    * Plays a short sound effect from the specified file in the sounds folder.
    * This method does not loop.
    *
    * @param fileName the name of the sound file to play (located in the "sounds" folder)
    */
    public static void playSound(String fileName) {
        File soundFile = new File(SOUND_FOLDER + "/" + fileName);
        if (!soundFile.exists()) {
            return;

        }

        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    /**
    * Plays a background music track in a continuous loop.
    *
    * @param bgmFile the name of the music file to play (located in the "sounds" folder)
    */
    public void playBGM(String bgmFile) {
        try {
            File musicPath = new File("sounds/" + bgmFile);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                bgmClip = AudioSystem.getClip();
                bgmClip.open(audioInput);
                bgmClip.start();
                bgmClip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
   
}
