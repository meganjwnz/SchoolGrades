package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Joins all the grades together in an arraylist 
 * @author Megan Brown
 *
 */
public class CompositeGrade implements Grade {
	private List<Grade> grades;
	private GradeCalculatorStrategy gcs;
	
	/**
	 * Constructor to initialize GradeCalculatorStrategy and Grade ArrayList
	 * @param gcs
	 */
	public CompositeGrade(GradeCalculatorStrategy gcs) {
		if (gcs == null) {
			throw new IllegalArgumentException ("GradeCalculatorStrategy must not be null");
		}
		this.grades = new ArrayList<Grade>();
		this.gcs = gcs;
	}
	
	@Override
	public double getValue() {
		return this.gcs.calculateGrade(this.grades);
	}

}
