package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CookieDao;
import model.CookieModel;

@WebServlet(urlPatterns = { "/add" }) // /add?cookie=
public class AddCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		PrintWriter pw = resp.getWriter();
		String cookieValue = req.getParameter("cookie");
		
		if (cookieValue != null) {
			pw.println("Cookie: " + cookieValue);
			
			CookieModel c = new CookieModel();
			c.setValue(cookieValue);
			
			CookieDao cookieDao = new CookieDao();
			cookieDao.add(c);
		} else {
			pw.println("Null cookie");
		}

		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		PrintWriter pw = resp.getWriter();
		String cookieValue = req.getParameter("cookie");
		
		if (cookieValue != null) {
			pw.println("Cookie: " + cookieValue);
			
			CookieModel c = new CookieModel();
			c.setValue(cookieValue);
			
			CookieDao cookieDao = new CookieDao();
			cookieDao.add(c);
		} else {
			pw.println("Null cookie");
		}

		pw.close();
	}
}
