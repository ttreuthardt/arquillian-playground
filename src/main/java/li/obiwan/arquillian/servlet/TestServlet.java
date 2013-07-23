package li.obiwan.arquillian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = -9210147268729058925L;

	public static final String RESPONSE = "TestServlet Response";
	public static final String URL_PATTERN = "/TestServlet";


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		out.println(RESPONSE);
		out.flush();
	}
}
