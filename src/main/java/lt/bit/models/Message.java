package lt.bit.models;



public class Message {
	
	private Integer id;
	private String dateCreated;
	private String content;
	private String username;

	public Message() {
		super();
	}

	public Message(Integer id, String dateCreated, String content, String username) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.content = content;
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return dateCreated+"(0"+id+")";
	}


	

	
	

	
	
	
	
	
}
