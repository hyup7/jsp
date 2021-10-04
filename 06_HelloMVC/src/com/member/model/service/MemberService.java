package com.member.model.service;
import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;
import static com.common.SqlSessionTemplate.getSession;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;
public class MemberService {
	private MemberDao dao=new MemberDao();
	public Member login(Member m2){
		SqlSession session=getSession();
		Member m=dao.login(session,m2);	
		session.close();
		return m;
	}
	
	public int insertMember(Member m) {
		SqlSession session=getSession();
		int result=dao.insertMember(session,m);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}

	public Member selectMemberId(String userId) {
		SqlSession session=getSession();
		Member m=dao.selectMemberId(session,userId);	
		session.close();
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
