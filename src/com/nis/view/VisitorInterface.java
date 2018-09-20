package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitorInterface
 */
@WebServlet("/VisitorInterface")
public class VisitorInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorInterface() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<center>");
		out.println("<form action=VisitorSubmit method=post enctype='multipart/form-data'>");
		out.println("<table>");
		out.println("<caption><b><u>Visitor Registration</u></b></caption>");
		
		out.println("<tr>");
		out.println("<td><b>Visitor First Name : </b></td>");
		out.println("<td><input type=text name=visnamef></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b>Visitor Second Name : </b></td>");
		out.println("<td><input type=text name=visnames></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b>Gender :</b></td>");
		out.println("<td><input type=radio name=visgen value=Male>Male &nbsp;&nbsp; <input type=radio name=visgen value=Female>Female</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b>Date of birth :</b></td>");
		out.println("<td><input type=date name=visdob></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b>Identity :</b></td>");
		out.println("<td><input type=checkbox value=aadhar name=visidentity>Aadhar Card &nbsp;&nbsp; <input type=checkbox value=License name=visidentity>License </td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b>Identity id :</b></td>");
		out.println("<td><input type=text name=visidentityid></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b>Upload Identity</b></td>");
		out.println("<td><input type=file name=visuploadidentity></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b>Department :</b></td>");
		out.println("<td><input type=text name=visdepartment></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b>Employee :</b></td>");
		out.println("<td><input type=text name=visemployee></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b>Purpose :</b></td>");
		out.println("<td><input type=text name=vispurpose></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b>Current Date :</b></td>");
		out.println("<td><input type=date name=viscdate></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b>Current Time :</b></td>");
		out.println("<td><input type=time name=visctime></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b>Exit Time :</b></td>");
		out.println("<td><input type=time name=visexittime></td>");
		out.println("</tr>");
		
		out.println("<td><input type=Submit></td>");
		out.println("<td><input type=Reset></td>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</html>");
		
	}

}
