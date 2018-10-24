package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * Takes the sum of all the grades and averages them
 * @author Megan Brown
 *
 */
public class AverageOfAllGrades implements GradeCalculatorStrategy {

	@Override
	public double calculateGrade(List<Grade> grades) {
		if (grades.size() == 0) {
			return 0.0;
		}
		GradeCalculatorStrategy sumOfAllGrades = new SumOfAllGrades();
		return Math.round((sumOfAllGrades.calculateGrade(grades) / grades.size()) * 10.0) / 10.0;
	}

}
