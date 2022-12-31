package com.nt.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishService;

@Controller
public class MessageController {

	@Autowired
	IWishService service;

	/*@RequestMapping("/home")
	public String displayHomePage() {
		return "welcome";
	}*/
	
	/*@RequestMapping("/")
	public String displayHomePage() {
		return "welcome";
	}*/

	@RequestMapping
	public String displayHomePage() {
		return "welcome";
	}
	
	/*@RequestMapping("/wms")
	public ModelAndView gernrateMessage() {
	
		String msg = service.genrateMessage();
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("time", new Date());
		mav.setViewName("messageView");
	
		return mav;
	}*/

	/*	@RequestMapping("/wms")
		public String gernrateMessage(HashMap<String, Object> map) {
		
			System.out.println("========================="+map.getClass());
			String msg = service.genrateMessage();
			
			map.put("msg", msg);
			map.put("time",new Date());
		
			return "messageView";
		}*/

	/*@RequestMapping("/wms")
	public String gernrateMessage(HashMap<String, Object> map) {
	
		System.out.println("=========================" + map.getClass());
		String msg = service.genrateMessage();
	
		map.put("msg", msg);
		map.put("time", new Date());
		return null;
	}*/
	
	
	@RequestMapping("/wms")
	public void gernrateMessage(HashMap<String, Object> map) {
	
		System.out.println("=========================" + map.getClass());
		String msg = service.genrateMessage();
	
		map.put("msg", msg);
		map.put("time", new Date());
		
	}
	
	@RequestMapping({"wms3","/wms1","wms2"})
	public String gernrateMessage1(HashMap<String, Object> map) {
	
		String msg = service.genrateMessage();
		
		map.put("msg", msg);
		map.put("time", new Date());
		
	
		return "WishMessage";
	}
	
	/*@RequestMapping("/wms")
	public void gernrateMessage(HttpServletResponse res) throws Exception  {
	
		System.out.println("=========================" + res.getClass());
		String msg = service.genrateMessage();
	
		PrintWriter pw=res.getWriter();
		pw.print("<b>MEsssge is :: "+msg+"</b><br>");
		pw.print("<b> Current Time is ::"+new Date());
	 
		
		
	}*/

}
