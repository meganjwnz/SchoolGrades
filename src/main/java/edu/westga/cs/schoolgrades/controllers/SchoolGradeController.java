package edu.westga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.SimpleGrade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;
import javafx.util.StringConverter;

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
	
	public void initialize() {
		this.displayQuizGrades();
		this.displayHomeworkGrades();
		this.displayExamGrades();
	}
	
	/**
	 * Populates quizllistview with observable list of quizzes
	 */
	public void displayQuizGrades() {
		this.quizGrades.setItems(quizzes);
		this.quizGrades.setCellFactory(new GradeManager());
	}

	/**
	 * Populates homeworklistview with observable list of quizzes
	 */
	public void displayHomeworkGrades() {
		this.homeworkGrades.setItems(homeworks);
		this.homeworkGrades.setCellFactory(new GradeManager());
	}

	/**
	 * Populates examlistview with observable list of quizzes
	 */
	public void displayExamGrades() {
		this.examGrades.setItems(exams);
		this.examGrades.setCellFactory(new GradeManager());
	}
	
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
