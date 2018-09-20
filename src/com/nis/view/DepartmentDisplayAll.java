package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.DepartmentController;
import com.nis.model.AdminModel;

/**
 * Servlet implementation class DepartmentDisplayAll
 */
@WebServlet("/DepartmentDisplayAll")
public class DepartmentDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentDisplayAll() {
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
   
   try{ ResultSet rs=DepartmentController.displayAll();
  out.println("<html>");
  out.println("<a href=DepartmentInterface>Add New Record</a><br><br>");
  
  if(rs.next())
   { 
   
   out.println("<table border=1>");
   out.println("<caption><h3><i>Department Register</i></h3></caption>");
   out.println("<tr><th>DepartmentId/Name</th><th>Location</th><th>Contact</th><th>Icon</th><th>Update</th></tr>");
      do{
	out.println("<tr><td>"+rs.getString(1)+"<br>"+rs.getString(2)+"</td><td>Block:"+rs.getString(3)+"<br>Floor:"+rs.getString(4)+"<br>Room No:"+rs.getString(5)+"</td><td>Contact No:"+rs.getString(6)+"<br>Person:"+rs.getString(7)+"<br>Email:"+rs.getString(8)+"</td><td><img src=pic/"+rs.getString(9)+" width=45 height=45></td><td><a href=DisplayDepartmentById?did="+rs.getString(1)+">Delete/Edit</a></td></tr>");   
	   
   }while(rs.next());
	   out.println("</table>");
   }
   else
   {
	out.println("Record Not Found.....");   
	   
   }
  out.println("</html>");
  }catch(Exception e)
  {System.out.println(e);
   }
	}

}







