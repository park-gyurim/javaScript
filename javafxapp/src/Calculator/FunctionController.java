package Calculator;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FunctionController implements Initializable {

	@FXML private Button btn1;
	@FXML private Button btn2;
	@FXML	private Button btn3;
	@FXML	private Button btn4;
	@FXML	private Button btn5;
	@FXML	private Button btn6;
	@FXML	private Button btn7;
	@FXML	private Button btn8;
	@FXML	private Button btn9;
	@FXML	private Button btn0;
	@FXML	private Button btnSum;
	@FXML	private Button btnSub;
	@FXML	private Button btnMul;
	@FXML	private Button btnDiv;
	@FXML	private Button btnClear;
	@FXML	private Button btnResult;
	@FXML	private Button btnBack;
	@FXML	private Button btnComma;
	@FXML	private TextField calResult;
	@FXML	private TextField calTotal;
	public String numSum;
	public String numSub;
	public String numDiv;
	public String numMul;
	public String numBack;
	public String numResult;
	public String numComma;
	public String zeroToNine;
	@FXML private MenuBar menubar;
	
	@FXML
	public void saleView(ActionEvent event) {
		try {
			AnchorPane saleView = FXMLLoader.load(getClass().getResource("CalculatorPage1.fxml"));
			Stage primaryStage = (Stage) menubar.getScene().getWindow();

			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(primaryStage);
			dialog.setTitle("할인율 계산");

			Scene scene = new Scene(saleView);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();

		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void btn0(ActionEvent event) { // 버튼 0을 눌렀을 때 텍스트 필드에 0이 출력되는 메서드
		zeroToNine = btn0.getText();
		calResult.appendText(zeroToNine);
		calTotal.appendText(zeroToNine);
	}

	public void btn1(ActionEvent event) {
		zeroToNine = btn1.getText();
		calResult.appendText(zeroToNine);
		calTotal.appendText(zeroToNine);
	}

	public void btn2(ActionEvent event) {
		zeroToNine = btn2.getText();
		calResult.appendText(zeroToNine);
		calTotal.appendText(zeroToNine);
	}

	public void btn3(ActionEvent event) {
		zeroToNine = btn3.getText();
		calResult.appendText(zeroToNine);
		calTotal.appendText(zeroToNine);
	}

	public void btn4(ActionEvent event) {
		zeroToNine = btn4.getText();
		calResult.appendText(zeroToNine);
		calTotal.appendText(zeroToNine);
	}

	public void btn5(ActionEvent event) {
		zeroToNine = btn5.getText();
		calResult.appendText(zeroToNine);
		calTotal.appendText(zeroToNine);
	}

	public void btn6(ActionEvent event) {
		zeroToNine = btn6.getText();
		calResult.appendText(zeroToNine);
		calTotal.appendText(zeroToNine);
	}

	public void btn7(ActionEvent event) {
		zeroToNine = btn7.getText();
		calResult.appendText(zeroToNine);
		calTotal.appendText(zeroToNine);
	}

	public void btn8(ActionEvent event) {
		zeroToNine = btn8.getText();
		calResult.appendText(zeroToNine);
		calTotal.appendText(zeroToNine);
	}

	public void btn9(ActionEvent event) {
		zeroToNine = btn9.getText();
		calResult.appendText(zeroToNine);
		calTotal.appendText(zeroToNine);
	}

	public void btnComma(ActionEvent event) {
		zeroToNine = btnComma.getText();
		calResult.appendText(zeroToNine);
		calTotal.appendText(zeroToNine);
	}

	public void btnSum(ActionEvent event) {
		zeroToNine = btnSum.getText();
		calTotal.appendText(zeroToNine);
		calResult.clear();
	}

	public void btnSub(ActionEvent event) {
		zeroToNine = btnSub.getText();
		calTotal.appendText(zeroToNine);
		calResult.clear();
	}

	public void btnDiv(ActionEvent event) {
		zeroToNine = btnDiv.getText();
		calTotal.appendText(zeroToNine);
		calResult.clear();
	}

	public void btnMul(ActionEvent event) {
		zeroToNine = btnMul.getText();
		calTotal.appendText(zeroToNine);
		calResult.clear();
	}

	public void btnClear(ActionEvent event) { // 텍스트 필드 클리어
		calResult.clear();
		calTotal.clear();
	}

	public void btnBack(ActionEvent event) { // 숫자 지우기
		String a = calResult.getText();
		if (a.length() != 0) {
			calResult.setText(a.substring(0, a.length() - 1));
		}
	}

	public void btnResult(ActionEvent event) { // 사칙연산 구현
		String result = calTotal.getText(); // 텍스트 필드 문자열 가져옴
		if (result.indexOf("+") != -1) { // 문자열에 "+"가 있는지 조사 true일 때 if문 실행.
			double result2 = 0; // 연산결과 값이 될 로컬 변수
			StringTokenizer st = new StringTokenizer(result, "+"); // "+"를 기준으로 문자열 분리
			int count = st.countTokens(); // 분리된 문자열의 갯수
			for (int i = 0; i < count; i++) {
				double token = Double.parseDouble(st.nextToken()); // 가져온 하나의 문자열
				result2 += token; // 결과 값에 가져온 문자열을 하나씩 더함.

			}
			calResult.clear(); // 텍스트 입력 필드를 클리어 시킨 후
			calResult.appendText(String.valueOf(result2)); // 연산 결과값을 출력
			calTotal.clear();
			calTotal.appendText(String.valueOf(result2));
		} else if (result.indexOf("-") != -1) {
			double result2 = 0;
			double token = 0;
			double token2 = 0;
			StringTokenizer st = new StringTokenizer(result, "-"); // "+"를 기준으로 문자열 분리
			int count = st.countTokens(); // 분리된 문자열의 갯수
			for (int i = 0; i < 1; i++) {
				token = Double.parseDouble(st.nextToken()); // 가져온 하나의 문자열
				result2 = token;
				for (int j = 1; j < count; j++) {
					token2 = Double.parseDouble(st.nextToken()); // 가져온 하나의 문자열
				}
			}
			result2 -= token2;
			calResult.clear();
			calResult.appendText(String.valueOf(result2));
			calTotal.clear();
			calTotal.appendText(String.valueOf(result2));
		} else if (result.indexOf("*") != -1) {
			double result2 = 1;
			StringTokenizer st = new StringTokenizer(result, "*");
			int count = st.countTokens();
			for (int i = 0; i < count; i++) {
				double token = Double.parseDouble(st.nextToken());
				result2 *= token;
			}
			calResult.clear();
			calResult.appendText(String.valueOf(result2));
			calTotal.clear();
			calTotal.appendText(String.valueOf(result2));

		} else if (result.indexOf("/") != -1) {
			double result2 = 0;
			double token = 0;
			double token2 = 0;
			StringTokenizer st = new StringTokenizer(result, "/"); // "+"를 기준으로 문자열 분리
			int count = st.countTokens(); // 분리된 문자열의 갯수
			for (int i = 0; i < 1; i++) {
				token = Double.parseDouble(st.nextToken()); // 가져온 하나의 문자열
				result2 = token;
				for (int j = 1; j < count; j++) {
					token2 = Double.parseDouble(st.nextToken()); // 가져온 하나의 문자열
				}
			}
			result2 /= token2;
			calResult.clear();
			calResult.appendText(String.valueOf(result2));
			calTotal.clear();
			calTotal.appendText(String.valueOf(result2));
		} else { // 아무것도 입려하지 않은 상태에서 = 를 누르면
			Platform.exit();
		}
	}
}