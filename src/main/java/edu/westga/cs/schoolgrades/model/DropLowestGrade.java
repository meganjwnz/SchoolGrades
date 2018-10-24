package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * Takes all the grades and drops the lowest value grade from the list
 * 
 * @author Megan Brown
 *
 */
public class DropLowestGrade implements GradeCalculatorStrategy {
	private GradeCalculatorStrategy gradeCalculatorStrategy;

	/**
	 * Constructor to initalize gradeCalculatorStrategy
	 * 
	 * @param gradeCalculatorStrategy GradeCalculatorStrategy to be used
	 */
	public DropLowestGrade(GradeCalculatorStrategy gradeCalculatorStrategy) {
		if (gradeCalculatorStrategy == null) {
			throw new IllegalArgumentException("GradeCalculator must not be null");
		}
		this.gradeCalculatorStrategy = gradeCalculatorStrategy;
	}
	
	@Override
	public double calculateGrade(List<Grade> grades) {
		// TODO Auto-generated method stub
		return 0;
	}

}
