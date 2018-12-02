package GIS;

import Geom.Point3D;
import java.util.Date;


public class Other implements Meta_data {
	private long time;

	public Other() {
		Date date = new Date();
		time = date.getTime();
	}

	@Override
	public long getUTC() {
		return time;
	}

	/**
	 * as proffesor asked, null
	 */
	@Override
	public Point3D get_Orientation() {
		return null;
	}


	@Override
	public String toString() {
		return "time: " + getUTC();
	}
}