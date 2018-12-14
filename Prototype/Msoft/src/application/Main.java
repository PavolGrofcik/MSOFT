package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import singleton.BusinessLogicController;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

/**
 * Main view: Homepage pre prihlásenia klienta (Žiadate¾a)
 * @author grofc
 *
 */

public class Main extends Application {
	
	//Singleton Controller
	public static BusinessLogicController controller = BusinessLogicController.getInstance();
	
	private Stage primaryStage;
    private static BorderPane mainLayout;
	
    //Init view
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Eurofonds User Manager");
			this.primaryStage.getIcons().add(new Image("etc/images/Logo4.png"));
			
			
			/*Správne ukonèenie programu a session factory pre Hibernate*/
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			    @Override
			    public void handle(WindowEvent t) {
			    	controller.shutDown();
			        Platform.exit();
			        System.exit(0);
			    }
			});
			
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
	
	 //Metóda zobrazí mód pre Žiadate¾a
    public static void showApplicantLogin() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Dashboard.fxml"));
        BorderPane officerLogin = loader.load();
        mainLayout.setCenter(officerLogin);
    }
    
	/*Metóda vytvorí nový stage s názvom stageName*/
	public static void showNewStage(String stageName) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(stageName));
		
		BorderPane pane = loader.load();
		mainLayout.setCenter(pane);
	}
}
