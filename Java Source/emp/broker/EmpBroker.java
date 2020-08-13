package emp.broker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class EmpBroker extends DBConnection{
	
public String checkEmployee(String empId){
	Connection con=null;
	String ename="";
	System.out.println("Testing inside Broker");
	try{
		PreparedStatement pstmt= (connect()).prepareStatement("SELECT ENAME FROM EMPLOYEE WHERE ENO=?");
		pstmt.setString(1,empId);
		ResultSet rs=pstmt.executeQuery();
			System.out.println("Testing inside Broker1");
		if(rs.next()){
			ename=rs.getString("ENAME");
		}
		System.out.println("Name:"+ename);
	}catch(Exception e){
	}		
	return ename;
}
}