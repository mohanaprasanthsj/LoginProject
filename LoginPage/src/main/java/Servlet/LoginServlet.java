package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	
    	String Email = req.getParameter("Email");
    	String Password = req.getParameter("Password");
    	String s="";
    	
    	PrintWriter out =resp.getWriter();
    	
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy?characterEncoding=latin1","root","root");
    		java.sql.PreparedStatement p=con.prepareStatement("select * from users where mail=? and pwd=?");
    		p.setString(1, Email);
    		p.setString(2, Password);
    		ResultSet row=p.executeQuery();
    		if(row.next()) {
    			s=row.getString(3);
    		}
    		
    	}
    	
    	catch(Exception e) {
    		e.printStackTrace();
    		
    		
    	}
    	String message = "";
    	RequestDispatcher dispatcher = req.getRequestDispatcher("LoginPage.jsp");
    	if(s.isBlank()||s.isEmpty()) {
    	
    	message = "User Doesn't exist";
    	req.setAttribute("ERR_MSG", message);
    	dispatcher.forward(req, resp);
    	 
    	}
    	else {
    	
    		out.print("welcome "+s);
    	}
    }
}
