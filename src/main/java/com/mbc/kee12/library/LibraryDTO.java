package com.mbc.kee12.library;


public class LibraryDTO {
	int bnum;
	String bname,bwriter,bdate,bintro;
	int bprice;
	String bimg;
	int libreadcnt;
	
	public LibraryDTO() {}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getBintro() {
		return bintro;
	}

	public void setBintro(String bintro) {
		this.bintro = bintro;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}

	public String getBimg() {
		return bimg;
	}

	public void setBimg(String bimg) {
		this.bimg = bimg;
	}

	public int getLibreadcnt() {
		return libreadcnt;
	}

	public void setLibreadcnt(int libreadcnt) {
		this.libreadcnt = libreadcnt;
	}
	
	
	
}
