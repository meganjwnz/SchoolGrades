package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * Takes all the grades of a list and adds them together
 * @author Megan Brown
 *
 */
public class SumOfAllGrades implements GradeCalculatorStrategy {

	@Override
	public double calculateGrade(List<Grade> grades) {
		if (grades == null) {
			throw new IllegalArgumentException("There must be grades to calculate");
		}
		double sumOfGrades = 0.0;
		for (Grade grade : grades) {
			sumOfGrades += grade.getValue();
		}
		return sumOfGrades;
	}

}
