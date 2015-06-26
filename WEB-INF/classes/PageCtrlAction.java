package BookStore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import javax.servlet.ServletContext;
import javax.sql.DataSource;
import java.sql.Connection;
import javax.servlet.http.*;
import java.util.*;
import org.apache.struts.action.DynaActionForm;


public final class PageCtrlAction extends Action{  
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,  
		HttpServletResponse response) throws Exception {
	
		DynaActionForm pageIdForm = (DynaActionForm) form;         
		Integer pageId = (Integer)pageIdForm.get("pageId");
		int iPageId = 0;
		if (pageId!=null) iPageId = pageId.intValue();
		if (iPageId<0) iPageId = 0;

   		ServletContext context = servlet.getServletContext();
		DataSource dataSource = (DataSource)context.getAttribute(Constants.DATASOURCE_KEY);
						
        DB db = new DB(dataSource);
        HttpSession session = request.getSession(true);
		Vector bookList = new Vector();
		
		SearchStatus schSta = new SearchStatus();
		schSta = (SearchStatus)session.getAttribute(Constants.BOOK_SEARCH_STATUS_KEY);
		
		String PageForward;
		ActionMessages errors = new ActionMessages();
		
		if (schSta.getBookCount()==0){
  			PageForward="toBookMain";  
        }
        else
        if (schSta.getBookCount()<iPageId * Constants.BOOK_PAGE_SIZE + 1){
        	iPageId--;
            errors.add(ActionMessages.GLOBAL_MESSAGE,
                           new ActionMessage("errors.pageEnd"));
			if (!errors.isEmpty()) {
				saveErrors(request, errors);
			} 
 			PageForward="toWrong";  
		}
		else{
			schSta.setPageId(iPageId);
			bookList = Book.SearchBook(db,schSta.getMode(),schSta.getCatId(),schSta.getField(),schSta.getKey());
			session.setAttribute(Constants.BOOK_LIST_KEY,bookList);
			session.setAttribute(Constants.BOOK_SEARCH_STATUS_KEY,schSta);
  			PageForward="toBookMain";  
       }
        
		db.close();
 	  	return  mapping.findForward(PageForward);  
	}

}
