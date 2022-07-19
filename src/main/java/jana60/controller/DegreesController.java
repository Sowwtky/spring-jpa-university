package jana60.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.repository.DegreesRepository;


@Controller
@RequestMapping("/degrees")
public class DegreesController {

	@Autowired
	private DegreesRepository repo;
	
	@GetMapping
	public String degreeList(Model model) {
		model.addAttribute("degreeList", repo.findAll());
		return "degrees";
	}
	
	
	
}
