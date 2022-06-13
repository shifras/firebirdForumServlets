package lt.bit.helper;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

public class Counter implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int count=1;
	
	public Counter() {
	
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	public int inc() {
		this.count++;
		return this.count;
	}
	
	public String toString() {
		return count+"";
	}
	
	public static void setCounter(HttpSession session) {
	
		
		if (session.getAttribute("counter")==null) {
			session.setAttribute("counter", new Counter());
		}else {
			Counter c=(Counter)  session.getAttribute("counter");
			c.inc();
		} 
	}

}
