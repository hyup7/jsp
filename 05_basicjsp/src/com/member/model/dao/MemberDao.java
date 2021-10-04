package com.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.member.model.vo.Member;

public class MemberDao {

	@SuppressWarnings("finally")
	public List<Member> memberList(Connection conn){
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> list=new ArrayList();
		try {
			String sql="select * from member";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m=new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setEmail(rs.getString("email"));
				
				list.add(m);
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	}
}
