package GIS;

import Coords.MyCoords;
import Geom.Geom_element;
import Geom.Point3D;

public class GIS_elem implements GIS_element {
	GIS_MetDat data ;
	Point3D point;
private String arr[];
	

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
	public GIS_MetDat getMd() {
		return data;
	}

	public void setMd(GIS_MetDat md) {
		this.data = md;
	}

	public Point3D getP() {
		return point;
	}

	public void setP(Point3D p) {
		this.point = p;
	}

	public String[] getArr() {
		return arr;
	}

	public void setArr(String[] arr) {
		this.arr = arr;
	}
	
	/**
	 * the constractor, get a row from the CSV and split it to the right places
	 * @param str
	 */
	public GIS_elem(String str)
	{
		arr=str.split(",");
		point = new Point3D(Double.parseDouble(arr[6]),Double.parseDouble(arr[7]),Double.parseDouble(arr[8]));
		data = new GIS_MetDat(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[9],arr[10]);
	}


}