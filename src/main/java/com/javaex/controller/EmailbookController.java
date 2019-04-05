package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.EmailBookDao;
import com.javaex.vo.EmailBookVo;

@Controller
public class EmailbookController {

	@RequestMapping(value = "/writeform", method = RequestMethod.GET)
	public String wirteform() {
		System.out.println("writeform");
		return "/WEB-INF/views/writeForm.jsp";
	}

	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String write(@RequestAttribute EmailBookVo emailBookVo) {

		System.out.println(emailBookVo.toString());
		EmailBookDao dao = new EmailBookDao();
		
		dao.insert(emailBookVo);
		return "redirect:/list";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(Model model) {
		System.out.println("list");
		
		EmailBookDao dao = new EmailBookDao();
		List<EmailBookVo> list = dao.getList();
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/list.jsp";
	}
}