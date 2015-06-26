
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

public final class AddrConfirmAction extends Action{  
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,  
		HttpServletResponse response) throws Exception {
			
   		DynaActionForm deliveryForm = (DynaActionForm) form;         
		String delivery = (String)deliveryForm.get("deliv");
		String payment = (String)deliveryForm.get("payment");
		
   		ServletContext context = servlet.getServletContext();
		DataSource dataSource = (DataSource)context.getAttribute(Constants.DATASOURCE_KEY);
        DB db = new DB(dataSource);
        
        HttpSession session = request.getSession();
   		Vector shopCartList=(Vector)session.getAttribute(Constants.BOOK_SHOPCART_KEY);
						
		String PageForward;
		ActionMessages errors = new ActionMessages();
		if (shopCartList==null||shopCartList.size()==0){
            errors.add(ActionMessages.GLOBAL_MESSAGE,
                           new ActionMessage("errors.nullShopCart"));
			if (!errors.isEmpty()) {
				saveErrors(request, errors);
			} 
 			PageForward="toWrong";  
			
		}
		else{
			Order order = new Order();
			order.setUsername ((String)session.getAttribute(Constants.LOGIN_USERNAME_KEY));
			order.setDelivery(delivery);
			order.setPayment(payment);
			ShopCart shopCart = new ShopCart();
		
			int orderId=order.Insert(db);
			if (orderId==-1){
            	errors.add(ActionMessages.GLOBAL_MESSAGE,
                           new ActionMessage("errors.insertFail"));
				if (!errors.isEmpty()) {
					saveErrors(request, errors);
				} 
 				PageForward="toWrong";  
			}
			else{
       			order.setId(orderId);
				session.setAttribute(Constants.BOOK_ORDER_KEY,order);
       			if(shopCartList!=null){
       				for(int i = 0; i < shopCartList.size() ;i++){
       					shopCart = (ShopCart)shopCartList.get(i);
       					shopCart.Save(db,orderId);
       				}
				}
				order.setTotal(order.GetOrderTotal(db));
				Vector orderDetail=(Vector)shopCartList.clone();
				session.setAttribute(Constants.ORDER_DETAIL_KEY,orderDetail);
				shopCartList.clear();				
 				PageForward="toOrderConfirm";  
			}
	   	}					
		db.close();
	   	return (mapping.findForward(PageForward));
 	}
 	
}