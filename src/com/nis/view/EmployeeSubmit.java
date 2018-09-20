package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class EmployeeSubmit
 */
@WebServlet("/EmployeeSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

public class EmployeeSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     PrintWriter out=response.getWriter();
	     Employee E=new Employee();
	     String name=request.getParameter("empnamef")+" "+request.getParameter("empnames");
	     E.setEmpname(name);
         E.setEmpfname(request.getParameter("empfname"));
	     E.setGen(request.getParameter("gen"));
	     E.setDob(request.getParameter("dob"));
	     E.setAddress(request.getParameter("address"));
	     E.setState(request.getParameter("state"));
	     E.setCity(request.getParameter("city"));
	     E.setDesig(request.getParameter("designation"));
	     E.setQuaification(request.getParameter("qualification"));
	     Part P = request.getPart("photo");
		 FileUpload F=new FileUpload(P,"F:/Eclipse Mars/eclipse/VIS/WebContent/pic");
		 E.setPhoto(F.filename);
	     E.setPassword(request.getParameter("password"));
	     boolean st=EmployeeController.addnewRecord(E);
		 if(st)
		 {
			out.println("<html><center><h1>Record Submitted...<br><a href=EmployeeInterface>Add More Deparment...</a></h1></center></html>");
		 } 
		 else
		 {
			out.println("<html><center><h1>Record Not Submitted...<br><a href=EmployeeInterface>Add More Deparment...</a></h1></center></html>");
		 } 
	}

}
