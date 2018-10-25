package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
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
		if (grades == null) {
			throw new IllegalArgumentException("Grades must not be null");
		}
		if (grades.size() < 2) {
			return gradeCalculatorStrategy.calculateGrade(grades);
		}
		Grade lowestGrade = grades.get(0);
		for (Grade grade : grades) {
			if (grade.getValue() < lowestGrade.getValue()) {
				lowestGrade = grade;
			}
		}
		List<Grade> newList = new ArrayList<Grade>(grades);
		newList.remove(lowestGrade);

		return gradeCalculatorStrategy.calculateGrade(newList);
	}

}
