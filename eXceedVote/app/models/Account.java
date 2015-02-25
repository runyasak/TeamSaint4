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
	
	
}
