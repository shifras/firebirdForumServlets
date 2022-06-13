package lt.bit.dao;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import lt.bit.db.Firebird;
import lt.bit.models.Message;

public class MessageDao {

	public MessageDao() {
		
	}
	
	public List<Message> getMessages() {
		PreparedStatement ps;
		try {
			ps = Firebird.getConnection().prepareStatement("SELECT * FROM messages");
			ResultSet rs = ps.executeQuery();
			List<Message> messages = new LinkedList<>();
			while (rs.next()) {
				messages.add(
						new Message(
								rs.getInt("ID"), 
								rs.getString("DATE_CREATED"), 
								rs.getString("CONTENT"),
								rs.getString("USERNAME")
						));
			}
			return messages;

		} catch (SQLException e) {
			System.out.println("iviko eroras");
			e.printStackTrace();
		}
		return null;
	}
	
	public void addMessage(Message message) {
		PreparedStatement s;
		try {
			
			s = Firebird.getConnection().prepareStatement("INSERT INTO messages ( DATE_CREATED, USERNAME, CONTENT) VALUES (?, ?,?)");

			s.setString(1, message.getDateCreated());
			s.setString(2, message.getUsername());
			s.setString(3, message.getContent());
			s.execute();
			
			
		} catch (SQLException e) {
			System.out.println("iviko eroras pridedant zinute");
			e.printStackTrace();
		}
	}
}
