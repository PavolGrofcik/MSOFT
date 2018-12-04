package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	
	private static final String LOGIN = "Applicant";
	private static final String PASSWORD = "helloworld";
	private static final String WARNING = "Some fields are empty!";
	private static final String WARNING2 = "Invalid username or password!";

	private Main main;
	
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
		Platform.exit();
	}
	
	
	/*MetÛda zobrazÌ nov˝ stage po platnom prihl·senÌ pouûÌvateæa*/
	@FXML
	private void login() throws IOException {
		info.setText("");
		info.setVisible(true);
		
		if (checkInput()) {
			
			if(userField.getText().equals(LOGIN) 
					&& passwordField.getText().equals(PASSWORD)) {
				
				Main.showOfficerLogin();
				
			}else {
				userField.clear();
				passwordField.clear();
				
				info.setVisible(true);
				info.setText(WARNING2);
			}
		}else {
			
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
