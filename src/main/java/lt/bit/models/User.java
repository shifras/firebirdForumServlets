package lt.bit.models;



public class User {

	
	private Integer id;
	
	
	private String username;
	
	
	private String password = "";
	
	
	private String role = "user";
	
	
	private Integer messageQty = 0;
	
	
	private Integer firstMessageId;

	
	private Integer lastMessageId;
	
	public User() {
		super();
	}
	
	public User(Integer id, String username, String password, String role, Integer messageQty, Integer firstMessageId, Integer lastMessageId) 
	{
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.messageQty = messageQty;
		this.firstMessageId = firstMessageId;
		this.lastMessageId = lastMessageId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getMessageQty() {
		return messageQty;
	}

	public void setMessageQty(Integer messageQty) {
		this.messageQty = messageQty;
	}



	public Integer getFirstMessageId() {
		return firstMessageId;
	}



	public void setFirstMessageId(Integer firstMessageId) {
		this.firstMessageId = firstMessageId;
	}



	public Integer getLastMessageId() {
		return lastMessageId;
	}



	public void setLastMessageId(Integer lastMessageId) {
		this.lastMessageId = lastMessageId;
	}

	



}
