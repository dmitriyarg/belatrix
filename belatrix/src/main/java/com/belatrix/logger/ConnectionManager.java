package main.java.com.belatrix.logger;

import java.rmi.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class ConnectionManager {

	public static Connection getConexion(Map<String, String> dbParams) throws SQLException {
		Connection connection = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", dbParams.get("userName"));
		connectionProps.put("password", dbParams.get("password"));

		connection = DriverManager.getConnection("jdbc:" + dbParams.get("dbms") + "://" + dbParams.get("serverName")
				+ ":" + dbParams.get("portNumber") + "/", connectionProps);
		return connection;
	}

	public static void closeDbConnection(Connection con) throws Exception {
		if (con != null) {
			if (!con.isClosed()) {
				try {
					con.close();
				} catch (Exception e) {
					throw new ConnectException("Error to close DB connection");
				}
			}
		}
	}
}
