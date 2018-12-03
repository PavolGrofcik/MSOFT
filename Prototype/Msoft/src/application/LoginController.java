package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

	private Main main;
	
	@FXML
	private TextField userField;
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private javafx.scene.control.Button closeButton;
	
	@FXML
	private void closeWindow() {	
		Platform.exit();
	}
	
}
