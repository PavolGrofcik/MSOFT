package application;

import java.io.IOException;

import controller.Controller;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	private static final String WARNING = "Some fields are empty!";
	private static final String WARNING2 = "Invalid username or password!";

	private static Controller LoginController = Controller.getInstance();
	
	@FXML
	private TextField userField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Label info;
	
	@FXML
	private javafx.scene.control.Button closeButton;
	@FXML
	private Button loginButton;
	
	@FXML
	private void closeWindow() {	
		Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();
	    Main.controller.shutDown();
	    Platform.exit();
        System.exit(0);
	}
	
	
	/*MetÛda zobrazÌ nov˝ stage po platnom prihl·senÌ pouûÌvateæa*/
	@FXML
	private void login() throws IOException {
		info.setText("");
		info.setVisible(true);

		if (checkInput()) {

			if (LoginController.login(userField.getText(), passwordField.getText())) {
				Main.showOfficerLogin();
			} else {
				userField.clear();
				passwordField.clear();

				info.setVisible(true);
				info.setText(WARNING2);
			}
		} else {
			info.setVisible(true);
			info.setText(WARNING);
		}
	}
	
	
	/*Funkcia overÌ platnosù vstupu */
	private boolean checkInput() {
		if(userField.getText().isEmpty() ||  passwordField.getText().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
}
