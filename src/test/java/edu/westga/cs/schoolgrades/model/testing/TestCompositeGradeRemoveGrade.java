package edu.westga.cs.schoolgrades.model.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.GradeCalculatorStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfAllGrades;

class TestCompositeGradeRemoveGrade {

	@Test
	void testRemoveOneGrade() {
		GradeCalculatorStrategy gcs = new SumOfAllGrades();
		CompositeGrade compGrade = new CompositeGrade(gcs);
		SimpleGrade s1 = new SimpleGrade(90.0);
		compGrade.addGrade(s1);
		compGrade.removeGrade(s1);
		assertEquals(0, compGrade.getGrades().size());
	}

	@Test
	void testRemoveTwoGrades() {
		GradeCalculatorStrategy gcs = new SumOfAllGrades();
		CompositeGrade compGrade = new CompositeGrade(gcs);
		SimpleGrade s1 = new SimpleGrade(90.0);
		SimpleGrade s2 = new SimpleGrade(50.0);
		SimpleGrade s3 = new SimpleGrade(40.0);
		compGrade.addGrade(s1);
		compGrade.addGrade(s2);
		compGrade.addGrade(s3);
		compGrade.removeGrade(s1);
		compGrade.removeGrade(s3);
		assertEquals(1, compGrade.getGrades().size());
	}

	@Test
	void testRemoveNull() {
		GradeCalculatorStrategy gcs = new SumOfAllGrades();
		CompositeGrade compGrade = new CompositeGrade(gcs);
		assertThrows(IllegalArgumentException.class, () -> {
			compGrade.removeGrade(null);
		});
	}
}
