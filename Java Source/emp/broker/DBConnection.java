package emp.broker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	Connection con=null;
	public Connection connect() throws SQLException,ClassNotFoundException  {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D:emp.MDB", "","");
     //   Connection con=DriverManager.getConnection("jdbc:odbc:ddate");
       return con;
	}
}
