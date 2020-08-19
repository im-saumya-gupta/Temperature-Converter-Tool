package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Optional;

public class MyMain extends Application {
	public static void main(String[] args){
		System.out.println("main");                //main method executed
		launch(args);
	}
	@Override
	public void init() throws Exception {
		System.out.println("init");                 //initialize to the application
		super.init();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");                //application started
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();                //application shows
	}
	private MenuBar createMenu(){
		//File Menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
		newMenuItem.setOnAction(event -> {
			System.out.println("new menu item clicked");
			//more code..
		});//lam da expression
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
		//Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		aboutApp.setOnAction(event -> aboutApp());
		helpMenu.getItems().addAll(aboutApp);
		//MenuBar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}
	public static void aboutApp() {
		//to  do
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My first desktop application");
		alertDialog.setHeaderText("Learning JAVA FX");
		alertDialog.setContentText("I am just a beginner but soon i will be the pro.");
		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
		Optional<ButtonType> clickedBtn;
		clickedBtn = alertDialog.showAndWait();
		if(clickedBtn.isPresent() && clickedBtn.get()==yesBtn){
			System.out.println("yes button clicked");
		}
		else {
			System.out.println("no button clicked");
		}
	}
	@Override
	public void stop() throws Exception {
		System.out.println("stop");         //application is stopped
		super.stop();
	}
}
