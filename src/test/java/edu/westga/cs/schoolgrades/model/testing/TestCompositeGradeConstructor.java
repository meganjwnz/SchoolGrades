package edu.westga.cs.schoolgrades.model.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.CompositeGrade;

class TestCompositeGradeConstructor {
	
	@Test
	void testCompositeGrade() {
		assertThrows(IllegalArgumentException.class, () -> {
			CompositeGrade compGrade = new CompositeGrade(null);
		});
	}
}
