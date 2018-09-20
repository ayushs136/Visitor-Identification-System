package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

public class StateCityController {
	public static ResultSet displayAllStates()
	{try{
		Connection cn=DBHelper.openConnection();
		String query="select * from states";
		ResultSet rs=DBHelper.executeQuery(query, cn);
		return(rs);
		
	}catch(Exception e){System.out.println("Error[Department]"+e);
	return(null);
	}
	 }

	public static ResultSet displayAllCities(String stateid)
	{try{
		Connection cn=DBHelper.openConnection();
		String query="select * from cities where stateid='"+stateid+"'";
		ResultSet rs=DBHelper.executeQuery(query, cn);
		return(rs);
		
	}catch(Exception e){System.out.println("Error[Department]"+e);
	return(null);
	}
	 }

}
