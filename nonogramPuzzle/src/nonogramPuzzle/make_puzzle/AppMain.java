package nonogramPuzzle.make_puzzle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
	
	
	
	@Override
	public void start(Stage ps) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("manegerRoot.fxml"));
		Scene sc = new Scene(root);
		
		ps.setScene(sc);
		ps.setTitle("네모네모로직");
		ps.show();
		
		
	}

	public static void main(String[] args) {
		
		launch(args);
	}

	

}
