
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

public final class BookBuyAction extends Action{  
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,  
		HttpServletResponse response) throws Exception {
			
   		DynaActionForm bookIdForm = (DynaActionForm) form;         
		Integer bookId = (Integer)bookIdForm.get("bookId");
		
        HttpSession session = request.getSession();
   		ServletContext context = servlet.getServletContext();
		DataSource dataSource = 
			(DataSource)context.getAttribute(Constants.DATASOURCE_KEY);
						
        DB db = new DB(dataSource);
		String PageForward;
        
		ShopCart compareShopCart = new ShopCart();
   		Vector shopCartList=(Vector)session.getAttribute(Constants.BOOK_SHOPCART_KEY);
		if (shopCartList==null) {
			shopCartList = new Vector();
		}
		ActionMessages errors = new ActionMessages();
		boolean bBought=false;
    	if(shopCartList != null ){
       		for(int i = 0;i < shopCartList.size();i++){
       			compareShopCart = (ShopCart)shopCartList.get(i);
     			if (compareShopCart.getId()==bookId.intValue()){
     				bBought=true;
     			}
     		}
     	}
		
		if (!bBought){
			Book book = new Book();
			book = Book.GetDetail(db,bookId.intValue());
			
			ShopCart shopCart = new ShopCart();
			
			shopCart.setId(bookId.intValue());
			shopCart.setName(book.getName());
			shopCart.setSalePrice(book.getSalePrice());
			shopCart.setCount(1);
			shopCartList.addElement(shopCart);
			session.setAttribute(Constants.BOOK_SHOPCART_KEY,shopCartList);
 			PageForward="toBookShopCart"; 
 			 
		}
		else{
            errors.add(ActionMessages.GLOBAL_MESSAGE,
                           new ActionMessage("errors.alreadyBought"));
			if (!errors.isEmpty()) {
						saveErrors(request, errors);
			} 
 			PageForward="toWrong";  
		}
		
		db.close();
	   	return (mapping.findForward(PageForward));					
 	}	
}