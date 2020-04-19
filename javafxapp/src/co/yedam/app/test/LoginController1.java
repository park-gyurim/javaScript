package co.yedam.app.test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController1  implements Initializable {

	@FXML Button btnCheck;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

	@FXML
	public void loginCheck(ActionEvent event) {
		try {
			
			Stage primaryStage = (Stage) btnCheck.getScene().getWindow();

            // ?Éà ?†à?ù¥?ïÑ?õÉ Ï∂îÍ?
			BorderPane empView = FXMLLoader.load(getClass().getResource("emp1.fxml"));
 
            // ?î¨?óê ?†à?ù¥?ïÑ?õÉ Ï∂îÍ?
            Scene sc = new Scene(empView);
 
            // ?î¨?ùÑ ?ä§?Öå?ù¥Ïß??óê?Ñú ?ÉÅ?òÅ
            primaryStage.setScene(sc);
            primaryStage.show();
            
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
