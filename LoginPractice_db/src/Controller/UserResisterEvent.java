package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.DBTest;
import View.Resister;
import View.UserResister;
import client.Client;
public class UserResisterEvent implements ActionListener{
	UserResister ure;
	DBTest db;
	public UserResisterEvent(UserResister ure) {
		this.ure =ure;
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(ure.b1)) {
			String id = ure.tf1.getText();
			String pw = ure.tf2.getText();
			String name = ure.tf3.getText();
			Client client = new Client(id, pw, name);
			db = new DBTest();
			db.add(client);
			System.out.println("등록 성공");
			
		}else if(e.getSource().equals(ure.b2)) {
			System.out.println("취소 눌림");
			ure.frm.dispose(); // 화면닫힘
			Resister re = new Resister();
		}
	}
}
