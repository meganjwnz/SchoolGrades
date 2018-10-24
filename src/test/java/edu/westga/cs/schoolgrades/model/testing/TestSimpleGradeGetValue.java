package edu.westga.cs.schoolgrades.model.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.SimpleGrade;

class TestSimpleGradeGetValue {

	@Test
	void testGetValue0ShouldBe0() {
		SimpleGrade grade = new SimpleGrade(0);
		assertEquals(0, grade.getValue());
	}

	@Test
	void testGetValue50ShouldBe50() {
		SimpleGrade grade = new SimpleGrade(50);
		assertEquals(50, grade.getValue());
	}

	@Test
	void testGetValue100ShouldBe100() {
		SimpleGrade grade = new SimpleGrade(100);
		assertEquals(100, grade.getValue());
	}

}
