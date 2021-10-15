package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CookieDao;

@WebServlet(urlPatterns = { "/delete-all" })
public class DeleteAllCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CookieDao cookieDao = new CookieDao();
		cookieDao.deleteAll();
		
		resp.setContentType("text/html");

		PrintWriter pw = resp.getWriter();
		pw.println("Delete all cookie success!");
		pw.println("</br>");
		pw.println("<a href='./'>Show all cookie</a>");
		
		pw.close();
	}
}
