package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.model.AdminModel;

/**
 * Servlet implementation class DepartmentInterface
 */
@WebServlet("/DepartmentInterface")
public class DepartmentInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentInterface() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
     PrintWriter out=response.getWriter();
	 //Session for security
     HttpSession ses=request.getSession();
     AdminModel A=null;
		String navbar="";
		try{
		A=(AdminModel)ses.getValue("SADMIN");	
		navbar="<h5><font color=green>Admin Id:"+A.getAdminid()+"&nbsp;&nbsp;&nbsp;&nbsp;"+A.getAdminname()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a><br><hr Color=red>";	
		}catch(Exception e)
		{
		response.sendRedirect("AdminLogin");	
		}
		//*******
     
     
     
     out.println("<html>");
	 out.println("<form action=DepartmentSubmit method=post enctype='multipart/form-data'>");
	 out.println("<a href=DepartmentDisplayAll>Display All Departments</a><br><br>");
	 out.println("<table>");
	 out.println("<caption><b><i>Department Register</i></b></caption>");
	 out.println("<tr>");
	 out.println("<td><b><i>Deparment Name:</i><b></td><td><input type=text name=dn size=30 required></td>");
	 out.println("</tr>");
	 
	 out.println("<tr>");
	 out.println("<td><b><i>Block Name:</i><b></td><td><input type=text name=dbn size=30 required></td>");
	 out.println("</tr>");
	 
	 out.println("<tr>");
	 out.println("<td><b><i>Floor Number:</i><b></td><td><input type=text name=fn size=30 required></td>");
	 out.println("</tr>");
	 
	 out.println("<tr>");
	 out.println("<td><b><i>Room Number:</i><b></td><td><input type=text name=rn size=30 required></td>");
	 out.println("</tr>");
	 
	 out.println("<tr>");
	 out.println("<td><b><i>Contact No:</i><b></td><td><input type=text name=cno size=30 required></td>");
	 out.println("</tr>");
	 
	 out.println("<tr>");
	 out.println("<td><b><i>Contact Person:</i><b></td><td><input type=text name=cp size=30 required></td>");
	 out.println("</tr>");
	
	 out.println("<tr>");
	 out.println("<td><b><i>Email Id:</i><b></td><td><input type=email name=em size=30 required></td>");
	 out.println("</tr>");
	
	 out.println("<tr>");
	 out.println("<td><b><i>Icon:</i><b></td><td><input type=file name=di size=30></td>");
	 out.println("</tr>");
	
	 out.println("<tr>");
	 out.println("<td><input type=submit></td><td><input type=reset></td>");
	 out.println("</tr>");
	 out.println("</table></form></html>");
	 out.flush();
		
	
	}

}






