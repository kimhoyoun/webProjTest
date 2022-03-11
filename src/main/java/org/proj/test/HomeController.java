package org.proj.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONObject;
import org.proj.data.TestAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
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
	
	@RequestMapping(value = "/test.action", method = RequestMethod.GET)
	public String testGo(Model model) {
		JSONArray jArr = api.getJArr();
		model.addAttribute("jArr", jArr);
		
		return "test";
	}
	
	@RequestMapping(value = "/detail.action", method = RequestMethod.GET)
	public String detail(Model model, String id) {
		JSONObject detailinfo = api.detailInfo(id);
		model.addAttribute("info", detailinfo);
		
		return "detail";
	}
}
