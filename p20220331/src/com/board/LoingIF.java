package com.board;

public interface LoingIF {

	public boolean boardLogin(String id, String pw); 
	public String boardcheck(String id, String pw); 
	public boolean join(Board join);
	
}