package com.techelevator.controller;

import com.techelevator.model.Color;
import com.techelevator.model.Food;
import com.techelevator.model.Season;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"color", "food", "season"})
public class FavoriteThingsController {

	@RequestMapping(path="/FavoriteThings/Page1", method=RequestMethod.GET)
	public String landingPage() {
		return "page1";
	}

	@RequestMapping(path="/FavoriteThings/Page1", method=RequestMethod.POST)
	public String favoriteColor(@RequestParam String input, ModelMap map) {

		Color color = new Color();
		color.setName(input);

		map.addAttribute("color", color);

		return "/page2";
	}

	@RequestMapping(path="/FavoriteThings/Page2", method=RequestMethod.POST)
	public String favoriteFood(@RequestParam String input, ModelMap map) {

		Food food = new Food();
		food.setName(input);

		map.addAttribute("food", food);

		return "/page3";
	}

	@RequestMapping(path="/FavoriteThings/Page3", method=RequestMethod.POST)
	public String favoriteSeason(@RequestParam String input, ModelMap map) {

		Season season = new Season();
		season.setName(input);

		map.addAttribute("season", season);

		return "redirect:/summary";
	}

	@RequestMapping(path="/summary", method=RequestMethod.GET)
	public String viewSummary() {
		return "/summary";
	}
}