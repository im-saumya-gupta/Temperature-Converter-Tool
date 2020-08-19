package com.internshala.javafxapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	@FXML
	public Label welcomeLabel;
	@FXML
	public ChoiceBox<String> choiceBox;
	@FXML
	public TextField userInputField;
	@FXML
	public Button convertButton;
	private static final String C_TO_F_TEXT="Celsius to Fahrenheit";
	private static final String F_TO_C_TEXT="Fahrenheit to Celsius";
	private boolean is_C_TO_F = true;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choiceBox.getItems().add(C_TO_F_TEXT);
		choiceBox.getItems().add(F_TO_C_TEXT);
		choiceBox.setValue(C_TO_F_TEXT);
		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.equals(C_TO_F_TEXT)){//if user has selected "celsius to fahrenheit"
				is_C_TO_F = true;
			}else {	//else user has selected fahrenheit to celsius
				is_C_TO_F = false;
			}
		});
		convertButton.setOnAction(event -> {
			convert();
		});
	}
	private void convert() {
		String input = userInputField.getText();      //23.4-->"23.4"
		float enteredTemperature = 0.0f;
		try{
			 enteredTemperature = Float.parseFloat(input);     //"23.4"-->23.4f
		}catch (Exception ex){
			warnUser();
			return;//no code executed
		}
		float newTemperature = 0.0f;
		if(is_C_TO_F){                                     //if user selected celsiuses to fahrenheit
			newTemperature = (enteredTemperature * 9/5)+32;
		}else {
			newTemperature = (enteredTemperature - 32)*5/9;     //else user selected fahrenheit to celsiuses
		}
		display(newTemperature);
	}
	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please enter valid temperature");
		alert.show();
	}
	private void display(float newTemperature) {
		String unit = is_C_TO_F?"F":"C";
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The Temperature is: "+newTemperature+" "+unit);
		alert.show();
	}
}
