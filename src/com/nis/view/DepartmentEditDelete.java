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
 * Servlet implementation class DepartmentEditDelete
 */
@WebServlet("/DepartmentEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class DepartmentEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }
 	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
      PrintWriter out=response.getWriter();
      String btn=request.getParameter("btn");
      if(btn.equals("Edit"))
      {
      Department D=new Department();
      D.setDepartmentid(Integer.parseInt(request.getParameter("did")));
      D.setDepartmentname(request.getParameter("dn"));
		D.setBlock(request.getParameter("dbn"));
		D.setFloor(request.getParameter("fn"));
		D.setRoomno(request.getParameter("rn"));
		D.setContactno(request.getParameter("cno"));
		D.setContactperson(request.getParameter("cp"));
		D.setEmailid(request.getParameter("em"));
		boolean st=DepartmentController.EditRecord(D);
		 response.sendRedirect("DepartmentDisplayAll");
	}
	else if(btn.equals("Update Picture"))
	{
		Part P=request.getPart("dpic");
		FileUpload F=new FileUpload(P,"F:/Eclipse Mars/eclipse/VIS/WebContent/pic");
	    boolean st=DepartmentController.EditPicture(Integer.parseInt(request.getParameter("did")),F.filename);	
	    response.sendRedirect("DepartmentDisplayAll");
	}
	else if(btn.equals("Delete"))
	{  
		boolean st=DepartmentController.DeleteRecord(Integer.parseInt(request.getParameter("did")));
		 response.sendRedirect("DepartmentDisplayAll");
		
	}
	

}}




