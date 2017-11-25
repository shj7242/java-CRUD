package View;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

import Controller.ModifyInformationEvent;
import Controller.WindowController;
import Model.DBTest;
import client.Client;
public class ModifyInformation {
	public String id;
	public String pw;
	public Frame mfr;
	public Label mlb,mlb1,mlb2;
	public Button mbt,mbt1;
	public TextField mtfd1, mtfd2, mtfd;
	WindowController wc;
	public ModifyInformationEvent mre;
	public Resister pre;
	public Client clientm;
	public ModifyInformation(Client client){
		this.clientm = client;
		this.id = clientm.getId();
		DBTest db = new DBTest();
		
		mfr = new Frame("Modifyer");
		mlb = new Label("ID");
		mlb1 = new Label("PASSWORD");
		mlb2 = new Label("이름");
		
		mbt = new Button("수정 및 저장");
		mbt1 = new Button("취소");
		mtfd = new TextField();
		mtfd1 = new TextField();
		mtfd2 = new TextField();
	}
//	public  ModifyInformation() {
//	DBTest db = new DBTest();
//	
//		mfr = new Frame("Modifyer");
//		mlb = new Label("ID");
//		mlb1 = new Label("PASSWORD");
//		mlb2 = new Label("이름");
//		
//		mbt = new Button("저장");
//		mbt1 = new Button("취소");
//		
//		mtfd = new TextField(db.client.getId().toString());
//		mtfd1 = new TextField(db.client.getPw());
//		mtfd2 = new TextField(db.client.getName());
//	}
		
		
	
	public void ModifyDraw(){
		mfr.setSize(700,700);
		
		mfr.setLayout(null);
		
		
		mlb.setBounds(100, 100, 300, 50);
		mlb1.setBounds(100,250,300,50);
		mlb2.setBounds(100, 400,300, 50);
		mtfd.setBounds(400,100,300,50);
		mtfd1.setBounds(400, 250, 300, 50);
		mtfd2.setBounds(400, 400, 300, 50);
		mbt1.setBounds(400,500,100,50);
		mbt.setBounds(100,500,100,50);
		
		
		mfr.add(mlb);
		mfr.add(mlb1);
		mfr.add(mlb2);
		mfr.add(mbt);
		mfr.add(mbt1);
		mfr.add(mtfd);
		mfr.add(mtfd1);
		mfr.add(mtfd2);
		mre = new ModifyInformationEvent(this);
		mfr.setVisible(true);
		wc = new WindowController();
		mfr.addWindowListener(wc);
		System.out.println(clientm.getName());
		mbt1.addActionListener(mre);
		mbt.addActionListener(mre);
		mtfd.setText(clientm.getId());
		mtfd1.setText(clientm.getPw());
		mtfd2.setText(clientm.getName());
	
	}
	
	
	
	
	
}
