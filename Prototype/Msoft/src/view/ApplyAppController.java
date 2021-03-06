package view;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import singleton.BusinessLogicController;

public class ApplyAppController {
	
	private static final String WARNING = "Niektor� polo�ky s� pr�zdne!";
	private static final String STATUS = "�iados� bola �spe�ne odoslan�!";

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
	
	/*Zru�enie �iadosti*/
	@FXML
	public void cancelApplication() throws IOException {
		Main.showNewStage("../view/Dashboard.fxml");
	}
	
	/*Met�da odo�le �iados� na pos�denie*/
	@FXML
	public void sendApplication() {
		
		if(checkInputData()) {
			BusinessLogicController.createApplication(username.getText(), surname.getText(),
					company.getText(), description.getText());
			info.setText(STATUS);
		}else {
			info.setText(WARNING);
		}
	}
	
	/*Met�da over� platnos� vstupu*/
	private boolean checkInputData() {
		if(username.getText().isEmpty() || surname.getText().isEmpty()
				|| company.getText().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
}
