package BookStore;

import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class User {  
	private String username = null;	
	private String password = null;	
	private String name = null;	
	private String tel = null;	
	private String address = null;	
	private String email = null;
	
	 
	public User(){}
	public void setUsername(String username) {
		this.username = username;
	}
	  
	public String getUsername() {
		return username;
	}
	  
	public void setPassword(String password) {
		this.password = password;
	}
	  
	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}
	  
	public String getName() {
		return name;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	  
	public String getTel() {
		return tel;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	  
	public String getAddress() {
		return address;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	  
	public String getEmail() {
		return email;
	}
	
	public static boolean CheckUser(DB db,String name,String psw) throws Exception{
        String strSql;
		ResultSet rs;
        strSql = "select * from storeuser where username='"
					+ name + "' and password='" + psw + "'";
		rs = db.OpenSql(strSql);  
		if ( rs.next()) {
			return true;
		}
		else{
			return false;
		}
	
	}
	
	public  static User GetUserInfo(DB db,String name) throws Exception{
        String strSql;
		ResultSet rs;
        strSql = "select * from storeuser where username='"
					+ name + "'";
		rs = db.OpenSql(strSql);  
		User user = new User();
		if (rs.next()){
			
			user.setName(rs.getString("name")) ;
			user.setAddress(rs.getString("address")) ;
			user.setTel(rs.getString("tel")) ;
		}
		return user;
	}
	
	public boolean Insert(DB db) throws Exception{
        String strSql;
        strSql = "insert into storeuser values('" 
        		+ username 	+"','"
				+ password 	+"','"
				+ name 		+"','"
				+ tel 		+"','"
				+ address 	+"','"
				+ email     +"')";
		if ( db.ExecSql(strSql)==0) {
			return false;
		}
		else{
			return true;
		}
	}

}