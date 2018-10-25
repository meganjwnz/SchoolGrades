package edu.westga.cs.schoolgrades.model.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.AverageOfAllGrades;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.DropLowestGrade;
import edu.westga.cs.schoolgrades.model.GradeCalculatorStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;

class TestDropLowestGradeCalculateGrade {

	@Test
	void testCalculateGrade() {
		GradeCalculatorStrategy gcs = new AverageOfAllGrades();
		DropLowestGrade lowestGrade = new DropLowestGrade(gcs);
		CompositeGrade grade = new CompositeGrade(lowestGrade);
		SimpleGrade s1 = new SimpleGrade(90.0);
		SimpleGrade s2 = new SimpleGrade(50.0);
		SimpleGrade s3 = new SimpleGrade(40.0);
		grade.addGrade(s1);
		grade.addGrade(s2);
		grade.addGrade(s3);
		assertEquals(70, lowestGrade.calculateGrade(grade.getGrades()));
	}

	@Test
	void testCalculateGradeWith10Grades() {
		GradeCalculatorStrategy gcs = new AverageOfAllGrades();
		DropLowestGrade lowestGrade = new DropLowestGrade(gcs);
		CompositeGrade grade = new CompositeGrade(lowestGrade);
		SimpleGrade s1 = new SimpleGrade(90.0);
		SimpleGrade s2 = new SimpleGrade(50.0);
		SimpleGrade s3 = new SimpleGrade(80.0);
		SimpleGrade s4 = new SimpleGrade(80.0);
		SimpleGrade s5 = new SimpleGrade(100.0);
		SimpleGrade s6 = new SimpleGrade(10.0);
		SimpleGrade s7 = new SimpleGrade(20.0);
		SimpleGrade s8 = new SimpleGrade(30.0);
		SimpleGrade s9 = new SimpleGrade(50.0);
		SimpleGrade s10 = new SimpleGrade(90.0);
		grade.addGrade(s1);
		grade.addGrade(s2);
		grade.addGrade(s3);
		grade.addGrade(s4);
		grade.addGrade(s5);
		grade.addGrade(s6);
		grade.addGrade(s7);
		grade.addGrade(s8);
		grade.addGrade(s9);
		grade.addGrade(s10);
		assertEquals(65.6, lowestGrade.calculateGrade(grade.getGrades()));
	}

	@Test
	void testCalculateGradeIfOnly1GradeIsAvailabe() {
		GradeCalculatorStrategy gcs = new AverageOfAllGrades();
		DropLowestGrade lowestGrade = new DropLowestGrade(gcs);
		CompositeGrade grade = new CompositeGrade(lowestGrade);
		SimpleGrade s1 = new SimpleGrade(90.0);
		grade.addGrade(s1);
		assertEquals(90, lowestGrade.calculateGrade(grade.getGrades()));
	}

	@Test
	void testCalculateGradeIfOnlyNoGradesAreAvailabe() {
		GradeCalculatorStrategy gcs = new AverageOfAllGrades();
		DropLowestGrade lowestGrade = new DropLowestGrade(gcs);
		CompositeGrade grade = new CompositeGrade(lowestGrade);
		assertEquals(0.0, lowestGrade.calculateGrade(grade.getGrades()));
	}

	@Test
	void testCalculateGradeWhenNull() {
		GradeCalculatorStrategy gcs = new AverageOfAllGrades();
		DropLowestGrade lowestGrade = new DropLowestGrade(gcs);
		assertThrows(IllegalArgumentException.class, () -> {
			lowestGrade.calculateGrade(null);
		});
	}
}
