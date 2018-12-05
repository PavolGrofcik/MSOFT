package application;
	
import java.io.IOException;

import controller.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

/**
 * Main view pre prihlásenia klienta (Žiadate¾a)
 * @author grofc
 *
 */


public class Main extends Application {
	
	
	public static Controller controller = Controller.getInstance();
	
	private Stage primaryStage;
    private static BorderPane mainLayout;
	
    
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
			//showMainItems();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void showHomePage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("MainItems.fxml"));
		BorderPane pane = loader.load();
		mainLayout.setCenter(pane);	
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
	
	public void showMainItems() throws IOException {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("MainItems.fxml"));
        BorderPane officerLogin = loader.load();
        mainLayout.setCenter(officerLogin);
	}
	
	 //Metóda zobrazí mód pre Officer-a
    public static void showOfficerLogin() throws IOException {
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
