package com.kh.test.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TestDao {

	public List<Test> selectList(){
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		List<Test> list =new ArrayList();
		Test t =null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.3:1521:xe","kh","kh");
			conn.setAutoCommit(false);		
			String sql ="select * from test";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				t=new Test();
				t.setNumber(rs.getInt("number"));
				t.setTitle(rs.getString("title"));
				t.setWriter(rs.getString("writer"));
				t.setRegdate(rs.getDate("regdate"));
				t.setContent(rs.getString("content"));
				list.add(t);
			}
			
		} catch (SQLException e) {
				e.printStackTrace();			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
		       try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	                if( rs != null && !rs.isClosed()){
	                    rs.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
		}return list;							
	} 
	
}
