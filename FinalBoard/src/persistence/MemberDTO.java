package persistence;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberDTO {
	private static Logger log = LoggerFactory.getLogger(MemberDTO.class);
	private String email;
	private String pwd;
	private String nickname;
	private int grade;
		
	public MemberDTO() {
	}
	
	public MemberDTO(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
	}
	
	public MemberDTO(String email, String pwd, String nickname) {
		this.email = email;
		this.pwd = pwd;
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
}
