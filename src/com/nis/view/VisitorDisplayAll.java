package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.VisitorController;

/**
 * Servlet implementation class VisitorDisplayAll
 */
@WebServlet("/VisitorDisplayAll")
public class VisitorDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorDisplayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		  try{ ResultSet rs=VisitorController.displayAll();
		   if(rs.next())
		   { out.println("<html>");
		   out.println("<table border=1>");
		   out.println("<caption><h3><i>Visitor Register</i></h3></caption>");
		   out.println("<tr><th>Visitor Id</th><th>Visitor Name</th><th>Gender</th><th>Date Of Birth</th><th>Identity</th><th>Identity ID</th><th>Department</th><th>Employee</th><th>Purpose</th><th>Current Date</th><th>Current Time</th><th>Exit time</th><th>Identity Picture</th></tr>");
		      do{
		    	  out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td><td>"+rs.getString(12)+"</td><td>"+rs.getString(13)+"</td><td><img src=pic/"+rs.getString(7)+" width=45 height=45></td><td><a href=VisitorDisplayById?vid="+rs.getString(1)+">Delete/Edit</a></td></tr>");   
			   
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
