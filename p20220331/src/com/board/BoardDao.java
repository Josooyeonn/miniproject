package com.board;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardDao extends DAO implements BoardIF {
	Board board = new Board();
	Scanner scn = new Scanner(System.in);
	List<Board> boards = new ArrayList<Board>();

	// 게시글 전체 목록
	public List<Board> boardList() {
		List<Board> boards = new ArrayList<Board>();
		conn = getConnect();
		try {
			psmt = conn.prepareStatement("SELECT * FROM board");
			rs = psmt.executeQuery();
 			while (rs.next()) {
				Board board = new Board();

				board.setbNo(rs.getInt("b_no"));
				board.setbTitle(rs.getString("b_Content"));
	 	 		board.setbContent(rs.getString("b_title"));
				board.setbWriter(rs.getString("b_Writer"));
				board.setbDate(rs.getString("b_Date"));

				boards.add(board);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return boards;

	} 

	// 게시글 등록

	public boolean insert(Board bod) {

	 	conn = getConnect();
	 	String sql = "INSERT INTO board(b_no, b_title, b_writer, b_content, b_date)\r\n"
	 			+ "VALUES ((SELECT NVL(MAX(b_no),0)+1 FROM board), ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bod.getbTitle());
 	 		psmt.setString(2, bod.getbWriter());
		  	psmt.setString(3, bod.getbContent());
	 		psmt.setString(4, bod.getbDate());

			int r = psmt.executeUpdate();
 
			if (r > 0) {

				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();

		}				
		
		return false;

	}

	// 게시글 수정

	public boolean modify(Board board) {

		conn = getConnect();

		String sql = "UPDATE board " + "SET b_title = ?, b_writer = ?, b_content = ? WHERE b_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getbTitle());
	 		psmt.setString(2, board.getbWriter());
			psmt.setString(3, board.getbContent());
			psmt.setInt(4, board.getbNo());

			int r = psmt.executeUpdate();

			if (r > 0) {
		 		return true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return false;

	}

	//
	public boolean delete(int bno) {
		conn = getConnect();
		String sql = "DELETE FROM board " + "WHERE b_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
	 		psmt.setInt(1, bno);

			int r = psmt.executeUpdate();

			if (r > 0) {

	 			return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return false;

		// 게시글 삭제

	}

	@Override
	public List<Board> searchTitle(String name) {

		conn = getConnect();
		String sql = "SELECT * FROM board WHERE b_title LIKE ?";
		Board board = null;
		List<Board> list = new ArrayList<Board>();
		try {
			psmt = conn.prepareStatement(sql);
 	  		psmt.setString(1, '%'+name+'%');
	  	 	rs = psmt.executeQuery();
 	   		while (rs.next()) {

				board = new Board();
				
				board.setbNo(rs.getInt("b_no"));
	 	 		board.setbTitle(rs.getString("b_title"));
	  		 	board.setbContent(rs.getString("b_content"));
	 	  		board.setbWriter(rs.getString("b_writer"));
			  	board.setbDate(rs.getString("b_Date"));

				list.add(board);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();			
		}
		return list;
	}
	
//	public void boardCount(String bno) {
//		conn = getConnect();
//		String sql = "UPDATE b_title SET "
//				+ "b_view = b_view+1 where b_no=1";
//		try {psmt = conn.prepareStatement(sql);
//			System.out.println(sql);
//			psmt.executeUpdate();
//		}
//		catch(SQLException e) {
//			
//		} finally {
//			disconnect();
//		}
//	}
//	
//	public List<Board> selectContent(String bno) {
//
//		conn = getConnect();
//		String sql = "SELECT * FROM board WHERE b_bo LIKE ?";
//		Board board = null;
//		List<Board> list = new ArrayList<Board>();
//		
//		try {
//			psmt = conn.prepareStatement(sql);
//	 		psmt.setString(1, bno);
//	 	 	rs = psmt.executeQuery();
// 	  		while (rs.next()) {
//
//				board = new Board();
//
//	 			board.setbTitle(rs.getString("b_title"));
//				board.setbContent(rs.getString("b_content"));
//	 	  		board.setbWriter(rs.getString("b_writer"));
//				board.setbDate(rs.getString("b_Date"));
//
//				list.add(board);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			disconnect();			
//		}
//		return list;
//	}
//	
//	public void comment() {
//		
//		
//		
//	}
//	
}
