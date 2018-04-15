package controllers;

import algorithms.Intro;
import algorithms.Merge;
import algorithms.Quick;
import data.ArrayUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MainController {

	// - model values -
	private int numbOfElements;
	private double sortedItemsPercent;
	private int maxRandNumb;
	private Boolean highToLow;
	private double mergeTimer;
	private double quickTimer;
	private double introTimer;
	private int[] mergeArray;
	private int[] quickArray;
	private int[] introArray;
	
	// - util values -
	private Boolean isArrayLoaded;

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
	private Label highToLowLabel;
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
		// set default values
		numbOfElements = 0;
		sortedItemsPercent = 0;
		maxRandNumb = 0;
		highToLow = false;
		mergeTimer = 0;
		quickTimer = 0;
		introTimer = 0;
		isArrayLoaded = false;

		// view setup
		clearFields();
		setLabels();
	}

	@FXML
	public void loadArray() {
		
		Boolean isGood = true;

		// get number of elements
		int tempSize = 0;
		if (numbOfElemField.getText().isEmpty()) {
			showMessage("Cannot add the node. There is no value entered.");
			isGood = false;
		} else {
			try {
				tempSize = Integer.parseInt(numbOfElemField.getText());
				numbOfElements = tempSize;
			} catch (NumberFormatException e) {
				showMessage("The value should be a type of integer!");
				isGood = false;
			}
		}

		// get percentage of sorted items
		double tempPercent = 0;
		if (sortedItemsPercentField.getText().isEmpty()) {
			showMessage("Cannot add the node. There is no value entered.");
			isGood = false;
		} else {
			try {
				tempPercent = Double.parseDouble(sortedItemsPercentField.getText());
				sortedItemsPercent = tempPercent;
			} catch (NumberFormatException e) {
				showMessage("The value should be a type of double!");
				isGood = false;
			}
		}
		
		// get max random number
		int tempMax = 0;
		if (maxRandNumbField.getText().isEmpty()) {
			maxRandNumb = 500000000;
		} else {
			try {
				tempMax = Integer.parseInt(maxRandNumbField.getText());
				maxRandNumb = tempMax;
			} catch (NumberFormatException e) {
				showMessage("The value should be a type of integer!");
				isGood = false;
			}
		}
		
		// get high to low checkbox
		if(highToLowCheckbox.isSelected()==true)
			highToLow = true;
		else highToLow = false;
		
		// set arrays
		if(isGood == true) {
			mergeArray = ArrayUtil.fillArray(numbOfElements, sortedItemsPercent, highToLow, maxRandNumb);
			quickArray = new int[numbOfElements];
			introArray = new int[numbOfElements];
			System.arraycopy(mergeArray, 0, quickArray, 0, mergeArray.length);
			System.arraycopy(mergeArray, 0, introArray, 0, mergeArray.length);
			
			// display loaded array
			unsortedTextArea.setText(ArrayUtil.arrayToString(mergeArray));
			setLabels();
			isArrayLoaded = true;
		}
	}

	@FXML
	public void sortArray() {
		if(isArrayLoaded == true) {
			long[] startTime = new long[3];
			long[] finishTime = new long[3];
			
			// merge sort
			startTime[0] = System.nanoTime();
			Merge.sort(mergeArray);
			finishTime[0] = System.nanoTime();
			mergeTimer = (finishTime[0] - startTime[0])/1000000;
			
			// quick sort
			startTime[1] = System.nanoTime();
			Quick.sort(quickArray);
			finishTime[1] = System.nanoTime();
			quickTimer = (finishTime[1] - startTime[1])/1000000;
			sortedTextArea.setText(ArrayUtil.arrayToString(quickArray));		
			// intro sort
			startTime[2] = System.nanoTime();
			Intro.sort(introArray);
			finishTime[2] = System.nanoTime();
			introTimer = (finishTime[2] - startTime[2])/1000000;
			
			
			displayTime();
		}
	}

	// - set all labels -
	private void setLabels() {
		numbOfElemLabel.setText(Integer.toString(numbOfElements));
		sortedItemsPercentLabel.setText(Double.toString(sortedItemsPercent));
		maxRandNumbLabel.setText(Integer.toString(maxRandNumb));
		mergeTimerLabel.setText(Double.toString(mergeTimer));
		quickTimerLabel.setText(Double.toString(quickTimer));
		introTimerLabel.setText(Double.toString(introTimer));
		if (highToLow == true) {
			highToLowLabel.setText("yes");
		} else
			highToLowLabel.setText("no");
	}
	
	// - display time -
	private void displayTime() {
		mergeTimerLabel.setText(String.valueOf(mergeTimer));
		introTimerLabel.setText(String.valueOf(introTimer));
		quickTimerLabel.setText(String.valueOf(quickTimer));
	}

	// - clear fields -
	private void clearFields() {
		numbOfElemField.setText("");
		maxRandNumbField.setText("");
		sortedItemsPercentField.setText("");
		numbOfElemField.setText("");
		highToLowCheckbox.setSelected(false);
	}

	// - show error message -
	public void showMessage(String message) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning Message");
		alert.setHeaderText("Warning message");
		alert.setContentText(message);
		alert.showAndWait();
	}

}
