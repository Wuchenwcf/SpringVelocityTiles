package com.wcf.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wcf.data.Clientdata;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	Clientdata clientdata=new Clientdata();
	int count=0;

	@RequestMapping(method=RequestMethod.GET)
	public String home(HttpServletRequest request,Model model)
	{
		String ip=clientdata.getClientIp(request);
		String mac=clientdata.getMACAddress(ip);
		count++;
		model.addAttribute("IP",ip);
		model.addAttribute("MAC",mac);
		model.addAttribute("c",count);
		return "home";
	}

	@RequestMapping(value="spittr",method=RequestMethod.GET)
	public String toHome()
	{
		
		return "spittr";
	}
}