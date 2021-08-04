package com.techelevator;

import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * FilmSearchController
 */
@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;

    @RequestMapping("/filmList")
    public String showFilmSearchForm(HttpServletRequest request) {
        int minLength = Integer.parseInt(request.getParameter("maxLength"));
        int maxLength = Integer.parseInt(request.getParameter("minLength"));
        String genre = request.getParameter("genre");

        List<Film> films = filmDao.getFilmsBetween(genre, minLength, maxLength);
        return "filmList";
    }


    @RequestMapping("/filmList/search")
    public String searchFilms(HttpServletRequest request) {
        String strMinLength = request.getParameter("minLength");
        String strMaxLength = request.getParameter("maxLength");
        String genre = request.getParameter("genre");
        int minLength = Integer.parseInt(strMinLength);
        int maxLength = Integer.parseInt(strMaxLength);

        List<Film> results = new ArrayList<Film>();

        results = filmDao.getFilmsBetween(genre, minLength, maxLength);

        request.setAttribute("films", results);

        return "filmList";
    }

}