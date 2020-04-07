package nonogramPuzzle.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameAppMain extends Application {
	
	@Override
	public void start(Stage ps) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		Scene sc = new Scene(root);
		
		ps.setScene(sc);
		ps.setTitle("NonoGram Puzzle");
		ps.show();
	}

	public static void main(String[] args) {
		
		launch(args);

	}

}
