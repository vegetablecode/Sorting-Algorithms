package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class MainController {
	
	@FXML
	private TextField numbOfElementsTextField;
	
	@FXML
	void initialize() {
		//numbOfElementsTextField.setText("KEK");
	}
	
	@FXML
	public void loadArrayAction() {
		System.out.println("siema");
		numbOfElementsTextField.setText("KEK");
	}

}
