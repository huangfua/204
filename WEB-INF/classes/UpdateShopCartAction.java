
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

public final class UpdateShopCartAction extends Action{  
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,  
		HttpServletResponse response) throws Exception {
			
   		DynaActionForm bookShopCartForm = (DynaActionForm) form;         
		Integer[] count = (Integer[])bookShopCartForm.get("count");
		Integer[] del = (Integer[])bookShopCartForm.get("del");
		
        HttpSession session = request.getSession();
						
		ShopCart shopCart = new ShopCart();
   		Vector shopCartList=(Vector)session.getAttribute(Constants.BOOK_SHOPCART_KEY);
//更新数量
       	if(shopCartList!=null){
       		for(int i = 0; i < shopCartList.size() ;i++){
       			shopCart = (ShopCart)shopCartList.get(i);
       			shopCart.setCount(count[i].intValue());
       			shopCartList.set(i,shopCart);
			}
//删除        
       		for(int i = shopCartList.size()-1;i >=0 ;i--){
       			shopCart = (ShopCart)shopCartList.get(i);
       			for(int j = 0;j < del.length;j++){
     				if (shopCart.getId()==del[j].intValue()){
     					shopCartList.remove(i);
     				}
				}
			}
			session.setAttribute(Constants.BOOK_SHOPCART_KEY,shopCartList);
       	}
	   	return (mapping.findForward("toBookShopCart"));					
 	}
 	
}