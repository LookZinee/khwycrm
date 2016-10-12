package com.khwy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/user")
@Controller
public class PageController {
	@RequestMapping("{page}")
	public String tiaozhuan(@PathVariable String page){
		return page;
	}
}
