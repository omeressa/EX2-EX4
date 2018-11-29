package GIS;


import File_format.CsvReader;
import Geom.Point3D;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Csv2Gis {

    public static GIS_layer csv2gisLayer(String path) {
        String[] lines = CsvReader.read(path);
        GIS_layer gisLayer = (GIS_layer) new GIS_lay(); 
        for (int lineIndex = 2; lineIndex < lines.length; lineIndex++) { 
            String[] splittedData = lines[lineIndex].split(",");
            double alt = Double.parseDouble(splittedData[8]);
            double lon = Double.parseDouble(splittedData[7]);
            double lat = Double.parseDouble(splittedData[6]);
            Point3D geom = new Point3D(lat, lon, alt);
            String time = splittedData[3];
            DateTimeFormatter parseFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(time, parseFormatter);
            long utc = dateTime.atOffset(ZoneOffset.UTC).toInstant().toEpochMilli();
            Meta_data data = new GIS_MetDat(utc);
            GIS_element element = new GIS_elem(geom, data);
            gisLayer.add(element);
        }
        return gisLayer;
    }
}