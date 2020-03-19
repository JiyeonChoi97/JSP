package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.MemberDTO;
import persistence.ProductDTO;

public interface MemberService {

	void execute(HttpServletRequest request, HttpServletResponse response, String sign);
	boolean regist(MemberDTO mdto);
	MemberDTO login(MemberDTO mdto);
	int idCheck(String email);
	List<MemberDTO> getList();

	
}
