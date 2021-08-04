package com.techelevator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.ReviewDao;

@Controller
public class HomeController {

	@Autowired
	private ReviewDao reviewDao;

	@RequestMapping(path="/home", method=RequestMethod.GET)
	public String showReviews(ModelMap map) {
		map.addAttribute("posts", reviewDao.getAllReviews());
		return "home";
	}
	
}
