package com.vt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vtpay")
public class HomeController {

	@RequestMapping(value={"","/"})
	private String home(Model model){
		return "home";
		
	}
	

}
