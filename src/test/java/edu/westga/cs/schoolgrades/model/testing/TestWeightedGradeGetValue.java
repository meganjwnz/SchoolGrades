package edu.westga.cs.schoolgrades.model.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.WeightedGrade;

class TestWeightedGradeGetValue {

	@Test
	void testGetValueOf100Worth20Percent() {
		SimpleGrade simpleGrade = new SimpleGrade(100);
		WeightedGrade grade = new WeightedGrade(simpleGrade, 0.2);
		assertEquals(20, grade.getValue());
	}

	@Test
	void testGetValue80Worth15Percent() {
		SimpleGrade simpleGrade = new SimpleGrade(80);
		WeightedGrade grade = new WeightedGrade(simpleGrade, 0.15);
		assertEquals(12, grade.getValue());
	}

}
