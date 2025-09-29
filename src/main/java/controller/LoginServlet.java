package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Student;
import model.StudentDAO;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password  = request.getParameter("password");
		StudentDAO studentService = new StudentDAO();
		Student student = studentService.getStudentByEmail(email, password);
			
		if (student != null) {
			//create session
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(30*60);
			
			//create cookie 
			Cookie studentName = new Cookie("student", student.getFullName());
			response.addCookie(studentName);
		    request.setAttribute("student", student);
		 
		    //case user browser does not have cookie, use URL rewriting
		    String encodedURL = response.encodeRedirectURL("index.jsp");
			response.sendRedirect(encodedURL);
		} else {
		    request.setAttribute("error", "email or password is incorrect! ");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		    dispatcher.forward(request, response);
		}
	}

}
