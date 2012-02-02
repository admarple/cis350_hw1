package edu.upenn.cis350.gpx;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class GPXcalculatorTest {

	// for assertEquals(double, double), which requires a third argument to check equality
	double delta = 0.00001;

	GPXtrkpt normalPt1;
	GPXtrkpt normalPt2;
	GPXtrkpt normalPt3;
	GPXtrkpt normalPt4;
	GPXtrkpt normalPt5;
	GPXtrkpt latGT90;
	GPXtrkpt latLTNeg90;
	GPXtrkpt longGT180;
	GPXtrkpt longLTNeg180;
	GPXtrkpt latEQ90;
	GPXtrkpt latEQNeg90;
	GPXtrkpt longEQ180;
	GPXtrkpt longEQNeg180;
	GPXtrkpt nullTrkpt;

	// GPXtrkseg objects

	ArrayList<GPXtrkpt> listNormal1;
	GPXtrkseg segNormal1;

	ArrayList<GPXtrkpt> listNormal2;
	GPXtrkseg segNormal2;

	ArrayList<GPXtrkpt> listNormal3;
	GPXtrkseg segNormal3;

	GPXtrkseg nullSeg = null;

	ArrayList<GPXtrkpt> listContainsOneNullPoint;
	GPXtrkseg segContainsOneNullPoint;

	ArrayList<GPXtrkpt> listContainsNullPoint;
	GPXtrkseg segContainsNullPoint;

	ArrayList<GPXtrkpt> listContainsLatGT90;
	GPXtrkseg segContainsLatGT90;

	ArrayList<GPXtrkpt> listContainsLatLTNeg90;
	GPXtrkseg segContainsLatLTNeg90;

	ArrayList<GPXtrkpt> listContainsLongGT180;
	GPXtrkseg segContainsLongGT180;

	ArrayList<GPXtrkpt> listContainsLongLTNeg180;
	GPXtrkseg segContainsLongLTNeg180;
	
	ArrayList<GPXtrkpt> listContainsLatEQ90;
	GPXtrkseg segContainsLatEQ90;

	ArrayList<GPXtrkpt> listContainsLatEQNeg90;
	GPXtrkseg segContainsLatEQNeg90;

	ArrayList<GPXtrkpt> listContainsLongEQ180;
	GPXtrkseg segContainsLongEQ180;

	ArrayList<GPXtrkpt> listContainsLongEQNeg180;
	GPXtrkseg segContainsLongEQNeg180;

	ArrayList<GPXtrkpt> listContainsOnePoint;
	GPXtrkseg segContainsOnePoint;

	ArrayList<GPXtrkpt> listContainsNoPoint;
	GPXtrkseg segContainsNoPoint;

	// GPXtrk objects

	ArrayList<GPXtrkseg> segListNormal1;
	GPXtrk normalTrk1;

	ArrayList<GPXtrkseg> segListNormal2;
	GPXtrk normalTrk2;

	ArrayList<GPXtrkseg> segListNormal3;
	GPXtrk normalTrk3;

	ArrayList<GPXtrkseg> segListLatGT90;
	GPXtrk trkLatGT90;

	ArrayList<GPXtrkseg> segListLatLTNeg90;
	GPXtrk trkLatLTNeg90;;

	ArrayList<GPXtrkseg> segListLongGT180;
	GPXtrk trkLongGT180;

	ArrayList<GPXtrkseg> segListLongLTNeg180;
	GPXtrk trkLongLTNeg180;
	
	ArrayList<GPXtrkseg> segListLatEQ90;
	GPXtrk trkLatEQ90;

	ArrayList<GPXtrkseg> segListLatEQNeg90;
	GPXtrk trkLatEQNeg90;;

	ArrayList<GPXtrkseg> segListLongEQ180;
	GPXtrk trkLongEQ180;

	ArrayList<GPXtrkseg> segListLongEQNeg180;
	GPXtrk trkLongEQNeg180;

	ArrayList<GPXtrkseg> segListNullTrkpt;
	GPXtrk trkNullTrkpt;

	ArrayList<GPXtrkseg> segListOneNullTrkpt;
	GPXtrk trkOneNullTrkpt;

	ArrayList<GPXtrkseg> segListOneTrkpt;
	GPXtrk trkOneTrkpt;

	ArrayList<GPXtrkseg> segListNoTrkpt;
	GPXtrk trkNoTrkpt;

	ArrayList<GPXtrkseg> segListNoTrkseg;
	GPXtrk trkNoTrkseg;

	ArrayList<GPXtrkseg> segListNullTrkseg;
	GPXtrk trkNullTrkseg;

	GPXtrk nullTrk;

	ArrayList<GPXtrkseg> segListJustInvalid;
	GPXtrk trkJustInvalid;

	ArrayList<GPXtrkseg> segListMultipleInvalid;
	GPXtrk trkMultipleInvalid;

	@Before
	public void setUp() throws Exception {

		// GPXtrkpt objects

		normalPt1 = new GPXtrkpt(0, 0, new java.util.Date());
		normalPt2 = new GPXtrkpt(10, 0, new java.util.Date()); // 1 -> 2 = 10
		normalPt3 = new GPXtrkpt(10, 15, new java.util.Date()); // 2 -> 3 = 15
		normalPt4 = new GPXtrkpt(28, 15, new java.util.Date()); // 3 -> 4 = 18
		normalPt5 = new GPXtrkpt(28, 21, new java.util.Date()); // 4 -> 5 = 6
		latGT90 = new GPXtrkpt(100, 0, new java.util.Date());
		latLTNeg90 = new GPXtrkpt(-100, 0, new java.util.Date());
		longGT180 = new GPXtrkpt(0, 190, new java.util.Date());
		longLTNeg180 = new GPXtrkpt(0, -190, new java.util.Date());
		latEQ90 = new GPXtrkpt(90, 0, new java.util.Date());
		latEQNeg90 = new GPXtrkpt(-90, 0, new java.util.Date());
		longEQ180 = new GPXtrkpt(0, 180, new java.util.Date());
		longEQNeg180 = new GPXtrkpt(0, -180, new java.util.Date());
		nullTrkpt = null;

		// GPXtrkseg objects

		listNormal1 = new ArrayList<GPXtrkpt>();
		listNormal1.add(normalPt1);
		listNormal1.add(normalPt2);
		segNormal1 = new GPXtrkseg(listNormal1); // length should be 10

		listNormal2 = new ArrayList<GPXtrkpt>();
		listNormal2.add(normalPt3);
		listNormal2.add(normalPt4);
		listNormal2.add(normalPt5);
		segNormal2 = new GPXtrkseg(listNormal2); // length should be 24

		listNormal3 = new ArrayList<GPXtrkpt>();
		listNormal3.add(normalPt1);
		listNormal3.add(normalPt2);
		listNormal3.add(normalPt3);
		listNormal3.add(normalPt4);
		listNormal3.add(normalPt5);
		segNormal3 = new GPXtrkseg(listNormal3); // length should be 49

		nullSeg = null;

		listContainsOneNullPoint = new ArrayList<GPXtrkpt>();
		listContainsOneNullPoint.add(nullTrkpt);
		segContainsOneNullPoint = new GPXtrkseg(listContainsOneNullPoint);

		listContainsNullPoint = new ArrayList<GPXtrkpt>();
		listContainsNullPoint.add(normalPt1);
		listContainsNullPoint.add(nullTrkpt);
		listContainsNullPoint.add(normalPt2);
		segContainsNullPoint = new GPXtrkseg(listContainsNullPoint);

		listContainsLatGT90 = new ArrayList<GPXtrkpt>();
		listContainsLatGT90.add(normalPt1);
		listContainsLatGT90.add(latGT90);
		listContainsLatGT90.add(normalPt2);
		segContainsLatGT90 = new GPXtrkseg(listContainsLatGT90);

		listContainsLatLTNeg90 = new ArrayList<GPXtrkpt>();
		listContainsLatLTNeg90.add(normalPt1);
		listContainsLatLTNeg90.add(latLTNeg90);
		listContainsLatLTNeg90.add(normalPt2);
		segContainsLatLTNeg90 = new GPXtrkseg(listContainsLatLTNeg90);

		listContainsLongGT180 = new ArrayList<GPXtrkpt>();
		listContainsLongGT180.add(normalPt1);
		listContainsLongGT180.add(longGT180);
		listContainsLongGT180.add(normalPt2);
		segContainsLongGT180 = new GPXtrkseg(listContainsLongGT180);

		listContainsLongLTNeg180 = new ArrayList<GPXtrkpt>();
		listContainsLongLTNeg180.add(normalPt1);
		listContainsLongLTNeg180.add(longLTNeg180);
		listContainsLongLTNeg180.add(normalPt2);
		segContainsLongLTNeg180 = new GPXtrkseg(listContainsLongLTNeg180);

		listContainsLatEQ90 = new ArrayList<GPXtrkpt>();
		listContainsLatEQ90.add(normalPt1);
		listContainsLatEQ90.add(latEQ90);
		segContainsLatEQ90 = new GPXtrkseg(listContainsLatEQ90); // length should be 90
		
		listContainsLatEQNeg90 = new ArrayList<GPXtrkpt>();
		listContainsLatEQNeg90.add(normalPt1);
		listContainsLatEQNeg90.add(latEQNeg90);
		segContainsLatEQNeg90 = new GPXtrkseg(listContainsLatEQNeg90); // length should be 90
		
		listContainsLongEQ180 = new ArrayList<GPXtrkpt>();
		listContainsLongEQ180.add(normalPt1);
		listContainsLongEQ180.add(longEQ180);
		segContainsLongEQ180 = new GPXtrkseg(listContainsLongEQ180); // length should be 90
		
		listContainsLongEQNeg180 = new ArrayList<GPXtrkpt>();
		listContainsLongEQNeg180.add(normalPt1);
		listContainsLongEQNeg180.add(longEQNeg180);
		segContainsLongEQNeg180 = new GPXtrkseg(listContainsLongEQNeg180); // length should be 90
		
		listContainsOnePoint = new ArrayList<GPXtrkpt>();
		listContainsOnePoint.add(normalPt1);
		segContainsOnePoint = new GPXtrkseg(listContainsOnePoint);

		listContainsNoPoint = new ArrayList<GPXtrkpt>();
		segContainsNoPoint = new GPXtrkseg(listContainsNoPoint);

		// GPXtrk objects

		segListNormal1 = new ArrayList<GPXtrkseg>();
		segListNormal1.add(segNormal1);
		normalTrk1 = new GPXtrk("Normal Trk 1", segListNormal1);

		segListNormal2 = new ArrayList<GPXtrkseg>();
		segListNormal2.add(segNormal1);
		segListNormal2.add(segNormal2);
		normalTrk2 = new GPXtrk("Normal Trk 2", segListNormal2);

		segListNormal3 = new ArrayList<GPXtrkseg>();
		segListNormal3.add(segNormal3);
		normalTrk3 = new GPXtrk("Normal Trk 3", segListNormal3);

		segListLatGT90 = new ArrayList<GPXtrkseg>();
		segListLatGT90.add(segContainsLatGT90);
		trkLatGT90 = new GPXtrk("Trk Lat > 90", segListLatGT90);

		segListLatLTNeg90 = new ArrayList<GPXtrkseg>();
		segListLatLTNeg90.add(segContainsLatLTNeg90);
		trkLatLTNeg90 = new GPXtrk("Trk Lat < -90", segListLatLTNeg90);

		segListLongGT180 = new ArrayList<GPXtrkseg>();
		segListLongGT180.add(segContainsLongGT180);
		trkLongGT180 = new GPXtrk("Trk Long > 180", segListLongGT180);

		segListLongLTNeg180 = new ArrayList<GPXtrkseg>();
		segListLongLTNeg180.add(segContainsLongLTNeg180);
		trkLongLTNeg180 = new GPXtrk("Trk Long < -180", segListLongLTNeg180);

		segListLatEQ90 = new ArrayList<GPXtrkseg>();
		segListLatEQ90.add(segContainsLatEQ90);
		trkLatEQ90 = new GPXtrk("Trk Lat == 90", segListLatEQ90);

		segListLatEQNeg90 = new ArrayList<GPXtrkseg>();
		segListLatEQNeg90.add(segContainsLatEQNeg90);
		trkLatEQNeg90 = new GPXtrk("Trk Lat == -90", segListLatEQNeg90);

		segListLongEQ180 = new ArrayList<GPXtrkseg>();
		segListLongEQ180.add(segContainsLongEQ180);
		trkLongEQ180 = new GPXtrk("Trk Long == 180", segListLongEQ180);

		segListLongEQNeg180 = new ArrayList<GPXtrkseg>();
		segListLongEQNeg180.add(segContainsLongEQNeg180);
		trkLongEQNeg180 = new GPXtrk("Trk Long == -180", segListLongEQNeg180);
		
		segListNullTrkpt = new ArrayList<GPXtrkseg>();
		segListNullTrkpt.add(segNormal1);
		segListNullTrkpt.add(segContainsNullPoint);
		segListNullTrkpt.add(segNormal2);
		trkNullTrkpt = new GPXtrk("null trkpt", segListNullTrkpt);

		segListOneNullTrkpt = new ArrayList<GPXtrkseg>();
		segListOneNullTrkpt.add(segNormal1);
		segListOneNullTrkpt.add(segContainsOneNullPoint);
		segListOneNullTrkpt.add(segNormal2);
		trkOneNullTrkpt = new GPXtrk("One null trkpt", segListOneNullTrkpt);

		segListOneTrkpt = new ArrayList<GPXtrkseg>();
		segListOneTrkpt.add(segNormal1);
		segListOneTrkpt.add(segContainsOnePoint);
		segListOneTrkpt.add(segNormal2);
		trkOneTrkpt = new GPXtrk("One trkpt", segListOneTrkpt);

		segListNoTrkpt = new ArrayList<GPXtrkseg>();
		segListNoTrkpt.add(segNormal1);
		segListNoTrkpt.add(segContainsNoPoint);
		segListNoTrkpt.add(segNormal2);
		trkNoTrkpt = new GPXtrk("No trkpt", segListNoTrkpt);

		segListNoTrkseg = new ArrayList<GPXtrkseg>();
		trkNoTrkseg = new GPXtrk("No trkseg", segListNoTrkseg);

		segListNullTrkseg = new ArrayList<GPXtrkseg>();
		segListNullTrkseg.add(segNormal1);
		segListNullTrkseg.add(nullSeg);
		segListNullTrkseg.add(segNormal2);
		trkNullTrkseg = new GPXtrk("Null trkseg", segListNullTrkseg);

		nullTrk = null;

		segListMultipleInvalid = new ArrayList<GPXtrkseg>();
		segListMultipleInvalid.add(segContainsNoPoint);
		segListMultipleInvalid.add(segContainsNullPoint);
		trkMultipleInvalid = new GPXtrk("Multiple invalid",
				segListMultipleInvalid);
	}

	@Test
	public void testNormal() {
		assertEquals(10, GPXcalculator.calculateDistanceTraveled(normalTrk1),
				delta);
		assertEquals(24, GPXcalculator.calculateDistanceTraveled(normalTrk2),
				delta);
		assertEquals(49, GPXcalculator.calculateDistanceTraveled(normalTrk3),
				delta);
	}

	@Test
	public void testJustInvalid() {
		assertEquals(0,
				GPXcalculator.calculateDistanceTraveled(trkJustInvalid), delta);
	}

	@Test
	public void testMultipleInvalid() {
		assertEquals(0, GPXcalculator
				.calculateDistanceTraveled(trkMultipleInvalid), delta);
	}

	@Test
	public void testLatGT90() {
		assertEquals(0, GPXcalculator.calculateDistanceTraveled(trkLatGT90),
				delta);
	}

	@Test
	public void testLatLTNeg90() {
		assertEquals(0, GPXcalculator.calculateDistanceTraveled(trkLatLTNeg90),
				delta);
	}

	@Test
	public void testLongGT180() {
		assertEquals(0, GPXcalculator.calculateDistanceTraveled(trkLongGT180),
				delta);
	}

	@Test
	public void testLongLTNeg180() {
		assertEquals(0, GPXcalculator
				.calculateDistanceTraveled(trkLongLTNeg180), delta);
	}
	
	@Test
	public void testLatEQ90() {
		assertEquals(90, GPXcalculator.calculateDistanceTraveled(trkLatEQ90),
				delta);
	}

	@Test
	public void testLatEQNeg90() {
		assertEquals(90, GPXcalculator.calculateDistanceTraveled(trkLatEQNeg90),
				delta);
	}

	@Test
	public void testLongEQ180() {
		assertEquals(180, GPXcalculator.calculateDistanceTraveled(trkLongEQ180),
				delta);
	}

	@Test
	public void testLongEQNeg180() {
		assertEquals(180, GPXcalculator
				.calculateDistanceTraveled(trkLongEQNeg180), delta);
	}

	@Test
	public void testNoTrkpt() {
		assertEquals(34, GPXcalculator.calculateDistanceTraveled(trkNoTrkpt),
				delta);
	}

	@Test
	public void testNoTrkseg() {
		assertEquals(-1, GPXcalculator.calculateDistanceTraveled(trkNoTrkseg),
				delta);
	}

	@Test
	public void testNullTrkpt() {
		assertEquals(34, GPXcalculator.calculateDistanceTraveled(trkNullTrkpt),
				delta);
	}

	@Test
	public void testNullTrkseg() {
		assertEquals(34,
				GPXcalculator.calculateDistanceTraveled(trkNullTrkseg), delta);
	}

	@Test
	public void testOneTrkpt() {
		assertEquals(34, GPXcalculator.calculateDistanceTraveled(trkOneTrkpt),
				delta);
	}

	@Test
	public void testOneNullTrkpt() {
		assertEquals(34, GPXcalculator
				.calculateDistanceTraveled(trkOneNullTrkpt), delta);
	}

	@Test
	public void testNullTrk() {
		assertEquals(-1, GPXcalculator.calculateDistanceTraveled(nullTrk),
				delta);
	}
}
