package BookStore;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.RequestProcessor;

import org.apache.struts.config.ForwardConfig;
import org.apache.commons.logging.Log;


public class MyRequestProcessor extends RequestProcessor {
	
	public MyRequestProcessor() {}
	
protected boolean processPreprocess( HttpServletRequest request,
                                     HttpServletResponse response ){
 
 try{
  	request.setCharacterEncoding("gb2312");
	
 }
 catch(Exception ex){
	System.out.println("×Ö·û¼¯ÉèÖÃÊ§°Ü");
 	
 }
 
 return true;
}

}