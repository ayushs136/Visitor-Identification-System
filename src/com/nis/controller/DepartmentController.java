package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.Department;

public class DepartmentController {
public static boolean addNewRecord(Department D)
{try{
	Connection cn=DBHelper.openConnection();
	String query="insert into department(departmentname,block,floor,roomno,contactno,contactperson,emailid,icon)values('"+D.getDepartmentname()+"','"+D.getBlock()+"','"+D.getFloor()+"','"+D.getRoomno()+"','"+D.getContactno()+"','"+D.getContactperson()+"','"+D.getEmailid()+"','"+D.getIcon()+"')";
	boolean st=DBHelper.executeNonQuery(query, cn);
	return(st);
	
}catch(Exception e){System.out.println("Error[Department]"+e);
return(false);
}
}

public static ResultSet displayAll()
{try{
	Connection cn=DBHelper.openConnection();
	String query="select * from department";
	ResultSet rs=DBHelper.executeQuery(query, cn);
	return(rs);
	
}catch(Exception e){System.out.println("Error[Department]"+e);
return(null);
}
 }

public static Department displayById(int did)
{try{
	Connection cn=DBHelper.openConnection();
	String query="select * from department where departmentid="+did;
	ResultSet rs=DBHelper.executeQuery(query, cn);
	if(rs.next())
	{ Department D=new Department();
	D.setDepartmentid(Integer.parseInt(rs.getString(1)));
	D.setDepartmentname(rs.getString(2));
	D.setBlock(rs.getString(3));
	D.setFloor(rs.getString(4));
	D.setRoomno(rs.getString(5));
	D.setContactno(rs.getString(6));
	D.setContactperson(rs.getString(7));
	D.setEmailid(rs.getString(8));
	D.setIcon(rs.getString(9));
	return D;
	
		
	}
	return null;
}catch(Exception e){System.out.println("Error[Department]"+e);
return(null);
}
 }


public static boolean EditRecord(Department D)
{try{
	Connection cn=DBHelper.openConnection();
	String query="update department set departmentname='"+D.getDepartmentname()+"',block='"+D.getBlock()+"',floor='"+D.getFloor()+"',roomno='"+D.getRoomno()+"',contactno='"+D.getContactno()+"',contactperson='"+D.getContactperson()+"',emailid='"+D.getEmailid()+"' where departmentid="+D.getDepartmentid();
	boolean st=DBHelper.executeNonQuery(query, cn);
	return(st);
	
}catch(Exception e){System.out.println("Error[Department]"+e);
return(false);
}}

public static boolean EditPicture(int did,String picture)
{try{
	Connection cn=DBHelper.openConnection();
	String query="update department set icon='"+picture+"'  where departmentid="+did;
	boolean st=DBHelper.executeNonQuery(query, cn);
	return(st);
	
}catch(Exception e){System.out.println("Error[Department]"+e);
return(false);
}
}
public static boolean DeleteRecord(int did)
{try{
	Connection cn=DBHelper.openConnection();
	String query="delete from department where departmentid="+did;
 	boolean st=DBHelper.executeNonQuery(query, cn);
	return(st);
	
}catch(Exception e){System.out.println("Error[Department]"+e);
return(false);
}}



}
