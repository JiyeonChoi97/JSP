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
			targetPage = "list.do";
			
		} else if(path.equals("/list.do")) {
			BoardDAO bdao = new BoardDAO();
			
			ArrayList<BoardDTO> bList = (ArrayList<BoardDTO>)bdao.getList();
			
			if(bList == null) {
				log.info("Getting Data List Fail From DB");
			} 
			
			req.setAttribute("bList", bList);
			targetPage = "/list.jsp";
		} else if(path.equals("/detail.do")) {
			int bno =  Integer.parseInt(req.getParameter("clno"));
			BoardDAO bdao = new BoardDAO();
			BoardDTO bdto = (BoardDTO)bdao.getDetail(bno);
			
			if(bdto == null) {
				log.info("Getting Detail Data Fail From DB");
			} 
			
			req.setAttribute("bdto", bdto);
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
