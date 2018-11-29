package File_format;

import GIS.GIS_element;
import GIS.GIS_layer;
import Geom.Geom_element;
import Geom.Point3D;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class kml {

    private Collection<GIS_element> points = new HashSet<>();


    public void addLayer(GIS_layer layer) {
        for (GIS_element element : layer) {
            points.add(element);
        }
    }

    public void toKmlFile(String path) throws FileNotFoundException {
    	/*
    	PrintWriter writer = new PrintWriter(new File(path));
        writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.println("<kml xmlns=\"http://www.opengis.net/kml/2.2\">");
        writer.println("<Document>");
        writer.println("<Folder>");
        writer.println("<name/>");
        for (GIS_element element : points) {
            writer.println("<Placemark>");
            writer.println("<name/>");
            Date date = new Date(element.getData().getUTC());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            writer.println("<description><![CDATA[Timestamp: <b>" + element.getData().getUTC() + "</b><br/>Date: <b>" + df.format(date) + "</b>]]></description>");
            writer.println("<Point>");
            writer.println("<coordinates>" + ((Point3D) element.getGeom()).y() + "," + ((Point3D) element.getGeom()).x() + "," + ((Point3D) element.getGeom()).z() + "</coordinates>");
            writer.println("</Point>");
            writer.println("</Placemark>");
        }
        writer.println("</Folder>");
        writer.println("</Document>");
        writer.println("</kml>");
        writer.close();
    }
    	 */
    	//private static String KmlFileTemplateFormat = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document>\n%s\n</Document>\n</kml>";
    	//private static String KmlPlacemarkTemplateFormat = "<Placemark>\n<name>%s</name>\n<TimeStamp>\n<when>%s</when>\n</TimeStamp>\n<description>%s</description>\n<Point>\n<coordinates>%s,%s,%s</coordinates></Point>\n</Placemark>";
    	
		String fileName = "output.kml";
		PrintWriter PrintWriter = null;
		try 
		{
			PrintWriter = new PrintWriter(new File(fileName));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
    	StringBuilder KmlFileTemplateFormat = new StringBuilder();
    	 KmlFileTemplateFormat.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<kml xmlns=\\\"http://www.opengis.net/kml/2.2\\\">\n<Document>\n<Folder>\n<name/>");
    	//String KmlFileTemplateFormat= "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<kml xmlns=\\\"http://www.opengis.net/kml/2.2\\\">\n<Document>\n<Folder>\n<name/>";
        for (GIS_element element : points) {
        	KmlFileTemplateFormat.append("<Placemark>");
        	KmlFileTemplateFormat.append("<name/>");
            Date date = new Date(element.getData().getUTC());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            KmlFileTemplateFormat.append("<description><![CDATA[Timestamp: <b>" + element.getData().getUTC() + "</b><br/>Date: <b>" + df.format(date) + "</b>]]></description>");
            KmlFileTemplateFormat.append("<Point>");
            KmlFileTemplateFormat.append("<coordinates>" + ((Point3D) element.getGeom()).y() + "," + ((Point3D) element.getGeom()).x() + "," + ((Point3D) element.getGeom()).z() + "</coordinates>");
            KmlFileTemplateFormat.append("</Point>");
            KmlFileTemplateFormat.append("</Placemark>");	
        }
        PrintWriter.write(KmlFileTemplateFormat.toString());
        PrintWriter.close();
     //   KmlFileTemplateFormat+="</Folder>\n</Document>\n</kml>";
     //   System.out.print(KmlFileTemplateFormat);       
    }
    }