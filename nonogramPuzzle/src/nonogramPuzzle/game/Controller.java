package nonogramPuzzle.game;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	PuzzleIndex puzIndex = new PuzzleIndex();
	GridPane grid = new GridPane();
	
	Image wrongImg = new Image(getClass().getResourceAsStream("img/wrong.jpg"));
	ArrayList<ImageView> img = new ArrayList<ImageView>();
	ArrayList<Image> wrong = new ArrayList<Image>();
	int imgCount = 0;
//	Label numbersList[] = new numbersList
	
	
	@Override 
	public void initialize(URL arg0, ResourceBundle arg1) {
		makeNemo();
		writeCount();
	}
	
	private void makeNemo() {
		
		
		grid.setMinSize(300, 300);
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				nemos[i] = new Button();
				nemos[i].setStyle("-fx-background-radius:0");
				nemos[i].setId(i+""+j);
				nemos[i].setPrefSize(30, 30);
				nemos[i].setOnAction(event->fillNemo((Button)event.getSource()));
				grid.add(nemos[i], i, j);
			}
		}
//		grid.setStyle("-fx-background-color:#ededed");//생성 보기 테스트
		back.getChildren().add(grid);
		
	}
	
	//힌트 출력 메소드
	private void writeCount() {
		Label num = new Label();
	//col
		for(int i=0; i<10; i++) {
			colCount[i] = new GridPane();
	
			colCount[i].setPrefSize(30, 100);
			colCount[i].setPadding(new Insets(0,0,0,5));
			colCount[i].setId(i+"0");
			for(int j=0; j<4; j++) {
				Label label = new Label(i+"0");
				label.setPadding(new Insets(0,0,10,0));
				colCount[i].add(label, i, j);
			}

		}
		
	//row
		for(int i=0; i<10; i++) {
			rowCount[i] = new GridPane();
			rowCount[i].setPrefSize(120, 30);
			rowCount[i].setPadding(new Insets(5,0,0,0));
			rowCount[i].setId("0"+i);
			for(int j=0; j<4; j++) {
				Label label = new Label("0"+i);
				label.setPadding(new Insets(0,0,0,10));
				rowCount[i].add(label, j, i);
			}

		}
		
		colNum.getChildren().addAll(colCount);
		rowNum.getChildren().addAll(rowCount);
		
	}
	
	private void fillNemo(Button nemo) {
//		System.out.println(wrongImg.getWidth());
		
		String nemoId = nemo.getId();
		if(puzIndex.checkIndex(nemoId))
			nemo.setStyle("-fx-background-color : BLACK");
		
		else {
			System.out.println("클릭한 버튼 "+nemo.getId());

			int col = GridPane.getColumnIndex(nemo);
			int row = GridPane.getRowIndex(nemo);
			System.out.println("nemo 인덱스 : "+col+","+row);
			ImageView getImg = check();
			grid.add(getImg,col,row);
			back.getChildren().addAll(getImg);
			
//			System.out.println(imgCount);
			
			
//			nemo.setGraphic(ch.check());
		}

	}
	
	ImageView check() {
		wrong.add(new Image(getClass().getResourceAsStream("img/wrong.jpg")));
		img.add(new ImageView(wrong.get(imgCount)));
		System.out.println("저장시점 count "+imgCount);
		System.out.println("wrong사이즈: "+wrong.size());
		System.out.println("img사이즈: "+img.size());
		imgCount++;
		
		
		return img.get(imgCount-1);
	}
	

}
