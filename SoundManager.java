import javax.sound.sampled.*;
import java.io.File;

public class SoundManager {
    private static final String SOUND_FOLDER = "sounds";

    public static void playSound(String fileName) {
        File soundFile = new File(SOUND_FOLDER + "/" + fileName);
        if (!soundFile.exists()) return;

        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}
