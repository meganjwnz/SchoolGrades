package edu.westga.cs.schoolgrades.model.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.GradeCalculatorStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfAllGrades;

class TestCompositeGradeAddGrade {

	@Test
	void testAddOneGrade() {
		GradeCalculatorStrategy gcs = new SumOfAllGrades();
		CompositeGrade compGrade = new CompositeGrade(gcs);
		SimpleGrade s1 = new SimpleGrade(90.0);
		compGrade.addGrade(s1);
		assertEquals(1, compGrade.getGrades().size());
	}

	@Test
	void testAddThreeGrades() {
		GradeCalculatorStrategy gcs = new SumOfAllGrades();
		CompositeGrade compGrade = new CompositeGrade(gcs);
		SimpleGrade s1 = new SimpleGrade(90.0);
		SimpleGrade s2 = new SimpleGrade(50.0);
		SimpleGrade s3 = new SimpleGrade(40.0);
		compGrade.addGrade(s1);
		compGrade.addGrade(s2);
		compGrade.addGrade(s3);
		assertEquals(3, compGrade.getGrades().size());
	}

	@Test
	void testAddFiveGrades() {
		GradeCalculatorStrategy gcs = new SumOfAllGrades();
		CompositeGrade compGrade = new CompositeGrade(gcs);
		SimpleGrade s1 = new SimpleGrade(80.0);
		SimpleGrade s2 = new SimpleGrade(60.0);
		SimpleGrade s3 = new SimpleGrade(50.0);
		SimpleGrade s4 = new SimpleGrade(70.0);
		SimpleGrade s5 = new SimpleGrade(10.0);
		compGrade.addGrade(s1);
		compGrade.addGrade(s2);
		compGrade.addGrade(s3);
		compGrade.addGrade(s4);
		compGrade.addGrade(s5);
		assertEquals(5, compGrade.getGrades().size());
	}
	
	@Test
	void testAddNull() {
		GradeCalculatorStrategy gcs = new SumOfAllGrades();
		CompositeGrade compGrade = new CompositeGrade(gcs);
		assertThrows(IllegalArgumentException.class, () -> {
			compGrade.addGrade(null);
		});
	}
}
