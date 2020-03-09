package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//DAO : Data Access Object
public class BoardDAO {

	private static Logger log = LoggerFactory.getLogger(BoardDAO.class);
	DataSource ds;
	Connection cn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	public BoardDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/mysql");
			
		} catch (NamingException e) {
			log.info(">>> error : DBCP Fail!");
			e.printStackTrace();
		}

	}
	
	public boolean insert(String title, String author, String content, String email){
		String sql = "INSERT INTO board(title, author, content, email, regdate)"
				+ " VALUES(?,?,?,?,now())";
		try {
			cn = ds.getConnection();
			pst = cn.prepareStatement(sql);
			pst.setString(1, title);
			pst.setString(2, author);
			pst.setString(3, content);
			pst.setString(4, email);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
