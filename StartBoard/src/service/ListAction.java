package service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.BoardDAO;
import model.BoardDTO;

public class ListAction implements Action{
	
	private static Logger log = LoggerFactory.getLogger(InsertAction.class);	


	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
		BoardDAO bdao = new BoardDAO();
		
		ArrayList<BoardDTO> bList = (ArrayList<BoardDTO>)bdao.getList();
		
		if(bList == null) {
			log.info("Getting Data List Fail From DB");
		} 
		
		req.setAttribute("bList", bList);		
	}

}
