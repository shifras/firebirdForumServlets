package lt.bit.world.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lt.bit.dao.MessageDao;
import lt.bit.models.Message;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/")
public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String psw="labas";
		//String hash="$2a$16$jbBpMHL4bQF9DzYA9Ro7BOp5KsHPXwm7VKYxAF2kWIrAUuMdSOoR2";
		
		//Slaptažodžio sukūrimas su BCrypt
		//System.out.println( BCrypt.withDefaults().hashToString(10, psw.toCharArray()) );
		
		//Slaptažodžio patikrinimas su BCrypt
		//System.out.println(BCrypt.verifyer().verify(psw.toCharArray(), hash).verified);
		
		
		
		
		MessageDao messageDao=new MessageDao();
		List<Message> messages=messageDao.getMessages();
		for (Message message : messages) {
			System.out.println(message);
		}
		request.setAttribute("messages", messages);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Message m=new Message();
		m.setDateCreated( new Timestamp(System.currentTimeMillis()).toString() );
		m.setContent( request.getParameter("CONTENT") );
		m.setUsername( "kliunkis" );
//		m.setContinent( request.getParameter("continent") );
//		m.setSurfaceArea( Double.parseDouble(request.getParameter("surfaceArea")) );
//		m.setPopulation( Integer.parseInt(request.getParameter("population")) );
//		m.setLifeExpectancy( Double.parseDouble(request.getParameter("lifeExpectancy")) );
		
		MessageDao messageDao=new MessageDao();
		messageDao.addMessage(m);
		response.sendRedirect( request.getContextPath()+"/");
	}
}
