package Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.User;

/**
 * Servlet implementation class CtrlRegisterUser
 */
@WebServlet("/CtrlRegisterUser")
public class CtrlRegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private User m_user;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrlRegisterUser() {
        super();
        m_user = new User();
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
		
		int result = m_user.RegisterUser(request.getParameter("name"), request.getParameter("email"), request.getParameter("password"));
		String text;
		if(result == 1){
			text = "El usuario se registro correctamente";
		}else{
			text = "El usuario ya existe";
		}
		
		PrintWriter out = response.getWriter();
		/*
		StringBuffer res = new StringBuffer();
		res.append("{");
	    res.append("'result':");
	    res.append(result);
	    res.append(",");
	    res.append("'msg':");
	    res.append(text);
	    res.append("}");
	    
	    out.println(res.toString());*/
		
		out.println(text);
	    
        //out.close();
        
	}

}
