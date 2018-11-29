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

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		double ln = Math.cos((gps0.x()*PI)/180);
		double x_dis = Math.sin((gps1.x()-gps0.x())*(PI/180))*radios;
		double y_dis = Math.sin((gps1.y()-gps0.y())*(PI/180))*ln*radios;
		double ans = Math.sqrt(Math.pow(x_dis, 2) + Math.pow(y_dis, 2));
		return ans;
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		double ln = Math.cos((gps0.x()*PI)/180);
		double x = Math.sin((gps1.x()-gps0.x())*(PI/180))*radios;
		double y = Math.sin((gps1.y()-gps0.y())*(PI/180))*radios*ln;
		double z = gps0.z()-gps1.z();
		Point3D ans = new Point3D(x,y,z); 
		return ans;
	}
/**
 * this code is taken from someone on github and addabted it to my own coding
 */
	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		double dist = distance3d(gps0,gps1);
		double elevation = (180/PI)*((gps1.z()-gps0.z())/dist-dist/(2*radios));
		double delta= gps1.y()-gps0.y();
		double azimuth = Math.toDegrees(Math.atan2(Math.sin(Math.toRadians(delta))*Math.cos(Math.toRadians(gps1.x())),
				(Math.cos(Math.toRadians(gps0.x()))*Math.sin(Math.toRadians(gps1.x())))-Math.sin(Math.toRadians(gps0.x()))*Math.cos(Math.toRadians(gps1.x()))*Math.cos(Math.toRadians(delta))));
		if (azimuth<0) azimuth+=360;
		double[] Polar = {azimuth,elevation,dist};
		return Polar;
	}
	/**
	 * this function returns true id the gps point got a valid lat lon and alt
	 */
	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		if((p.x() > -90 && p.x() < 90) && (p.y() > -180 && p.y() < 180) && (p.z() > -450)) {
			return true;
		}
		return false;
	}


}