package com.nis.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.nis.controller.EmployeeController;
import com.nis.model.Employee;

/**
 * Servlet implementation class EmployeeEditDelete
 */
@WebServlet("/EmployeeEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class EmployeeEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String btn=request.getParameter("btn");
	    if(btn.equals("Edit"))
	    {
	    	Employee E=new Employee();
		     String name=request.getParameter("empnamef")+" "+request.getParameter("empnames");
		     E.setEmpid(Integer.parseInt(request.getParameter("eid")));
		     E.setEmpname(name);
	         E.setEmpfname(request.getParameter("empfname"));
		     E.setGen(request.getParameter("gen"));
		     E.setDob(request.getParameter("dob"));
		     E.setAddress(request.getParameter("address"));
		     E.setState(request.getParameter("state"));
		     E.setCity(request.getParameter("city"));
		     E.setDesig(request.getParameter("designation"));
		     E.setQuaification(request.getParameter("qualification"));
		     E.setPassword(request.getParameter("password"));
		     boolean st=EmployeeController.editRecord(E);
			 response.sendRedirect("EmployeeDisplayAll");
	    }
	    else if(btn.equals("Update Picture"))
		{
			Part P=request.getPart("photo");
			FileUpload F=new FileUpload(P,"F:/Eclipse Mars/eclipse/VIS/WebContent/pic");
		    boolean st=EmployeeController.EditPicture(Integer.parseInt(request.getParameter("eid")),F.filename);	
		    response.sendRedirect("EmployeeDisplayAll");
		}
	    else if(btn.equals("Delete"))
		{  
			boolean st=EmployeeController.DeleteRecord(Integer.parseInt(request.getParameter("eid")));
			 response.sendRedirect("EmployeeDisplayAll");
			
		}
	}

}
