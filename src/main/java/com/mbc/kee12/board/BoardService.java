package com.mbc.kee12.board;

import java.util.ArrayList;

public interface BoardService {

	void insertbd(String name, String title, String content);

	ArrayList<BoardDTO> all2out();

	void readcntup(int bnum);

	BoardDTO detail(int bnum);

	BoardDTO alldata(int bnum);

	void appendc(int bnum, String title, String name, String content, int groups, int step, int indent);

	void stepup(int groups, int step);

	// 페이징처리에서 게시글 조회 3333333
	public int total();// 전체레코드수구하기

	public ArrayList<BoardDTO> page(PageDTO dto);// 페이지정보

}
