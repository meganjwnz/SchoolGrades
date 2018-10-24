package edu.westga.cs.schoolgrades.model.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.AverageOfAllGrades;
import edu.westga.cs.schoolgrades.model.DropLowestGrade;
import edu.westga.cs.schoolgrades.model.GradeCalculatorStrategy;

class TestDropLowestGradeConstructor {

	@Test
	void testDropLowestGradeWhenNull() {
		GradeCalculatorStrategy gcs = new AverageOfAllGrades();
		assertThrows(IllegalArgumentException.class, () -> {
			DropLowestGrade lowestGrade = new DropLowestGrade(null);
		});
	}

}
