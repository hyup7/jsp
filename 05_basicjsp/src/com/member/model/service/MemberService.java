package com.member.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;

public class MemberService {

	private MemberDao dao=new MemberDao();
	public List<Member> memberList(){
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","STUDENT","STUDENT");
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<Member> list =dao.memberList(conn);
		
		try {
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
