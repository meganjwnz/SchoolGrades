package edu.westga.cs.schoolgrades.model;

/**
 * Sets up a simple grade object, who's grade value can be set and retrieved
 * 
 * @author Megan Brown
 * 
 */
public class SimpleGrade implements Grade {
	private double value;

	/**
	 * Constructor that sets the value of the grade
	 * 
	 * @param value Grade Value
	 */
	public SimpleGrade(double value) {
		if (value > 100 || value < 0) {
			throw new IllegalArgumentException("Grade value must be greater than 0 but less than 100.");
		}
		this.value = value;
	}

	@Override
	public double getValue() {
		return this.value;
	}
}
