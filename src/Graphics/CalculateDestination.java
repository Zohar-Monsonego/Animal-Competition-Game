package Graphics;

import Animals.Animal;
import Mobility.Point;


/**
 * Implements the `ICalculateDestination` interface to calculate destination points
 * based on the type of competition and track for an animal.
 */
public class CalculateDestination implements ICalculateDestination{
	
	/**
     * Constructs a new `CalculateDestination` instance.
     */
	public CalculateDestination() {
		
	}
	
	
	/**
     * Calculates the destination point for the given animal based on its competition type and track.
     *
     * @param a the `Animal` instance for which the destination is being calculated
     * @param track the name or identifier of the track the animal is competing on
     * @return the calculated `Point` representing the destination for the animal
     */
    @Override
	public Point calcDestination(Animal a,String track) {
		Point des = null;
		if(a.getComp().equals("Water")) {
			switch(track) {
			case "Track 1":
				des =  new Point(1250,120);
				break;
			case "Track 2":
				des = new Point(1250,300);
				break;
			case "Track 3":
				des = new Point(1250,480);
				break;
			case "Track 4":
				des = new Point(1250,670);
				break;
			default:
				des = new Point(0,0);
				break;
					
			}
			return des;
		}
		else if(a.getComp().equals("Air")) {
			switch(track) {
			case "Track 1":
				des = new Point(1300,20);
				break;
			case "Track 2":
				des = new Point(1300,200);
				break;
			case "Track 3":
				des = new Point(1300,380);
				break;
			case "Track 4":
				des = new Point(1300,580);
				break;
			case "Track 5":
				des = new Point(1300,760);
				break;
			default:
				des = new Point(0,0);	
				break;
			}
			return des;
		}
		else if(a.getComp().equals("Terrestrial")) {
			des = new Point(1350,0);
			return des;
		}
		else {
			System.out.print("still here");
		}
		return des;
				
	}

}
