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

import com.nis.controller.VisitorController;
import com.nis.model.Visitor;

/**
 * Servlet implementation class VisitorEditDelete
 */
@WebServlet("/VisitorEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class VisitorEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	    String btn=request.getParameter("btn");
	    if(btn.equals("Edit"))
	      {
	    	Visitor V=new Visitor();
		     
		     V.setVisid(Integer.parseInt(request.getParameter("vid")));
		     V.setVisname(request.getParameter("visname"));
		     V.setVisgen(request.getParameter("visgen"));
		     V.setVisdob(request.getParameter("visdob"));
		     V.setVisidentity(request.getParameter("visidentity"));
		     V.setVisidentityid(request.getParameter("visidentityid"));
		     V.setVisdepartment(request.getParameter("visdepartment"));
			 V.setVisemployee(request.getParameter("visemployee"));
			 V.setVispurpose(request.getParameter("vispurpose"));
			 V.setViscdate(request.getParameter("viscdate"));
			 V.setVisctime(request.getParameter("visctime"));
			 V.setVisexittime(request.getParameter("visexittime"));
	      	 boolean st=VisitorController.editRecord(V);
			 response.sendRedirect("VisitorDisplayAll");
		}
		else if(btn.equals("Update Picture"))
		{
			Part P=request.getPart("photo");
			FileUpload F=new FileUpload(P,"F:/Eclipse Mars/eclipse/VIS/WebContent/pic");
		    boolean st=VisitorController.EditPicture(Integer.parseInt(request.getParameter("vid")),F.filename);	
		    response.sendRedirect("VisitorDisplayAll");
		}
		else if(btn.equals("Delete"))
		{  
			boolean st=VisitorController.DeleteRecord(Integer.parseInt(request.getParameter("vid")));
			 response.sendRedirect("VisitorDisplayAll");
			
		}
	}

}
