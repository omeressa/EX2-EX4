package Algorithms;

import File_format.kml;
import GIS.Csv2Gis;
import GIS.GIS_layer;
import GIS.GIS_proj;
import GIS.GIS_project;

import java.io.File;
import java.io.FileNotFoundException;

public class MultiCsv {

    public static  GIS_project creatProject(String file) throws FileNotFoundException {
        GIS_project project = recursiveSearch(new File(file));
        kml kml = new kml();
        for (GIS_layer layer : project) {
            kml.addLayer(layer);
        }
        // save kml as a text file
        kml.make(file + "/CsvsAsKml.kml");
        return project;
    }

    public static GIS_project recursiveSearch(File directory) {
        GIS_project project = new GIS_proj();
        if (directory.isDirectory()) {
            try {
                File[] files = directory.listFiles();
                for (File file : files) {
                    if (file.isDirectory()) {
                        GIS_project tempProject = recursiveSearch(file);
                        for (GIS_layer layer : tempProject) {
                            project.add(layer);
                        }
                    }
                    if (isCsv(file)) {
                        GIS_layer layer = Csv2Gis.csv2gisLayer(file.getAbsolutePath());
                        project.add(layer);
                    }
                }
            } catch (Exception e) {
                // unexpected catastrophe
            }
        }
        return project;
    }

    public static boolean isCsv(File fileType){
        return fileType.getName().endsWith(".csv");
    }
}