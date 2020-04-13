package com.yedam.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class clientExample extends Application {
	Socket socket;

	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}

	// startClient()
	void startClient() {
		Thread thread = new Thread() {

			@Override
			public void run() {
				socket = new Socket();
				try {
					socket.connect(new InetSocketAddress("192.168.0.63", 5001));
					Platform.runLater(() -> {
						displayText("[연결완료: " + socket.getRemoteSocketAddress() + "]");
						btnConn.setText("stop");
						btnSend.setDisable(false);// 접속연결을 만드는부분
					});
				} catch (IOException e) {
					e.printStackTrace();
					Platform.runLater(() -> displayText("[서버통신안됨]"));
					if (!socket.isClosed()) {
						// 스탑클라이언트();
					}
				}
			}

		};
		thread.start();
	}

	// stopClient()
	void stopClient() {
		Platform.runLater(() -> {
			displayText("[연결끊음]");
			btnConn.setText("start");
			btnSend.setDisable(true);
			if (socket != null && !socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			;
		});
	}

	// receive()
	void receive() {
		while(true) {
			byte[] buf = new byte[100];
			try {
				InputStream is = socket.getInputStream();
				int readByte = is.read(buf);
				if( readByte == -1 ) {
					throw new IOException();
				}
				String data = new String(buf,0,readByte, "UTF-8");
				Platform.runLater(() -> {
					displayText("[받기 완료]" + data);
				});
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Platform.runLater(() -> {
					displayText("[서버통신안됨]");
				});
				stopClient();
				break;
			}// 트라이캐치 끝부분
		}//와일문 끝부분
	}//리시브 끝부분

	// send()
	void send(String data) {
		Thread thread = new Thread() {

			@Override
			public void run() {
				try {
					byte[] buf = data.getBytes("UTF-8");
					OutputStream os = socket.getOutputStream();
					os.write(buf);
					os.flush();
					Platform.runLater(() -> {
						displayText("[보내기완료]");
					});
				} catch (IOException e) {
					
					Platform.runLater(() -> {
						displayText("[서버 통신 안됨]");
						stopClient();
					});
				}
			}

		};
		thread.start();
	}//센드 메소드 끝나는 부분
	

	// start() => UI를 만드는 메소드
	TextArea txtDisplay;
	TextField txtInput;
	Button btnConn, btnSend;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);

		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
		root.setCenter(txtDisplay);

		BorderPane bottom = new BorderPane();
		txtInput = new TextField();
		txtInput.setPrefSize(60, 30);
		BorderPane.setMargin(txtInput, new Insets(0, 1, 1, 1));

		btnConn = new Button("start");
		btnConn.setPrefSize(60, 30);
		btnConn.setOnAction(event -> {
			if (btnConn.getText().equals("start")) {
				startClient();
			} else if (btnConn.getText().equals("stop")) {
				stopClient();
			}
		});

		btnSend = new Button("send");
		btnSend.setPrefSize(60, 30);
		btnSend.setDisable(true);
		btnSend.setOnAction(event -> send(txtInput.getText()));//메세지보내는기능

		bottom.setCenter(txtInput);
		bottom.setLeft(btnConn);
		bottom.setRight(btnSend);

		root.setBottom(bottom);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Client");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
