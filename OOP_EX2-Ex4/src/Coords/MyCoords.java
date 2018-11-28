package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter{
	
	private static final long radios = 6371000;

	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {


		double ln = Math.cos((gps.x()*Math.PI)/180);
		double x = gps.x()+Math.toDegrees(Math.asin(local_vector_in_meter.x()/radios));
		double y = gps.y()+Math.toDegrees(Math.asin(local_vector_in_meter.y()/(radios*ln)));
		double z = gps.z()+local_vector_in_meter.z();
		Point3D gps2 = new Point3D(x,y,z);
		return gps2;
	}

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		return null;

	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {

		return null;

	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		return null;


	}

}