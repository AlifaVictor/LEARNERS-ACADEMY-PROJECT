

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlett
 */
public class LoginServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlett() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		PrintWriter pw=response.getWriter();
		RequestDispatcher rd=request.getRequestDispatcher("Welcome2.jsp");
		rd.include(request, response);
		
		if(user.equals(pwd)) {
			//create a cookie
			Cookie c=new Cookie("userid" ,user);
			System.out.println("cookie id is created");
			//cookie added to the browser
			response.addCookie(c);
			pw.print("login is succesful");
		}
		else {
			pw.print("login failed");
	}

}}
