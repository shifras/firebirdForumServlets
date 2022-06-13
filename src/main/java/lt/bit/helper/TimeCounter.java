package lt.bit.helper;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

public class TimeCounter {
	private LocalDateTime start = LocalDateTime.now();

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	
	public String toString() {
		long total=(Duration.between(start, LocalDateTime.now())).getSeconds();
		
		long min=total/60;
		long sec=total%60;
		
		return min+" min. "+sec+" sec.";
	}
	
	public static void setTimeCounter(HttpSession session) {
		if (session.getAttribute("timeCounter")==null) {
			session.setAttribute("timeCounter", new TimeCounter());
		}
	}


}
