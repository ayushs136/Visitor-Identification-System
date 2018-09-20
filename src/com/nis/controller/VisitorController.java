package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;


import com.nis.model.Visitor;


public class VisitorController 
{
	public static boolean addNewRecord(Visitor V)
	{
		try
		{
			Connection cn=DBHelper.openConnection();
			String query="insert into visitor(visname,visgen,visdob,visidentity,visidentityid,visidentityupload, visdepartment,visemployee, vispurpose,viscdate,visctime,visexittime) values('"+V.getVisname()+"','"+V.getVisgen()+"','"+V.getVisdob()+"','"+V.getVisidentity()+"','"+V.getVisidentityid()+"','"+V.getVisidentitupload()+"','"+V.getVisdepartment()+"','"+V.getVisemployee()+"','"+V.getVispurpose()+"','"+V.getViscdate()+"','"+V.getVisctime()+"','"+V.getVisexittime()+"')";
		    boolean st=DBHelper.executeNonQuery(query, cn);
			return st;
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e);
			return false;
		}
	}
	public static ResultSet displayAll()
	{try{
		Connection cn=DBHelper.openConnection();
		String query="select * from visitor";
		ResultSet rs=DBHelper.executeQuery(query, cn);
		return(rs);
		
	}catch(Exception e){System.out.println("Error[Visitor]"+e);
	return(null);
	}
	}
	public static Visitor displayById(int vid)
	{try{
		Connection cn=DBHelper.openConnection();
		String query="select * from visitor where visid="+vid;
		ResultSet rs=DBHelper.executeQuery(query, cn);
		if(rs.next())
		{
			Visitor V=new Visitor();
			V.setVisid(Integer.parseInt(rs.getString(1)));
			V.setVisname(rs.getString(2));
			V.setVisgen(rs.getString(3));
			V.setVisdob(rs.getString(4));
		    V.setVisidentity(rs.getString(5));
			V.setVisidentityid(rs.getString(6));
			V.setVisidentitupload(rs.getString(7));
			V.setVisdepartment(rs.getString(8));
			V.setVisemployee(rs.getString(9));
			V.setVispurpose(rs.getString(10));
			V.setViscdate(rs.getString(11));
			V.setVisctime(rs.getString(12));
			V.setVisexittime(rs.getString(13));
			return V;
			
			
		}
		return null;
		
	}catch(Exception e){System.out.println("Error[Visitor]"+e);
	return(null);
	}
	}
	
	
	
	public static boolean editRecord(Visitor V)
	{
		try
		{
			Connection cn=DBHelper.openConnection();
			String query="update visitor set visname='"+V.getVisname()+"',visgen='"+V.getVisgen()+"',visdob='"+V.getVisdob()+"',visidentity='"+V.getVisidentity()+"',visidentityid='"+V.getVisidentityid()+"',visdepartment='"+V.getVisdepartment()+"',visemployee='"+V.getVisemployee()+"',vispurpose='"+V.getVispurpose()+"',viscdate='"+V.getViscdate()+"',visctime='"+V.getVisctime()+"',visexittime='"+V.getVisexittime()+"' where visid="+V.getVisid();
		    boolean st=DBHelper.executeNonQuery(query, cn);
			return st;
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e);
			return false;
		}
	}
	
	
	
	public static boolean EditPicture(int vid,String picture)
	{try{
		Connection cn=DBHelper.openConnection();
		String query="update visitor set visidentityupload='"+picture+"'  where visid="+vid;
		boolean st=DBHelper.executeNonQuery(query, cn);
		return(st);
		
	}catch(Exception e){System.out.println("Error[Visitor]"+e);
	return(false);
	}
	}
	
	
	
	
	public static boolean DeleteRecord(int vid)
	{try{
		Connection cn=DBHelper.openConnection();
		String query="delete from visitor where visid="+vid;
	 	boolean st=DBHelper.executeNonQuery(query, cn);
		return(st);
		
	}catch(Exception e){System.out.println("Error[Visitor]"+e);
	return(false);
	}}

}
