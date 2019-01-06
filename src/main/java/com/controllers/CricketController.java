package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.pojo.Score;

@Controller
public class CricketController {

	@RequestMapping(value="/showScore")
	public String showScore(Model model) {
		System.out.println("fetching score!!");
		
//		Need to hit url from here
		//Hit rest api and get score
		final String uri = "http://192.168.0.16:8080/cricket-app/ipl/getScore";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    
	    System.out.println(result);
	    //Convert json to score java object
	    Gson gson = new Gson();
	    Score score = gson.fromJson(result, Score.class);
	    
	    model.addAttribute("score", score);
		return "score";
	}
	
	public static void main(String[] args) {
		
		final String uri = "http://192.168.0.16:8080/cricket-app/ipl/getScore";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    System.out.println(result);
	}
}
