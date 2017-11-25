package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Model.DBTest;
import View.AllowLogin;
import View.Resister;
import View.UserResister;
import client.Client;

public class ResisterEvent implements ActionListener {
	Resister Re;
	public Client clientInfo;
	public String id;
	public String pw;
	public DBTest db;


	public ResisterEvent(Resister Re) {
		this.Re = Re;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(Re.bt)) {
			System.out.println("로그인 눌림");
			db = new DBTest();
			id = Re.tfiled.getText();
			pw = Re.tfiled1.getText();
			clientInfo = db.carry(id, pw);
			
			if (!clientInfo.getId().equals(null)) {
				System.out.println("로그인 성공");
				
				System.out.println(clientInfo.getId());
				Re.frame.dispose();
				AllowLogin are = new AllowLogin(clientInfo);
				are.llbDraw();
				
				
			}
			
		} else if (e.getSource().equals(Re.bt1)) {
			System.out.println("회원가입 눌림");
			Re.frame.dispose(); // 화면닫힘
			UserResister ure = new UserResister();
			ure.draw();

		}
	}

}
