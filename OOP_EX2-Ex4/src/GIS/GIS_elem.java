package GIS;

import Coords.*;
import Geom.Geom_element;
import Geom.Point3D;


public class GIS_elem implements GIS_element {

	private Point3D point;
	private GIS_MetDat data;

	/**
	 * gps point information 
	 *
	 * @param MAC
	 * @param SSID
	 * @param Auth_mode
	 * @param FS
	 * @param Channel
	 * @param RSSI
	 * @param LAT
	 * @param LON
	 * @param ALT
	 * @param Accuracy
	 * @param Type
	 */
	public GIS_elem(String MAC, String SSID, String Auth_mode, String FS, String Channel, String RSSI,
			String LAT, String LON, String ALT, String Accurcy, String Type) {
		String point = "[" + LAT + "," + LON + "," + ALT + "]";
		this.point = new Point3D(point);
		//getting the data from MetDat
		this.data = new GIS_MetDat(MAC, SSID, Auth_mode, FS, Channel, RSSI, Accurcy, Type);
	}

	public GIS_elem(Point3D geom, Meta_data data2) {
		this.point = geom;
		this.data = (GIS_MetDat)data2;
	}

	@Override
	public Geom_element getGeom() {
		return point;
	}

	@Override
	public Meta_data getData() {
		return data;
	}

	/**
	 * פונקציית translate:
	 * לקחת את הנקודה ולהשתמש בפונקציה ממחלקת MYCOORDS 
	 * של הוספת וקטור
	 * this is what the other student added on whatsapp for what to do with this function
	 */
	@Override
	public void translate(Point3D vec) {
		MyCoords coord = new MyCoords();
		Point3D gps = coord.add(point, vec);
		point = new Point3D(gps.x(),gps.y(),gps.z());		
	}

	@Override
	public String toString() {
		return "GIS_elem [gps point=" + point + ", data=" + data + "]";
	}



}