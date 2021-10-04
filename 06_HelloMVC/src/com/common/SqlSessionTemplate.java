package com.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {

	public static SqlSession getSession() {
		SqlSession session=null;
		String path="/mybatis-config.xml";
		try {
			InputStream is=Resources.getResourceAsStream(path);
			SqlSessionFactoryBuilder bulider=new SqlSessionFactoryBuilder();
			SqlSessionFactory factory=bulider.build(is);
			session=factory.openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}return session;
		
	}
}
