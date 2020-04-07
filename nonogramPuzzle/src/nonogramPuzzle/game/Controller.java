package nonogramPuzzle.game;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Controller implements Initializable{
	@FXML Pane back;
	@FXML HBox colNum;
	@FXML VBox rowNum;
	
	@Override 
	public void initialize(URL arg0, ResourceBundle arg1) {
		makeNemo();
	}
	
	private void makeNemo() {
		GridPane grid = new GridPane();
		
		grid.setMinSize(300, 300);
//		grid.setStyle("-fx-background-color:#ededed");//생성 보기 테스트
		back.getChildren().add(grid);
	}
	

}
