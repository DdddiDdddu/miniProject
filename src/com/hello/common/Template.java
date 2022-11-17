package com.hello.common;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {
	
	// remix 혼용방식 사용
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	private static String USER = "mini";
	private static String PASSWORD = "mini"; 
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSession getSqlSession() {

		if (sqlSessionFactory == null) {
			
			Environment environment = new Environment("dev", new JdbcTransactionFactory(),
					new PooledDataSource(DRIVER, URL, USER, PASSWORD));

			Configuration configuration = new Configuration(environment);

			configuration.addMapper(UimsMapper.class);

			sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
			
		}
		return sqlSessionFactory.openSession(false);
	}
}
