package com.board;

public class Board {

	private int bNo;
	private String bTitle;
	private String bContent;
	private String bWriter;
	private String bDate;
	private String bId;
	private String bPw;
	
 public void Login(String id, String pw) {
	 this.bId=id;
  	 this.bPw=pw;
 }	
	
	public String getbId() {
		return bId;
	}


	public void setbId(String bId) {
		this.bId = bId;
	}


	public String getbPw() {
		return bPw;
	}


	public void setbPw(String bPw) {
		this.bPw = bPw;
	}

	

	public Board(String bId, String bPw) {
		super();
		this.bId = bId;
		this.bPw = bPw;
	}


	public Board(String bTitle2, String bWriter2, String bContent2, int num) {
  	   	this.bTitle = bTitle2;
 	 	this.bWriter = bWriter2;
	 	this.bContent = bContent2;
	 	this.bNo = num;
		
	}
	
	
	
	
	public Board(String bTitle, String bContent, String bWriter, String bDate) {
		super();
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWriter = bWriter;
		this.bDate = bDate;
	}

	public Board(int bNo, String bTitle1,String bContent, String bWriter, String bDate) {

   	   	this.bContent = bContent;
	   	this.bTitle = bTitle1;
	 	this.bWriter = bWriter;
 		this.bDate = bDate;
 		this.bNo = bNo;
	}
	
	public Board() {}
//	}
//		
//	public Board(String title, String writer, String content, int num) {
//	}

	
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getbTitle() {
	  	return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
 	public void setbContent(String bContent) {
	 	this.bContent = bContent;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbDate() {
 		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}

	@Override
	public String toString() {
		return "　글 번호 : "+bNo+ " 글 제목 : " + bTitle +  " 글 내용 : " + bContent+ 
				" 작성자 : " + bWriter+ " 작성일 : " + bDate;
	}
	
	
	
	
	

}
