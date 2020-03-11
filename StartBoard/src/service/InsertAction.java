package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.BoardDAO;
import model.BoardDTO;

public class InsertAction implements Action{

	private static Logger log = LoggerFactory.getLogger(InsertAction.class);	
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String content = req.getParameter("content");
		String email = req.getParameter("email");
		
		BoardDTO bdto = new BoardDTO(title, author, content, email);
		
		
		BoardDAO bdao = new BoardDAO();
		boolean flag = bdao.insert(bdto);
		if(flag) {
			log.info(">>> Insert Data Success");
		} else {
			log.info(">>> Insert Data Fail");
		}					
	}
	

}
