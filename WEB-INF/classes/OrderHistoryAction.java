
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

public final class OrderHistoryAction extends Action{  
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,  
		HttpServletResponse response) throws Exception {
			
   		ServletContext context = servlet.getServletContext();
		DataSource dataSource = (DataSource)context.getAttribute(Constants.DATASOURCE_KEY);
        DB db = new DB(dataSource);
        
        HttpSession session = request.getSession();
		String username = (String)session.getAttribute(Constants.LOGIN_USERNAME_KEY);
        Vector orderList = new Vector();
		orderList = Order.SearchOrder(db,username);
		session.setAttribute(Constants.ORDER_LIST_KEY,orderList);
		db.close();
	   	return (mapping.findForward("toOrderHistory"));					
 	}
 	
}