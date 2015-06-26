package BookStore;

import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class ShopCartForm {  
	private String[] count;	
	private String[] del;	
	 
	public Book(){}
	
	public void setId(int count) {
		this.count = count;
	}
	  
	public int getId() {
		return id;
	}
	
	public void setCatId(int catId) {
		this.catId = catId;
	}
	  
	public int getCatId() {
		return catId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	  
	public String getName() {
		return name;
	}
	  

	public void setPrice(float price) {
		this.price = price;
	}
	  
	public float getPrice() {
		return price;
	}
	
	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}
	  
	public float getSalePrice() {
		return salePrice;
	}
	
	public void setDescript(String descript) {
		this.descript = descript;
	}
	  
	public String getDescript() {
		return descript;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	  
	public String getAuthor() {
		return author;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	  
	public String getContents() {
		return contents;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	  
	public String getImage() {
		return image;
	}
	
	public static Vector SearchBook(DB db,int mode,int bookCat,String field,String keyword) throws Exception{
		Vector bookList = new Vector();
		ResultSet rs;
        String strSql=null;
        String sField=null;
       if (mode==1 ) {
        	strSql = "select * from book where catid=" + bookCat;
       }
       else{
        	if (field.equals("1")) sField="name";
        	else if(field.equals("2")) sField="author";
        	
        	strSql = "select * from book where " + sField +" like '%" + keyword +"%' order by id";
       }
       			
/*        if (bookCat==0 ) {
        	strSql = "select * from book where 1=1 ";
        }
        else{
        	strSql = "select * from book where catid=" + bookCat;
        }
        
        if (keyword==null||keyword==""){
        	strSql = strSql + " order by id";
        }
        else{
        	if (field.equals("1")) sField="name";
        	else if(field.equals("2")) sField="author";
        	
        	strSql = strSql	+ " and " + sField +" like '%" + keyword +"%' order by id";
        }
*/        
		rs = db.OpenSql(strSql);
		
		while  (rs.next()){
			Book book = new Book();
			
			book.setId(rs.getInt("id")) ;
			book.setName(rs.getString("name")) ;
			book.setAuthor(rs.getString("author")) ;
			book.setPrice(rs.getInt("price")) ;
			book.setSalePrice(rs.getInt("saleprice")) ;
			
			bookList.add(book);
		}
		System.out.println("bookList:        "+bookList.size());
					
		return bookList;
	}
	
	public static Book GetDetail(DB db,int bookId) throws Exception{
		ResultSet rs;
        String strSql=null;
        String rplContent=null;
		
        strSql = "select * from book where id=" + bookId;
		rs = db.OpenSql(strSql);
		Book book = new Book();
		if (rs.next()){
			
			book.setId(rs.getInt("id")) ;
			book.setName(rs.getString("name")) ;
			book.setAuthor(rs.getString("author")) ;
			book.setPrice(rs.getInt("price")) ;
			book.setSalePrice(rs.getInt("saleprice")) ;
			book.setImage(rs.getString("image")) ;
			
			rplContent = rs.getString("descript");
			rplContent = rplContent.replaceAll("\n","<br>");
			book.setDescript(rplContent) ;
			
			rplContent = rs.getString("contents");
			rplContent = rplContent.replaceAll("\n","<br>");
			book.setContents(rplContent) ;
			
		}
		return book;
	}
	
	public static int GetBookCount(DB db,int mode,int bookCat,String field,String keyword) throws Exception{
		ResultSet rs;
        String strSql=null;
        String sField=null;
        int iRecordCount=0;
       	if (mode==1 ) {
        	strSql = "select  count(*) from book where catid=" + bookCat;
       	}
       	else{
        	if (field.equals("1")) sField="name";
        	else if(field.equals("2")) sField="author";
        	
        	strSql = "select  count(*) from book where " + sField +" like '%" + keyword +"%' order by id";
       	}
       			
		rs = db.OpenSql(strSql);
		if ( rs.next()) {
			iRecordCount=rs.getInt(1);
		}
		return iRecordCount;
	}
		

		
}