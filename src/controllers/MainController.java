package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class MainController {
	
	@FXML
	private TextField numbOfElemField;
	@FXML
	private TextField sortedItemsPercentField;
	@FXML
	private TextField maxRandNumbField;
	@FXML
	private CheckBox highToLowCheckbox;
	@FXML
	private Label numbOfElemLabel;
	@FXML
	private Label sortedItemsPercentLabel;
	@FXML
	private Label maxRandNumbLabel;
	@FXML
	private Label hiwhToLowLabel;
	@FXML
	private Label mergeTimerLabel;
	@FXML
	private Label quickTimerLabel;
	@FXML
	private Label introTimerLabel;
	@FXML
	private TextArea sortedTextArea;
	@FXML
	private TextArea unsortedTextArea;
	
	
	@FXML
	void initialize() {
		// nothing
	}
	
	@FXML
	public void loadArray() {
		System.out.println("loadArray");
	}
	
	@FXML
	public void sortArray() {
		System.out.println("sortArray");
	}

}
