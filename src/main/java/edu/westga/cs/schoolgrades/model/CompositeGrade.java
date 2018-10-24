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
	
	/**
	 * Adds grade to arraylist
	 * @param grade Grade to be added
	 */
	public void addGrade(Grade grade) {
		if (grade == null) {
			throw new IllegalArgumentException ("Grade must not be null");
		}
		this.grades.add(grade);
	}
	
	/**
	 * Lists all the grades in the arrayList
	 * @return
	 */
	public List<Grade> getGrades() {
		return this.grades;
	}
	
	/**
	 * Removes grade from arraylist
	 * @param grade Grade to be removed
	 */
	public void removeGrade(Grade grade) {
		if (grade == null) {
			throw new IllegalArgumentException ("Grade must not be null");
		}
		this.grades.remove(grade);
	}

}
