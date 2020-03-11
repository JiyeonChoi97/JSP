package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.BoardDAO;
import model.BoardDTO;

public class DetailAction implements Action{

	private static Logger log = LoggerFactory.getLogger(InsertAction.class);	

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		int bno =  Integer.parseInt(req.getParameter("clno"));
		BoardDAO bdao = new BoardDAO();
		BoardDTO bdto = (BoardDTO)bdao.getDetail(bno);
		
		if(bdto == null) {
			log.info("Getting Detail Data Fail From DB");
		} 
		
		req.setAttribute("bdto", bdto);		
	}
	

}
