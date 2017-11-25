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
			System.out.println("회원정보수정 눌림");
			ModifyInformation mre = new ModifyInformation(are.clientInfo);
			mre.ModifyDraw();
			are.afr.dispose();
			
			//회원 수정창들어갔을 때 회원정보 셋팅
		}else if(e.getSource().equals(are.abt2)) {
			System.out.println("회원탈퇴 눌림");
			db = new DBTest();
			
			if(db.del(are.clientInfo.getId())==1) {
				System.out.println("삭제완료");
			}
			
			are.afr.dispose(); // 화면닫힘
		}
	}
}
