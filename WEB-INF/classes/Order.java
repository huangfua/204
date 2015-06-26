package BookStore;

import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class Order {  
	private int id = 0;	
	private String username = null;	
	private String time = null;
	private String delivery = null;	
	private String payment = null;
	private float total = 0;	
	 
	public Order(){}
	
	public void setId(int id) {
		this.id = id;
	}
	  
	public int getId() {
		return id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	  
	public String getUsername() {
		return username;
	}
	  
	public void setTime(String time) {
		this.time = time;
	}
	  
	public String getTime() {
		return time;
	}
	
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	  
	public String getDelivery() {
		return delivery;
	}
	
	public void setPayment(String payment) {
		this.payment = payment;
	}
	  
	public String getPayment() {
		return payment;
	}
	
	public void setTotal(float total) {
		this.total = total;
	}
	  
	public float getTotal() {
		return total;
	}
	
	public int Insert(DB db) throws Exception{
        String strSql;
		ResultSet rs;
		int iMaxId;
        strSql = "Select max(id) From orders";
		rs = db.OpenSql(strSql);  
		if ( rs.next()) {
			iMaxId=rs.getInt(1)+1;
		}
		else{
			iMaxId=1;
		}
        
        strSql = "insert into orders values(" 
				+ iMaxId 	+",'"
        		+ username 	+"',sysdate,'"
				+ delivery 	+"','"
				+ payment	+"')";
		if ( db.ExecSql(strSql)==0) {
			return -1;
		}
		else{
			return iMaxId;
		}
	}
	
	public float GetOrderTotal(DB db) throws Exception{
        String strSql;
		ResultSet rs;
		int iResult=0;
        strSql = "Select sum(count*price) From orderdetail where orderid=" + id ;
		rs = db.OpenSql(strSql);  
		if ( rs.next()) {
			iResult=rs.getInt(1);
		}
		return iResult;
	}

	public static Vector SearchOrder(DB db,String username) throws Exception{
		Vector orderList = new Vector();
        String strSql;
		ResultSet rs;
		int iResult=0;
        strSql = "Select * From orders where username='" + username + "'";
		rs = db.OpenSql(strSql);  
		while  (rs.next()){
			Order order = new Order();
			
			order.setId(rs.getInt("id")) ;
			order.setTime(rs.getString("time")) ;
			order.setTotal(order.GetOrderTotal(db)) ;
			
			orderList.add(order);
		}
		return orderList;
	}

	public static boolean Delete(DB db,int orderId) throws Exception{
        String strSql;
        strSql = "delete from orders where id='"+orderId+"'";
		if ( db.ExecSql(strSql)==0) {
			return false;
		}
		else{
			return true;
		}
	}	
		
}