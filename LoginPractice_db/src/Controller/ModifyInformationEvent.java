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
			//회원정보 수정
			System.out.println("회원수정 눌림");
			
			db = new DBTest();
			String id = mre.mtfd.getText();
			String pw = mre.mtfd1.getText();
			String name = mre.mtfd2.getText();
			
			modifyClient = new Client(id, pw, name);
			String oid = mre.clientm.getId();
			db.modifying(modifyClient, oid);
			System.out.println("수정완료");
			System.out.println(mre.clientm.getId());
//			System.out.println(mre.clientm.getId());
		}
		else if(e.getSource().equals(mre.mbt1)) {
			
			mre.mfr.dispose();
			System.out.println("취소눌림");
		}
	}
	
	
}
