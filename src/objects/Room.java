package objects;

import java.util.ArrayList;
import java.lang.Math;

public class Room {
	private double sizex = 0;
	private double sizey = 0;
	private ArrayList<Microphone> mics = new ArrayList<Microphone>();
	private Source src;
	
	/**
	 * 
	 * Room constructor.
	 * 
	 */
	public Room(double _sizex, double _sizey) {
		sizex = _sizex;
		sizey = _sizey;
	}
	
	/**
	 * Insert microphone.
	 *
	 * @param mic the mic
	 * @return true, if successful
	 */
	public boolean insertMicrophone(Microphone mic) {
		if(this.contains(mic.posx, mic.posy)) {
			mics.add(mic);
			return true;
		}
		return false;
	}
	
	/**
	 * Insert microphone.
	 *
	 * @param posx the xposition of the mic.
	 * @param posy the yposition of the mic.
	 * @return true, if successfully inserts mic into room.
	 */
	public boolean insertMicrophone(double posx, double posy) {
		if(this.contains(posx, posy)) {
			mics.add(new Microphone(posx, posy));
			return true;
		}
		return false;
	}
	public boolean insertSource(Source _src) {
		if(this.contains(_src.posx, _src.posy)) {
			src = _src;
			return true;
		}
		return false;
	}
	public boolean insertSource(double posx, double posy) {
		if(this.contains(posx, posy)) {
			src = new Source(posx, posy);
			return true;
		}
		return false;
	}
	public ArrayList<Double> getDistances() {
		ArrayList<Double> distances = new ArrayList<Double>();
		for(Microphone mic : mics) {
			double d = Math.sqrt(Math.pow(src.posx - mic.posx, 2)
								+Math.pow(src.posy - mic.posy, 2));
			distances.add(d);
		}
		return distances;
	}
	private boolean contains(double x, double y) {
		if(x <= sizex && y <= sizey) {
			return true;
		}
		return false;
	}
}
