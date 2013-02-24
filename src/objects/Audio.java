package objects;

import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class Audio {
	private String filename = "Her Way.wav";
	
	public Audio(String filehandle) {
		filename = filehandle;
	}
	
    public byte[] readWAVData(){
        byte[] data = null;
        try {
            final ByteArrayOutputStream baout = new ByteArrayOutputStream();
            final AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filename));

            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, baout);
            audioInputStream.close();
            baout.close();
            data = baout.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
