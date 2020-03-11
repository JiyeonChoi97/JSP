package service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

	void execute(HttpServletRequest req, HttpServletResponse resp)  throws SQLException;
}
