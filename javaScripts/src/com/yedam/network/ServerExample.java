package com.yedam.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ServerExample extends Application {
	ExecutorService executorService;
	ServerSocket serverSocket;
	List<Client> list = new Vector<>();// arrayList랑 비슷

	void startServer() {
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());// 스레드풀 만들기
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("192.168.0.63", 5001));
		} catch (IOException e) {
			if (!serverSocket.isClosed())
				stopServer();// 서버소켓연결->> close()
		}
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					displayText("[서버 시작]");
					btnStartStop.setText("stop");
				});
				while (true) {
					try {
						Socket socket = serverSocket.accept();
						String message = "[연결 수락]" + socket.getRemoteSocketAddress() + " : "
								+ Thread.currentThread().getName() + "]";
						Platform.runLater(() -> displayText(message));
						Client client = new Client(socket);
						list.add(client);
					} catch (IOException e) {
						if (!serverSocket.isClosed()) {
							stopServer();
						}
						break;
					}
				} // end of while
			}// end of run
		};// end of runnable
		executorService.submit(runnable);
	}// end of startServer

	void stopServer() {
		try {
			Iterator<Client> iterator = list.iterator();
			while (iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			if( serverSocket != null && !serverSocket.isClosed())
				serverSocket.close();
			if( serverSocket != null && !executorService.isShutdown())
				executorService.isShutdown();
			Platform.runLater(() -> {
				displayText("[서버 멈춤]");
				btnStartStop.setText("start");
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}

	class Client {
		Socket socket;

		Client(Socket socket) {
			this.socket = socket;
			receive();
		}

		void receive() {
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					try {
						while (true) {
							InputStream is = socket.getInputStream();
							byte[] buf = new byte[100];
							int readByte = is.read(buf);
							if (readByte == -1) {
								throw new IOException();
							}
							String message = "[요청 처리]" + socket.getRemoteSocketAddress() + " : "
									+ Thread.currentThread().getName() + "]";
							Platform.runLater(() -> {
								displayText(message);
							});
							String data = new String(buf, 0, readByte, "UTF-8");
							for (Client client : list) {
								client.send(data);
							}
						}
					} catch (IOException e) {
						list.remove(Client.this);
						String message = "[클라이언트 통신안됨: " + socket.getRemoteSocketAddress() + ":"
								+ Thread.currentThread().getName() + "]";
						Platform.runLater(() -> {
							displayText(message);
						});
						try {
							socket.close();
						} catch (IOException e1) {

						}
					}

				}

			};
			executorService.submit(runnable);
		};

		void send(String data) {
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					byte[] buf = new byte[100];
					try {
						OutputStream os = socket.getOutputStream();
						buf = data.getBytes();
						os.write(buf);
						os.flush();

					} catch (IOException e) {
						String message = "[클라이언트 통신 안됨: " + Thread.currentThread().getName() + ":" + "]";
						Platform.runLater(() -> {
							displayText(message);
						});
						list.remove(Client.this);
						try {
							socket.close();// socket
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}

			};
			executorService.submit(runnable);
		}

	}
	// ui 만드는 스타트

	public static void main(String[] args) {
		launch(args);

	}

	TextArea txtDisplay;
	Button btnStartStop;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);

		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 20, 0));
		root.setCenter(txtDisplay);

		btnStartStop = new Button("start");
		btnStartStop.setPrefHeight(30);
		btnStartStop.setMaxWidth(Double.MAX_VALUE);
		btnStartStop.setOnAction((event) -> {
			if (btnStartStop.getText().equals("start"))
				startServer();
			else if (btnStartStop.getText().equals("stop"))
				stopServer();
		});

		root.setBottom(btnStartStop);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("server");
		primaryStage.show();

	}

}
