package com.techelevator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewDao reviewDao;
	
	@RequestMapping(path="/review", method=RequestMethod.GET)
	public String showReviews(ModelMap map) {
		map.addAttribute("posts", reviewDao.getAllReviews());
		return "review";
	}
	
	@RequestMapping(path="/review", method=RequestMethod.POST)
	public String showProductReviews(Review post, ModelMap map) {
		reviewDao.save(post);
		return "redirect:/home";
	}
}
