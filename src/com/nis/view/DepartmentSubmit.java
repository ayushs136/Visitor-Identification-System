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

import com.nis.controller.DepartmentController;
import com.nis.model.Department;

/**
 * Servlet implementation class DepartmentSubmit
 */
@WebServlet("/DepartmentSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class DepartmentSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Department D=new Department();
		D.setDepartmentname(request.getParameter("dn"));
		D.setBlock(request.getParameter("dbn"));
		D.setFloor(request.getParameter("fn"));
		D.setRoomno(request.getParameter("rn"));
		D.setContactno(request.getParameter("cno"));
		D.setContactperson(request.getParameter("cp"));
		D.setEmailid(request.getParameter("em"));
		Part P=request.getPart("di");
		FileUpload F=new FileUpload(P,"F:/Eclipse Mars/eclipse/VIS/WebContent/pic");
		D.setIcon(F.filename);
		boolean st=DepartmentController.addNewRecord(D);
		if(st)
		{out.println("<b><i>Record Submitted...</i></b><br><a href=DepartmentInterface>Add More Deparment...</a>");
		 }
		else
		{out.println("<b><i>Fail to Submit Record...</i></b><br><a href=DepartmentInterface>Add More Deparment...</a>");
		
			
		}	
		out.flush();
		
		 
	}

}




