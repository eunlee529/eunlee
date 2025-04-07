package com.mbc.kee12.library;

import java.util.ArrayList;

public interface LibraryService {

	void insertok(String bname, String bwriter, String bdate, String bintro, int bprice, String fname);

	ArrayList<LibraryDTO> out2();

	void readcnt(int bnum);


	LibraryDTO lidetail(int bnum);

	LibraryDTO modify1(int bnum);

	void modify2(String bname, String bwriter, String bdate, String bintro, int bprice, String fname, int bnum);

	LibraryDTO delete1(int bnum);

	void delete2(int snumber);

}
