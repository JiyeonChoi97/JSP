package service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.BoardDAO;
import model.BoardDTO;

public class ModifyAction implements Action {

	private static Logger log = LoggerFactory.getLogger(InsertAction.class);	
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {

		int bno = Integer.parseInt(req.getParameter("clno"));
		
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String content = req.getParameter("content");
		String email = req.getParameter("email");
		
		BoardDTO bdto = new BoardDTO(title, author, content, email);
		bdto.setBno(bno);
		
		BoardDAO bdao = new BoardDAO();
		boolean flag = bdao.modify(bdto);
		
		if(flag) {
			log.info(">>> Modify Data Success");
		} else {
			log.info(">>> Modify Data Fail");
		}	
		req.setAttribute("clno", bno);
		
		
	}

}
