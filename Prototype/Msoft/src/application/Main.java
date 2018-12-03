package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

/**
 * Main view pre prihlásenia klienta (Žiadate¾a)
 * @author grofc
 *
 */


public class Main extends Application {
	
	
	private Stage primaryStage;
    private static BorderPane mainLayout;
	
    
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Eurofonds User Manager");
			this.primaryStage.getIcons().add(new Image("etc/Logo4.png"));
			
			showLogin();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	/*Metóda zobrazí login na prihlásenia klienta*/
	public void showLogin() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Main.fxml"));
		mainLayout = loader.load();
		
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);;
		primaryStage.show();
	}
}
