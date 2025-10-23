import javax.sound.sampled.*;
import java.io.File;


public class SoundManager {
    private static final String SOUND_FOLDER = "sounds";
    private Clip bgmClip;

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
    public void playBGM(String bgmFile){
        try{
            File musicPath = new File("sounds/"+bgmFile);
            if (musicPath.exists()){
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
