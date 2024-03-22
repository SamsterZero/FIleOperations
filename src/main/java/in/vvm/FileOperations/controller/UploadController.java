package in.vvm.FileOperations.controller;

import in.vvm.FileOperations.service.DataSavingService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class UploadController {

	private final DataSavingService dataSavingService;

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletResponse response,Model model) {
		response.setHeader("hx-request", "v1");
		if (file.isEmpty()) {
			return "Please select a file to upload.";
		}
		String fileName = dataSavingService.savePincodeData(file);
		model.addAttribute("fileName",fileName);
		return "x";
	}
}