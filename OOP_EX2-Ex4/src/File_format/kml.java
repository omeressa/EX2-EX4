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
    	//private static String KmlFileTemplateFormat = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document>\n%s\n</Document>\n</kml>";
    	//private static String KmlPlacemarkTemplateFormat = "<Placemark>\n<name>%s</name>\n<TimeStamp>\n<when>%s</when>\n</TimeStamp>\n<description>%s</description>\n<Point>\n<coordinates>%s,%s,%s</coordinates></Point>\n</Placemark>";
    	String KmlFileTemplateFormat= "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<kml xmlns=\\\"http://www.opengis.net/kml/2.2\\\">\n<Document>\n<Folder>\n<name/>";
        for (GIS_element element : points) {
        	KmlFileTemplateFormat+="<Placemark>";
        	KmlFileTemplateFormat+="<name/>";
            Date date = new Date(element.getData().getUTC());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            KmlFileTemplateFormat+="<description><![CDATA[Timestamp: <b>" + element.getData().getUTC() + "</b><br/>Date: <b>" + df.format(date) + "</b>]]></description>";
            KmlFileTemplateFormat+="<Point>";
            KmlFileTemplateFormat+="<coordinates>" + ((Point3D) element.getGeom()).y() + "," + ((Point3D) element.getGeom()).x() + "," + ((Point3D) element.getGeom()).z() + "</coordinates>";
            KmlFileTemplateFormat+="</Point>";
            KmlFileTemplateFormat+="</Placemark>";	
        }
        KmlFileTemplateFormat+="</Folder>\n</Document>\n</kml>";
        System.out.print(KmlFileTemplateFormat);       
    }
    }