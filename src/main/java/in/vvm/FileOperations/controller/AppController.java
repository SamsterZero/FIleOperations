package in.vvm.FileOperations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String blank() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}

	@PostMapping("/login")
	public String authen() {
		return "redirect:/Home";
	}

	@GetMapping("/Home")
	public String home() {
		return "form";
	}
}