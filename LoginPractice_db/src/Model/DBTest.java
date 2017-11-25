package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import client.Client;

public class DBTest {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn;
	PreparedStatement pstmt;
	// 받는값 저장
	ResultSet rs;
	Client client ;
	String id = "system";
	String pw = "1234";
	public DBTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int add(Client client) {
		int i = 0;
		try {
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "insert into TEST1 values(?,?,?)";
			String id = client.getId();
			String pw = client.getPw();
			String name = client.getName();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("회원가입 실패");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return i;

	}

	public Client carry(String id, String pw) {
		String loginid = null;
		try {
			conn = DriverManager.getConnection(url, this.id, this.pw);
			String sql = "select * from TESt1 where id=? and password=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				 client = new Client(rs.getString("id"),rs.getString("password"),rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return client;
	}

	public int del(String id) {
		int i = 0;
		try {
			conn = DriverManager.getConnection(url, this.id, this.pw);
			String sql = "delete from TEST1 where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return i;

	}
	

	public int modifying(Client modifyClient, String oid) {
		int i=0;
		try {
			conn = DriverManager.getConnection(url, this.id, this.pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "update TEST1 set id= ? , password = ?, name= ? where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			String id = modifyClient.getId();
			String pw = modifyClient.getPw();
			String name = modifyClient.getName();
			pstmt.setString(1, id );
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, oid);
			i=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return i;
	}

	public ArrayList<Client> allView() {
		ArrayList<Client> abc = new <Client>ArrayList();
		try {
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "select * from TEST1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			for(int k=0; rs.next(); k++) {			
				client= new Client(rs.getString("id"),rs.getString("password"),rs.getString("name"));
				abc.add(client);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		return abc;
	}
}

