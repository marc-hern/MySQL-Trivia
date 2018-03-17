package trivia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import trivia.model.TriviaEntry;

@WebServlet("/MainTrivia")
public class MainTrivia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (ClassNotFoundException e){
    		throw new ServletException(e);
    	}
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		int x = 0;
		
		try {
			String host = "127.0.0.1";
			String port = "3306";
			
			String dbName = "Trivia";
			String username = "root";
			String password = "MySQL456";
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
