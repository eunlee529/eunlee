package com.mbc.kee12.board2;

import java.util.ArrayList;


public interface BoardService2 {

	void insertboard(String name, String title, String content);

	ArrayList<BoardDTO2> bdoutss();
	
	void bdreadcount(int bdnum);
	
	BoardDTO2 bddetail(int bdnum);

	BoardDTO2 bdalldata(int bdnum);

	void stepss(int groups, int step);

	void boardappend(int bnum, String name, String title, String content, int groups, int step, int indent);

	//페이징처리에서 게시글 조회 3333333
	   public int total22();//전체레코드수구하기
	   public ArrayList<BoardDTO2> page22(PageDTO2 dto);//페이지정보 


	

	

}
