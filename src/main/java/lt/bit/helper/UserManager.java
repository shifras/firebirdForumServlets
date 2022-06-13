package lt.bit.helper;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lt.bit.dao.UserDAO;
import lt.bit.models.User;

public class UserManager implements Serializable{
	private User user;
	
	
	public static UserManager login(String name, String password) {
		User user=new UserDAO().getUser(name);
		if (user==null) return null;
		
		if ( BCrypt.verifyer().verify(password.toCharArray(), user.getPassword()).verified ) {
				UserManager um=new UserManager();
				um.setUser(user);
				return um;
			
		}else {
			return null;
		}
		 
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}
	
	public static boolean isLoggedIn(HttpSession session) {
		return session.getAttribute("userManager")!=null;
	}
	

}
