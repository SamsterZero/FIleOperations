package in.vvm.FileOperations.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.vvm.FileOperations.service.FileFetchingService;

@Controller
public class DownlodController {

	@Autowired
	FileFetchingService fetchingService;

	@GetMapping("/download")
	public ResponseEntity<ByteArrayResource> download(Model model) {
		ByteArrayResource file = fetchingService.pinExcel();
		Date today = new Date();
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=PINCODE_" + today + ".xlsx");
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return ResponseEntity.ok().headers(headers).body(file);
	}
}
