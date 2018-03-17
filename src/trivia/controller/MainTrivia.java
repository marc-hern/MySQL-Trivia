package trivia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

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
			
			String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
			c = DriverManager.getConnection(url, username, password);
			
			Statement state = c.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM quiz ORDER BY RAND() LIMIT 5");
			
			ArrayList<TriviaEntry> entries = new ArrayList<TriviaEntry>();
			
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String question = rs.getString("question");
				String answer = rs.getString("answer");
				TriviaEntry entry = new TriviaEntry(id, question, answer);
				entries.add(entry);
			}
			
			request.setAttribute("questions", entries.get(1));
			request.getRequestDispatcher("/WEB-INF/views/MainTrivia.jsp").forward(request, response);
			
			while (x < entries.size()) {
				request.setAttribute("questions", entries.get(x));
				request.getRequestDispatcher("/WEB-INF/views/MainTrivia.jsp").forward(request, response);
			}
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
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		ServletContext context = this.getServletContext();
		ArrayList<TriviaEntry> entries = (ArrayList<TriviaEntry>) context.getAttribute("");
		
		doGet(request, response);
	}

}
