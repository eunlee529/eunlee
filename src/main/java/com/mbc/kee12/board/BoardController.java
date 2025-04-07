package com.mbc.kee12.board;


import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	@Autowired
	SqlSession sqlSession;
	@RequestMapping(value = "/boardinput")
	public String bb1()
	{
		
		return "binput";
	}
	@RequestMapping(value = "/boardsave")
	public String bb2(HttpServletRequest request)
	{
		String name=request.getParameter("boardwriter");
		String title=request.getParameter("boardtitle");
		String content=request.getParameter("boardcontent");
		BoardService bs = sqlSession.getMapper(BoardService.class);
		bs.insertbd(name,title,content);
		return "redirect:/";
	}

	/*
	 * @RequestMapping(value = "/boardout") public String bb3(Model mo) {
	 * BoardService bs =sqlSession.getMapper(BoardService.class);
	 * ArrayList<BoardDTO>list=bs.all2out(); mo.addAttribute("list", list); return
	 * "bout"; }
	 */
	
	// --  2222 -->
	   @RequestMapping(value="/boardout")
	      public String ko16(HttpServletRequest request, PageDTO dto,Model mo) {
	         String nowPage=request.getParameter("nowPage");
	         String cntPerPage=request.getParameter("cntPerPage");
	         BoardService bs = sqlSession.getMapper(BoardService.class);
	         //전체레코드수구하기
	         int total=bs.total();
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
	         dto=new PageDTO(total,Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
	         mo.addAttribute("paging",dto);
	         mo.addAttribute("list",bs.page(dto));
	         return "bout";
	    //2222222222
	   }//
	
	@RequestMapping(value = "/detail")
	public String bb4(HttpServletRequest request,Model mo)
	{
		int bnum=Integer.parseInt(request.getParameter("boardnum")) ;
		
		BoardService bs =sqlSession.getMapper(BoardService.class);
		bs.readcntup(bnum);
		BoardDTO dto = bs.detail(bnum);
		mo.addAttribute("dto", dto);
		return "detailview";
	}
	@RequestMapping(value = "/detailsave",method = RequestMethod.POST)
	public String bb5(HttpServletRequest request,Model mo)
	{
		int bnum=Integer.parseInt(request.getParameter("boardnum"));
		BoardService bs = sqlSession.getMapper(BoardService.class);
		BoardDTO dto =bs.alldata(bnum);
		mo.addAttribute("dto", dto);
		return "reply";
	}
	@RequestMapping(value = "/replysave",method = RequestMethod.POST)
	public String bb6(HttpServletRequest request,Model mo)
	{
		int bnum=Integer.parseInt(request.getParameter("boardnum"));
		int groups=Integer.parseInt(request.getParameter("groups"));
		int step=Integer.parseInt(request.getParameter("step"));
		int indent=Integer.parseInt(request.getParameter("indent"));
		String name =request.getParameter("boardwriter");
		String title =request.getParameter("boardtitle");
		String content =request.getParameter("boardcontent");
		////step
		BoardService bs = sqlSession.getMapper(BoardService.class);
		bs.stepup(groups,step);
		step++;
		indent++;
		
		
		bs.appendc(bnum,title,name,content,groups,step,indent);
		
		return "redirect:/";
	}
	@RequestMapping(value = "/mapgo")
	public String bb7()
	{
		
		return "map";
	}
}
