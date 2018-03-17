package trivia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import trivia.model.TriviaEntry;

@WebServlet("/AdminTrivia")
public class AdminTrivia extends HttpServlet {
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
		
		try {
			String host = "127.0.0.1";
			String port = "3306";
			
			String dbName = "Trivia";
			String username = "root";
			String password = "MySQL456";
			
			String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
			c = DriverManager.getConnection(url, username, password);
			
			Statement state = c.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM quiz");
			
			ArrayList<TriviaEntry> entries = new ArrayList<TriviaEntry>();
			
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String question = rs.getString("question");
				String answer = rs.getString("answer");
				TriviaEntry entry = new TriviaEntry(id, question, answer);
				entries.add(entry);
			}
			
			request.setAttribute("quiz", entries);
			request.getRequestDispatcher("/WEB-INF/views/AdminTrivia.jsp").forward(request, response);
			
		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				if (c != null) {
					c.close();
				}
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		
		try {
			String host = "127.0.0.1";
			String port = "3606";
			
			String dbName = "Trivia";
			String username = "root";
			String password = "MySQL456";
			
			String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
			conn = DriverManager.getConnection(url, username, password);
			
			Statement state = conn.createStatement();
			state.executeQuery("INSERT INTO quiz (id, question, answer) VALUES (NULL, ' " + request.getParameter("question") + " ',' " + request.getParameter("answer") + " '); ");
			
			response.sendRedirect("AdminTrivia");
		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}
	}

}
