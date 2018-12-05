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


/**
 * LoginController zodpovedn� za spr�vne prihl�senie �iadate�a
 * @author grofc
 *
 */

public class LoginController {
	
	private static final String WARNING = "Niektor� polo�ky s� pr�zdne!";
	private static final String WARNING2 = "Neplatn� Meno alebo Heslo";

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
	
	
	/*Met�da zobraz� nov� stage po platnom prihl�sen� pou��vate�a*/
	@FXML
	private void login() throws IOException {
		info.setText("");
		info.setVisible(true);

		//Overenie vstupu
		if (checkInput()) {

			//Overenie platnosti �dajov
			if (LoginController.login(userField.getText(), passwordField.getText())) {
				Main.showApplicantLogin();
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
	
	
	/*Funkcia over� platnos� vstupu */
	private boolean checkInput() {
		if(userField.getText().isEmpty() ||  passwordField.getText().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
}
