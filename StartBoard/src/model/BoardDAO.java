package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	public boolean insert(BoardDTO bdto){
		String sql = "INSERT INTO board(title, author, content, email, regdate)"
				+ " VALUES(?,?,?,?,now())";
		try {
			cn = ds.getConnection();
			pst = cn.prepareStatement(sql);
			pst.setString(1, bdto.getTitle());
			pst.setString(2, bdto.getAuthor());
			pst.setString(3, bdto.getContent());
			pst.setString(4, bdto.getEmail());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public ArrayList<BoardDTO> getList() {
		
		String sql = "SELECT * FROM board ORDER BY bno DESC";
		ArrayList<BoardDTO> bList = new ArrayList<>();
		
		try {
			cn = ds.getConnection();
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BoardDTO bdto = new BoardDTO();
				bdto.setBno(rs.getInt("bno"));
				bdto.setTitle(rs.getString("title"));
				bdto.setAuthor(rs.getString("author"));
				bdto.setContent(rs.getString("content"));
				bdto.setEmail(rs.getString("email"));
				bdto.setRegdate(rs.getDate("regdate"));
				bList.add(bdto);
				
			}
			
			return bList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public BoardDTO getDetail(int clno) {
		String sql = "SELECT * FROM board WHERE bno=clno ORDER BY bno DESC";
		
		try {
			cn = ds.getConnection();
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BoardDTO bdto = new BoardDTO();
				bdto.setBno(rs.getInt("bno"));
				bdto.setTitle(rs.getString("title"));
				bdto.setAuthor(rs.getString("author"));
				bdto.setContent(rs.getString("content"));
				bdto.setEmail(rs.getString("email"));
				bdto.setRegdate(rs.getDate("regdate"));
				
			}
			
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
