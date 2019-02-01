package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.RegistrationBean;
  public class MyDao {
		public Connection start()
		{
			Connection con=null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return con;
		}
		
		public int login(String emailid,String password)
		{
			int x=0;
			
			try {
				Connection con=start();
				PreparedStatement ps=con.prepareStatement("select * from registration where emailid=? and password=?");
				ps.setString(1, emailid);
				ps.setString(2, password);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
					x=1;
				con.close();
				}catch(  SQLException e)
			{
					System.out.println(e);
			}
			
			return x;
		}
		
		
		public int insert(RegistrationBean e)
		{ 
			int x=0;
			
			try {
				
				Connection con=start();
				PreparedStatement ps1=con.prepareStatement("insert into registration (name,gender,dob,religion,mothertongue,cast,country,mobileno,emailid,password)values(?,?,?,?,?,?,?,?,?,?)");
			    
			    ps1.setString(1,e.getName());
			    ps1.setString(2, e.getGender());
			    java.sql.Date sqlDate=new java.sql.Date(e.getDob().getTime());
			    ps1.setDate(3,sqlDate);
			    ps1.setString(4,e.getReligion());
			    ps1.setString(5,e.getMothertongue());
			    ps1.setString(6,e.getCast());
			    ps1.setString(7,e.getCountry());
			    ps1.setInt(8,e.getMobileno());
			    ps1.setString(9,e.getEmailid());
			    ps1.setString(10,e.getPassword());
			   
			    x=ps1.executeUpdate();
			    con.close();
			    }catch(Exception w)
			{
			    	System.out.println(w);
			}
			
		return x;
		}
		
		public ArrayList<RegistrationBean>   viewDetails(String gender)
		{
			ArrayList<RegistrationBean> list=new ArrayList<>();
			try {
				Connection con=start();
				PreparedStatement ps=con.prepareStatement("select * from registration where gender!=?");
				ps.setString(1, gender);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{ 
					RegistrationBean e=new RegistrationBean();
					e.setName(rs.getString("name"));
					e.setGender(rs.getString("gender"));
					e.setDob(rs.getDate("dob"));
					e.setReligion(rs.getString("religion"));
					e.setMothertongue(rs.getString("mothertongue"));
					e.setCast(rs.getString("cast"));
					e.setCountry(rs.getString("country"));
					e.setMobileno(rs.getInt("mobileno"));
					e.setEmailid(rs.getString("emailid"));
					e.setPassword(rs.getString("password"));
					

					list.add(e);
			     }
				con.close();
			}catch( SQLException w)
				{
				  System.out.println(w);
				}
		return list;
			
		}
		
		public String getGender(String email)
		{
			String gender=null;
			try {
				 Connection con=start();
				 PreparedStatement ps=con.prepareStatement("select gender from registration where emailid=?");
				 ps.setString(1,email);
				 ResultSet rs=ps.executeQuery();
				 if(rs.next())
				 {
					 gender=rs.getString(1);
				 }
					 con.close();
			}catch(SQLException e) {
				System.out.println(e);
			}
			return gender;
		}
		
		
}
