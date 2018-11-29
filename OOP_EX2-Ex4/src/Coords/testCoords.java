package Coords;

import Geom.Point3D;

public class testCoords {

	public static void main(String[] args) {
		MyCoords m = new MyCoords();
		Point3D p1 = new Point3D(32.103315,35.209039,670);
		Point3D p2 = new Point3D(32.106352,35.205225,650);
		System.out.println("Distance: "+m.distance3d(p2, p1));
		Point3D p3 = new Point3D(m.vector3D(p1, p2));
		System.out.println("Vector between: "+m.vector3D(p1, p2));
		System.out.println(p3);
		System.out.println("Add Vector: "+m.add(p1, p3));
		System.out.println("Cheack: "+m.isValid_GPS_Point(p1));
	}

}
