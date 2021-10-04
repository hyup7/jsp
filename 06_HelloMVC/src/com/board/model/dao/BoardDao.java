package com.board.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.board.model.vo.Board;
import com.board.model.vo.BoardComment;

public class BoardDao {
	
	private Properties prop=new Properties();
	public BoardDao() {
		// TODO Auto-generated constructor stub
		String path = BoardDao.class.getResource("/sql/board_sql.properties").getPath();
		try {
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
			

		public List<Board> selectBoard(Connection conn, int cPage, int numPerpage) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			List<Board> list =new ArrayList();
			Board b =null;
			
			try {
				pstmt=conn.prepareStatement(prop.getProperty("boardeselect"));
				pstmt.setInt(1, (cPage-1)*numPerpage+1);
				pstmt.setInt(2, cPage*numPerpage);
				rs=pstmt.executeQuery();
			
				while(rs.next()) {
				b=new Board();
				b.setBoardNo(rs.getInt("board_no"));
				b.setBoardTitle(rs.getString("board_title"));
				b.setBoardWriter(rs.getString("board_writer"));
				b.setBoardContent(rs.getString("board_content"));
				b.setBoardOriginalFilename(rs.getString("board_original_filename"));
				b.setBoardRenamedFilename(rs.getString("board_renamed_filename"));
				b.setBoardDate(rs.getDate("board_date"));
				b.setBoardReadcount(rs.getInt("board_readcount"));
				list.add(b);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
				
			}
			return list;
		}


		public int BoardSearchCount(Connection conn) {
			PreparedStatement pstmt=null;
			int result =0;
			ResultSet rs= null;
			
			try {
				pstmt=conn.prepareStatement(prop.getProperty("boardselectcount"));
				rs=pstmt.executeQuery();
				
				if(rs.next()) result=rs.getInt(1);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			
			return result;
		}


		public Board selectinfrom(Connection conn, int no) {
			PreparedStatement pstmt=null;
			ResultSet rs= null;
			Board b =new Board();
			
			try {
				pstmt=conn.prepareStatement(prop.getProperty("selectinfrom"));
				pstmt.setInt(1, no);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					b.setBoardNo(rs.getInt("board_no"));
					b.setBoardTitle(rs.getString("board_title"));
					b.setBoardWriter(rs.getString("board_writer"));
					b.setBoardContent(rs.getString("board_content"));
					b.setBoardOriginalFilename(rs.getString("board_original_filename"));
					b.setBoardRenamedFilename(rs.getString("board_renamed_filename"));
					b.setBoardDate(rs.getDate("board_date"));
					b.setBoardReadcount(rs.getInt("board_readcount"));
				}
	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			
			return b;
		}


		public int updateReadCount(Connection conn, int no) {
			PreparedStatement pstmt=null;
			int result=0;
			try {
				pstmt=conn.prepareStatement(prop.getProperty("updateReadCount"));
				pstmt.setInt(1, no);
				result=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		}


		public int insertBoard(Connection conn, Board b) {
			PreparedStatement pstmt=null;
			int result=0;
			try {
				pstmt=conn.prepareStatement(prop.getProperty("insertboard"));
				pstmt.setString(1, b.getBoardTitle());
				pstmt.setString(2, b.getBoardWriter());
				pstmt.setString(3, b.getBoardContent());
				pstmt.setString(4, b.getBoardOriginalFilename());
				pstmt.setString(5, b.getBoardRenamedFilename());
				result=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		}


		public int boardDelete(Connection conn, int no) {		
				PreparedStatement pstmt=null;
				int result=0;
				
				try {
					pstmt=conn.prepareStatement(prop.getProperty("boarddelete"));
					pstmt.setInt(1, no);
					result=pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					close(pstmt);
				}
				
				return result;
			
		}


		public int BoardUpdate(Connection conn, Board b) {
			PreparedStatement pstmt=null;
			int result =0;
			
			try {
				pstmt=conn.prepareStatement(prop.getProperty("updateboard"));
				pstmt.setString(1, b.getBoardTitle());
				pstmt.setString(2, b.getBoardContent());
				pstmt.setString(3, b.getBoardOriginalFilename());
				pstmt.setString(4, b.getBoardRenamedFilename());
				pstmt.setInt(5, b.getBoardNo());
				result=pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			
			return result;
		}


		public int insertComment(Connection conn, BoardComment bc) {
			PreparedStatement pstmt=null;
			int result=0;
			
			try {
				pstmt=conn.prepareStatement(prop.getProperty("insertcomment"));
				pstmt.setInt(1, bc.getBoardCommentLevel());
				pstmt.setString(2, bc.getBoardCommentWriter());
				pstmt.setString(3, bc.getBoardCommentContent());
				pstmt.setInt(4, bc.getBoardRef());
//				pstmt.setInt(5, bc.getBoardCommentRef());
				pstmt.setString(5, bc.getBoardCommentRef()==0?null:String.valueOf(bc.getBoardCommentRef()));
				result=pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		}


		public List<BoardComment> selectBoardCommnet(Connection conn, int no) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			List<BoardComment> list =new ArrayList();
			BoardComment bc=null;
			
			try {
				pstmt=conn.prepareStatement(prop.getProperty("selectboardcomment"));
				pstmt.setInt(1, no);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					bc=new BoardComment();
					bc.setBoardRef(rs.getInt("board_ref"));
					bc.setBoardCommentRef(rs.getInt("board_comment_ref"));
					bc.setBoardCommentNo(rs.getInt("board_comment_no"));
					bc.setBoardCommentLevel(rs.getInt("board_comment_level"));
					bc.setBoardCommentContent(rs.getString("BOARD_COMMENT_CONTENT"));
					bc.setBoardCommentDate(rs.getDate("BOARD_COMMENT_DATE"));
					bc.setBoardCommentWriter(rs.getString("BOARD_COMMENT_WRITER"));
					
					list.add(bc);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return list;
		}


		public int BoardCommentDel(Connection conn, int no) {
			PreparedStatement pstmt =null;
			int result =0;
			
			try {
				pstmt=conn.prepareStatement(prop.getProperty("commentdel"));
				
				result=pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
		}
}