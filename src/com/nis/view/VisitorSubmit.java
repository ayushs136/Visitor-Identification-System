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
 * Servlet implementation class VisitorSubmit
 */
@WebServlet("/VisitorSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class VisitorSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	     Visitor V=new Visitor();
	     String name=request.getParameter("visnamef")+" "+request.getParameter("visnames");
	     V.setVisname(name);
	     V.setVisgen(request.getParameter("visgen"));
	     V.setVisdob(request.getParameter("visdob"));
	     V.setVisidentity(request.getParameter("visidentity"));
	     V.setVisidentityid(request.getParameter("visidentityid"));
	     Part P = request.getPart("visuploadidentity");
		 FileUpload F=new FileUpload(P,"F:/Eclipse Mars/eclipse/vis/WebContent/pic");
		 V.setVisidentitupload(F.filename);
		 V.setVisdepartment(request.getParameter("visdepartment"));
		 V.setVisemployee(request.getParameter("visemployee"));
		 V.setVispurpose(request.getParameter("vispurpose"));
		 V.setViscdate(request.getParameter("viscdate"));
		 V.setVisctime(request.getParameter("visctime"));
		 V.setVisexittime(request.getParameter("visexittime"));
         
	     boolean st=VisitorController.addNewRecord(V);
		 if(st)
		 {
			out.println("<html><center><h1>Record Submitted...<br><a href=VisitorInterface>Add More Deparment...</a></h1></center></html>");
		 } 
		 else
		 {
			out.println("<html><center><h1>Record Not Submitted...<br><a href=VisitorInterface>Add More Deparment...</a></h1></center></html>");
		 } 
	}

}
