package com.mbc.kee12.member;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	
	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping(value = "/minput")
	public String mm1()
	{
		return "minput";
	}
	
	@ResponseBody
	@RequestMapping(value = "/logcheck" )
	public String mm5(String mid)
	{
		MemberService ms =sqlSession.getMapper(MemberService.class);
		int count = ms.id2count(mid);
		String bigo =(count==1)?"no":"ok";
		
		return bigo;
	}
	
	@RequestMapping(value = "/memsave")
	public String mm2(HttpServletRequest request)
	{
		String mid=request.getParameter("mid");
		String mpw=request.getParameter("mpw");
		String mname=request.getParameter("mname");
		PasswordEncoder pe = new BCryptPasswordEncoder();
		mpw=pe.encode(mpw);
		MemberService ms = sqlSession.getMapper(MemberService.class);
		ms.meminsert(mid,mpw,mname);
		
		return "redirect:/";
	}
	
}
