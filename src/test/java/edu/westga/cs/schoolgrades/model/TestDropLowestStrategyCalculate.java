package edu.westga.cs.schoolgrades.model;



import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
public class TestDropLowestStrategyCalculate {

	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy childStrategy;
	
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	
	private List<Grade> grades;
	
	@BeforeEach
	public void setUp() throws Exception {
		mockGrade0 = mock(SimpleGrade.class);
		when(mockGrade0.getValue()).thenReturn(10.0);
		mockGrade1 = mock(SimpleGrade.class);
		when(mockGrade1.getValue()).thenReturn(20.0);
		mockGrade2 = mock(SimpleGrade.class);
		when(mockGrade2.getValue()).thenReturn(30.0);
		
		grades = new ArrayList<Grade>();
		
		childStrategy = mock(SumOfGradesStrategy.class);
		dropLowestStrategy = new DropLowestStrategy(childStrategy);
	}

	@Test
	public void shouldNotAllowNullGradesList() {
		when(childStrategy.calculate(null)).thenThrow(new IllegalArgumentException());
	}

	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		dropLowestStrategy.calculate(grades);
		verify(childStrategy).calculate(grades);
	}
	
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		grades.add(mockGrade0);
		dropLowestStrategy.calculate(grades);
		
		Grade lowest = grades.get(0);
		for (Grade grade: grades) {
			if (lowest.getValue() > grade.getValue()) {
				lowest = grade;
			}
		}
		List<Grade> mockList = new ArrayList<Grade>(grades);
		mockList.remove(lowest);
		
		verify(childStrategy).calculate(mockList);
	}
	
	@Test
	public void canDropWhenLowestIsFirst() {
		grades.add(mockGrade0);
		grades.add(mockGrade1);
		grades.add(mockGrade2);
		dropLowestStrategy.calculate(grades);
		
		Grade lowest = grades.get(0);
		for (Grade grade: grades) {
			if (lowest.getValue() > grade.getValue()) {
				lowest = grade;
			}
		}
		List<Grade> mockList = new ArrayList<Grade>(grades);
		mockList.remove(lowest);
		
		verify(childStrategy).calculate(mockList);
	}
	
	
	@Test
	public void canDropWhenLowestIsLast() {
		grades.add(mockGrade1);
		grades.add(mockGrade2);
		grades.add(mockGrade0);
		dropLowestStrategy.calculate(grades);
		
		Grade lowest = grades.get(0);
		for (Grade grade: grades) {
			if (lowest.getValue() > grade.getValue()) {
				lowest = grade;
			}
		}
		List<Grade> mockList = new ArrayList<Grade>(grades);
		mockList.remove(lowest);
		
		verify(childStrategy).calculate(mockList);
	}
	
	@Test
	public void canDropWhenLowestIsInMiddle() {
		grades.add(mockGrade1);
		grades.add(mockGrade0);
		grades.add(mockGrade2);
		dropLowestStrategy.calculate(grades);
		
		Grade lowest = grades.get(0);
		for (Grade grade: grades) {
			if (lowest.getValue() > grade.getValue()) {
				lowest = grade;
			}
		}
		List<Grade> mockList = new ArrayList<Grade>(grades);
		mockList.remove(lowest);
		
		verify(childStrategy).calculate(mockList);
	}
	
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		grades.add(mockGrade1);
		grades.add(mockGrade0);
		grades.add(mockGrade2);
		grades.add(mockGrade0);
		dropLowestStrategy.calculate(grades);
		
		Grade lowest = grades.get(0);
		for (Grade grade: grades) {
			if (lowest.getValue() > grade.getValue()) {
				lowest = grade;
			}
		}
		List<Grade> mockList = new ArrayList<Grade>(grades);
		mockList.remove(lowest);
		
		verify(childStrategy).calculate(mockList);
	}
}
