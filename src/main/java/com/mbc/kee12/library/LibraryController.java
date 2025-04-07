package com.mbc.kee12.library;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
public class LibraryController {

	@Autowired
	SqlSession sqlSession;
	String path = "C:\\mbc12ai\\spring\\day10_board\\src\\main\\webapp\\image";
	@RequestMapping(value = "/libinput")
	public String ll()
	{
		return "libin";
	}
	
	@RequestMapping(value = "/libsave")
	public String ll2(MultipartHttpServletRequest mul) throws IllegalStateException, IOException
	{
		String bname=mul.getParameter("bname");
		String bwriter=mul.getParameter("bwriter");
		String bdate=mul.getParameter("bdate");
		String bintro=mul.getParameter("bintro");
		int bprice=Integer.parseInt(mul.getParameter("bprice"));
		MultipartFile mf=mul.getFile("bimg");
		String fname = mf.getOriginalFilename();
		
		UUID uu = UUID.randomUUID();
		fname=uu.toString()+"_"+fname;
		
		LibraryService ls = sqlSession.getMapper(LibraryService.class);
		ls.insertok(bname,bwriter,bdate,bintro,bprice,fname);
		
		mf.transferTo(new File(path+"\\"+fname));
		
		return "redirect:/";
	}
	@RequestMapping(value = "/libout")
	public String ll3(Model mo)
	{
		LibraryService ls = sqlSession.getMapper(LibraryService.class);
		ArrayList<LibraryDTO> list = ls.out2();
		mo.addAttribute("list", list);
		return "libout";
	}
	@RequestMapping(value = "/libdetail")
	public String ll4(HttpServletRequest request, Model mo)
	{
		int bnum = Integer.parseInt(request.getParameter("bnum")) ;
		LibraryService ls = sqlSession.getMapper(LibraryService.class);
		ls.readcnt(bnum);
		LibraryDTO dto = ls.lidetail(bnum);
		mo.addAttribute("dto", dto);
		return "libdetailview";
	}
	@RequestMapping(value = "/modify")
	public String ll5(HttpServletRequest request, Model mo)
	{
		int bnum = Integer.parseInt(request.getParameter("bnum")) ;
		LibraryService ls = sqlSession.getMapper(LibraryService.class);
		ls.readcnt(bnum);
		LibraryDTO dto = ls.modify1(bnum);
		mo.addAttribute("dto", dto);
		return "modify";
	}
	@RequestMapping(value = "/modisave")
	public String ll6(MultipartHttpServletRequest mul, Model mo) throws IllegalStateException, IOException
	{
		int bnum = Integer.parseInt(mul.getParameter("bnum")) ;
		String bname=mul.getParameter("bname");
		String bwriter=mul.getParameter("bwriter");
		String bdate=mul.getParameter("bdate");
		String bintro=mul.getParameter("bintro");
		int bprice=Integer.parseInt(mul.getParameter("bprice"));
		MultipartFile mf=mul.getFile("bimg");
		String dfname = mul.getParameter("himage");
		String fname = mf.getOriginalFilename();
		
		UUID uu = UUID.randomUUID();
		fname=uu.toString()+"_"+fname;
		
		LibraryService ls = sqlSession.getMapper(LibraryService.class);
		ls.modify2(bname,bwriter,bdate,bintro,bprice,fname,bnum);
		System.out.println(fname);
		mf.transferTo(new File(path+"\\"+fname));
		File ff= new File(path+"\\"+dfname);
		ff.delete();
		return "redirect:/libout";
	}
	@RequestMapping(value = "/delete1")
	public String ll7(HttpServletRequest request,Model mo) 
	{
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		
		LibraryService ls = sqlSession.getMapper(LibraryService.class);
		
		LibraryDTO dto = ls.delete1(bnum);
		mo.addAttribute("dto", dto);
		
		return "deleteview";
	}
	@RequestMapping(value = "/delete2")
	public String ll8(HttpServletRequest request,Model mo) 
	{
		int snumber = Integer.parseInt(request.getParameter("bnum"));
		String dfname = request.getParameter("himage");
		LibraryService ss = sqlSession.getMapper(LibraryService.class);
		ss.delete2(snumber);
		File ff = new File(path+"\\"+dfname);
		ff.delete();
		
		return "redirect:/libout";
	}
}
