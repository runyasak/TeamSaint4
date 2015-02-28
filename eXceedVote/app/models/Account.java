package models;
import javax.persistence.*;

import play.*;
import play.db.ebean.Model;
import play.mvc.*;
import views.html.*;

@Entity
public class Account extends Model {
	
@Id
	public Long ID;
	public String Username;
	public String Password;
	public int type;
	public static Finder<Long,Account> find=new Finder<Long,Account>(Long.class,Account.class);
	public Account(String string, String string2, int i) {
		this.Username=string;
		this.Password=string2;
	}
	public static Account authenticate(String username,String password){
		
		
		return Account.find.where().eq("Username", username).eq("Password", password).findUnique(); 
		
	}
	
}
