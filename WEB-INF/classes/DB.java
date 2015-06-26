package BookStore;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {

	Connection connect = null;
	ResultSet rs = null;
	public DB(DataSource dataSource) {
		
		try {
			connect = dataSource.getConnection();
		}
		catch(SQLException e) {
			System.out.println("×Ö·û¼¯ÉèÖÃÊ§°Ü");
			e.printStackTrace();
		}
	}
	
	public ResultSet OpenSql(String sql) {
		try {
			Statement stmt = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			System.out.println("sql:        "+sql);
		} 
		catch(SQLException ex) { 
			System.out.println("sql:        "+sql);
			ex.printStackTrace();
		}
		return rs;
	}
	
	public int ExecSql(String sql) {
		int result = 0;
		try {
			Statement stmt = connect.createStatement();
			System.out.println("sql:        "+sql);
			result = stmt.executeUpdate(sql);
		} 
		catch(SQLException ex) { 
			System.out.println("sql:        "+sql);
			System.err.println(ex.getMessage());
			
		}
		return result;
	}
	
	public void close(){
		if(connect!=null){
			try{
				connect.close();
				connect = null;	
			}catch(SQLException ex) { 
				System.err.println(ex.getMessage());
			}
		}	
	}
}
