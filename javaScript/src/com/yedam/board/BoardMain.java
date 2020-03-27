package com.yedam.board;

import java.util.List;


public class BoardMain {
	public static void main(String[] args) {
//		BoardDao e = new BoardDao();
//		List<Board> elist = e.getBoardList();
//		for( Board brd : elist) {
//			System.out.println(brd);
//			
//		}
//		Board board = new Board();
//		board.setWriter("user1");
//		board.setContent("java test");
//		
//		e.insertBoard(board);
		
		BoardDao b = new BoardDao();
		Board brd  = b.getBoardInfo(3);
		System.out.println(brd);
	}

}
