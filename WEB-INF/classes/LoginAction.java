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


public final class LoginAction extends Action{  
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,  
		HttpServletResponse response) throws Exception {
	
   		DynaActionForm loginForm = (DynaActionForm) form;         
		String username = (String)loginForm.get("username");
		String password = (String)loginForm.get("password");
			System.out.println("username:        "+username);
			
   		ServletContext context = servlet.getServletContext();
		DataSource dataSource = (DataSource)context.getAttribute(Constants.DATASOURCE_KEY);
						
        DB db = new DB(dataSource);
        HttpSession session = request.getSession(true);
        
		String PageForward;
		ActionMessages errors = new ActionMessages();
        if (User.CheckUser(db,username,password)){
			User user = User.GetUserInfo(db,username);
			session.setAttribute(Constants.LOGIN_USERNAME_KEY,username);
			session.setAttribute(Constants.LOGIN_USER_INFO_KEY,user);
  			PageForward = "toOrderAddress";
        }
        else {
            errors.add(ActionMessages.GLOBAL_MESSAGE,
                           new ActionMessage("errors.needRegist"));
			if (!errors.isEmpty()) {
				saveErrors(request, errors);
			} 
 			PageForward="toWrong";  
        }	
		
        db.close();
 	  	return  mapping.findForward(PageForward);  
	}

}
