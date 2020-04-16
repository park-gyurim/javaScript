package com.yedam.board;

public class Board {
	int BoardNo;
	String Content;
	String Writer;
	String Date;
	public int getBoardNo() {
		return BoardNo;
	}
	public void setBoardNo(int boardNo) {
		this.BoardNo = boardNo;
	}
	public String getContent() {
		return Content;
		
	}
	public void setContent(String content) {
		this.Content = content;
	}
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		this.Date = date;
	}
	@Override
	public String toString() {
		return "Board [BoardNo=" + BoardNo + ", Content=" + Content + ", Writer=" + Writer + ", Date=" + Date + "]";
	}
	
	
}
