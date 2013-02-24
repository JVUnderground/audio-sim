package demo;

import java.util.ArrayList;

import objects.Microphone;
import objects.Room;
import objects.Source;

public class Demo {
	public static void main(String[] args) {
		Room room = new Room(10,10);
		room.insertMicrophone(new Microphone(5,4));
		room.insertMicrophone(new Microphone(1,3));
		room.insertMicrophone(new Microphone(10,10));
		room.insertMicrophone(new Microphone(2,5));
		room.insertMicrophone(3,5);
		room.insertMicrophone(10,10);
		room.insertSource(new Source(7,7));
		
		ArrayList<Double> distances = room.getDistances();
		for(double dist : distances) {
			String text = String.format("%f", dist);
			System.out.println(text);
		}
	}
}
