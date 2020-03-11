package ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.BoardDAO;
import model.BoardDTO;
import service.Action;
import service.DetailAction;
import service.InsertAction;
import service.ListAction;

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
		
		Action action = null;
		
		if (path.equals("/writeSave.do")) {
			action = new InsertAction();
			action.execute(req, resp);
			targetPage = "list.do";
			
		} else if(path.equals("/list.do")) {
			action = new ListAction();
			action.execute(req, resp);
			targetPage = "/list.jsp";
			
		} else if(path.equals("/detail.do")) {
			action = new DetailAction();
			action.execute(req, resp);
			targetPage = "/detail.jsp";
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
