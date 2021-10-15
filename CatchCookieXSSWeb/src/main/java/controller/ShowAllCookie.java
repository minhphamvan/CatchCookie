package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CookieDao;
import model.CookieModel;

@WebServlet(urlPatterns = {"/show"})
public class ShowAllCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CookieDao cookieDao = new CookieDao();
		List<CookieModel> list = cookieDao.getAll();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		if(list.size() != 0) {
			pw.println("<h3>List cookie</h3>");
			
			for (CookieModel c : list) {
				pw.println(c.getId() + ": " + c.getValue());
				pw.println("</br>");
				pw.println("</br>");
			}
		}
		else {
			pw.println("<h4>List cookie null.</h4>");
		}
		
		pw.close();
	}
}
