package View;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

import Controller.ResisterEvent;
import Controller.WindowController;
import client.Client;

public class Resister {
	ResisterEvent re;
	WindowController wc;
	public Button bt,bt1;
	public Frame frame;
	public TextField tfiled,tfiled1;
	public Resister(){
		frame = new Frame("register");
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		bt = new Button("로그인");
		bt1 = new Button("회원가입");
		frame.setLayout(null);
		
		Label lid = new Label ("ID:", Label.RIGHT);
		Label lid1 = new Label ("PASSWORD:", Label.RIGHT);
		tfiled = new TextField(15); // id
		tfiled1 = new TextField(15); // pw
		
		frame.add(bt);
		bt.setBounds(150, 400, 150, 30);
		frame.add(bt1);
		bt1.setBounds(350, 400, 150, 30);
		frame.add(lid);
		lid.setBounds(100, 100, 150, 30);
		frame.add(lid1);
		lid1.setBounds(100, 150, 150, 30);
		frame.add(tfiled);
		tfiled.setBounds(250, 100, 150, 30);
		frame.add(tfiled1);
		tfiled1.setBounds(250, 150, 150, 30);
		
		re = new ResisterEvent(this);
		wc=new WindowController();
		frame.addWindowListener(wc);
		bt.addActionListener(re);
		bt1.addActionListener(re);
		
		
		
	} 
}