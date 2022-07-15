package jana60.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import jana60.model.University;
import jana60.repository.UniversityRepository;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private UniversityRepository repo;
	
	@GetMapping("/home")
	public String home(Model model) {
		List<University> uniList = (List<University>) repo.findAll();
		model.addAttribute("uniList", uniList);
		return "home";
	}
	
	@GetMapping
	public String mainpage() {
		return "mainpage";
	}
}
