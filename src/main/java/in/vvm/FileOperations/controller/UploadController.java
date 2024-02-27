package in.vvm.FileOperations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import in.vvm.FileOperations.service.DataSavingService;

@Controller
public class UploadController {

//	private final String UPLOAD_DIR = "./";
	@Autowired
	DataSavingService dataSavingService;

	@PostMapping("/upload")
	@ResponseBody
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return "Please select a file to upload.";
		}
		String fileName = dataSavingService.savePincodeData(file);
		return "You successfully uploaded " + fileName + "!";
	}
}