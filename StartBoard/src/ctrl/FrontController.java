package ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.Action;
import service.DeleteAction;
import service.DetailAction;
import service.InsertAction;
import service.ListAction;
import service.ModifyAction;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
			try {
				action.execute(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			targetPage = "list.do";
			
		} else if(path.equals("/list.do")) {
			action = new ListAction();
			try {
				action.execute(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			targetPage = "/list.jsp";
			
		} else if(path.equals("/detail.do")) {
			action = new DetailAction();
			try {
				action.execute(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			targetPage = "/detail.jsp";
			
		} else if(path.equals("/modify.do")) {
			action = new DetailAction();
			try {
				action.execute(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			targetPage = "/modify.jsp";
			
		} else if(path.equals("/modifySave.do")) {
			action = new ModifyAction();
			try {
				action.execute(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			targetPage = "/detail.do";
		} else if(path.equals("/delete.do")) {
			action = new DeleteAction();
			try {
				action.execute(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			targetPage = "list.do";
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
