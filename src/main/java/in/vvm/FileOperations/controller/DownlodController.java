package in.vvm.FileOperations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DownlodController {

	@PostMapping("/download")
	public String download() {
		return "";
	}
}
