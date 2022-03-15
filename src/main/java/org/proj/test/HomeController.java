package org.proj.test;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.proj.data.TestAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	private static TestAPI api;
	
	static {
		api = new TestAPI();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	int currentPage =1;
	int nextPage=0;
	@RequestMapping(value = "/showList", method = RequestMethod.GET)
	public String testGo(Model model, String pageNum) {
				
		JSONArray jArr = api.getJArr();
		model.addAttribute("jArr", jArr);
		model.addAttribute("pageNum", pageNum);
		return "showList";
	}
	
	
	
	@RequestMapping(value = "/showDetail", method = RequestMethod.GET)
	public String detail(Model model, String id) {
		JSONObject detailinfo = api.detailInfo(id);
		model.addAttribute("info", detailinfo);
		
		return "showDetail";
	}
}
