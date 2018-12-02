
package File_format;

import GIS.*;
import Geom.Point3D;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;


public final class kml {


	private Collection<GIS_element> points = new HashSet<>();


	public void addLayer(GIS_layer layer) {
		for (GIS_element element : layer) {
			points.add(element);
		}
	}
	/**
	 * an easy code 
	 * @param path
	 * @throws FileNotFoundException
	 */
	public void make(String path) throws FileNotFoundException {
		PrintWriter PW = new PrintWriter(new File(path));
		PW.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		PW.println("<kml xmlns=\"http://www.opengis.net/kml/2.2\">");
		PW.println("<Document>");
		PW.println("<Folder>");
		PW.println("<name/>");
		for (GIS_element element : points) {
			PW.println("<Placemark>");
			PW.println("<name/>");
			Date date = new Date(element.getData().getUTC());
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			PW.println("<description><![CDATA[Timestamp: <b>" + element.getData().getUTC() + "</b><br/>Date: <b>" + df.format(date) + "</b>]]></description>");
			PW.println("<Point>");
			PW.println("<coordinates>" + ((Point3D) element.getGeom()).y() + "," + ((Point3D) element.getGeom()).x() + "," + ((Point3D) element.getGeom()).z() + "</coordinates>");
			PW.println("</Point>");
			PW.println("</Placemark>");
		}
		PW.println("</Folder>");
		PW.println("</Document>");
		PW.println("</kml>");
		PW.close();
	}
}