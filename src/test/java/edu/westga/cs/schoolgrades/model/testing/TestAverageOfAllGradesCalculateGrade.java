package edu.westga.cs.schoolgrades.model.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.AverageOfAllGrades;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;

class TestAverageOfAllGradesCalculateGrade {

	@Test
	void testCalculateGradeWithTwoGrades() {
		AverageOfAllGrades average = new AverageOfAllGrades();
		CompositeGrade grade = new CompositeGrade(average);
		SimpleGrade s1 = new SimpleGrade(90.0);
		SimpleGrade s2 = new SimpleGrade(50.0);
		grade.addGrade(s1);
		grade.addGrade(s2);
		assertEquals(70, average.calculateGrade(grade.getGrades()));
	}

	@Test
	void testCalculateGradeWithFiveGrades() {
		AverageOfAllGrades average = new AverageOfAllGrades();
		CompositeGrade grade = new CompositeGrade(average);
		SimpleGrade s1 = new SimpleGrade(90.0);
		SimpleGrade s2 = new SimpleGrade(50.0);
		SimpleGrade s3 = new SimpleGrade(40.0);
		SimpleGrade s4 = new SimpleGrade(20.0);
		SimpleGrade s5 = new SimpleGrade(10.0);
		grade.addGrade(s1);
		grade.addGrade(s2);
		grade.addGrade(s3);
		grade.addGrade(s4);
		grade.addGrade(s5);
		assertEquals(42, average.calculateGrade(grade.getGrades()));
	}

	@Test
	void testCalculateGradeWithNoGrades() {
		AverageOfAllGrades average = new AverageOfAllGrades();
		CompositeGrade grade = new CompositeGrade(average);
		assertEquals(0.0, average.calculateGrade(grade.getGrades()));
	}
}
