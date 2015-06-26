
package BookStore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import javax.servlet.ServletContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;
import javax.servlet.http.*;

public final class OrderDelAction extends Action{  
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,  
		HttpServletResponse response) throws Exception {
			
   		DynaActionForm orderIdForm = (DynaActionForm) form;         
		Integer orderId = (Integer)orderIdForm.get("orderId");
		
        HttpSession session = request.getSession();
		String username = (String)session.getAttribute(Constants.LOGIN_USERNAME_KEY);
        Vector orderList = new Vector();
		
   		ServletContext context = servlet.getServletContext();
		DataSource dataSource = 
			(DataSource)context.getAttribute(Constants.DATASOURCE_KEY);
						
        DB db = new DB(dataSource);
        
		String PageForward;
		ActionMessages errors = new ActionMessages();
		if (Order.Delete(db,orderId.intValue())){
		
			orderList = Order.SearchOrder(db,username);
			session.setAttribute(Constants.ORDER_LIST_KEY,orderList);
			PageForward="toOrderHistory";					
		}
		else{
            errors.add(ActionMessages.GLOBAL_MESSAGE,
                           new ActionMessage("errors.deleteFail"));
			if (!errors.isEmpty()) {
				saveErrors(request, errors);
			} 
 			PageForward="toWrong";  
		}
		
		db.close();
	   	return (mapping.findForward(PageForward));					
		
 	}	
}