package edu.west.ga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.SimpleGrade;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
	
	/**
	 * Initalizes instance variables
	 */
	public SchoolGradeController() {
		this.quizzes = FXCollections.observableArrayList();
		this.homeworks = FXCollections.observableArrayList();
		this.exams = FXCollections.observableArrayList();
	}
}
