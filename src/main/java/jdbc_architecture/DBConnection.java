package jdbc_architecture;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection{

	public static Connection getConnection() {

		String url = "jdbc:postgresql://localhost:5432/Employee";
		String user = "postgres";
		String pwd = "tiger";

		Connection con = null;

		try {
			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection(url, user, pwd);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}