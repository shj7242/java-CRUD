package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.DBTest;
import View.ModifyInformation;
import client.Client;

public class ModifyInformationEvent implements ActionListener{
	ModifyInformation mre;
	DBTest db;
	public Client modifyClient;
	public ModifyInformationEvent(ModifyInformation mre){
		this.mre = mre;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(mre.mbt)) {
			//ȸ������ ����
			System.out.println("ȸ������ ����");
			
			db = new DBTest();
			String id = mre.mtfd.getText();
			String pw = mre.mtfd1.getText();
			String name = mre.mtfd2.getText();
			
			modifyClient = new Client(id, pw, name);
			String oid = mre.clientm.getId();
			db.modifying(modifyClient, oid);
			System.out.println("�����Ϸ�");
			System.out.println(mre.clientm.getId());
//			System.out.println(mre.clientm.getId());
		}
		else if(e.getSource().equals(mre.mbt1)) {
			
			mre.mfr.dispose();
			System.out.println("��Ҵ���");
		}
	}
	
	
}
