package BookStore;

import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class SearchStatus {  
	private int mode = 0;	
	private int catId = 0;	
	private String key = null;	
	private String field = null;	
	private int pageId = 0;	
	private int pageCount = 0;	
	private int bookCount = 0;	
	 
	public SearchStatus(){}
	
	public void setMode(int mode) {
		this.mode = mode;
	}
	  
	public int getMode() {
		return mode;
	}
	
	public void setCatId(int catId) {
		this.catId = catId;
	}
	  
	public int getCatId() {
		return catId;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	  
	public String getKey() {
		return key;
	}
	  
	public void setField(String field) {
		this.field = field;
	}
	  
	public String getField() {
		return field;
	}
	  
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	  
	public int getPageId() {
		return pageId;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	  
	public int getPageCount() {
		return pageCount;
	}
	
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	  
	public int getBookCount() {
		return bookCount;
	}
	
}