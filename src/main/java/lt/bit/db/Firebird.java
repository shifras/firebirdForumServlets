package lt.bit.db;

import java.sql.*;




public class Firebird {
	private static Firebird firebird=null;
	private Connection connection=null;
	
	private Firebird() {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("org.firebirdsql.jdbc.FBDriver");
			//please change path to the file according to your local machine. Path must not be relative, but full path
			this.connection=DriverManager.getConnection("jdbc:firebirdsql://localhost:3050/<full path to the file>/forum.fdb","SYSDBA","masterkey");
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		if (firebird==null) {
			firebird=new Firebird();
		}
		return firebird.connection;
	}

}
