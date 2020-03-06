package ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	public FrontController() {}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		System.out.println("uri : " + uri );
		
		String contexPath = req.getContextPath();
		System.out.println("context : " + contexPath);
		
		String path = uri.substring(contexPath.length());
		System.out.println("path : " + path);
		
		if (path.equals("/test.do")) {
			String name = req.getParameter("myName");
			System.out.println("Is this myName transfered?" + name);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}

	
	

}
