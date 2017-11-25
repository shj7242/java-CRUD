package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.DBTest;
import View.AllowLogin;
import View.ModifyInformation;


public class AllowLoginEvent implements ActionListener{
	public AllowLogin are;
	public DBTest db;
	public AllowLoginEvent(AllowLogin are) {
		this.are = are;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(are.abt1)) {
			System.out.println("ȸ���������� ����");
			ModifyInformation mre = new ModifyInformation(are.clientInfo);
			mre.ModifyDraw();
			are.afr.dispose();
			
			//ȸ�� ����â���� �� ȸ������ ����
		}else if(e.getSource().equals(are.abt2)) {
			System.out.println("ȸ��Ż�� ����");
			db = new DBTest();
			
			if(db.del(are.clientInfo.getId())==1) {
				System.out.println("�����Ϸ�");
			}
			
			are.afr.dispose(); // ȭ�����
		}
	}
}
