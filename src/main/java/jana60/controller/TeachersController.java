package jana60.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import jana60.model.Teacher;
import jana60.repository.TeachersRepository;

@Controller
@RequestMapping("/teachers")
public class TeachersController {

	@Autowired
	private TeachersRepository repo;
	
	@GetMapping
	public String teachers(Model model) {
		List<Teacher> teacherList = (List<Teacher>) repo.findAll();
		model.addAttribute("teacherList", teacherList);
		return "teachers";
	}
	
	@GetMapping("/{teacherId}")
	public String teacherDetail(Model model, @PathVariable(name="teacherId") Integer teacherPrimaryKey) {
		Optional<Teacher> queryResult = repo.findById(teacherPrimaryKey);
		if(queryResult.isPresent()) {
			model.addAttribute("teacher", queryResult.get());
			return "teacherDetails";
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insegnante non trovato.");
		}
	}
	
}
