package BookStore;

import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class ShopCart extends Book{  
	private int count = 0;
	 
	public ShopCart(){}
	
	public void setCount(int count) {
		this.count = count;
	}
	  
	public int getCount() {
		return count;
	}
	
	public boolean Save(DB db,int orderId) throws Exception{
        String strSql;
        
        strSql = "insert into orderDetail values(" 
				+ orderId 	+","
        		+ getId() 		+","
				+ count 	+","
				+ getSalePrice()	+")";
		if ( db.ExecSql(strSql)==0) {
			return false;
		}
		else{
			return true;
		}
	}
}