package co.yedam.app.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.yedam.app.model.EmpDAO;
import co.yedam.app.model.EmpDO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class EmpController implements Initializable {

	@FXML
	TextField txtEmployeeId;
	@FXML
	TextField txtLastName;
	@FXML
	TextField txtEmail;
	@FXML
	TextField txtHireDate;
	@FXML
	TextField txtJobId;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@FXML
	public void empInsert(ActionEvent actionEvent) {
		
		// DAO
	    // 텍스트필드 값을 읽어서 DO 객체에 담기
		EmpDO emp = new EmpDO();
		emp.setEmployeeId(txtEmployeeId.getText());
		emp.setLastName(txtLastName.getText());
		emp.setEmail(txtEmail.getText());
		emp.setHireDate(txtHireDate.getText());
		emp.setJobId(txtJobId.getText());
		
		// DAO 등록
	      EmpDAO dao = new EmpDAO();
	      dao.insert(emp);
	      System.out.println("등록처리됨.");
	}

	@FXML
	public void empUpdate(ActionEvent actionEvent) {
		System.out.println("수정처리됨");
	}
	
	@FXML
	public void empDelete(ActionEvent actionEvent) {
		EmpDO emp = new EmpDO();
		emp.setEmployeeId(txtEmployeeId.getText());
		//단건조회
		EmpDAO dao = new EmpDAO();
		dao.delete(emp);
		
		//텍스트필드에 표시
		txtEmployeeId.setText("");
		txtLastName.setText("");
		txtEmail.setText("");
		txtHireDate.setText("");
		txtJobId.setText("");
		System.out.println("삭제처리됨");
	}
	
	@FXML
	public void empSelect(ActionEvent actionEvent) {
		System.out.println("전제조회처리됨");
	}

	@FXML
	public void empSelectOne(ActionEvent actionEvent) {
		
		//조회할 사번은 DO 객체에 담기
		EmpDO emp = new EmpDO();
		emp.setEmployeeId(txtEmployeeId.getText());
		//단건조회
		EmpDAO dao = new EmpDAO();
		EmpDO result = dao.SelectOne(emp);
		
		//텍스트필드에 표시
		txtEmployeeId.setText(result.getEmployeeId());
		txtLastName.setText(result.getLastName());
		txtEmail.setText(result.getEmail());
		txtHireDate.setText(result.getHireDate());
		txtJobId.setText(result.getJobId());
		System.out.println("단건조회처리됨");
	}

}
