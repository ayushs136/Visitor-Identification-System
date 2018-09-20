package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeInterface
 */
@WebServlet("/EmployeeInterface")
public class EmployeeInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeInterface() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<script src='asset/jquery-2.2.1.min.js' ></script>");
		out.println("<script src='asset/statecity.js' ></script>");
		out.println("<html>");
		out.println("<center>");
		out.println("<form action=EmployeeSubmit method=post enctype='multipart/form-data'>");
		out.println("<table>");
		out.println("<caption><b><u>Employee Registration</u></b></caption>");
		out.println("<tr>");
		out.println("<td><b>Employee First Name : </b></td>");
		out.println("<td><input type=text name=empnamef></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><b>Employee Second Name : </b></td>");
		out.println("<td><input type=text name=empnames></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><b>Employee Father's Name :</b></td>");
		out.println("<td><input type=text name=empfname></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><b>Gender :</b></td>");
		out.println("<td><input type=radio name=gen value=Male>Male &nbsp;&nbsp; <input type=radio name=gen value=Female>Female</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><b>Date of birth :</b></td>");
		out.println("<td><input type=date name=dob></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><b>Address :</b></td>");
		out.println("<td><input type=text name=address></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><b>State :</b></td>");
		out.println("<td><select id=state name=state></select></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><b>City :</b></td>");
		out.println("<td><select id=city name=city></select></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><b>Designation :</b></td>");
		out.println("<td><select name=designation>");
		out.println("<option disabled selected>Select</option>");
		out.println("<option value=SeniorProf>Senior Prof</option>");
		out.println("<option value=JuniorProf>Juior Prof</option>");
		out.println("<option value=ComputerOperator>Computer Operator</option>");
		out.println("<option value=LabAttedend>Lab Attedend</option>");
		out.println("</select></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><b>Qualification :</b></td>");
		out.println("<td><select name=qualification>");
		out.println("<option disabled selected>Select</option>");
		out.println("<option value=BTech>B.Tech</option>");
		out.println("<option value=MTech>M.Tech</option>");
		out.println("<option value=Phd>Phd</option>");
		out.println("<option vaalue=DEd>D.Ed</option>");
		out.println("</select></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><b>Photo :</b></td>");
		out.println("<td><input type=file name=photo></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><b>Password :</b></td>");
		out.println("<td><input type=password name=password></td>");
		out.println("</tr>");
		out.println("<td><input type=Submit></td>");
		out.println("<td><input type=Reset></td>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</html>");
	}

}
