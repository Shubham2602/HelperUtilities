package Resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBCOnn 
{
	public String connect(String query) throws SQLException
	{
		Connection con = DriverManager.getConnection("");
		PreparedStatement pr = con.prepareStatement("");
		
		ResultSet rs = pr.executeQuery();
		
		String ab=null;
		while(rs.next())
		{
			
			int colNum = rs.findColumn("Statement");
			ab = rs.getString(colNum);
			
		}
 		
 		return ab;
	}
	
	
}
