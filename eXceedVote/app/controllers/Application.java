package controllers;




import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*; 
import views.html.*;
import models.*;

public class Application extends Controller {

    public static Result index() {
    	Account a = new Account ("aaa@aaa","bbb",1);
    	a.save();
        return ok(index.render("a"));
    }
    public static Result login(){
    	return ok(login.render(Form.form(Login.class)));
    	
    }
    public static Result authenticate(){
    	Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
    	if(loginForm.hasErrors()){
    		return badRequest(login.render(loginForm));
    		
    	}else{
    		session().clear();
    		session("email",loginForm.get().email);
    		return redirect(routes.Application.index());	
    			
    	}
    
    	
    }
    
    public static class Login{
    	public String email;
    	public String password;
    	public String validate(){
    		if(Account.authenticate(email,password)==null){
    			return "Invalid user or password";
    			
    			
    		}
    		return null;
    		
    		
    	}
    	
    }

}
