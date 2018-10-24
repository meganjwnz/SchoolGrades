package edu.westga.cs.schoolgrades.model.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.GradeCalculatorStrategy;

class TestGradeCalculatorStrategyInterface {

	private class DummyGroup implements GradeCalculatorStrategy {
		@Override
		public double calculateGrade(List<Grade> grades) {
			return 0;
		}
	}

	@Test
	public void testGetValue0ShouldBeTrue() {
		DummyGroup dummy = new DummyGroup();
		assertEquals(0.0, dummy.calculateGrade(null));
	}
}
