package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.DepartmentController;
import com.nis.model.Department;

/**
 * Servlet implementation class DisplayDepartmentById
 */
@WebServlet("/DisplayDepartmentById")
public class DisplayDepartmentById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayDepartmentById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Department D=DepartmentController.displayById(Integer.parseInt(request.getParameter("did"))); 
	if(D!=null)
	{
		
		 out.println("<html>");
		 out.println("<form action=DepartmentEditDelete method=post enctype='multipart/form-data'>");
		 out.println("<a href=DepartmentInterface>Add New Record</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=DepartmentDisplayAll>Display All Departments</a><br><br>");
		  
		 out.println("<table><tr><td>");		
		 out.println("<table>");
		 out.println("<caption><b><i>Department Register [Edit/Delete]</i></b></caption>");
		 out.println("<tr>");
		 out.println("<td><b><i>Deparment Id:</i><b></td><td><input type=text name=did size=30 required value='"+D.getDepartmentid()+"' readonly=true></td>");
		 out.println("</tr>");
		 
		 out.println("<tr>");
		 out.println("<td><b><i>Deparment Name:</i><b></td><td><input type=text name=dn size=30 required value='"+D.getDepartmentname()+"'></td>");
		 out.println("</tr>");
		 
		 out.println("<tr>");
		 out.println("<td><b><i>Block Name:</i><b></td><td><input type=text name=dbn size=30 required value='"+D.getBlock()+"'></td>");
		 out.println("</tr>");
		 
		 out.println("<tr>");
		 out.println("<td><b><i>Floor Number:</i><b></td><td><input type=text name=fn size=30 required value='"+D.getFloor()+"'></td>");
		 out.println("</tr>");
		 
		 out.println("<tr>");
		 out.println("<td><b><i>Room Number:</i><b></td><td><input type=text name=rn size=30 required value='"+D.getRoomno()+"'></td>");
		 out.println("</tr>");
		 
		 out.println("<tr>");
		 out.println("<td><b><i>Contact No:</i><b></td><td><input type=text name=cno size=30 required value='"+D.getContactno()+"'></td>");
		 out.println("</tr>");
		 
		 out.println("<tr>");
		 out.println("<td><b><i>Contact Person:</i><b></td><td><input type=text name=cp size=30 required value='"+D.getContactperson()+"'></td>");
		 out.println("</tr>");
		
		 out.println("<tr>");
		 out.println("<td><b><i>Email Id:</i><b></td><td><input type=email name=em size=30 required value='"+D.getEmailid()+"'></td>");
		 out.println("</tr>");
		
		 
		 out.println("<tr>");
		 out.println("<td><input type=submit value=Edit name=btn></td><td><input type=submit value=Delete name=btn></td>");
		 out.println("</tr>");
		 out.println("</table></td>");
		 out.println("<td valign=top>");
		 out.println("<img src=pic/"+D.getIcon()+" width=150 height=150>");
		 out.println("<br><br><b><i>Select Picture..</i></b>");
		 out.println("<br><br><input type=file name=dpic><br>");
		 out.println("<br><input type=submit value='Update Picture' name=btn></td></tr></table>");
		 
		 out.print("</form></html>");
	}
	else
	{out.println("Department Not Found....");
		
	}
	
	}

}
