package nonogramPuzzle.make_puzzle;

import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class NonogramController implements Initializable{
	@FXML GridPane grid;
	@FXML Pane backPane;
	@FXML Button saveBtn;
	@FXML Button[] nemos = new Button[100];
	@FXML TextField puzName;
	
	Set<String> indexList = new TreeSet<String>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setGrid();
		saveBtn.setOnAction(event->getIndextoFile(event));
	}
	

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
				
				nemos[i].setId(Integer.toString(i)+Integer.toString(j));
				System.out.println(nemos[i].getId());
			}
		}
		
		backPane.getChildren().add(grid);
		
	}
	
	void setBlack( Button nemo ) {
		int col = GridPane.getColumnIndex(nemo);
		int row = GridPane.getRowIndex(nemo);
		String justGet = col+""+row;
		
		if(indexList!=null) {
			
				if(indexList.contains(justGet)) {
					System.out.println("iter");
					nemo.setStyle("-fx-background-radius:0");
					indexList.remove(justGet);
				}else {
					nemo.setStyle("-fx-background-color:BLACK; -fx-background-radius:0");
					indexList.add(justGet);
				}						
	
		}else {
			System.out.println("null");
			nemo.setStyle("-fx-background-color:BLACK; -fx-background-radius:0");
			indexList.add(justGet);
		}
		
		System.out.println(indexList);
	}
	
	void getIndextoFile(ActionEvent e ) {
		
		String filePath = "C:\\Users\\user\\Desktop\\"+puzName.getText()+".txt";
		try {
			FileWriter fw = new FileWriter(filePath);
			String list = indexList.toString();
		
			fw.write(list);
			fw.flush();
			fw.close();
			
		}catch(Exception ee) {
			
		}
		
		
	}
	
}


