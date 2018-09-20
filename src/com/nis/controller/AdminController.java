package com.nis.controller;

import java.sql.Connection;

import java.sql.ResultSet;
import com.nis.model.AdminModel;
 

public class AdminController {
	public static AdminModel checkLogin(int adminid,String password)
	{try{
		Connection cn=DBHelper.openConnection();
		String query="select * from admin where adminid="+adminid+" and password='"+password+"'";
		ResultSet rs=DBHelper.executeQuery(query, cn);
		 if(rs.next())
		 { AdminModel A=new AdminModel();
		 A.setAdminid(rs.getInt(1));
		 A.setAdminname(rs.getString(2));
		 A.setPassword(rs.getString(3));
		 return(A);
			 
		 }
		return(null);
	}catch(Exception e){System.out.println("Error[Department]"+e);
	return(null);
	}
	}
}
