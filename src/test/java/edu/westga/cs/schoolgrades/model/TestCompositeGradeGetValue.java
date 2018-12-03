package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCompositeGradeGetValue {

	private SimpleGrade mockGrade1;
	private SimpleGrade mockGrade2;
	private SimpleGrade mockGrade3;
	private SumOfGradesStrategy mockSumGrade;
	
	@BeforeEach
	public void setup() {
		mockGrade1 = mock(SimpleGrade.class);
		when(mockGrade1.getValue()).thenReturn(30.00);
		mockGrade2 = mock(SimpleGrade.class);
		when(mockGrade2.getValue()).thenReturn(20.00);
		mockGrade3 = mock(SimpleGrade.class);
		when(mockGrade3.getValue()).thenReturn(10.00);
	}
	
	
	@Test
	void shouldGetValue() {
		CompositeGrade composite = new CompositeGrade(new SumOfGradesStrategy());
		composite.add(mockGrade1);
		composite.add(mockGrade2);
		composite.add(mockGrade3);
		assertEquals(60, composite.getValue(), 0.01);
	}

}
