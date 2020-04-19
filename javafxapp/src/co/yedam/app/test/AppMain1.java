package co.yedam.app.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain1 extends Application {
	public static void main(String[] args) {
		launch(args);
		//new DeptFrame();
	}

	@Override
	public void start(Stage stage) throws Exception {
		//Parent root = FXMLLoader.load(getClass().getResource("emp.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("할인율계산기.fxml"));
        Scene scene = new Scene(root, 500, 500); 
        stage.setTitle("FXML Welcome");
        stage.setScene(scene); 
        stage.show();
	}

}
