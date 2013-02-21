package objects;

import java.util.ArrayList;
import java.lang.Math;

public class Room {
	private double posx = 0;
	private double posy = 0;
	private ArrayList<Microphone> mics = new ArrayList<Microphone>();
	private Source src = new Source(0,0);
	
	public Room(double _posx, double _posy) {
		posx = _posx;
		posy = _posy;
	}
	
	public boolean insertMicrophone(Microphone mic) {
		if(this.contains(mic.posx, mic.posy)) {
			mics.add(mic);
			return true;
		}
		return false;
	}
	public boolean insertSource(Source _src) {
		if(this.contains(_src.posx, _src.posy)) {
			src.posx = _src.posx;
			src.posy = _src.posy;
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
		if(x <= posx && y <= posy) {
			return true;
		}
		return false;
	}
}
