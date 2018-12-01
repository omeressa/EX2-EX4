package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter{
	
	/**
	 * the radios of earth
	 */
	private static final long radios = 6371000;
	/**
	 * PI
	 */
	private static final double PI =Math.PI; 
	
	
	/** computes a new point which is the gps point transformed by a 3D vector (in meters)*/
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
    /*
    * this is a reference from which we thought of the code down:
    * https://stackoverflow.com/questions/53411266/gps-to-cartesian-x-y-z
    */
		double ln = Math.cos((gps.x()*Math.PI)/180);
		double x = gps.x() + Math.toDegrees(Math.asin(local_vector_in_meter.x() / radios));
		double y = gps.y() + Math.toDegrees(Math.asin(local_vector_in_meter.y() / (radios*ln) ));
		double z = gps.z() + local_vector_in_meter.z();
		Point3D ans = new Point3D(x,y,z);
		
		return ans;
	}
	
	/** computes the 3D distance (in meters) between the two gps like points */
	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {

		Point3D p= vector3D(gps0,gps1);
		return Math.sqrt(p.x()*p.x()+ p.y()*p.y());
	}
	
	/** computes the 3D vector (in meters) between two gps like points */
	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		
		double ln = Math.cos(Math.toRadians(gps0.x()));
		double x= radios*Math.sin(Math.toRadians((gps1.x()-gps0.x())));
		double y= ln*radios*Math.sin(Math.toRadians((gps1.y()-gps0.y())));
		double z= gps1.z()-gps0.z();
		Point3D ans = new Point3D(x,y,z); 
		return ans;
	}
	/** computes the polar representation of the 3D vector be gps0-->gps1 
	 * Note: this method should return an azimuth (aka yaw), elevation (pitch), and distance*/
	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		double dist = distance3d(gps0,gps1);
		double elevation = (180/PI)*((gps1.z()-gps0.z())/dist-dist/(2*radios));
		double delta= gps1.y()-gps0.y();
		double azimuth = Math.toDegrees(Math.atan2(Math.sin(Math.toRadians(delta))
				*Math.cos(Math.toRadians(gps1.x())),
				(Math.cos(Math.toRadians(gps0.x()))
				*Math.sin(Math.toRadians(gps1.x())))
				-Math.sin(Math.toRadians(gps0.x()))
				*Math.cos(Math.toRadians(gps1.x()))
				*Math.cos(Math.toRadians(delta))));
		if (azimuth<0) azimuth+=360;
		double[] Polar = {azimuth,elevation,dist};
		return Polar;
	}
	/**
	 * return true iff this point is a valid lat, lon , lat coordinate: [-180,+180],[-90,+90],[-450, +inf]
	 * @param p
	 * @return
	 */
	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		if((p.x() > -90 && p.x() < 90) && (p.y() > -180 && p.y() < 180) && (p.z() > -450)) {
			return true;
		}
		return false;
	}


}