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
	Point3D gps1,gps2,gps3;



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
		
		assertEquals(true, coord.add(gps1, gps3).equals(new Point3D(32.106352000071396,35.20522500219698,650.0)));
	}

	@Test
	void testDistance3d() {
		assertEquals(493.05233183241336, coord.distance3d(gps1, gps2));
	}

	@Test
	void testVector3D() {
		assertEquals(true, coord.vector3D(gps1, gps2).equals(new Point3D(337.69899206128815,-359.2492069388189,-20.0)));
	}

	@Test
	void testAzimuth_elevation_dist() {
		double[] ar= coord.azimuth_elevation_dist(gps1, gps2);
		double[] ar2= {313.2585, -2.3253, 493.0523};
		assertArrayEquals(ar, ar2, 0.05);
	}

	@Test
	void testIsValid_GPS_Point() {
		assertEquals(true, coord.isValid_GPS_Point(gps1));
		assertEquals(false, coord.isValid_GPS_Point(gps3));

	}

}