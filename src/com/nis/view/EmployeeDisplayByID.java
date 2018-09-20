package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.nis.controller.EmployeeController;
import com.nis.model.Employee;

/**
 * Servlet implementation class EmployeeDisplayByID
 */
@WebServlet("/EmployeeDisplayByID")
public class EmployeeDisplayByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDisplayByID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Employee E=EmployeeController.displayById(Integer.parseInt(request.getParameter("eid")));
		if(E!=null)
		{
			out.println("<html>");
			out.println("<center>");
			out.println("<form action=EmployeeEditDelete method=post enctype='multipart/form-data'>");
			out.println("<table><tr><td>");
			out.println("<table>");
			out.println("<caption><b><u>Employee Registration</u></b></caption>");
			out.println("<tr>");
			 out.println("<td><b><i>Employee Id:</i><b></td><td><input type=text name=eid size=30 required value='"+E.getEmpid()+"' readonly=true></td>");
			 out.println("</tr>");
			out.println("<tr>");
			out.println("<td><b>Employee First Name : </b></td>");
			out.println("<td><input type=text name=empname value='"+E.getEmpname()+"'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td><b>Employee Father's Name :</b></td>");
			out.println("<td><input type=text name=empfname value='"+E.getEmpfname()+"'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td><b>Gender :</b></td>");
			if(E.getGen().equals("Male"))
			{
				out.println("<td><input type=radio name=gen value=Male checked>Male<input type=radio name=gen value=Female>Female</td>");
			}
			else
			{
				out.println("<td><input type=radio name=gen value=Male>Male<input type=radio name=gen value=Female checked>Female</td>");
			}
			 
			out.println("<tr>");
			out.println("<td><b>Date of birth :</b></td>");
			out.println("<td><input type=date name=dob value='"+E.getDob()+"'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td><b>Address :</b></td>");
			out.println("<td><input type=text name=address value='"+E.getAddress()+"'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td><b>State :</b></td>");
			out.println("<td><input type=text name=state value='"+E.getState()+"'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td><b>City :</b></td>");
			out.println("<td><input type=text name=city value='"+E.getCity()+"'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td><b>Designation</b></td>");
			out.println("<td><input type=text name=designation value='"+E.getDesig()+"'></td>");
			out.println("</tr>");
			/*out.println("<tr>");
			out.println("<td><b>Designation :</b></td>");
			out.println("<td><select value='"+E.getDesig()+"'>");
			out.println("<option disabled selected>Select</option>");
			out.println("<option>Senior Prof</option>");
			out.println("<option>Juior Prof</option>");
			out.println("<option>Computer Operator</option>");
			out.println("<option>Lab Attedend</option>");
			out.println("</select></td>");
			out.println("</tr>");*/
			
			out.println("<tr>");
			out.println("<td><b>Qualification</b></td>");
			out.println("<td><input type=text name=qualification value='"+E.getQuaification()+"'></td>");
			out.println("</tr>");
			
			/*out.println("<tr>");
			out.println("<td><b>Qualification :</b></td>");
			out.println("<td><select value='"+E.getQuaification()+"'>");
			out.println("<option disabled selected>Select</option>");
			out.println("<option>B.Tech</option>");
			out.println("<option>M.Tech</option>");
			out.println("<option>Phd</option>");
			out.println("<option>D.Ed</option>");
			out.println("</select></td>");
			out.println("</tr>");*/
			
			out.println("<tr>");
			out.println("<td><input type=submit value=Edit name=btn></td>");
			out.println("<td><input type=submit value=Delete name=btn></td>");
			out.println("</tr>");
			
			out.println("</table></td>");
			 out.println("<td valign=top>");
			 out.println("<img src=pic/"+E.getPhoto()+" width=150 height=150>");
			 out.println("<br><br><b><i>Select Picture..</i></b>");
			 out.println("<br><br><input type=file name=photo><br>");
			 out.println("<br><input type=submit value='Update Picture' name=btn></td></tr></table>");
			 
			out.println("</form>");
			out.println("</center>");
			out.println("</html>");

		}
		else
		{
			out.println("Employee Not Found....");
		}
		

		}

}
