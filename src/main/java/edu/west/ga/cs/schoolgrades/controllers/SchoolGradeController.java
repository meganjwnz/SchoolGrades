package edu.west.ga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.SimpleGrade;
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
}
