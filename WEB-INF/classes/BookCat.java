package BookStore;

import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class BookCat {  
	private int id = 0;	
	private String name = null;	
	 
	public BookCat(){}
	
	public void setId(int id) {
		this.id = id;
	}
	  
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	  
	public String getName() {
		return name;
	}
		
	public static Vector Search(DB db) throws Exception{
		Vector catList = new Vector();
		ResultSet rs;
        String strSql=null;
        strSql = "select * from bookcat ";
        	
		rs = db.OpenSql(strSql);
		
		while  (rs.next()){
			BookCat bookCat = new BookCat();
			
			bookCat.setId(rs.getInt("id")) ;
			bookCat.setName(rs.getString("catname")) ;
			
			catList.add(bookCat);
		}
		return catList;
	}
	
	public static int GetFirstBookCat(DB db) throws Exception{
		ResultSet rs;
        String strSql=null;
        
        strSql = "select * from bookcat";
		rs = db.OpenSql(strSql);
		
		if (rs.next()){
			return rs.getInt("id");
		}
		else			
			return 0;
	}
}