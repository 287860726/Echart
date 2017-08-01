package com.zhao.www.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;

public class BaseDao {
	protected Connection connection;
	protected String driver = "com.mysql.jdbc.Driver"; // 驱动包名称
	protected String url = "jdbc:mysql://127.0.0.1:3306/qxntvms?useUnicode=true&characterEncoding=UTF-8"; // url指向要访问数据库名jzsoft
	protected String user = "root"; // 数据库用户名
	protected String pwd = "123456"; // 数据库密码

	public Connection getConnection() throws Exception {
		this.OpenConncetion();
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void OpenConncetion() throws Exception {
		try {
			if (connection == null || connection.isClosed()) {

				Class.forName(driver);
				connection = (Connection) DriverManager.getConnection(url, user, pwd);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 此处的异常，不需抛出，只需要记录
	 */
	public void closeConnection() {

		if (connection != null) {
			try {
				if (!connection.isClosed())
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void beginTransaction() throws Exception {
		this.OpenConncetion();
		this.connection.setAutoCommit(false);
	}

	public void commit() throws Exception {

		if (this.connection != null)
			this.connection.commit();

	}

	public void rollback() throws Exception {
		if (this.connection != null) {
			this.connection.rollback();
		}
	}
}
