package view;


import java.io.IOException;

import application.Main;
import controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import model.Grant;

public class ApplicationController {
	
	 private static  ObservableList<Grant> data =
	            FXCollections.observableArrayList(new Grant(1, "Podpora inovácií IT", true),
	            		new Grant(2, "Rozvoj vzdelávania zamestnancov", true),
	            		new Grant(3, "Podpora nezamestnanosti na vidieku", false));
	
	@FXML
	private TableView tableView;
	@FXML
	private Button show;
	@FXML 
	private Button apply;
	
	@FXML
	private void initialize(){
		setHeader();
	}

	/*Init nastavenie Tableview */
	private void setHeader() {
		 TableColumn id = new TableColumn("ID");
	        TableColumn name = new TableColumn("Name");
	        TableColumn valid = new TableColumn("Valid");
	        
	        id.setCellValueFactory(
	                new PropertyValueFactory<Grant,Integer>("id")
	        );
	        id.prefWidthProperty().bind(tableView.widthProperty().divide(3));
	        
	        
	        name.setCellValueFactory(
	                new PropertyValueFactory<Grant,String>("name")
	        );
	        name.prefWidthProperty().bind(tableView.widthProperty().divide(2));
	        valid.setCellValueFactory(
	                new PropertyValueFactory<Grant,Boolean>("valid")
	        );
	        valid.prefWidthProperty().bind(tableView.widthProperty().divide(4));
	        tableView.getColumns().addAll(id, name, valid);
	        
	        tableView.setOnMouseClicked((MouseEvent event) -> {
	            if(event.getButton().equals(MouseButton.PRIMARY)){
	               Controller.setSelectedGrant((Grant)tableView.getSelectionModel().getSelectedItem());
	            }
	        });
	}
	 
	 
	//Naèítanie dát do Tableview
	@FXML
	public void addData() {
		tableView.setItems(data);
	}
	
	@FXML
	public void ApplyForApplication() throws IOException {
			Main.showNewStage("../view/ApplyApp.fxml");
	}

}
