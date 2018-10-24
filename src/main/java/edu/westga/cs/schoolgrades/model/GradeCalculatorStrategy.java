package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * GradeCalculatorStrategy to enforce calculations
 * 
 * @author Megan Brown
 *
 */
public interface GradeCalculatorStrategy {

	public double calculateGrade(List<Grade> grades);
}
