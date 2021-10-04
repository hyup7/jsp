package com.member.model.service;
import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;
public class MemberService {
	private MemberDao dao=new MemberDao();
	public Member login(String userId,String password){
		Connection conn=getConnection();
		Member m=dao.login(conn,userId,password);
		
		close(conn);
		return m;
	}
	
	public int insertMember(Member m) {
		Connection conn=getConnection();
		int result=dao.insertMember(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public Member selectMemberId(String userId) {
		Connection conn=getConnection();
		Member m=dao.selectMemberId(conn,userId);
		close(conn);
		return m;
	}

	public int deleteMember(String userId) {
		Connection conn=getConnection();
		int result=dao.deleteMember(conn,userId);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int updateMember(Member m) {
		Connection conn=getConnection();
		int result=dao.updateMember(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}

	public int updatePassword(String userId, String pw) {
		Connection conn=getConnection();
		int result=dao.updatePassword(conn,userId,pw);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}

	public List<Member> selectAllMemberId(int cPage, int numPerpage) {
		Connection conn=getConnection();
		List<Member> list=dao.selectAllMemberId(conn,cPage,numPerpage);
		close(conn);
		return list;
	}

}
