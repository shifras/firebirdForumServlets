package lt.bit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lt.bit.db.MySQL;
import lt.bit.models.User;

public class UserDAO {
	public UserDAO() {
		
	}
	
	public User getUser(String name) {
		PreparedStatement s;
		try {
			s=MySQL.getConnection().prepareStatement("SELECT * FROM users WHERE name like ?");
			s.setString(1, name);
			ResultSet r=s.executeQuery();
			if ( ! r.next() ) return null;
			
			return new User(r.getInt("id"), r.getString("name"), r.getString("password"));
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return null;
	}
	

}
