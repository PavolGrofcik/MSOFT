package view;

import java.io.IOException;

import application.Main;
import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ApplyAppController {
	
	private static final String WARNING = "Some fields are empty!";
	private static final String STATUS = "Application has been sent!";

	@FXML
	private Label info;
	@FXML
	private Button revoke;
	@FXML
	private Button apply;
	@FXML 
	private TextField username;
	@FXML 
	private TextField surname;
	@FXML 
	private TextField company;
	@FXML
	private TextArea description;
	
	
	@FXML
	public void cancelApplication() throws IOException {
		Main.showNewStage("../view/Dashboard.fxml");
	}
	
	@FXML
	public void sendApplication() {
		
		if(checkInputData()) {
			Controller.createApplication(username.getText(), surname.getText(),
					company.getText(), description.getText());
			info.setText(STATUS);
		}else {
			info.setText(WARNING);
		}
	}
	
	
	
	/*MetÛda overÌ platnosù vstupu*/
	private boolean checkInputData() {
		if(username.getText().isEmpty() || surname.getText().isEmpty()
				|| company.getText().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
}
