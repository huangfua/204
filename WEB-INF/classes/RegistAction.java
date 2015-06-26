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
import org.apache.struts.validator.DynaValidatorForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;


public final class RegistAction extends Action{  
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,  
		HttpServletResponse response) throws Exception {
		
	
   		DynaValidatorForm userForm = (DynaValidatorForm) form;         
		String username = (String)userForm.get("username");
		String password = (String)userForm.get("password");
		String name = (String)userForm.get("name");
		String tel = (String)userForm.get("tel");
		String address = (String)userForm.get("address");
		String email = (String)userForm.get("email");
		
   		ServletContext context = servlet.getServletContext();
		DataSource dataSource = (DataSource)context.getAttribute(Constants.DATASOURCE_KEY);
						
        DB db = new DB(dataSource);
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setTel(tel);
        user.setAddress(address);
        user.setEmail(email);

		String PageForward;
		ActionMessages errors = new ActionMessages();
        
        if (user.Insert(db)) {
			PageForward="toLogin";  //新用户注册成功
        }
        else{                       //新用户注册失败
            errors.add(ActionMessages.GLOBAL_MESSAGE,
                           new ActionMessage("errors.registFail"));
			if (!errors.isEmpty()) {
				saveErrors(request, errors);
			} 
 			PageForward="toWrong";
        } 
           	
		db.close();
  		return  mapping.findForward(PageForward);  
 	}
}