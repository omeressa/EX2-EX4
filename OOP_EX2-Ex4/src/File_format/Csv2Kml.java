package File_format;

import java.io.FileNotFoundException;

import GIS.Csv2Gis;
import GIS.GIS_lay;


/**
 * Static class used for reading CSV file and converting to KML or converting a folder and its content (if valid) to
 * KML.
 */
public final class Csv2Kml {
	/**
	 * u have to input the file and where it is
	 * example: Data/data1/WigleWifi_20171203085618.csv
	 * @param file
	 * @throws FileNotFoundException
	 */
	public static void turn(String file) throws FileNotFoundException{
		GIS_lay layer =  (GIS_lay) Csv2Gis.csv2gisLayer(file);
		kml kml = new kml();
		kml.addLayer(layer);
		String path = file.replace(".csv", ".kml");
		kml.make(path);


	}
}