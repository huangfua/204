
package BookStore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public final class ClearShopCartAction extends Action{  
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,  
		HttpServletResponse response) throws Exception {
			
        HttpSession session = request.getSession();
						
   		Vector shopCartList=(Vector)session.getAttribute(Constants.BOOK_SHOPCART_KEY);
       	if(shopCartList!=null){
			shopCartList.clear();
			session.setAttribute(Constants.BOOK_SHOPCART_KEY,shopCartList);
       	}
	   	return (mapping.findForward("toBookShopCart"));					
 	}
 	
}