package com.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardExe {
	Board board = new Board();
	Scanner scn = new Scanner(System.in);
	BoardDao dao = new BoardDao();
	List<Board> boards = new ArrayList<Board>();
	String id;
	String pw;
	int menu;

	public void execute() {
		System.out.println("\t\t==============================");
		System.out.println("\t\t　　　　　　　로그인 페이지입니다.　　　　　");
		System.out.println("\t\t------------------------------");

		BoardLogin boardLogin = new BoardLogin();
		while (true) {
			System.out.println("\t\t\t ▷ 1. 로그인");
			System.out.println("\t\t\t ▷ 2. 회원가입");
			System.out.println("\t\t\t ▷ 9. 종료");
	 		System.out.println("\t\t==============================");
	 		System.out.print("\t\t\t    ▶ ");
			menu = scn.nextInt();
			if (menu == 1) {
				System.out.println("\t\t\t ▶ 1. 로그인");
				System.out.println("\t\t------------------------------");
				System.out.print("\t\t  아이디를 입력 해 주세요. > ");
	 			id = scn.next();
				System.out.print("\t\t  비밀번호를 입력 해 주세요. > ");
	 	 		pw = scn.next();
		 		boolean login = boardLogin.boardLogin(id, pw);

				if (login == true) {

					while (true) {
						System.out.println("1. 게시글 목록 2. 게시글 등록 3. 게시글 수정 4. 게시글 삭제 5. 게시글 검색 9. 로그아웃");
						System.out.print("메뉴를 입력해주세요. > ");
						menu = scn.nextInt();
 
						if (menu == 1) {
							List<Board> list = dao.boardList();
							System.out.println("전체 게시글 목록");
							for (Board board : list) {
					 			System.out.println(board.toString());
							}

						} else if (menu == 2) {

							int bNo;
							String bTitle, bContent, bWriter, bDate;

//							System.out.println("게시글 번호를 입력해주세요.");
							bNo = 0;
							System.out.print("\t\t 제목을 입력해주세요. > ");
					 		bTitle = scn.next();
							System.out.print("\t\t 작성자 명을 입력해주세요. > ");
							bWriter = scn.next();
							System.out.print("\t\t 내용을 입력해주세요. > ");
							bContent = scn.next();
							System.out.print("\t\t 작성 날짜를 입력해주세요. > ");
							bDate = scn.next();

							Board board = new Board(bNo, bTitle, bContent, bWriter, bDate);

							dao.insert(board);

						} else if (menu == 3) {
							// 게시글 수정

							System.out.print("수정할 글 번호를 입력해주세요. > ");
 							int num = scn.nextInt();
							System.out.print("제목을 입력해주세요. > ");
							String title = scn.next();
						 	System.out.print("내용을 입력해주세요. > ");
							String content = scn.next();
							System.out.print("작성자를 입력해주세요. > ");
							String writer = scn.next();

							Board board = new Board(title, writer, content, num);

							dao.modify(board);

						} else if (menu == 4) {
							// 게시글 삭제
							System.out.print("삭제할 글 번호를 입력해주세요. > ");
							int num = scn.nextInt();
							dao.delete(num);

						} else if(menu == 5) {
						 	System.out.print("검색 할 글의 제목을 입력해주세요. > ");
							String name = scn.next();
	 					 	List <Board> list = dao.searchTitle(name);
						 	for(Board b : list) {
			 					System.out.println(b.toString());
							}
							
							
						}else if (menu == 9) {

							System.out.println("로그아웃이 완료되었습니다.");
							break;

						} else {
							System.out.println("메뉴를 잘못 선택하셨습니다.");
						}

					}

				} else
					System.out.println("입력이 잘못 되었습니다.");

			} else if (menu == 2) {

				System.out.print("아이디를 입력해주세요. > ");
				String id = scn.next();
				System.out.print("비밀번호를 입력해주세요. > ");
				String pw = scn.next();

				String idCheck = boardLogin.boardcheck(id, pw);
				try {
	 				if (idCheck.equals(id)) {
						System.out.println("중복된 아이디입니다.");
					}
				} catch (NullPointerException e) {
					Board board = new Board(id, pw);

					boardLogin.join(board);
				}

			} else if (menu == 9) {

	 			scn.close();
	 			
	 			System.out.println("\t\t         시스템을 종료합니다.");
	 			System.out.println("\t\t------------------------------");
				System.out.println("\t\t        - end of prog -");
		 		break;

			} else {
				System.out.println("메뉴를 잘못 선택하셨습니다.");

			}
		}

//		
//

	}
}
