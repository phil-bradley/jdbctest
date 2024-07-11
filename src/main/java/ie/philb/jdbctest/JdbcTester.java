package ie.philb.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcTester {

	private String login = "";
	private String password = "";
	private String url = "";
	private DataSource dataSource;

	public JdbcTester(String login, String password, String url) {
		this.login = login;
		this.password = password;
		this.url = url;
		
		this.dataSource = getDataSource();
	}

	
	public void runTestQuery() {

		String sql = "select 1 from sysibm.sysdummy1";
		
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed test query --> " + sql + "<--");
		
	}
	
	private HikariDataSource getDataSource() {
		System.out.println("Creating Hikari Datasource...");
		HikariConfig config = getConfig();
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}
	
	private HikariConfig getConfig() {
		System.out.println("Creating Hikari config...");
		HikariConfig config = new HikariConfig();
		config.setUsername(login);
		config.setPassword(password);
		config.setJdbcUrl(url);
		config.setDriverClassName("com.ibm.as400.access.AS400JDBCDriver");
		
		return config;
	}

}
