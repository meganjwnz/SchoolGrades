package edu.westga.cs.schoolgrades.model.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import edu.westga.cs.schoolgrades.model.Grade;

public class TestGradeInterface {

	private class DummyGroup implements Grade {
		@Override
		public double getValue() {
			return 0;
		}
	}

	@Test
	public void testGetValue0ShouldBeTrue() {
		DummyGroup dummy = new DummyGroup();
		assertEquals(0.0, dummy.getValue());
	}
}
