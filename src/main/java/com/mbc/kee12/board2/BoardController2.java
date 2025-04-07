package com.mbc.kee12.board2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController2 {
	
	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping(value = "binput")
	public String bd1()
	{
		return "bdinput";
	}
	
	@RequestMapping(value = "bdsave")
	public String bd2(HttpServletRequest request)
	{
		String name = request.getParameter("bwriter");
		String title = request.getParameter("btitle");
		String content = request.getParameter("bcontent");
		BoardService2 bs2 = sqlSession.getMapper(BoardService2.class);
		bs2.insertboard(name,title,content);
		return "redirect:/";
	}
	
//	@RequestMapping(value = "bout")
//	public String bd3(Model mo)
//	{
//		BoardService2 bs2 = sqlSession.getMapper(BoardService2.class);
//		ArrayList<BoardDTO2>list=bs2.bdoutss();
//		mo.addAttribute("list", list);
//		return "bdout";
//	}
//	
	// --  2222 -->
	   @RequestMapping(value="/bout")
	      public String bd88(HttpServletRequest request, PageDTO2 dto,Model mo,HttpServletResponse response) throws IOException {
	        HttpSession hs =request.getSession(); 
	        boolean flag= (boolean) hs.getAttribute("loginstate");
			if(flag)
			{
		   	String nowPage=request.getParameter("nowPage");
	         String cntPerPage=request.getParameter("cntPerPage");
	         BoardService2 bs2 = sqlSession.getMapper(BoardService2.class);
	         //전체레코드수구하기
	         int total=bs2.total22();
	         if(nowPage==null && cntPerPage == null) {
	            nowPage="1";
	            cntPerPage="5";
	         }
	         else if(nowPage==null) {
	            nowPage="1";
	         }
	         else if(cntPerPage==null) {
	            cntPerPage="5";
	         }      
	         dto=new PageDTO2(total,Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
	         mo.addAttribute("paging",dto);
	         mo.addAttribute("list",bs2.page22(dto));
	         return "bdout";
			}
			else
			{
				response.setContentType("text/html;charset=utf-8");
				PrintWriter pww = response.getWriter();
				pww.print("<script>alert('로그인후 사용')</script>");
				pww.print("<script>location.href='login'</script>");
				pww.close();
			}
	         return "redirect:/login";
	   }
	
	@RequestMapping(value = "boarddetail")
	public String bd4(HttpServletRequest request, Model mo)
	{
		int bdnum=Integer.parseInt(request.getParameter("bnum"));
		BoardService2 bs2 = sqlSession.getMapper(BoardService2.class);
		bs2.bdreadcount(bdnum);
		BoardDTO2 dto2 = bs2.bddetail(bdnum);
		mo.addAttribute("dto2", dto2);
		return "bdetailvieww";
	}
	@RequestMapping(value = "bdetailsave")
	public String bd5(HttpServletRequest request, Model mo)
	{
		int bdnum=Integer.parseInt(request.getParameter("bnum"));
		BoardService2 bs2 = sqlSession.getMapper(BoardService2.class);
		BoardDTO2 dto2 = bs2.bdalldata(bdnum);
		mo.addAttribute("dto2", dto2);
		return "bdreply";
	}
	@RequestMapping(value = "bdresave")
	public String bd6(HttpServletRequest request)
	{
		int bnum=Integer.parseInt(request.getParameter("bnum"));
		int groups=Integer.parseInt(request.getParameter("groups"));
		int step=Integer.parseInt(request.getParameter("step"));
		int indent=Integer.parseInt(request.getParameter("indent"));
		String name = request.getParameter("bwriter");
		String title = request.getParameter("btitle");
		String content = request.getParameter("bcontent");
		BoardService2 bs2 = sqlSession.getMapper(BoardService2.class);
		bs2.stepss(groups,step);
		step++;
		indent++;
		
		bs2.boardappend(bnum,name,title,content,groups,step,indent);
		
		return "redirect:/";
	}
}
