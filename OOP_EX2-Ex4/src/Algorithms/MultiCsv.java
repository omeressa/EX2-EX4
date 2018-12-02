package Algorithms;

import File_format.kml;
import GIS.Csv2Gis;
import GIS.GIS_layer;
import GIS.GIS_proj;
import GIS.GIS_project;

import java.io.File;
import java.io.FileNotFoundException;

public class MultiCsv {

    public static  GIS_project compine_Csv_File_In_One_Kml(String file) throws FileNotFoundException {
    	File files = new File(file);
        GIS_project project = search(files);;
        kml kml = new kml();
        for (GIS_layer layer : project) {
            kml.addLayer(layer);
        }
        kml.make(file + "_Csv_Compine.kml");
        return project;
    }

    public static GIS_project search(File folder) {
        GIS_project project = new GIS_proj();;
        
        if (folder.isDirectory()) {
            try {
                File[] files = folder.listFiles();
                for (File file : files) {
                    if (file.isDirectory()) {
                        GIS_project tmp = search(file);
                        for (GIS_layer layer : tmp) {
                            project.add(layer);
                        }
                    }
                    if (find_CsvFiles_Only(file)) {
                        GIS_layer layer = Csv2Gis.csv2gisLayer(file.getAbsolutePath());
                        project.add(layer);
                    }
                }
            } catch (Exception e) {}
            
        }
        return project;
    }

 
    /**
     * a helping function for cheacking if the file is csv or kml
     * @param file
     * @return
     */
    public static boolean find_CsvFiles_Only(File file){
//    	boolean answer= false;
//    	if(file.getName().endsWith(".csv"))
//    		answer=true;
//        return answer;
    	return file.getName().endsWith(".csv");
    }
}