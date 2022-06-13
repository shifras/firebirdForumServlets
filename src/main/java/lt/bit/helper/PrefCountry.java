package lt.bit.helper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class PrefCountry {
	private String country="";
	
	private final static String[] countries= {"Lietuva", "Latvia", "Estija"};

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public static String[] getCountries() {
		return countries;
	}
	
	
	public static String getPrefCountry(HttpServletRequest request) {
		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
			for (Cookie c:cookies) {
				if (c.getName().equals("prefCountry")) {
					return c.getValue();
				}
			}
		}
		
		return null;
	}
	
	

}
