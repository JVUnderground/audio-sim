package objects;

import java.io.File;

import PCMPlayer.PCMFilePlayer;

public class Source {
	public double posx = 0;
	public double posy = 0;
	private PCMFilePlayer player;
	private byte[] data = null;

	public Source(double _posx, double _posy) {
		posx = _posx;
		posy = _posy;
		data = readData();
	}

	private byte[] readData() {
		Audio audio = null;
		try {
			player = new PCMFilePlayer (new File("Her Way.wav"));
			audio = new Audio("Her Way.wav");
			data = audio.readWAVData();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public void play() {
		player.start();
	}
	public byte[] getData() {
		return data;
	}
}
