package edu.westga.cs.schoolgrades.model.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.SimpleGrade;

class TestSimpleGradeConstructor {

	@Test
	void testSimpleGradeCreationWith0() {
		SimpleGrade grade = new SimpleGrade(0);
		assertEquals(0, grade.getValue());
	}

	@Test
	void testSimpleGradeCreationWith100() {
		SimpleGrade grade = new SimpleGrade(100);
		assertEquals(100, grade.getValue());
	}

	@Test
	void testSetValueTo200ShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
			SimpleGrade grade = new SimpleGrade(200);
		});
	}

	@Test
	void testSetValueToNegative5ShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
			SimpleGrade grade = new SimpleGrade(-5);
		});
	}

}
