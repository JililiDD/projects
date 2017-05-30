
public class QuakeEntry implements Comparable<QuakeEntry>{
	
	private Location myLocation;
	private String title;
	private double depth;
	private double magnitude;

	public QuakeEntry(double lat, double lon, double mag, 
	                  String t, double d) {
		myLocation = new Location(lat,lon);
		
		magnitude = mag;
		title = t;
		depth = d;
	}
	
	public Location getLocation(){
		return myLocation;
	}
	
	public double getMagnitude(){
		return magnitude;
	}
	
	public String getInfo(){
		return title;
	}
	
	public double getDepth(){
		return depth;
	}

	//@Override
	public int compareTo(QuakeEntry loc) {
		double difflat = myLocation.getLatitude() - loc.myLocation.getLatitude();
		if (Math.abs(difflat) < 0.001) {
			double diff = myLocation.getLongitude() - loc.myLocation.getLongitude();
			if (diff < 0) return -1;
			if (diff > 0) return 1;
			return 0;
		}
		if (difflat < 0) return -1;
		if (difflat > 0) return 1;
		
		// never reached
		return 0;
	}

	public double distanceTo(Location loc){
		/*
		final int R = 6371; // Radius of the earth

		double latDistance = Math.toRadians(loc.getLatitude() - this.myLocation.getLatitude());
		double lonDistance = Math.toRadians(loc.getLongitude() - this.myLocation.getLatitude());
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Math.toRadians(loc.getLatitude())) * Math.cos(Math.toRadians(this.myLocation.getLatitude()))
				* Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters

		return Math.sqrt(distance);
		*/
		return this.myLocation.distanceTo(loc);
	}
	
	public String toString(){
		return String.format("(%3.2f, %3.2f), mag = %3.2f, depth = %3.2f, title = %s", myLocation.getLatitude(),myLocation.getLongitude(),magnitude,depth,title);
	}
	
}