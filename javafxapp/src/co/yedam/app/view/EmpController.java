package co.yedam.app.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import co.yedam.app.model.EmpDAO;
import co.yedam.app.model.EmpDO;
import co.yedam.app.model.OpservEmpDO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class EmpController implements Initializable {
//컨트롤러는 이벤트를 일으키게하는 핸들러역할임

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
	@FXML
	TableView<EmpDO> tvemp;
	@FXML
	TableColumn<OpservEmpDO, String> colEmployeeId;
	@FXML
	TableColumn<OpservEmpDO, String> colLastName;
	@FXML
	TableColumn<OpservEmpDO, String> colEmail;
	@FXML
	TableColumn<OpservEmpDO, String> colHireDate;
	@FXML
	TableColumn<OpservEmpDO, String> colJobId;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		colEmployeeId.setCellValueFactory(new PropertyValueFactory<OpservEmpDO, String>("employeeId"));
		colLastName.setCellValueFactory(new PropertyValueFactory<OpservEmpDO, String>("lastName"));
		colEmail.setCellValueFactory(new PropertyValueFactory<OpservEmpDO, String>("email"));
		colHireDate.setCellValueFactory(new PropertyValueFactory<OpservEmpDO, String>("hireDate"));
		colJobId.setCellValueFactory(new PropertyValueFactory<OpservEmpDO, String>("jobId"));
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
		protected void delDept(ActionEvent event) {
	        EmpDO empDO = tvemp.getSelectionModel().getSelectedItem();
	        ObservableList<EmpDO> data = tvemp.getItems();

	        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setTitle("삭제 메시지");
	        alert.setHeaderText("칼럼을 삭제하려합니다.");
	        alert.setContentText("정말 삭제하시겠습니까?");

	        Optional<ButtonType>result = alert.showAndWait();
	        if(result.get() == ButtonType.OK) {
	        	EmpDAO dao = new EmpDAO();
	        	//DB에서 삭제
	        	dao.delete(empDO);
	        	//tableview 에서 삭제
	        	data.remove(empDO);
	        }
		}
	

	@FXML
	public void empSelectAll(ActionEvent actionEvent) {
		// 조회할 사번은 DO 객체에 담기
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpDO> list = dao.selectAll();
		tvemp.setItems(FXCollections.observableArrayList(list));
	}
		
	@FXML
	public void empInfo(MouseEvent mouseEvent) {
		EmpDO empDO = tvemp.getSelectionModel().getSelectedItem();
		txtEmployeeId.setText(empDO.getEmployeeId());
		txtLastName.setText(empDO.getLastName());
		txtEmail.setText(empDO.getEmail());
		txtHireDate.setText(empDO.getHireDate());
		txtJobId.setText(empDO.getJobId());
	}

	@FXML
	public void empSelectOne(ActionEvent actionEvent) {

		// 조회할 사번은 DO 객체에 담기
		EmpDO emp = new EmpDO();
		emp.setEmployeeId(txtEmployeeId.getText());
		// 단건조회
		EmpDAO dao = new EmpDAO();
		EmpDO result = dao.selectOne(emp);

		// 텍스트필드에 표시
		txtEmployeeId.setText(result.getEmployeeId());
		txtLastName.setText(result.getLastName());
		txtEmail.setText(result.getEmail());
		txtHireDate.setText(result.getHireDate());
		txtJobId.setText(result.getJobId());
		System.out.println("단건조회처리됨");
	}

}
