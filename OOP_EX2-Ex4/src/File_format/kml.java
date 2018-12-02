package File_format;

import GIS.*;
import Geom.Point3D;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;


public final class kml {

	//private final PrintWriter PW;
	//private final BufferedWriter PW;
	private Collection<GIS_element> points = new HashSet<>();


	public void addLayer(GIS_layer layer) {
		for (GIS_element element : layer) {
			points.add( element);
		}
	}


	/**
         *this function make kml file for us with all the elements needed to show in google earth
	 * @param path
	 * @throws FileNotFoundException 
	 */
	public void make(String path) throws FileNotFoundException
	{
		PrintWriter PW = new PrintWriter(new File(path));
		PW.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		PW.println("<kml xmlns=\"http://www.opengis.net/kml/2.2\">");
		PW.println("<Document>");
		PW.println("<Folder>");
		PW.println("<name/>");
		for (GIS_element element : points) {
					PW.println("<Placemark>\n");
			PW.println("<name/>");
			Date date = new Date(element.getData().getUTC());
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			PW.println("<name>"+"<![CDATA["+((GIS_elem) element).getMd().getSSID()+"]]>"  +"</name>\n");
			PW.println("<description>"+"<![CDATA[BSSID: <b>"+((GIS_elem) element).getMd().getMac()+"</b><br/>Capabilities: <b>"+((GIS_elem) element).getMd().getAuth_mode()+"</b><br/>Timestamp: <b>"+((GIS_elem) element).getMd().getRssi()+"</b><br/>Channel: <b>"+((GIS_elem) element).getMd().getChannel()+"</b><br/>RSSI: <b>"+((GIS_elem) element).getMd().getRssi()+"</b><br/>AltitudeMeters: <b>"+((GIS_elem) element).getP().z()+"</b><br/>AccuracyMeters: <b>"+((GIS_elem) element).getMd().getAccuracy()+"</b><br/>Type: <b>"+((GIS_elem) element).getMd().getType()+"</b><br/>Date: <b>"+((GIS_elem) element).getMd().getFirst_seen()+"Timestamp: <b>" + element.getData() + "</b><br/>Date: <b>" + df.format(date)  + "</b>]]></description>");
			PW.println("<Point>");
			PW.println("<coordinates>" + ((Point3D) element.getGeom()).y() + "," + ((Point3D) element.getGeom()).x() + "," + ((Point3D) element.getGeom()).z() + "</coordinates>");
			PW.println("</Point>\n");
			PW.println("</Placemark>");
			}
		
		PW.println("</Folder>");
		PW.println("</Document>");
		PW.println("</kml>");
		PW.close();	}
	}
