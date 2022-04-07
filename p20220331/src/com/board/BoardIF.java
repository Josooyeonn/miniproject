package com.board;

import java.util.List;

public interface BoardIF {

	public List<Board> boardList();
	public boolean insert(Board bod);
	public boolean modify(Board board);
	public boolean delete(int bno);
	public List<Board> searchTitle (String name);
}
