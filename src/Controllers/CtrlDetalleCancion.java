package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Cancion;

/**
 * Servlet implementation class CtrlDetalleCancion
 */
@WebServlet("/CtrlDetalleCancion")
public class CtrlDetalleCancion extends HttpServlet {
	
	private Cancion m_cancion;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrlDetalleCancion() {
        super();
        m_cancion = new Cancion();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int result = m_user.RegisterUser(request.getParameter("name"), request.getParameter("email"), request.getParameter("password"));
		
		m_cancion.ListarDetalleCancion(Integer.parseInt(request.getParameter("id_can")));
		request.setAttribute("Cancion", m_cancion);		
		
		RequestDispatcher rd = request.getRequestDispatcher("Cancion.jsp");
		rd.forward(request, response);
		
	    //RequestDispatcher rd = getServletContext()
	    ///                           .getRequestDispatcher("/Cancion.jsp");
	    //rd.forward(request, response);
		
		
		/*Vector<String> data = m_cancion.ListarDetalleCancion(Integer.parseInt(request.getParameter("id_can")));
		
		String text;
		
		text = "<!DOCTYPE html><html><body bgcolor='#DBE9F2'>";
		
		
		text += "<center><br><br>";
		
		if(data != null && data.size() > 1){
			text += "<font color='black' size='6' >"+data.elementAt(0)+ " - " +data.elementAt(3) + "(" +data.elementAt(4)+ ")"+ "</font><br>";
			
			//text += "<object type='application/x-shockwave-flash' style='width:425px;height:350px' data='https://www.youtube.com/watch?v=lNLdTfwx5ZQ'><param name='movie' value='https://www.youtube.com/watch?v=lNLdTfwx5ZQ' /></object>";
			text += "<iframe width='640' height='390' src='"+data.elementAt(2)+"' frameborder='0' ></iframe>";
			
			
			text += "<br><br><font color='black' size='4' >"+data.elementAt(1).replace("\n", "<br>")+"</font>";
		}
		
		
		
		text += "</center>";
		
		text += "</body></html>";
		
		
		PrintWriter out = response.getWriter();
		
		
		out.println(text);
	    */
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
