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
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
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
		
				
				
				
		out.println("<html>");
		out.println(navbar);
		out.println("<table>");
		out.println("<tr>");
		out.println("<td  valign=top>");
		out.println("<a href=DepartmentInterface target=mw>Department Register</a><br>");
		out.println("<a href=DepartmentDisplayAll target=mw>Edit/Delete Department</a><br>");
		out.println("<a href=EmployeeInterface target=mw>Employee Register</a><br>");
		out.println("<a href=EmployeeDisplayAll target=mw>Edit/Delete Employee</a><br>");
		out.println("<a href=VisitorInterface target=mw>Visitor Register</a><br>");
		out.println("<a href=VisitorDisplayAll target=mw>Edit/Delete Visitor</a><br>");
		out.println("</td>");

		out.println("<td valign=top>");
		out.println("<iframe width=600 height=700 frameborder=0 name=mw></iframe>");
		out.println("</td></table></html>");
		out.flush();
				
		
		
		
	}

}
