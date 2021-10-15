package co.micol.prj.En;



import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	private static DataSource dataSource;
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private DataSource() {
		getProperty();
	}
	
	public static DataSource getInstance() {
		dataSource = new DataSource();
		return dataSource;
	}
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	private void getProperty() {
		String resource = "db.properties";
		Properties properties = new Properties();
		try {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resource);
		properties.load(inputStream);
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
