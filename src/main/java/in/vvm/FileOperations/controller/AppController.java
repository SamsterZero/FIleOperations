package in.vvm.FileOperations.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class AppController {

//	final static Logger logger = LoggerFactory.getLogger(AppController.class);
	
	@GetMapping("/")
	public String blank() {
		return "redirect:/Home";
	}

	@GetMapping(value = "/login")
	public String login() {
		log.info("Get Login");
		return "Login";
	}

	@GetMapping(value = "/Home")
	public String home() {
		log.info("Get Home");
		return "form";
	}
}