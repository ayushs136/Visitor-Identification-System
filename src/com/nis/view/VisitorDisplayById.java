package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.VisitorController;
import com.nis.model.Visitor;

/**
 * Servlet implementation class VisitorDisplayById
 */
@WebServlet("/VisitorDisplayById")
public class VisitorDisplayById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorDisplayById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Visitor V=VisitorController.displayById(Integer.parseInt(request.getParameter("vid")));
		if(V!=null)
		{
			out.println("<html>");
			out.println("<center>");
			out.println("<form action=VisitorEditDelete method=post enctype='multipart/form-data'>");
			out.println("<table><tr><td>");
			out.println("<table>");
			out.println("<caption><b><u>Visitor Registration</u></b></caption>");
			
			out.println("<tr>");
			out.println("<td><b>Visitor Id : </b></td>");
			out.println("<td><input type=text name=vid value='"+V.getVisid()+"' readonly></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><b>Visitor Name : </b></td>");
			out.println("<td><input type=text name=visname value='"+V.getVisname()+"'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><b>Gender </b></td>");
			if(V.getVisgen().equals("Male"))
			{
				out.println("<td><input type=text name=visgen value=Male></td>");
			}
			else
			{
				out.println("<td><input type=text name=visgen value=Female></td>");
			}
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><b>Date of birth :</b></td>");
			out.println("<td><input type=text name=visdob value='"+V.getVisdob()+"'></td>");
			out.println("</tr>");
			
			if(V.getVisidentity().equals("aadhar"))
			{
			out.println("<tr>");
			out.println("<td><b>Identity :</b></td>");
			out.println("<td><input type=text name=visidentity value=Aadhar></td>");
			out.println("</tr>");
			}
			
			/*else if(V.getVisidentity().equals("License"))
			{
				out.println("<tr>");
				out.println("<td><b>Identity :</b></td>");
				out.println("<td><input type=checkbox name=visidentity value=false>Aadhar Card &nbsp;&nbsp; <input type=checkbox name=visidentity value=true>License </td>");
				out.println("</tr>");
			}*/
			
			else
			{
				out.println("<tr>");
				out.println("<td><b>Identity :</b></td>");
				out.println("<td><input type=text name=visidentity value=License></td>");
				out.println("</tr>");
				
			}
			
			out.println("<tr>");
			out.println("<td><b>Identity id :</b></td>");
			out.println("<td><input type=text name=visidentityid value='"+V.getVisidentityid()+"'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><b>Department :</b></td>");
			out.println("<td><input type=text name=visdepartment value='"+V.getVisdepartment()+"'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><b>Employee :</b></td>");
			out.println("<td><input type=text name=visemployee value='"+V.getVisemployee()+"'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><b>Purpose :</b></td>");
			out.println("<td><input type=text name=vispurpose value='"+V.getVispurpose()+"'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><b>Current Date :</b></td>");
			out.println("<td><input type=date name=viscdate value='"+V.getViscdate()+"'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><b>Current Time :</b></td>");
			out.println("<td><input type=time name=visctime value='"+V.getVisctime()+"'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><b>Exit Time :</b></td>");
			out.println("<td><input type=time name=visexittime value='"+V.getVisexittime()+"'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><input type=submit value=Edit name=btn></td>");
			out.println("<td><input type=submit value=Delete name=btn></td>");
			out.println("</tr>");
			
			out.println("</table></td>");
			out.println("<td valign=top>");
			out.println("<img src=pic/"+V.getVisidentitupload()+" width=150 height=150>");
			out.println("<br><br><b><i>Select Picture..</i></b>");
			out.println("<br><br><input type=file name=photo><br>");
			out.println("<br><input type=submit value='Update Picture' name=btn></td></tr></table>");
			 
			
			
			out.println("</form>");
			out.println("</center>");
			out.println("</html>");
		}
		else
		{
			out.println("Visitor Not Found....");
		}
	}

}
