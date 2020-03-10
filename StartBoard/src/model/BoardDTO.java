package model;

import java.util.Date;

public class BoardDTO {
	//멤버필드
	private int bno;
	private String title;
	private String author;
	private String content;
	private String email;
	private Date regdate;
	
	
	
	public BoardDTO() {}
	
	public BoardDTO(String title, String author, String content, String email) {
		this.title = title;
		this.author = author;
		this.content = content;
		this.email = email;
	}

	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", title=" + title + ", author=" + author + ", content=" + content + ", email="
				+ email + ", regdate=" + regdate + "]";
	}
	
}
