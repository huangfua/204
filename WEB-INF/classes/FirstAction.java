package BookStore;

import javax.sql.DataSource;
import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import java.util.Vector;
import org.apache.struts.action.DynaActionForm;

public final class FirstAction extends Action{  
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,  
		HttpServletResponse response) throws Exception {
	
   		DynaActionForm bookSearchForm = (DynaActionForm) form;         
		
		Integer mode = null;
		Integer bookCatId = null;
		String key = null;
		String field = null;
		if (bookSearchForm!=null){
			mode = (Integer)bookSearchForm.get("mode");
			bookCatId = (Integer)bookSearchForm.get("bookCatId");
			key = (String)bookSearchForm.get("key");
			field = (String)bookSearchForm.get("field");
		}
		
   		ServletContext context = servlet.getServletContext();
		DataSource dataSource = (DataSource)context.getAttribute(Constants.DATASOURCE_KEY);
        DB db = new DB(dataSource);
        
		SearchStatus schSta = new SearchStatus();
		int iMode = mode.intValue();
		schSta.setMode(iMode);
		int iCatId=0; 
		if (iMode==0){
			iCatId = BookCat.GetFirstBookCat(db);
			schSta.setCatId(iCatId);
		}
		else if (iMode==1){
			iCatId= bookCatId.intValue();
			schSta.setCatId(iCatId);
		}
		else if (iMode==2){
			schSta.setKey(key);
			schSta.setField(field);
		}
		
        int bookCount = Book.GetBookCount(db);
		int iPageCount;
		if (bookCount%Constants.BOOK_PAGE_SIZE==0) {
			iPageCount = bookCount/Constants.BOOK_PAGE_SIZE;
		}
		else{
			iPageCount = bookCount/Constants.BOOK_PAGE_SIZE+1;
		}
		
		schSta.setBookCount(bookCount);
		schSta.setPageCount(iPageCount);
		
        Vector bookList = new Vector();
        HttpSession session = request.getSession();
        
		session.setAttribute(Constants.BOOK_CAT_LIST_KEY,BookCat.Search(db));
		
		bookList = Book.SearchBook(db,iCatId,field,key);
		session.setAttribute(Constants.BOOK_LIST_KEY,bookList);
		session.setAttribute(Constants.BOOK_SEARCH_STATUS_KEY,schSta);
			
		db.close();
	   	return (mapping.findForward("toBookMain"));					
 	}

}
