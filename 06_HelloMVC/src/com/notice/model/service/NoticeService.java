package com.notice.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.notice.model.dao.NoticeDao;
import com.notice.model.vo.Notice;

public class NoticeService {
	private NoticeDao dao =new NoticeDao();
	public List<Notice> selectNotice(int cPage, int numPerpage) {
		Connection conn=getConnection();
		List<Notice> list=dao.selectNotice(conn,cPage,numPerpage);
		close(conn);
		return list;
		
	}
	public int NoticeSearchCount() {
		Connection conn=getConnection();
		int result=dao.selectNoticerCount(conn);
		close(conn);
		return result;
	}
	public Notice NoticeView(int no) {
			Connection conn=getConnection();
			Notice n =dao.NoticeView(conn,no);
			close(conn);
			
		return n;
	}
	public int InsertNotice(Notice n) {
		Connection conn=getConnection();
		int result=dao.insertNotice(conn,n);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}
	public int noticeDelete(int no) {
		Connection conn=getConnection();
		int result=dao.noticeDelete(conn,no);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public int noticeUpdate(Notice n) {
		Connection conn=getConnection();
		int result=dao.noticeUpdate(conn,n);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}

