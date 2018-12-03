package edu.westga.cs.schoolgrades.model;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
public class TestCompositeGradeAddAll {

	private CompositeGrade composite;
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	private List<Grade> list;
	
	@BeforeEach
	public void setup() {
		composite = new CompositeGrade(mock(GradeCalculationStrategy.class));
		mockGrade0 = mock(SimpleGrade.class);
		mockGrade1 = mock(SimpleGrade.class);
		mockGrade2 = mock(SimpleGrade.class);
		list = new ArrayList<Grade>();
	}
	

	@Test
	public void shouldNotAddNullGradesList() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			composite.addAll(null);
		});
	}
	
	@Test
	public void shouldAddEmptyList() {
		composite.addAll(new ArrayList<Grade>());
		assertTrue(composite.getGrades().isEmpty());
	}
	
	@Test
	public void shouldAddOneElementList() {
		list.add(mockGrade0);
		composite.addAll(list);
		List<Grade> actual = composite.getGrades();
		assertEquals(1, actual.size());
		assertEquals(mockGrade0, actual.get(0));
	}
	
	@Test
	public void shouldAddManyElementsList() {
		list.add(mockGrade0);
		list.add(mockGrade1);
		list.add(mockGrade2);
		composite.addAll(list);
		List<Grade> actual = composite.getGrades();
		assertEquals(3, actual.size());
		assertEquals(mockGrade0, actual.get(0));
		assertEquals(mockGrade1, actual.get(1));
		assertEquals(mockGrade2, actual.get(2));
	}

	@Test
	public void shouldNotAddListWithDuplicates() {
		list.add(mockGrade0);
		list.add(mockGrade1);
		list.add(mockGrade0);
		list.add(mockGrade2);
		
		assertThrows(IllegalArgumentException.class, () ->{ 
			composite.addAll(list);
		});
	}
	
	@Test
	public void shouldNotAddListThatDuplicatesExistingGrades() {
		composite.add(mockGrade1);
		list.add(mockGrade1);
		list.add(mockGrade0);
		list.add(mockGrade2);
		
		assertThrows(IllegalArgumentException.class, () ->{ 
			composite.addAll(list);
		});
	}
}
