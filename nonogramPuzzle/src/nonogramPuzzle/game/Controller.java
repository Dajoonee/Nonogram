package nonogramPuzzle.game;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Controller implements Initializable{
	@FXML Pane back;
	@FXML HBox colNum;
	@FXML VBox rowNum;
	Button nemos[] = new Button[100];
	GridPane rowCount[] = new GridPane[10];
	GridPane colCount[] = new GridPane[10];
	
	
	@Override 
	public void initialize(URL arg0, ResourceBundle arg1) {
		makeNemo();
		writeCount();
	}
	
	private void makeNemo() {
		GridPane grid = new GridPane();
		
		grid.setMinSize(300, 300);
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				nemos[i] = new Button();
				nemos[i].setStyle("-fx-background-radius:0");
				nemos[i].setPrefSize(30, 30);
				nemos[i].setOnAction(event->fillNemo((Button)event.getSource()));
				grid.add(nemos[i], i, j);
			}
		}
//		grid.setStyle("-fx-background-color:#ededed");//생성 보기 테스트
		back.getChildren().add(grid);
		
	}
	
	private void writeCount() {
		Label num = new Label();
	//col
		for(int i=0; i<10; i++) {
			colCount[i] = new GridPane();
			colCount[i].setPrefHeight(100);
			colCount[i].setPadding(new Insets(0,0,0,10));
			for(int j=0; j<4; j++) {
				colCount[i].add(new Label(i+""+j), i, j);
			}
//			colCount[i].set
		}
		
		colNum.getChildren().addAll(colCount);
	}
	
	private void fillNemo(Button nemo) {
		
	}
	

}
