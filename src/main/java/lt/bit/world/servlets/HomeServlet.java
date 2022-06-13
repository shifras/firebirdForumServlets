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
		m.setUsername( "test_username_here" );
		
		MessageDao messageDao=new MessageDao();
		messageDao.addMessage(m);
		response.sendRedirect( request.getContextPath()+"/");
	}
}
