package com.board.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.rollback;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.board.model.dao.BoardDao;
import com.board.model.vo.Board;
import com.board.model.vo.BoardComment;

public class BoardService {
	private BoardDao dao=new BoardDao();
	public List<Board> selectBoard(int cPage, int numPerpage) {
		Connection conn = getConnection();
		List<Board> list =dao.selectBoard(conn,cPage,numPerpage);
		close(conn);
		
		
		return list;
	}
	public int BoardSearchCount() {
		Connection conn = getConnection();
		int result =dao.BoardSearchCount(conn);
		close(conn);
		return result;
	}
	public Board selectinfrom(int no, boolean readFlag) {
		Connection conn= getConnection();
		Board b =dao.selectinfrom(conn,no);
		if(b!=null&&!readFlag) {
			int result=dao.updateReadCount(conn,no);
			if(result>0) {
				commit(conn);
				b.setBoardReadcount(b.getBoardReadcount()+1);
			}
			else rollback(conn);
		}
		close(conn);
		return b;
	}
	public int insertBoard(Board b) {
		Connection conn=getConnection();
		int result =dao.insertBoard(conn,b);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public int boardDelete(int no) {
		Connection conn=getConnection();
		int result =dao.boardDelete(conn,no);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	public Board selectboard(int no) {
		Connection conn= getConnection();
		Board b =dao.selectinfrom(conn,no);
		close(conn);
		return b;
	}
	public int BoardUpdate(Board b) {
		Connection conn=getConnection();
		int result=dao.BoardUpdate(conn,b);
		if(result>0) commit(conn);
		else rollback(conn);
		
		return result;
	}
	public int insertCommnet(BoardComment bc) {
		Connection conn=getConnection();
		int result=dao.insertComment(conn,bc);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public List<BoardComment> selectBoardComment(int no) {
		Connection conn=getConnection();
		List<BoardComment> list=dao.selectBoardCommnet(conn,no);
		close(conn);
		return list;
	}
	public int BoardCommentDel(int no) {
		Connection conn =getConnection();
		int result=dao.BoardCommentDel(conn,no);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
	
		return result;
	}

	
}
