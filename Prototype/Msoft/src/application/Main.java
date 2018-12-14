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
 * Main view: Homepage pre prihl�senia klienta (�iadate�a)
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
			
			
			/*Spr�vne ukon�enie programu a session factory pre Hibernate*/
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

	/*Met�da zobraz� login na prihl�senia klienta*/
	public void showLogin() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Main.fxml"));
		mainLayout = loader.load();
		
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);;
		primaryStage.show();
	}
	
	 //Met�da zobraz� m�d pre �iadate�a
    public static void showApplicantLogin() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Dashboard.fxml"));
        BorderPane officerLogin = loader.load();
        mainLayout.setCenter(officerLogin);
    }
    
	/*Met�da vytvor� nov� stage s n�zvom stageName*/
	public static void showNewStage(String stageName) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(stageName));
		
		BorderPane pane = loader.load();
		mainLayout.setCenter(pane);
	}
}
