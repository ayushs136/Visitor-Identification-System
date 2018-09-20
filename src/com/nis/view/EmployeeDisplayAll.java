package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.EmployeeController;

/**
 * Servlet implementation class EmployeeDisplayAll
 */
@WebServlet("/EmployeeDisplayAll")
public class EmployeeDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDisplayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try{ ResultSet rs=EmployeeController.displayAll();
		   if(rs.next())
		   { out.println("<html>");
		   out.println("<table border=1>");
		   out.println("<caption><h3><i>Employee Register</i></h3></caption>");
		   out.println("<tr><th>Employee Id</th><th>Employee Name</th><th>Father's Name</th><th>Gender</th><th>Date Of Birth</th><th>Address</th><th>State</th><th>City</th><th>Designation</th><th>Qualification</th><th>Photo</th></tr>");
		      do{
			out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td><img src=pic/"+rs.getString(11)+" width=45 height=45></td><td><a href=EmployeeDisplayByID?eid="+rs.getString(1)+">Delete/Edit</a></td></tr>");   
			   
		   }while(rs.next());
			   
		   }
		   else
		   {
			out.println("Record Not Found.....");   
			   
		   }
		  }catch(Exception e)
		  {System.out.println(e);
		   }
	}

}
