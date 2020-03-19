package service;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import persistence.MemberDAO;
import persistence.MemberDAOImpl;
import persistence.MemberDTO;
import persistence.ProductDTO;

public class MemberserviceImpl implements MemberService {

	private static Logger log = LoggerFactory.getLogger(MemberserviceImpl.class);
	MemberDAO mdao;
	List<MemberDTO> memList;

	public MemberserviceImpl() {
		mdao = new MemberDAOImpl();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String sign) {	//값 받아서 객체 생성
		if(sign.equals("regist")) {
			String email = request.getParameter("email");
			String pwd = request.getParameter("pwd");
			String nick = request.getParameter("nick");
			MemberDTO mdto = new MemberDTO(email, pwd, nick);
			boolean flag = regist(mdto);
			if(flag) {
				log.info(">>> 회원등록 성공");
			} else{
				log.info(">>> 회원등록 실패");
			}
		} else if(sign.equals("login")) {
			String email = request.getParameter("email");
			String pwd = request.getParameter("pwd");
			MemberDTO mdto = new MemberDTO(email, pwd);
			MemberDTO logindto = login(mdto);
			if(logindto != null) {
				log.info(">>> 회원 로그인 성공");
				HttpSession session = request.getSession();
				session .setAttribute("email", logindto.getEmail());
				session .setAttribute("nick", logindto.getNickname());
				session .setAttribute("grade", logindto.getGrade());
				session .setMaxInactiveInterval(5 * 60);
			} else{
				log.info(">>> 회원 로그인 실패");
			}
		} else if(sign.equals("idCheck")) {
			String email = request.getParameter("inemail");
			int isExist = idCheck(email);
			if(isExist > 0) {
				log.info(">>> 회원가입 불가!");
				try {
					PrintWriter out = response.getWriter();
					out.print(isExist);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				log.info(">>> 회원가입 가능!");
			}
			
		} else if(sign.equals("memList")) {

			 memList = getList();	
			 request.setAttribute("objMList", memList);
			
		}
	}

	@Override
	public boolean regist(MemberDTO mdto) { // 받은 데이터 검사 작업
		log.info("데이터 안전 검사 로직 부분 >>> 실행");
		boolean flag = mdao.join(mdto);
		if(flag) {
			return true;
		} else	return false;
	}

	@Override
	public MemberDTO login(MemberDTO mdto) {
		log.info("데이터 안전 검사 로직 부분 >>> 실행");
		MemberDTO logindto = mdao.login(mdto);
		if(logindto != null) {
			return logindto;
		} else return null;
	}

	@Override
	public int idCheck(String email) {
		return mdao.idCheck(email);
	}

	@Override
	public List<MemberDTO> getList() {
		return mdao.selectList();
	}




}
