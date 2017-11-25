package View;


import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JPasswordField;

import Controller.UserResisterEvent;
import Controller.WindowController;

public class UserResister {
	// 여기가 회원가입화면
	public Frame frm;
	public Label l1, l2, l3;
	public TextField tf1, tf3;
	public JPasswordField tf2;
	public Button b1, b2;

	WindowController wc;
	UserResisterEvent ure;

	public UserResister() {
		frm = new Frame("UserResister");

		l1 = new Label("Id를 입력하세요 ", Label.RIGHT);
		l2 = new Label("Password를 입력하세요", Label.RIGHT);
		l3 = new Label("이름을 입력하세요", Label.RIGHT);

		tf1 = new TextField();
		tf2 = new JPasswordField();
		tf3 = new TextField();
		
		b1 = new Button("등록");
		b2 = new Button("취소");
		wc = new WindowController();
		frm.addWindowListener(wc);
		ure = new UserResisterEvent(this);
		b1.addActionListener(ure);
		b2.addActionListener(ure);
	}

	public void draw() {
		frm.setSize(1000, 1000);

		frm.setLayout(null);
		tf1.setBounds(500, 100, 100, 50);
		tf2.setBounds(500, 200, 100, 50);
		tf3.setBounds(500, 300, 100, 50);
		b1.setBounds(800, 200, 100, 50);
		b2.setBounds(800, 300, 100, 50);

		l1.setBounds(120, 100, 200, 50);
		l2.setBounds(120, 200, 200, 50);
		l3.setBounds(120, 300, 200, 50);
		frm.add(tf1);
		frm.add(tf2);
		frm.add(tf3);
		frm.add(l1);
		frm.add(l2);
		frm.add(l3);
		frm.add(b1);
		frm.add(b2);

		frm.setVisible(true);

	}

}
