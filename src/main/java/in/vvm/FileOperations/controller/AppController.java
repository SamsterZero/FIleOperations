package in.vvm.FileOperations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String blank() {
		return "redirect:/Home";
	}

	@GetMapping(value = "/login")
	public String login() {
		System.out.println("Get Login");
		return "Login";
	}

	@GetMapping(value = "/Home")
	public String home() {
		return "form";
	}
}