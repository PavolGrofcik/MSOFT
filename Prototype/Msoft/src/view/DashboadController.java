package view;

import java.io.IOException;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DashboadController {
	
	
	@FXML
	private Button application;
	@FXML
	private Button businessPlan;
	@FXML
	private Button showApplications;
	
	@FXML
	private Button logout;
	@FXML
	private Button exit;
	
	
	
	/*Met�da ukon�� aplik�ciu*/
	@FXML
	private void closeWindow() {
		Platform.exit();
	}
	
	/*Met�da vr�ti pou��vate�a o okno spa�*/
	@FXML
	private void goBack() throws IOException {
		//Main.showNewStage("../application/Main.fxml");
		Main.showHomePage();
	}
	
	/*Met�da prejde na zaevidovanie �iadosti*/
	@FXML
	private void ApplyEurofonds() throws IOException {
		Main.showNewStage("../view/Application.fxml");
	}

}
