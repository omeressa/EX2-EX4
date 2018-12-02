package GIS;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is to turn Csv file into GIS_Layer
 * @author admin
 *
 */
public class Csv2Gis {
	/**
	 * still not final, testing time
	 * @param File
	 * @return
	 */
	public static GIS_layer csv2gisLayer(String File) {
		GIS_lay Layer = new GIS_lay(File);
		try (BufferedReader bufferReader = new BufferedReader(new FileReader(File))) {
			bufferReader.readLine();
			bufferReader.readLine();
			String Lines;
			while ((Lines = bufferReader.readLine()) != null) {
				String[] elements = Lines.split(",");
				//adding the gps data into layer
				Layer.add(new GIS_elem(elements[0], elements[1], elements[2], elements[3], elements[4], elements[5], elements[6], elements[7],
						elements[8], elements[9], elements[10]));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return Layer;
	}
	/**
	 * similer code used as reference
	 * @param path
	 * @return
	 */
	public static String[] read(String path) {
		List<String> lines = new ArrayList<>();
		try {
			BufferedReader BR = new BufferedReader(new FileReader(path));
			String line;
			while ((line = BR.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			return new String[0];
		}
		return lines.toArray(new String[lines.size()]);
	}
}