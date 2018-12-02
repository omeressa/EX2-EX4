package Algorithms;

import java.io.FileNotFoundException;

import GIS.GIS_proj;


public class testMultiCsv {


	public static void main(String[] args) throws FileNotFoundException {
		String files="OOP_EX2-EX4/Data";;
		GIS_proj project=(GIS_proj) MultiCsv.compine_Csv_File_In_One_Kml(files);
   		
	}
}
