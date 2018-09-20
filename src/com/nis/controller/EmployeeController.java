package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;



import com.nis.model.Employee;

public class EmployeeController 
{
	public static boolean addnewRecord(Employee E)
	{
		try
		{
			Connection cn=DBHelper.openConnection();
			String query="insert into employee (empname, empfname, gen, dob, address, state, city, designation, qualification, photo, password) values ('"+E.getEmpname()+"','"+E.getEmpfname()+"','"+E.getGen()+"','"+E.getDob()+"','"+E.getAddress()+"','"+E.getState()+"','"+E.getCity()+"','"+E.getDesig()+"','"+E.getQuaification()+"','"+E.getPhoto()+"','"+E.getPassword()+"')";
			boolean st=DBHelper.executeNonQuery(query, cn);
			return st;
		}
		catch(Exception e)
		{
			System.out.println("Error is : "+e);
			return false;
		}
	}
	public static ResultSet displayAll()
	{try{
		Connection cn=DBHelper.openConnection();
		String query="select empid,empname,empfname,gen,dob,address,(select statename from states S where S.stateid=E.state),(select cityname from cities C where C.cityid=E.city) ,designation,qualification,photo from employee E";
		ResultSet rs=DBHelper.executeQuery(query, cn);
		return(rs);
		
	}catch(Exception e){System.out.println("Error[Employee]"+e);
	return(null);
	}
	}
	public static Employee displayById(int eid)
	{try{
		Connection cn=DBHelper.openConnection();
		String query="select * from employee where empid="+eid;
		ResultSet rs=DBHelper.executeQuery(query, cn);
		if(rs.next())
		{
			Employee E=new Employee();
			E.setEmpid(Integer.parseInt(rs.getString(1)));
			E.setEmpname((rs.getString(2)));
	        E.setEmpfname((rs.getString(3)));
		    E.setGen((rs.getString(4)));
		    E.setDob((rs.getString(5)));
		    E.setAddress((rs.getString(6)));
		    E.setState((rs.getString(7)));
		    E.setCity(rs.getString(8));
		    E.setDesig((rs.getString(9)));
		    E.setQuaification((rs.getString(10)));
		    E.setPhoto(rs.getString(11));
		    E.setPassword(rs.getString(12));
		    return E;
			
			
		}
		return null;
		
	}catch(Exception e){System.out.println("Error[Employee]"+e);
	return(null);
	}
	}
	public static boolean editRecord(Employee E)
	{
		try
		{
			Connection cn=DBHelper.openConnection();
			String query="update employee set empname='"+E.getEmpname()+"',empfname='"+E.getEmpfname()+"',gen='"+E.getGen()+"',dob='"+E.getDob()+"',address='"+E.getAddress()+"',state='"+E.getState()+"',city='"+E.getCity()+"',designation='"+E.getDesig()+"',qualification='"+E.getQuaification()+"',password='"+E.getPassword()+"' where empid="+E.getEmpid();
		    boolean st=DBHelper.executeNonQuery(query, cn);
			return st;
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e);
			return false;
		}
	}
	public static boolean EditPicture(int eid,String picture)
	{try{
		Connection cn=DBHelper.openConnection();
		String query="update employee set photo='"+picture+"'  where empid="+eid;
		boolean st=DBHelper.executeNonQuery(query, cn);
		return(st);
		
	}catch(Exception e){System.out.println("Error[Employee]"+e);
	return(false);
	}
	}
	public static boolean DeleteRecord(int eid)
	{try{
		Connection cn=DBHelper.openConnection();
		String query="delete from employee where empid="+eid;
	 	boolean st=DBHelper.executeNonQuery(query, cn);
		return(st);
		
	}catch(Exception e){System.out.println("Error[Employee]"+e);
	return(false);
	}
	
	

}
}
