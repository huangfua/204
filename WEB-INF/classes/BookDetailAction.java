
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

public final class BookDetailAction extends Action{  
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,  
		HttpServletResponse response) throws Exception {
			
   		DynaActionForm bookIdForm = (DynaActionForm) form;         
		Integer bookId = (Integer)bookIdForm.get("bookId");
		
        HttpSession session = request.getSession();
		Book book = new Book();
		
   		ServletContext context = servlet.getServletContext();
		DataSource dataSource = 
			(DataSource)context.getAttribute(Constants.DATASOURCE_KEY);
						
        DB db = new DB(dataSource);

        book = Book.GetDetail(db,bookId.intValue());
		session.setAttribute(Constants.BOOK_DETAIL_KEY,book);
		db.close();
	   	return (mapping.findForward("toBookDetail"));					
 	}	
}