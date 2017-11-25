package View;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;

import Controller.AllowLoginEvent;
import Controller.WindowController;
import Model.DBTest;
import client.Client;

public class AllowLogin {
	
	
	public Frame afr;
	public Label alb;
	public Button abt1;
	public Button abt2;
	public AllowLoginEvent are;
	WindowController wc;
	public Client clientInfo;
	
	public AllowLogin(Client client) {
		afr = new Frame("AllowLogin");
		alb = new Label("�α��� ����");
		abt1 = new Button("ȸ����������");
		abt2 = new Button("ȸ��Ż��");
		this.clientInfo = client;
	}
	
	public void llbDraw() {
		
		afr.setSize(700,700);
		afr.setLayout(null);
		
		
		alb.setBounds(300, 200, 300, 100);
		abt1.setBounds(100,500,100,50);
		abt2.setBounds(400,500,100,50);
		
		afr.add(alb);
		afr.add(abt1);
		afr.add(abt2);
		
		afr.setVisible(true);
		
		are = new AllowLoginEvent(this);
		wc= new WindowController();
		afr.addWindowListener(wc);
		abt1.addActionListener(are);
		abt2.addActionListener(are);
	}
}
