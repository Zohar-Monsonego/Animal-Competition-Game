package Mobility;

public class Location implements ILocatable{
	private Point p;
	
	public Location(Point p) {
		this.p = new Point(p.getX(),p.getY());
	}
	
	public Point getLocation() {
		return p;
	}
	
	public boolean setLocation(Point p1) {
		if(p.setX(p1.getX()) && p.setY(p1.getY())) {
			return true;
		}
		else {
			return false;
		}
	}

}
