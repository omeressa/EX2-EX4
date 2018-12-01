package Coords;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Geom.Point3D;

class MyCoordsTest {
	
	MyCoords coord;
	Point3D gps1,gps2,gps3;;;



	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		coord = new MyCoords();

		gps1 = new Point3D(32.103315, 35.209039, 670);
		gps2 = new Point3D(32.106352, 35.205225, 650);
		gps3 = new Point3D(337.699, -359.249, -20);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAdd() {
		Point3D answer= new Point3D(32.106352000071396,35.20522500219698,650.0);
		assertEquals(true, coord.add(gps1, gps3).equals(answer));
	}

	@Test
	void testDistance3d() {
		double answer=493.05233183241336;
		assertEquals(answer, coord.distance3d(gps1, gps2));
	}

	@Test
	void testVector3D() {
		Point3D answer;
		answer = coord.vector3D(gps1, gps2);
		assertEquals(gps3.x(), answer.x(),0.001,"The Vector Latitude is wrong");
		assertEquals(gps3.y(), answer.y(),0.001,"The Vector longtidude is wrong");
		assertEquals(gps3.z(), answer.z(),0.001,"The Vector atitude is wrong");	
	}

	@Test
	void testAzimuth_elevation_dist() {
		double[] dist= coord.azimuth_elevation_dist(gps1, gps2);
		double[] answer= {313.2585, -2.3253, 493.0523};
		assertArrayEquals(dist, answer, 0.03);
	}

	@Test
	void testIsValid_GPS_Point() {
		assertEquals(true, coord.isValid_GPS_Point(gps2));

	}

}
