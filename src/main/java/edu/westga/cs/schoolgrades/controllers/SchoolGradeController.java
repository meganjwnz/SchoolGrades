package edu.westga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.AverageOfAllGrades;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.GradeCalculatorStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfAllGrades;
import edu.westga.cs.schoolgrades.model.WeightedGrade;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class SchoolGradeController {
	
	@FXML
	private TextField quizzesSubtotal;

	@FXML
	private TextField homeworksSubtotal;

	@FXML
	private TextField examsSubtotal;

	@FXML
	private TextField finalGradeTotal;

	@FXML
	private ListView<SimpleGrade> quizGrades;

	@FXML
	private ListView<SimpleGrade> homeworkGrades;

	@FXML
	private ListView<SimpleGrade> examGrades;

	@FXML
	private Button recalculate;
	
	private ObservableList<SimpleGrade> quizzes;
	private ObservableList<SimpleGrade> homeworks;
	private ObservableList<SimpleGrade> exams;
	
	private DoubleProperty qsubtotal;
	private DoubleProperty hsubtotal;
	private DoubleProperty esubtotal;
	private DoubleProperty finalGradeResult;
	
	/**
	 * Initalizes instance variables
	 */
	public SchoolGradeController() {
		this.quizzes = FXCollections.observableArrayList();
		this.homeworks = FXCollections.observableArrayList();
		this.exams = FXCollections.observableArrayList();
		
		this.qsubtotal = new SimpleDoubleProperty();
		this.hsubtotal = new SimpleDoubleProperty();
		this.esubtotal = new SimpleDoubleProperty();
		this.finalGradeResult = new SimpleDoubleProperty();
	}
	
	public void initialize() {
		this.displayQuizGrades();
		this.displayHomeworkGrades();
		this.displayExamGrades();
	}
	
	/**
	 * Populates quizGrades with observable list of quizzes
	 */
	public void displayQuizGrades() {
		this.quizGrades.setItems(quizzes);
		this.quizGrades.setCellFactory(new GradeManager());
	}

	/**
	 * Populates homeworkGrades with observable list of quizzes
	 */
	public void displayHomeworkGrades() {
		this.homeworkGrades.setItems(homeworks);
		this.homeworkGrades.setCellFactory(new GradeManager());
	}

	/**
	 * Populates examGrades with observable list of quizzes
	 */
	public void displayExamGrades() {
		this.examGrades.setItems(exams);
		this.examGrades.setCellFactory(new GradeManager());
	}
	
	/**
	 * binds the quiz subtotal text
	 */
	public void quizBinding() {
		this.quizzesSubtotal.textProperty().bindBidirectional(this.qsubtotal, new NumberStringConverter());
		this.quizzesSubtotal.setEditable(false);
	}

	/**
	 * binds the homework subtotal text
	 */
	public void homeworkBinding() {
		this.homeworksSubtotal.textProperty().bindBidirectional(this.hsubtotal,
				new NumberStringConverter());
		this.homeworksSubtotal.setEditable(false);
	}

	/**
	 * Binds the exam subtotal text
	 */
	public void examBinding() {
		this.examsSubtotal.textProperty().bindBidirectional(this.esubtotal, new NumberStringConverter());
		this.examsSubtotal.setEditable(false);
	}
	
	/**
	 * Binds the find grade text
	 */
	public void finalGradeTextFieldBinding() {
		this.finalGradeTotal.textProperty().bindBidirectional(this.finalGradeResult, new NumberStringConverter());
		this.finalGradeTotal.setEditable(false);
	}
	
	/*
	 * *****----------Calculations----------*****
	 */
	
	/**
	 * Calculates the sum of all quizzes
	 * 
	 * @return Calculation of Quiz Subtotal
	 */
	public Grade calculateQuizTotal() {
		SumOfAllGrades sumOfQuizzes = new SumOfAllGrades();
		CompositeGrade quizGrades = new CompositeGrade(sumOfQuizzes);
		for(Grade grade : this.quizzes) {
			quizGrades.addGrade(grade);
		}
		this.qsubtotal.set(quizGrades.getValue());
		return quizGrades;
	}
	
	/**
	 * Calculates the average of all homeworks
	 * 
	 * @return Calculation of Homework Subtotal
	 */
	public Grade calculateHomeworkTotal() {
		GradeCalculatorStrategy averageOfHomeworks = new AverageOfAllGrades();
		CompositeGrade homeworkGrades = new CompositeGrade(averageOfHomeworks);
		for(Grade grade : this.homeworks) {
			homeworkGrades.addGrade(grade);
		}
		this.hsubtotal.set(homeworkGrades.getValue());
		return homeworkGrades;
	}
	
	/**
	 * Calculates the average of all exams
	 * 
	 * @return Calculation of Exam Subtotal
	 */
	public Grade calculateExamTotal() {
		AverageOfAllGrades averageOfExams = new AverageOfAllGrades();
		CompositeGrade examGrades = new CompositeGrade(averageOfExams);
		for(Grade grade : this.exams) {
			examGrades.addGrade(grade);
		}
		this.esubtotal.set(examGrades.getValue());
		return examGrades;
	}
	
	/**
	 * Calculates the final grade
	 * 
	 * @return Calculation of Final Grade
	 */
	public Grade calculateFinalGrade() {
		WeightedGrade quizzes = new WeightedGrade(this.calculateQuizTotal(), 0.2);
		WeightedGrade homeworks = new WeightedGrade(this.calculateHomeworkTotal(), 0.3);
		WeightedGrade exams = new WeightedGrade(this.calculateExamTotal(), 0.5);
		CompositeGrade finalGrade = new CompositeGrade(new SumOfAllGrades());
		finalGrade.addGrade(quizzes);
		finalGrade.addGrade(homeworks);
		finalGrade.addGrade(exams);
		this.finalGradeResult.set(finalGrade.getValue());
		return finalGrade;
	}
	
	/*
	 * Menu Items
	 */
	
	/**
	 * Adds new quiz
	 * 
	 * @param event
	 */
	public void addQuiz(ActionEvent event) {
		this.quizzes.add(new SimpleGrade(0.0));
	}

	/**
	 * Adds new homework
	 * 
	 * @param event
	 */
	public void addHomework(ActionEvent event) {
		this.homeworks.add(new SimpleGrade(0.0));
	}

	/**
	 * Adds new exam
	 * 
	 * @param event
	 */
	public void addExam(ActionEvent event) {
		this.exams.add(new SimpleGrade(0.0));
	}

	
	/*
	 * **---------------------- Helper Class ---------------- **
	 */
	
	/**
	 * Manages the cell factory of the grades. Converts grades into string so that
	 * they can be displayed in the list pane. Based of Babble cell factory
	 * 
	 * @author Megan Brown
	 *
	 */
	private class GradeManager implements Callback<ListView<SimpleGrade>, ListCell<SimpleGrade>> {
		public ListCell<SimpleGrade> call(ListView<SimpleGrade> listView) {
			TextFieldListCell<SimpleGrade> cellFactory = new TextFieldListCell<>();
			cellFactory.setConverter(new StringConverter<SimpleGrade>() {
				@Override
				public String toString(final SimpleGrade grade) {
					final String gradeResult = grade.getValue() + "";
					cellFactory.setAccessibleText(gradeResult);
					return gradeResult;
				}

				@Override
				public SimpleGrade fromString(final String string) {
					return null;
				}
			});
			return cellFactory;
		}
	}
}
