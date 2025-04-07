package com.mbc.kee12.sang;

import java.util.ArrayList;

public interface SangService {


	void inserta(String sname, String fname);

	ArrayList<SangDTO> all2out();

	SangDTO deletee(int snum);

	void delete22(int snum);

	SangDTO modify11(int snum);

	void insertmodi(int snum, String sname, String fname);


	ArrayList<SangDTO> searchgo(String key, String value);



}
