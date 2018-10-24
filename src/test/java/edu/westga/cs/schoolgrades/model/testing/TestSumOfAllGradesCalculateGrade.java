package edu.westga.cs.schoolgrades.model.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfAllGrades;

class TestSumOfAllGradesCalculateGrade {

	@Test
	void testSumOfTwoGrades() {
		SumOfAllGrades sum = new SumOfAllGrades();
		CompositeGrade grade = new CompositeGrade(sum);
		SimpleGrade s1 = new SimpleGrade(90.0);
		SimpleGrade s2 = new SimpleGrade(50.0);
		grade.addGrade(s1);
		grade.addGrade(s2);
		assertEquals(140, sum.calculateGrade(grade.getGrades()));
	}

	@Test
	void testSumOfFiveGrades() {
		SumOfAllGrades sum = new SumOfAllGrades();
		CompositeGrade grade = new CompositeGrade(sum);
		SimpleGrade s1 = new SimpleGrade(90.0);
		SimpleGrade s2 = new SimpleGrade(50.0);
		SimpleGrade s3 = new SimpleGrade(30.0);
		SimpleGrade s4 = new SimpleGrade(20.0);
		SimpleGrade s5 = new SimpleGrade(10.0);
		grade.addGrade(s1);
		grade.addGrade(s2);
		grade.addGrade(s3);
		grade.addGrade(s4);
		grade.addGrade(s5);
		assertEquals(200, sum.calculateGrade(grade.getGrades()));
	}

	@Test
	void testSumOfNoGrades() {
		SumOfAllGrades sum = new SumOfAllGrades();
		CompositeGrade grade = new CompositeGrade(sum);
		assertEquals(0, sum.calculateGrade(grade.getGrades()));
	}

	@Test
	void testSumOfGradesWithInvalidParam() {
		SumOfAllGrades sum = new SumOfAllGrades();
		CompositeGrade grade = new CompositeGrade(sum);
		assertThrows(IllegalArgumentException.class, () -> {
			sum.calculateGrade(null);
		});
	}
}
