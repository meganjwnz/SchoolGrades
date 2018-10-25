package edu.westga.cs.schoolgrades.model.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.WeightedGrade;

class TestWeightedGradeConstructor {

	@Test
	void testCreateWeightedGradeWithNegativeWeight() {
		SimpleGrade simpleGrade = new SimpleGrade(100);
		assertThrows(IllegalArgumentException.class, () -> {
			WeightedGrade grade = new WeightedGrade(simpleGrade, -0.15);
		});
	}

	@Test
	void testCreateWeightedGradeWithWeightOver1() {
		SimpleGrade simpleGrade = new SimpleGrade(80);
		assertThrows(IllegalArgumentException.class, () -> {
			WeightedGrade grade = new WeightedGrade(simpleGrade, 5.0);
		});
	}

	@Test
	void testCreateWeightedGradeWithNoGradeObject() {
		SimpleGrade simpleGrade = new SimpleGrade(90);
		assertThrows(IllegalArgumentException.class, () -> {
			WeightedGrade grade = new WeightedGrade(null, 0.5);
		});
	}

}
