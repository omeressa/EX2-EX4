package File_format;
import java.io.FileNotFoundException;


public class test {
	public static void main(String[] args) throws FileNotFoundException {

		
		String file1 = "OOP_EX2-EX4/Data/data1/WigleWifi_20171201110209.csv";
		String file2 = "OOP_EX2-EX4/Data/data2/WigleWifi_20171203085618.csv";
		Csv2Kml.turn(file1);
		Csv2Kml.turn(file2);

	}
}