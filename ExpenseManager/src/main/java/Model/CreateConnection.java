package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



//singleton design pattern
public class CreateConnection {
	
	static Connection connection=null;

	private String url="jdbc:mysql://localhost:3306/advancejavaservlet";
	private String userName="root";
	private String password="hrutik";
	
	//private constructor created
	private CreateConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,userName,password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//method created
	public static Connection createConnection() {
		if(connection==null){
			new CreateConnection();
		}
		return connection;
	}
}
