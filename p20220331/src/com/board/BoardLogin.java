package com.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardLogin extends DAO implements LoingIF {

	Board board = new Board();
	Scanner scn = new Scanner(System.in);
	List<Board> boards = new ArrayList<Board>();

	@Override
	public boolean boardLogin(String id, String pw) {
		conn = getConnect();
		String sql = "SELECT * FROM BOARD_INFO WHERE b_id=? AND b_pw=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();

			if (rs.next()) {
				int r = psmt.executeUpdate();
				if (r > 0) {
					System.out.println("\t\t==============================");
					System.out.println("\t\t\t　　　로그인 성공　　　　　");
					System.out.println("\t\t==============================");
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return false;
	}

	// 오류 처리용

	public String boardcheck(String id, String pw) {
		conn = getConnect();
		String sql = "SELECT b_id FROM BOARD_INFO WHERE b_id=? AND b_pw=?";
		String check = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();

			if (rs.next()) {
				check = rs.getString("b_id");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return check;
	}

	public boolean join(Board join) {

		conn = getConnect();
		String sql = "INSERT INTO board_info(b_id, b_pw) VALUES (?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, join.getbId());
			psmt.setString(2, join.getbPw());

			int r = psmt.executeUpdate();

			if (r > 0) {
				System.out.println("\t\t==============================");
				System.out.println("\t\t   　　　회원 가입이 완료되었습니다.　");
				System.out.println("\t\t==============================");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();

		}
		System.out.println("\t\t\t=====================");
		System.out.println("　　　중복된 아이디입니다.　　　");
		System.out.println("\t\t\t=====================");
		return false;
	}
}
