package ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.BoardDAO;

public class FrontController extends HttpServlet {

	private static Logger log = LoggerFactory.getLogger(FrontController.class);
	
	public FrontController() {}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		log.info("uri : " + uri );
		
		String contexPath = req.getContextPath();
		log.info("context : " + contexPath);
		
		String path = uri.substring(contexPath.length());
		log.info("path : " + path);
		
		String targetPage = "";
		
		if (path.equals("/writeSave.do")) {
			String title = req.getParameter("title");
			String author = req.getParameter("author");
			String content = req.getParameter("content");
			String email = req.getParameter("email");
			
			BoardDAO bdao = new BoardDAO();
			boolean flag = bdao.insert(title, author, content, email);
			if(flag) {
				log.info(">>> Insert Data Success");
			} else {
				log.info(">>> Insert Data Fail");
			}			
			
			targetPage = "/testReturn.jsp";
		}
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher(targetPage);
		requestDispatcher.forward(req, resp);
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
