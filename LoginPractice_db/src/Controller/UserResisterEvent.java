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
			System.out.println("��� ����");
			
		}else if(e.getSource().equals(ure.b2)) {
			System.out.println("��� ����");
			ure.frm.dispose(); // ȭ�����
			Resister re = new Resister();
		}
	}
}
