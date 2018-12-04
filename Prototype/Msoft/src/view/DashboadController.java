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
	
	
	
	/*MetÛda ukonËÌ aplik·ciu*/
	@FXML
	private void closeWindow() {
		Platform.exit();
	}
	
	/*MetÛda vr·ti pouûÌvateæa o okno spaù*/
	@FXML
	private void goBack() throws IOException {
		//Main.showNewStage("../application/Main.fxml");
		Main.showHomePage();
	}
	
	/*MetÛda prejde na zaevidovanie ûiadosti*/
	@FXML
	private void ApplyEurofonds() throws IOException {
		Main.showNewStage("../view/Application.fxml");
	}

}
