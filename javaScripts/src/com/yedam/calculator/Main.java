package com.yedam.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Main extends JFrame {

	JTextField inputTf; // 숫자가 출력될 텍스트 필드
	final int fontSizeMax = 28; // 숫자가 작을 때 폰트 사이즈
	final int fontSizeMin = 18; // 숫자가 중간정도로 클 때 폰트 사이즈
	final int fontSizeMinMin = 16; // 숫자가 클 때 폰트 사이즈
	Color buttonColor = Color.LIGHT_GRAY;
	MainPanel mainPane;

	JButton numberBtn[];
	JButton doubleZeroBtn;
	JButton dotBtn;
	JButton equalBtn;
	JButton cBtn;
	JButton ceBtn;
	JButton addBtn;
	JButton subBtn;
	JButton mulBtn;
	JButton divBtn;
	JButton backBtn;

	Main() {
		setTitle("자바 계산기 - 규림");
		setSize(255, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(500, 200);
//add MainPanel
		mainPane = new MainPanel();
		mainPane.addKeyListener(new InputKeyListener());
		mainPane.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mainPane.requestFocus(true);
			}
		});
		setContentPane(mainPane);
		setVisible(true);
	}

	class InputKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			for (int i = 0; i < 10; i++)
				if (e.getKeyChar() == Integer.toString(i).charAt(0))
					numberBtn[i].doClick();
			if (e.getKeyChar() == '+')
				addBtn.doClick();
			if (e.getKeyChar() == '-')
				subBtn.doClick();
			if (e.getKeyChar() == '*')
				mulBtn.doClick();
			if (e.getKeyChar() == '/')
				divBtn.doClick();
			if (e.getKeyChar() == '.')
				dotBtn.doClick();
			if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				backBtn.doClick();
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
				equalBtn.doClick();
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
				cBtn.doClick();
		}
	}

	class MainPanel extends JPanel {
		String inputTfString;
		int dotCount; // 소수점을 한번만 찍기위한 변수
		boolean calPushBtn; // 연산기호의 중복 눌림을 막기위한 변수
		Calculate cal;

		MainPanel() {
// 레이아웃 관리자를 없앰
			setLayout(null);
// Calculate 클래스의 객체 생성
			cal = new Calculate();
// inputTfString 초기화
			initInputTfString();
// dotCount, calPushBtn 초기화
			dotCount = 0;
			calPushBtn = false; // 눌리지 않은 상태. true 면 연산기호가 눌린 상태
// 연산기호가 눌린 상태라면 연산기호를 입력 받지 않는다.
// 텍스트 필드 초기화
			inputTf = new JTextField(20);
			inputTf.setBounds(20, 10, 210, 40);
			inputTf.setHorizontalAlignment(SwingConstants.RIGHT);
			inputTf.setFont(new Font(null, Font.PLAIN, fontSizeMax));
			inputTf.setFocusable(false);
			/*
			 * inputTf.addKeyListener(new NumberKeyListener()); // 키입력 리스너(예정)
			 * inputTf.addKeyListener(new SymbolKeyListener());
			 */
// 텍스트 필드에 cal.result 값을 출력. result는 0으로 초기화 됐으므로 0이 출력. 
			setInputTfResult(cal);
// numberBtn 초기화
			numberBtn = new JButton[10];
			for (Integer i = 0; i < 10; i++) {
				numberBtn[i] = new JButton(i.toString());
				numberBtn[i].setFont(new Font(null, Font.PLAIN, 20)); // 폰트 크기를 20으로 설정
				numberBtn[i].addActionListener(new NumberActionListener());
// if(i != 0)
				numberBtn[i].setSize(45, 30); // 0이외의 버튼 크기
// else
// numberBtn[i].setSize(100, 30); // 0의 버튼 크기
				numberBtn[i].setFocusable(false);
			}
// doubleZeroBtn 초기화
			doubleZeroBtn = new JButton("00");
			doubleZeroBtn.setBounds(75, 220, 45, 30);
			doubleZeroBtn.setFont(new Font(null, Font.PLAIN, 15));
			doubleZeroBtn.addActionListener(new NumberActionListener());
			doubleZeroBtn.setFocusable(false);
			doubleZeroBtn.setBackground(buttonColor);
// dotBtn 초기화
			dotBtn = new JButton(".");
			dotBtn.setBounds(130, 220, 45, 30);
			dotBtn.setFont(new Font(null, Font.PLAIN, 25));
			dotBtn.addActionListener(new DotActionListener());
			dotBtn.setFocusable(false);
			dotBtn.setBackground(buttonColor);
// equalBtn 초기화
			equalBtn = new JButton("=");
			equalBtn.setBounds(185, 220, 45, 30);
			equalBtn.setFont(new Font(null, Font.PLAIN, 18));
			equalBtn.addActionListener(new CalculateActionListener());
			equalBtn.setFocusable(false);
			equalBtn.setBackground(buttonColor);
// 연산 버튼 초기화
			addBtn = new JButton("+");
			addBtn.setBounds(185, 180, 45, 30);
			addBtn.setFont(new Font(null, Font.PLAIN, 18));
			addBtn.addActionListener(new CalculateActionListener());
			addBtn.setFocusable(false);
			addBtn.setBackground(buttonColor);
			subBtn = new JButton("-");
			subBtn.setBounds(185, 140, 45, 30);
			subBtn.setFont(new Font(null, Font.PLAIN, 25));
			subBtn.addActionListener(new CalculateActionListener());
			subBtn.setFocusable(false);
			subBtn.setBackground(buttonColor);
			mulBtn = new JButton("*");
			mulBtn.setBounds(185, 100, 45, 30);
			mulBtn.setFont(new Font(null, Font.PLAIN, 20));
			mulBtn.addActionListener(new CalculateActionListener());
			mulBtn.setFocusable(false);
			mulBtn.setBackground(buttonColor);
			divBtn = new JButton("/");
			divBtn.setBounds(185, 60, 45, 30);
			divBtn.setFont(new Font(null, Font.PLAIN, 20));
			divBtn.addActionListener(new CalculateActionListener());
			divBtn.setFocusable(false);
			divBtn.setBackground(buttonColor);
// 백스페이스 버튼 초기화

			backBtn = new JButton("←");
			backBtn.setBounds(20, 60, 45, 30);
			backBtn.setFont(new Font(null, Font.BOLD, 10));
			backBtn.addActionListener(new CorrectionBtnListener());
			backBtn.setFocusable(false);
			backBtn.setBackground(buttonColor);
//c, ce 버튼 초기화

			cBtn = new JButton("C");
			cBtn.setBounds(130, 60, 45, 30);
			cBtn.setFont(new Font(null, Font.BOLD, 15));
			cBtn.addActionListener(new CorrectionBtnListener());
			cBtn.setFocusable(false);
			cBtn.setBackground(buttonColor);
			ceBtn = new JButton("CE");
			ceBtn.setBounds(75, 60, 45, 30);
			ceBtn.setFont(new Font(null, Font.BOLD, 8));
			ceBtn.addActionListener(new CorrectionBtnListener());
			ceBtn.setFocusable(false);
			ceBtn.setBackground(buttonColor);
// numberBtn 위치 설정

			numberBtn[0].setLocation(20, 220);
			for (int i = 1, x = 20, y = 220; i < 10; i++) {
				if (i % 3 == 1) {
					x = 20;
					y = y - 40;
				}
				numberBtn[i].setLocation(x, y);
				x += 55;
			}
// add inputTextField

			add(inputTf);
// add numberBtn

			for (int i = 0; i < 10; i++) {
				add(numberBtn[i]);
				numberBtn[i].setBackground(buttonColor);
			}
// add All Btn

			add(dotBtn);
			add(equalBtn);
			add(addBtn);
			add(subBtn);
			add(mulBtn);
			add(divBtn);
			add(backBtn);
			add(cBtn);
			add(ceBtn);
			add(doubleZeroBtn);
			this.setVisible(true);
			this.setBackground(Color.PINK);
			this.setFocusable(true);
			this.setRequestFocusEnabled(true);
			this.grabFocus();
		}

		class NumberActionListener implements ActionListener { // 숫자 키 리스너
			public void actionPerformed(ActionEvent e) {
				for (Integer i = 0; i < 10; i++) {
					if (e.getSource().equals(numberBtn[i]) || e.getSource().equals(doubleZeroBtn)) {
						if (inputTf.getText().equals("0")) // 입력창이 0 이면 0을 눌렀을때
							if (i == 0)
								return; // 아무것도 안함

						if (inputTfString.equals("")) // 재입력 시작순간 폰트 크기 초기화
							inputTf.setFont(new Font(null, Font.PLAIN, fontSizeMax)); // 폰트 크기 초기화
						if (!e.getSource().equals(doubleZeroBtn)) {
							setInputTfString(i.toString()); // 그 외에는 계속 입력을 받는다
							inputTf.setText(inputTfString); // 더해진 문자열을 출력
						} else {
							setInputTfString("00");
							inputTf.setText(inputTfString); // 더해진 문자열을 출력
							break;
						}
					}
					calPushBtn = false; // 숫자 키가 한번이라도 눌리면 다시
// 연산 버튼을 누를 수 있게 함 
				}
			}
		}

		class CorrectionBtnListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(cBtn)) {
					cal.initAllElement(); // cal 객체의 calNum result 0으로 초기화
					initInputTfString();
					setInputTfResult(cal); // inputTf 텍스트 필드에 result를 출력, 0이 출력
					dotCount = 0; // dot 카운트 초기화
					calPushBtn = false;
					inputTf.setFont(new Font(null, Font.PLAIN, fontSizeMax)); // 폰트 크기 초기화
				} else if (e.getSource().equals(ceBtn)) {
					initInputTfString(); // inputTfString 을 ""로 초기화
					inputTf.setText("0"); // inputTf 텍스트 필드에 0을 출력
					dotCount = 0; // dot 카운트 초기화
					inputTf.setFont(new Font(null, Font.PLAIN, fontSizeMax)); // 폰트 크기 초기화
				} else if (e.getSource().equals(backBtn)) {// 백스페이스 키를 눌렀을때의 액션
					if (inputTfString.length() > 0) { // 문자열의 길이가 0보다 크면 한문자씩 잘라나간다.
						if (inputTfString.length() < 14)
							inputTf.setFont(new Font(null, Font.PLAIN, fontSizeMax)); // 폰트 크기 초기화
						if (inputTfString.charAt(inputTfString.length() - 1) == '.')
							dotCount = 0; // 자를 문자가 .이면 dot 카운트를 초기화
						inputTfString = inputTfString.substring(0, inputTfString.length() - 1);
						if (inputTfString.length() == 0) // 1에서 0이 되는 순간 0을 출력
							inputTf.setText("0");
						else // 그 외에는 항상 백스페이스된 문자열을 출력
							inputTf.setText(inputTfString);
					}
				}
			}
		}

		class DotActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(dotBtn)) {
					if (dotCount == 0) {
						if (inputTf.getText().equals("0")) // 텍스트 필드가 0일때 .을 누르면
							setInputTfString("0."); // .만 찍히는게 아니고 0.이 찍힘
						else
							setInputTfString(".");
						inputTf.setText(inputTfString);
						dotCount++; // dot 카운트도 초기화가 필요하다
					}
				}
			}
		}

		class CalculateActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (calPushBtn && !e.getSource().equals(equalBtn)) // calPushBtn 이 true 면서
// eqaul버튼 이외의 연산버튼을 누르면
// 아무런 명령도 수행하지 않고 종료
// 연산의 중복 입력을 방지
// 즉, 사용자가 숫자-연산-숫자-연산이 아닌
// 숫자-연산-연산-연산 행동을 할 경우 스탑
					return;
				cal.stringToCalNum(inputTf.getText()); // 텍스트 필드에 있는 문자열을 cal.calNum
// 에 대입
				if (cal.calculate() != 2) // 계산
					setInputTfResult(cal); // 결과치를 텍스트 필드에 출력
				initInputTfString(); // 문자열을 초기화
// 중복 눌림 없게끔 수정하기
				if (e.getSource().equals(addBtn))
					cal.setSymbol('+'); // 각 버튼에 맞는 연산 기호를 입력
				else if (e.getSource().equals(subBtn))
					cal.setSymbol('-');
				else if (e.getSource().equals(mulBtn))
					cal.setSymbol('*');
				else if (e.getSource().equals(divBtn))
					cal.setSymbol('/');
				else if (e.getSource().equals(equalBtn)) { // equal 버튼을 누르면 연산기호를 초기화
					cal.initSymbol();
					cal.initCalNum();
					dotCount = 0;
					return;
				}
				cal.initCalNum(); // 숫자를 초기화(재연산 방지)
				calPushBtn = true; // 연산 버튼 중복 입력 방지
				dotCount = 0; // dot카운트를 초기화(실수 재입력 가능)
			}
		}

		public void setInputTfString(String inputTfString) {
			if (this.inputTfString.length() < 16) {
				if (this.inputTfString.length() > 10) // 합쳐질 문자열이 11보다 크면
// 폰트 크기를 작게
					inputTf.setFont(new Font(null, Font.PLAIN, fontSizeMin));
				if (this.inputTfString.equals("0"))
					if (!inputTfString.equals("."))
						this.inputTfString = "";
				this.inputTfString = this.inputTfString + inputTfString; // 16개의 숫자까지만 받음
			}
		}

		public void setInputTfResult(Calculate cal) {
			Double result = cal.result;
			int length = result.toString().length(); // 문자열의 길이
			String resultString; // 결과 문자열을 받을 문자열 변수
			if (result.toString().substring(length - 2, length).equals(".0")) // 실수 0.0, 1.0등의
// 소수점 아래 .0을 없앰
				resultString = result.toString().substring(0, length - 2);
			else if (searchE(result.toString().toCharArray()))
				if (isInteger(cal.result)) {
					Long longResult = (long) cal.result; // 문자열에 E가 있으면 Long 래핑클래스 선언
					if (longResult.toString().length() < 15) // 문자열의 길이가 14개 이하면 정수형으로 표현
						resultString = longResult.toString();
					else
						resultString = result.toString(); // 15개 이상이면 E가 들어간 축약형으로 표현
				} else {
					DecimalFormat df = new DecimalFormat("#.###############");
					resultString = df.format(result); // 실수형을 축약하지 않고 출력
					if (resultString.length() > 18) // 17개 이하일 경우 축약하지 않는다.
						resultString = result.toString();
				}
			else
				resultString = result.toString(); // E가 없는 실수는 그냥 실수형으로 표현
			length = resultString.length();
// if((length = resultString.length()) > 22)
// resultString = resultString.substring(0, 22);
			if (length < 13)
				inputTf.setFont(new Font(null, Font.PLAIN, fontSizeMax));
			if (length > 12)
				inputTf.setFont(new Font(null, Font.PLAIN, fontSizeMin));
			if (length > 20)
				inputTf.setFont(new Font(null, Font.PLAIN, fontSizeMinMin));
			inputTf.setText(resultString);
		}

		public void initInputTfString() {
			this.inputTfString = "";
		}

		public boolean searchE(char[] array) { // 문자열에서 E가 발견되면 true를 리턴
			for (int i = 0; i < array.length; i++)
				if (array[i] == 'E')
					return true;
			return false;
		}

		public boolean isInteger(double result) {
			if (result == (long) result)
				return true;
			return false;
		}
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); // 룩앤필 적용
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Main();
	}
}
