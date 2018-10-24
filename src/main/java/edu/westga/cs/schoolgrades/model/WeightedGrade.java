package edu.westga.cs.schoolgrades.model;

/**
 * Compares the grade to the percentage of the total grade
 * 
 * @author Megan Brown
 *
 */
public class WeightedGrade implements Grade {
	private Grade grade;
	private double weight;

	/**
	 * Constructor to initialize grade and weight
	 * 
	 * @param grade  Grade Object
	 * @param weight Percentage of grade
	 * @precondition : weight must be > 0 && < 1; grade must not be null
	 */
	public WeightedGrade(Grade grade, double weight) {
		if (weight < 0 || weight > 1) {
			throw new IllegalArgumentException("Weight percentage must be between 0 and 1, inclusive.");
		}
		if (grade == null) {
			throw new IllegalArgumentException("Grade must not be null.");
		}
		this.grade = grade;
		this.weight = weight;
	}

	@Override
	public double getValue() {
		return this.grade.getValue() * this.weight;
	}

}
