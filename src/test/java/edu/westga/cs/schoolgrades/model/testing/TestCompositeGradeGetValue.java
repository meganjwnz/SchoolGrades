package edu.westga.cs.schoolgrades.model.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.AverageOfAllGrades;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.DropLowestGrade;
import edu.westga.cs.schoolgrades.model.GradeCalculatorStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfAllGrades;

class TestCompositeGradeGetValue {
	
	@Test
	void testGetValueWithOf3GradesUsingSumOfAllGrades() {
		GradeCalculatorStrategy gcs = new SumOfAllGrades();
		CompositeGrade compGrade = new CompositeGrade(gcs);
		SimpleGrade s1 = new SimpleGrade(90.0);
		SimpleGrade s2 = new SimpleGrade(50.0);
		SimpleGrade s3 = new SimpleGrade(40.0);
		compGrade.addGrade(s1);
		compGrade.addGrade(s2);
		compGrade.addGrade(s3);
		assertEquals(180, compGrade.getValue());
	}

	@Test
	void testGetValueWithOfNoGrades() {
		GradeCalculatorStrategy gcs = new SumOfAllGrades();
		CompositeGrade compGrade = new CompositeGrade(gcs);
		assertEquals(0, compGrade.getValue());
	}
	
	@Test
	void testGetValueWithOf3GradesUsingAverageOfAllGrades() {
		GradeCalculatorStrategy gcs = new AverageOfAllGrades();
		CompositeGrade compGrade = new CompositeGrade(gcs);
		SimpleGrade s1 = new SimpleGrade(90.0);
		SimpleGrade s2 = new SimpleGrade(50.0);
		SimpleGrade s3 = new SimpleGrade(40.0);
		compGrade.addGrade(s1);
		compGrade.addGrade(s2);
		compGrade.addGrade(s3);
		assertEquals(60, compGrade.getValue());
	}

	@Test
	void testGetValueWithOfNoGradesUsingAverageOfAllGrades() {
		GradeCalculatorStrategy gcs = new AverageOfAllGrades();
		CompositeGrade compGrade = new CompositeGrade(gcs);
		assertEquals(0.0, compGrade.getValue());
	}
	
	@Test
	void testGetValueWithOf3GradesUsingDropLowestGrade() {
		GradeCalculatorStrategy averageCalc = new AverageOfAllGrades();
		GradeCalculatorStrategy gcs = new DropLowestGrade(averageCalc);
		CompositeGrade compGrade = new CompositeGrade(gcs);
		SimpleGrade s1 = new SimpleGrade(80.0);
		SimpleGrade s2 = new SimpleGrade(70.0);
		SimpleGrade s3 = new SimpleGrade(30.0);
		compGrade.addGrade(s1);
		compGrade.addGrade(s2);
		compGrade.addGrade(s3);
		assertEquals(75, compGrade.getValue());
	}

	@Test
	void testGetValueWithOfNoGradesUsingDropLowestGrade() {
		GradeCalculatorStrategy averageCalc = new AverageOfAllGrades();
		GradeCalculatorStrategy gcs = new DropLowestGrade(averageCalc);
		CompositeGrade compGrade = new CompositeGrade(gcs);
		assertEquals(0.0, compGrade.getValue());
	}

}
