package nonogramPuzzle.code1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class NonogramController implements Initializable{
	@FXML GridPane grid;
	@FXML Pane backPane;
	@FXML Button saveBtn;
	@FXML Button[] nemos = new Button[100];
	
	@FXML public void clickNemo(MouseEvent e) {
//		String getsrc = e.getPickResult().getIntersectedNode().getId();
		
		
		
		
//		System.out.println(getsrc);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setGrid();
//		nemos[0].setOnAction(event->setBlack(event));
//		for(Button nm : nemos) {
//			nm.setOnAction(event->setBlack((Button)event.getSource()));
//		}
	}
	
//	@SuppressWarnings("static-access")
	void setGrid() {
		
		GridPane grid = new GridPane();
		grid.setMaxSize(300, 300);
		grid.setId("grid");

		for(int i=0; i<10; i++) { //column
			
			for(int j=0; j<10; j++) { //row

				nemos[i] =  new Button();
				nemos[i].setStyle("-fx-background-radius:0");
				nemos[i].setPrefSize(30, 30);
				nemos[i].setOnAction(event->setBlack((Button)event.getSource()));
				grid.add(nemos[i], i, j);
				
				nemos[i].setId(i+","+j);
				System.out.println(nemos[i].getId());
			}
		}
		
		backPane.getChildren().add(grid);
		
	}
	
	void setBlack( Button nemo ) {
		System.out.println("µé¿È");
		nemo.setStyle("-fx-background-color:BLACK");
//		System.out.println(nemo.getId());
	}

}

class FillEvent implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent e) {
		
		
	}
	
}

class setGrid {
	GridPane grid = new GridPane();
	
	
}
