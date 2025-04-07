package com.mbc.kee12.sang;

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
public class SangController {
	
	@Autowired
	SqlSession sqlSession;
	String path = "C:\\mbc12ai\\spring\\day10_board\\src\\main\\webapp\\image";
	@RequestMapping(value = "/sanginput")
	public String ss1()
	{
		return "sinput";
	}
	
	@RequestMapping(value = "/ssave")
	public String ss2(MultipartHttpServletRequest mul) throws IllegalStateException, IOException
	{
		String sname=mul.getParameter("sname");
		MultipartFile mf = mul.getFile("simg") ;
		String fname = mf.getOriginalFilename();
		
		UUID uu =UUID.randomUUID();
		fname = uu.toString()+"_"+fname;
		
		SangService ss= sqlSession.getMapper(SangService.class);
		ss.inserta(sname,fname);
		
		mf.transferTo(new File(path+"\\"+fname));
		
		
		return "redirect:/";
	}
	@RequestMapping(value = "/sangout")
	public String ss3(Model mo)
	{
		SangService ss= sqlSession.getMapper(SangService.class);
		ArrayList<SangDTO> list = ss.all2out();
		mo.addAttribute("list", list);
		return "sout";
		
	}
	@RequestMapping(value = "/delete11")
	public String ss4(HttpServletRequest request,Model mo)
	{
		int snum =Integer.parseInt(request.getParameter("snum"));
		
		SangService ss= sqlSession.getMapper(SangService.class);
		SangDTO dto = ss.deletee(snum);
		mo.addAttribute("dto", dto);

		return "ddview";
		
	}
	@RequestMapping(value = "/delsave")
	public String ss5(HttpServletRequest request,Model mo)
	{
		int snum =Integer.parseInt(request.getParameter("snum"));
		String dfname=request.getParameter("himg");
		
		SangService ss= sqlSession.getMapper(SangService.class);
		ss.delete22(snum);
		
		File ff = new File(path+"\\"+dfname);
		ff.delete();

		return "redirect:/sangout";
		
	}
	@RequestMapping(value = "/modify12")
	public String ss6(HttpServletRequest request,Model mo)
	{
		int snum =Integer.parseInt(request.getParameter("snum"));
		
		SangService ss= sqlSession.getMapper(SangService.class);
		SangDTO dto = ss.modify11(snum);
		mo.addAttribute("dto", dto);

		return "modiview";
		
	}
	@RequestMapping(value = "/sangmodisave")
	public String ss7(MultipartHttpServletRequest mul) throws IllegalStateException, IOException 
	{
		int snum =Integer.parseInt(mul.getParameter("snum"));
		String sname=mul.getParameter("sname");
		MultipartFile mf = mul.getFile("simg") ;
		String fname = mf.getOriginalFilename();
		String dfname = mul.getParameter("himg");
		
		UUID uu =UUID.randomUUID();
		fname = uu.toString()+"_"+fname;
		
		SangService ss= sqlSession.getMapper(SangService.class);
		ss.insertmodi(snum,sname,fname);
		
		mf.transferTo(new File(path+"\\"+fname));
		File ff = new File(path+"\\"+dfname);
		ff.delete();
		
		return "redirect:/sangout";
	}
	@RequestMapping(value = "/sangsearchview")
	public String ss8(HttpServletRequest request)
	{
	
		return "ssearch";
	}
	@RequestMapping(value = "/sangsearch")
	public String ss9(HttpServletRequest request, Model mo) {
	    String key = request.getParameter("key");   // 컬럼명 (snum, sname)
	    String value = request.getParameter("value"); // 검색 값

	    SangService ss = sqlSession.getMapper(SangService.class);
	    ArrayList<SangDTO> list = ss.searchgo(key, value);

	    mo.addAttribute("list", list);
	    return "ssearchview";
	}
}
