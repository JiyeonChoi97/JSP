package service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.BoardDAO;
import model.BoardDTO;

public class DeleteAction implements Action {
	private static Logger log = LoggerFactory.getLogger(InsertAction.class);	

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {

		Integer bno = (Integer)req.getAttribute("clno");
		if(bno == null) {
			bno =  Integer.parseInt(req.getParameter("clno"));
		} 
		
		
		
		BoardDAO bdao = new BoardDAO();
		BoardDTO bdto = (BoardDTO)bdao.delete(bno);
		
		if(bdto == null) {
			log.info("Getting Delete Data Fail From DB");
		} 

		req.setAttribute("bdto", bdto);		
	}

}

